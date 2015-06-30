package modules.build;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

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
				URL dlf = new URL(
						"https://github.com/nao20010128nao/DexModLoader-Android/raw/build/dx/lib/dx.jar");
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
				URL dlf = new URL(
						"https://github.com/nao20010128nao/DexModLoader-Android/raw/build/lib/commons-codec-1.10.jar");
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
				URL dlf = new URL(
						"https://github.com/nao20010128nao/DexModLoader-Android/raw/build/lib/commons-compress-1.9.jar");
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
}
