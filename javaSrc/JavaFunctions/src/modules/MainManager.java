package modules;

import java.io.BufferedReader;
import java.io.File;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mozilla.javascript.Function;

import android.content.Context;
import android.os.Environment;
import dalvik.system.DexClassLoader;

public final class MainManager {
	static File mcGames = new File(Environment.getExternalStorageDirectory(),
			"games/com.mojang");
	static File jMods = new File(mcGames, "javaMods");
	static Map<String, Function> functions = new HashMap<>();
	static {
		if (!jMods.exists()) {
			jMods.mkdir();
		}
	}
	static StringWriter log;

	public static void registerMethod(String name, Function method) {
		if (name == null | method == null) {
			return;
		}
		functions.put(name, method);
	}

	protected static void callMethod(String name, Object[] args) {
		if (functions.containsKey(name)) {
			Function f = functions.get(name);
			f.call(org.mozilla.javascript.Context.getCurrentContext(),
					f.getParentScope(), f, args);
		}
	}

	private static void writeLog(MainManager mm, String text) {
		synchronized (log) {
			log.write("[" + Integer.toHexString(mm.hashCode()) + "]");
			log.write("[" + time() + "]");
			log.write(text);
			log.write("\n");
		}
	}

	private static String time() {
		return new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance()
				.getTime());
	}

	File modDir;
	Context context;
	List<ModBase> mods = new ArrayList<>();
	List<ClassLoader> classLoaders = new ArrayList<>();
	List<Class<?>> classes = new ArrayList<>();

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
					mods.add(mod);
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
}