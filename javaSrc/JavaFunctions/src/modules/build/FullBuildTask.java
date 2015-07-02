package modules.build;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import org.apache.commons.codec.binary.Base64;

public class FullBuildTask {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("===================");
		System.out
				.println("Java Mod Loader for BlockLauncher(Android) builder");
		System.out.println("===================");
		System.out.println("Starting build...");
		String js = null, b64 = null;
		System.out.println("Downloading latest js file...");
		try {
			URL from = new URL(
					"https://github.com/nao20010128nao/DexModLoader-Android/raw/master/jsSrc/main.js");
			InputStream is = from.openConnection().getInputStream();
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(is));
			char[] buf = new char[1000];
			StringBuilder sb = new StringBuilder(1000);
			while (true) {
				int r = reader.read(buf);
				if (r <= 0)
					break;
				sb.append(buf, 0, r);
			}
			js = sb.toString();
		} catch (Throwable ex) {
			ex.printStackTrace();
			System.out.println("Aborted");
			return;
		}
		System.out.println("Combining some jar files...");
		ByteArrayOutputStream baos = new ByteArrayOutputStream(100000);
		ZipOutputStream zos = null;
		try {
			zos = new ZipOutputStream(baos);
			zos.setLevel(9);
			System.out.println("Combining: default library and loader");
			ZipInputStream zis = null;
			try {
				URL dlf = new URL(
						"https://github.com/nao20010128nao/DexModLoader-Android/raw/master/resources/app.jar");
				zis = new ZipInputStream(dlf.openConnection().getInputStream());
				copyEntries(zis, zos, new FilenameFilter() {
					@Override
					public boolean accept(File dir, String filename) {
						// TODO 自動生成されたメソッド・スタブ
						return filename.startsWith("META-INF")
								| filename.startsWith("modules.build");
					}
				});
			} catch (Throwable ex) {
				ex.printStackTrace();
			} finally {
				try {
					if (zis != null)
						zis.close();
				} catch (IOException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
				zis = null;
			}

			System.out.println("Combining: dx tool");
			try {
				zis = new ZipInputStream(new FileInputStream("./lib/dx.jar"));
				copyEntries(zis, zos, new FilenameFilter() {
					@Override
					public boolean accept(File dir, String filename) {
						// TODO 自動生成されたメソッド・スタブ
						return filename.startsWith("META-INF")
								| filename.startsWith("modules.build");
					}
				});
			} catch (Throwable ex) {
				ex.printStackTrace();
			} finally {
				try {
					if (zis != null)
						zis.close();
				} catch (IOException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
				zis = null;
			}

			System.out.println("Combining: Apache Commons Codec");
			try {
				zis = new ZipInputStream(new FileInputStream(
						"./lib/commons-codec-1.10.jar"));
				copyEntries(zis, zos, new FilenameFilter() {
					@Override
					public boolean accept(File dir, String filename) {
						// TODO 自動生成されたメソッド・スタブ
						return filename.startsWith("META-INF")
								| filename.startsWith("modules.build");
					}
				});
			} catch (Throwable ex) {
				ex.printStackTrace();
			} finally {
				try {
					if (zis != null)
						zis.close();
				} catch (IOException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
				zis = null;
			}

			System.out.println("Combining: Apache Commons Compress");
			try {
				zis = new ZipInputStream(new FileInputStream(
						"./lib/commons-compress-1.9.jar"));
				copyEntries(zis, zos, new FilenameFilter() {
					@Override
					public boolean accept(File dir, String filename) {
						// TODO 自動生成されたメソッド・スタブ
						return filename.startsWith("META-INF")
								| filename.startsWith("modules.build");
					}
				});
			} catch (Throwable ex) {
				ex.printStackTrace();
			} finally {
				try {
					if (zis != null)
						zis.close();
				} catch (IOException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
				zis = null;
			}
		} catch (Throwable ex) {
		} finally {
			try {
				if (zos != null)
					zos.close();
			} catch (IOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}

		System.out.println("Converting result...");
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("tmp.jar");
			fos.write(baos.toByteArray());
		} catch (Throwable ex) {

		} finally {
			try {
				if (fos != null)
					fos.close();
			} catch (IOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
		ClassLoader cl = loadDx();
		Class dxClass = null;
		try {
			dxClass = cl.loadClass("com.android.dx.command.Main");
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			System.err.println("Failed!");
			e.printStackTrace();
			return;
		}
		Method method = null;
		try {
			method = dxClass.getMethod("main", String[].class);
		} catch (NoSuchMethodException e) {
			// TODO 自動生成された catch ブロック
			System.err.println("Failed!");
			e.printStackTrace();
			return;
		}
		try {
			method.invoke(
					null,
					new Object[] { "--dex --output=./tmp.zip --multi-dex ./tmp.jar"
							.split(" ") });
		} catch (Throwable e) {
			// TODO 自動生成された catch ブロック
			System.err.println("Failed!");
			e.printStackTrace();
			return;
		} finally {
			System.gc();
		}
		ByteArrayOutputStream baos2 = new ByteArrayOutputStream();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("./tmp.zip");
			byte[] buffer = new byte[80000];
			while (true) {
				int r = fis.read(buffer);
				if (r <= 0)
					break;
				baos2.write(buffer, 0, r);
			}
		} catch (Throwable ex) {
		} finally {
			try {
				if (fis != null)
					fis.close();
			} catch (IOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}

		System.out.println("Generating js file result...");
		b64 = Base64.encodeBase64String(baos2.toByteArray());
		String toWrite = js.replace("%mainDex%", b64);
		FileWriter fw = null;
		try {
			fw = new FileWriter("./result.js");
			fw.write(toWrite);
		} catch (Throwable ex) {
		} finally {
			try {
				if (fw != null)
					fw.close();
			} catch (IOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}

		System.out.println("Deleting cache...");
		new File("./tmp.zip").delete();
		new File("./tmp.jar").delete();

		System.out.println("Done!");
	}

	public static void copyEntries(ZipInputStream zis, ZipOutputStream zos,
			FilenameFilter filter) throws IOException {
		if (filter == null)
			filter = new FilenameFilter() {
				@Override
				public boolean accept(File dir, String filename) {
					// TODO 自動生成されたメソッド・スタブ
					return true;
				}
			};
		byte[] buf = new byte[1000];
		while (true) {
			ZipEntry ze = zis.getNextEntry();
			if (ze == null)
				return;
			if (!filter.accept(null, ze.getName()))
				continue;
			System.out.println("Copying: " + ze.getName());
			zos.putNextEntry(ze);
			while (true) {
				int r = zis.read(buf);
				if (r <= 0)
					break;
				zos.write(buf, 0, r);
			}
		}
	}

	public static ClassLoader loadDx() {
		try {
			return new URLClassLoader(new URL[] { new File("./lib/dx.jar")
					.toURI().toURL() });
		} catch (MalformedURLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return null;
		}
	}
}
