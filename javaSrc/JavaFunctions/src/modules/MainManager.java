package modules;

import java.io.BufferedReader;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import modules.methods.ModMethods;

import org.mozilla.javascript.Function;

import android.content.Context;
import android.os.Environment;
import dalvik.system.DexClassLoader;

public final class MainManager {
	static File mcGames = new File(Environment.getExternalStorageDirectory(),
			"games/com.mojang");
	static File jMods = new File(mcGames, "javaMods");
	static Map<String, Function> functions = new HashMap<>();
	static StringWriter log = new StringWriter();
	static {
		if (!jMods.exists()) {
			jMods.mkdir();
		}
	}

	public static void registerMethod(String name, Function method) {
		if (name == null | method == null) {
			return;
		}
		functions.put(name.toLowerCase(), method);
	}

	public static Object callMethod(String name, Object[] args) {
		name = name.toLowerCase();
		if (functions.containsKey(name)) {
			Function f = functions.get(name);
			return f.call(org.mozilla.javascript.Context.getCurrentContext(),
					f.getParentScope(), f, args);
		}
		return null;
	}

	private static void writeLog(MainManager mm, String text) {
		synchronized (log) {
			writeLog0(mm, text);
		}
	}

	private static void writeLog0(MainManager mm, String text) {
		log.write("[" + Integer.toHexString(mm.hashCode()) + "]");
		log.write("[" + time() + "]");
		log.write(text);
		log.write("\n");
	}

