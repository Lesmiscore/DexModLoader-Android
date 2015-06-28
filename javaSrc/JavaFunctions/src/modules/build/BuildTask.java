package modules.build;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class BuildTask {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		String dest = args[0];
		String jar1 = args[1];
		String jar2 = args[2];
		ZipInputStream zis1 = null, zis2 = null;
		ZipOutputStream zos = null;
		try {
			byte[] buffer = new byte[8000];
			System.out.println("Opening...");
			zis1 = new ZipInputStream(new FileInputStream(jar1));
			zis2 = new ZipInputStream(new FileInputStream(jar2));
			zos = new ZipOutputStream(new FileOutputStream(dest));
			zos.setLevel(9);
			System.out.println("Starting merging...");
			while (true) {
				ZipEntry ze = zis1.getNextEntry();
				if (ze == null)
					break;
				if (ze.getName().startsWith("META-INF")
						| ze.getName().startsWith("modules.build"))
					continue;
				System.out.println("Copying: " + ze.getName());
				zos.putNextEntry(new ZipEntry(ze.getName()));
				while (true) {
					int r = zis1.read(buffer);
					if (r <= 0)
						break;
					zos.write(buffer, 0, r);
				}
			}
			System.out.println("Phase 1 finished, stating phase 2...");
			while (true) {
				ZipEntry ze = zis1.getNextEntry();
				if (ze == null)
					break;
				if (ze.getName().startsWith("META-INF")
						| ze.getName().startsWith("modules.build"))
					continue;
				System.out.println("Copying: " + ze.getName());
				zos.putNextEntry(new ZipEntry(ze.getName()));
				while (true) {
					int r = zis1.read(buffer);
					if (r <= 0)
						break;
					zos.write(buffer, 0, r);
				}
			}
		} catch (Throwable ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (zis1 != null)
					zis1.close();
				if (zis2 != null)
					zis2.close();
				if (zos != null)
					zos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
