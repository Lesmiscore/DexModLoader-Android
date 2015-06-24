package modules;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;

public class ModEnablingList extends HashMap<String, Boolean> {
	private ModEnablingList() {

	}

	public static ModEnablingList of(byte[] array) {
		return of(new ByteArrayInputStream(array));
	}

	public static ModEnablingList of(InputStream is) {
		ModEnablingList mel = create();
		DataInputStream dis = is instanceof DataInputStream ? (DataInputStream) is
				: new DataInputStream(is);
		int entriesCount;
		try {
			entriesCount = dis.readInt();
			if (entriesCount < 0) {
				dataError(null,
						"entries count is less than 0. Is the data broken?");
			}
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			return dataError(e, null);
		}
		try {
			for (int i = 0; i < entriesCount; i++) {
				String modName = dis.readUTF();
				Boolean enabled = dis.readBoolean();
				mel.put(modName, enabled);
			}
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			return dataError(e, null);
		}
		return mel;
	}

	public static ModEnablingList importFrom(Context from) {
		SharedPreferences pref = from.getSharedPreferences("nao20010128nao",
				755);
		if (pref.getBoolean("javaModLoaderEnablingListAvaliable", false)) {
			return of(Base64.decode(
					pref.getString("javaModLoaderEnablingListMapData", null),
					Base64.NO_WRAP));
		} else {
			return create();
		}
	}

	private static ModEnablingList dataError(Throwable caused, String reason) {
		if (caused != null)
			throw new IllegalArgumentException(
					"Error in parsing InputStream/byte[].", caused);
		else
			throw new IllegalArgumentException(
					"Error in parsing InputStream/byte[]:" + reason);
	}

	private static ModEnablingList create() {
		return new ModEnablingList();
	}

	public static ModEnablingList createNew() {
		return create();
	}

	public void serialize(OutputStream os) throws IOException {
		DataOutputStream dos = os instanceof DataOutputStream ? (DataOutputStream) os
				: new DataOutputStream(os);
		dos.writeInt(size());
		for (Map.Entry<String, Boolean> entry : entrySet()) {
			dos.writeUTF(entry.getKey());
			dos.writeBoolean(entry.getValue());
		}
	}

	public byte[] serialize() {
		ByteArrayOutputStream baos = null;
		try {
			baos = new ByteArrayOutputStream();
			serialize(baos);
			return baos.toByteArray();
		} catch (Throwable ex) {
		} finally {
			if (baos != null)
				try {
					baos.close();
				} catch (IOException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
		}
		return null;
	}

	public void exportTo(Context to) {
		to.getSharedPreferences("nao20010128nao", 755)
				.edit()
				.putBoolean("javaModLoaderEnablingListAvaliable", true)
				.putString("javaModLoaderEnablingListMapData",
						Base64.encodeToString(serialize(), Base64.NO_WRAP))
				.commit();
	}
}