	private static void writeLogMultiLine(MainManager mm, String text) {
		try {
			synchronized (log) {
				writeLogMultiLine0(mm, text);
			}
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	private static void writeLogMultiLine0(MainManager mm, String text)
			throws IOException {
		BufferedReader br = new BufferedReader(new StringReader(text));
		while (true) {
			String s = br.readLine();
			if (s != null)
				writeLog0(mm, s);
		}
	}

	private static void writeLogThrowable(MainManager mm, Throwable ex) {
		synchronized (log) {
			try {
				StringWriter sw = new StringWriter();
				ex.printStackTrace(new PrintWriter(sw));
				writeLogMultiLine0(mm, sw.toString());
			} catch (IOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
	}

	private static String time() {
		return new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance()
				.getTime());
	}

	File modDir;
	Context context;
	Map<ModBase, Boolean> mods = new HashMap<>();
	Set<ClassLoader> classLoaders = new HashSet<>();
	Set<Class<?>> classes = new HashSet<>();
	protected ModMethods methods = new ModMethods(this);

	public MainManager(Context c) {
		this(c, jMods);
	}

	public MainManager(Context c, File modDir) {
		this.context = c;
		this.modDir = modDir;
	}

	public void loadCode() {
		String[] fileStrings = modDir.list(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String filename) {
				// TODO 自動生成されたメソッド・スタブ
				dir = new File(dir, filename);
				return dir.isFile()
						& dir.isAbsolute()
						& (!dir.equals(modDir))
						& (dir.toString().endsWith(".dex") | dir.toString()
								.endsWith(".zip"));
			}
		});
		for (String s : fileStrings) {
			try {
				writeLog(this, "Loading file:" + s);
				ClassLoader cl = new DexClassLoader(s, tryGetOptDir(), null,
						getClass().getClassLoader());
				classLoaders.add(cl);
				String className = "modules.Mod";
				InputStream is = null;
				BufferedReader br = null;
				try {
					is = cl.getResource("className").openStream();
					br = new BufferedReader(new InputStreamReader(is));
					className = br.readLine();
				} catch (Throwable ex) {
				} finally {
					if (br != null)
						br.close();
					if (is != null)
						is.close();
				}
				writeLog(this, "Loading class:" + className);
				Class<?> clazz = cl.loadClass(className);
				classes.add(clazz);
				try {
					ModBase mod = (ModBase) clazz.getConstructor(
							MainManager.class, Context.class).newInstance(this,
							context);
					writeLog(this, "Loaded mod:" + mod.getModInfo().getName());
					writeLog(this, "Enabling mod:" + mod.getModInfo().getName());
					mod.onEnable();
					writeLog(this, "Enabled mod:" + mod.getModInfo().getName());
					mods.put(mod, true);
				} catch (Throwable ex) {

				}
			} catch (Throwable ex) {

			}
		}
	}

	private String tryGetOptDir() {
		try {
			Method gccd = Context.class.getMethod("getCodeCacheDir",
					new Class<?>[] {});
			return gccd.invoke(context, new Object[] {}).toString();
		} catch (Throwable ex) {
			return context.getFilesDir().toString();
		}
	}

	@Override
	public int hashCode() {
		// TODO 自動生成されたメソッド・スタブ
		return super.hashCode() ^ context.hashCode();
	}

	public ModHooks getModHooksObserver() {
		return observerHooks;
	}

	ModHooks observerHooks = new ModHooks() {

		@Override
		public void useItem(int x, int y, int z, short itemId, short blockId,
				byte side, short itemDamage, short blockDamage) {
			// TODO 自動生成されたメソッド・スタブ
			for (ModBase mb : mods.keySet()) {
				try {
					mb.useItem(x, y, z, itemId, blockId, side, itemDamage,
							blockDamage);
				} catch (Throwable ex) {
					writeLogThrowable(MainManager.this, ex);
				}
			}
		}

		@Override
		public void startDestroyBlock(int x, int y, int z, byte side) {
			// TODO 自動生成されたメソッド・スタブ
			for (ModBase mb : mods.keySet()) {
				try {
					mb.startDestroyBlock(x, y, z, side);
				} catch (Throwable ex) {
					writeLogThrowable(MainManager.this, ex);
				}
			}
		}

		@Override
		public void serverMessageReceiveHook(String text) {
			// TODO 自動生成されたメソッド・スタブ
			for (ModBase mb : mods.keySet()) {
				try {
					mb.serverMessageReceiveHook(text);
				} catch (Throwable ex) {
					writeLogThrowable(MainManager.this, ex);
				}
			}
		}

		@Override
		public void selectLevelHook() {
			// TODO 自動生成されたメソッド・スタブ
			for (ModBase mb : mods.keySet()) {
				try {
					mb.selectLevelHook();
				} catch (Throwable ex) {
					writeLogThrowable(MainManager.this, ex);
				}
			}
		}

		@Override
		public void procCmd(String text) {
			// TODO 自動生成されたメソッド・スタブ
			for (ModBase mb : mods.keySet()) {
				try {
					mb.procCmd(text);
				} catch (Throwable ex) {
					writeLogThrowable(MainManager.this, ex);
				}
			}
		}

		@Override
		public void newLevel(boolean isLocal) {
			// TODO 自動生成されたメソッド・スタブ
			for (ModBase mb : mods.keySet()) {
				try {
					mb.newLevel(isLocal);
				} catch (Throwable ex) {
					writeLogThrowable(MainManager.this, ex);
				}
			}
		}

		@Override
		public void modTick() {
			// TODO 自動生成されたメソッド・スタブ
			for (ModBase mb : mods.keySet()) {
				try {
					mb.modTick();
				} catch (final Throwable ex) {
					new Thread() {
						@Override
						public void run() {
							try {
								StringWriter sw = new StringWriter();
								ex.printStackTrace(new PrintWriter(sw));
								BufferedReader br = new BufferedReader(
										new StringReader(sw.toString()));
								while (true) {
									String s = br.readLine();
									if (s != null)
										writeLog(MainManager.this, s);
								}
							} catch (IOException e) {
								writeLogThrowable(MainManager.this, ex);
							}
						}
					}.start();
				}
			}
		}

		@Override
		public void levelEventHook(Object entity, int eventType, int x, int y,
				int z, Object data) {
			// TODO 自動生成されたメソッド・スタブ
			for (ModBase mb : mods.keySet()) {
				try {
					mb.levelEventHook(entity, eventType, x, y, z, data);
				} catch (Throwable ex) {
					writeLogThrowable(MainManager.this, ex);
				}
			}
		}

		@Override
		public void leaveGame() {
			// TODO 自動生成されたメソッド・スタブ
			for (ModBase mb : mods.keySet()) {
				try {
					mb.leaveGame();
				} catch (Throwable ex) {
					writeLogThrowable(MainManager.this, ex);
				}
			}
		}

		@Override
		public void entityRemovedHook(Object entity) {
			// TODO 自動生成されたメソッド・スタブ
			for (ModBase mb : mods.keySet()) {
				try {
					mb.entityRemovedHook(entity);
				} catch (Throwable ex) {
					writeLogThrowable(MainManager.this, ex);
				}
			}
		}

		@Override
		public void entityAddedHook(Object entity) {
			// TODO 自動生成されたメソッド・スタブ
			for (ModBase mb : mods.keySet()) {
				try {
					mb.entityAddedHook(entity);
				} catch (Throwable ex) {
					writeLogThrowable(MainManager.this, ex);
				}
			}
		}

		@Override
		public void destroyBlock(int x, int y, int z, byte side) {
			// TODO 自動生成されたメソッド・スタブ
			for (ModBase mb : mods.keySet()) {
				try {
					mb.destroyBlock(x, y, z, side);
				} catch (Throwable ex) {
					writeLogThrowable(MainManager.this, ex);
				}
			}
		}

		@Override
		public void deathHook(Object murdererEnt, Object victimEnt) {
			// TODO 自動生成されたメソッド・スタブ
			for (ModBase mb : mods.keySet()) {
				try {
					mb.deathHook(murdererEnt, victimEnt);
				} catch (Throwable ex) {
					writeLogThrowable(MainManager.this, ex);
				}
			}
		}

		@Override
		public void chatReceiveHook(Object senderEnt, String message) {
			// TODO 自動生成されたメソッド・スタブ
			for (ModBase mb : mods.keySet()) {
				try {
					mb.chatReceiveHook(senderEnt, message);
				} catch (Throwable ex) {
					writeLogThrowable(MainManager.this, ex);
				}
			}
		}

		@Override
		public void blockEventHook(int x, int y, int z, int eventType,
				Object data) {
			// TODO 自動生成されたメソッド・スタブ
			for (ModBase mb : mods.keySet()) {
				try {
					mb.blockEventHook(x, y, z, eventType, data);
				} catch (Throwable ex) {
					writeLogThrowable(MainManager.this, ex);
				}
			}
		}

		@Override
		public void attackHook(Object attackerEnt, Object victimEnt) {
			// TODO 自動生成されたメソッド・スタブ
			for (ModBase mb : mods.keySet()) {
				try {
					mb.attackHook(attackerEnt, victimEnt);
				} catch (Throwable ex) {
					writeLogThrowable(MainManager.this, ex);
				}
			}
		}
	};

}