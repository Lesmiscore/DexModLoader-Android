package modules;

import java.lang.reflect.Field;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Base64;

public class HelperMessenger extends BroadcastReceiver {
	static Context c = null;
	static MainManager mainManager = null;
	static boolean initFinished = false;

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO 自動生成されたメソッド・スタブ
		String action = intent.getAction();
		c = context;
		if (action.equals(IntentActions.HELPER_REQUEST_GET_MODS)) {
			c.sendBroadcast(new Intent(IntentActions.MOD_LOADED_LIST).putExtra(
					"list", mainManager.loadedModNames()));
			c.sendBroadcast(new Intent(IntentActions.MOD_ENABLED_LIST)
					.putExtra("list", Base64.encode(mainManager
							.getModEnablingList().serialize(), Base64.NO_WRAP)));
		} else if (action.equals(IntentActions.HELPER_REQUEST_LOADER_LOG)) {
			c.sendBroadcast(new Intent(IntentActions.LOADER_INTERNAL_LOG)
					.putExtra("log", mainManager.getLog()));
		} else if (action.equals(IntentActions.HELPER_REQUEST_MOD_DETAIL)) {
			ModBase mb = mainManager.findMod(intent.getStringExtra("mod"));
			c.sendBroadcast(new Intent(IntentActions.MOD_DETAIL)
					.putExtra("name", mb.getModInfo().getName())
					.putExtra("version", mb.getModInfo().getVersion())
					.putExtra("className", mb.getClass().getName())
					.putExtra("enabled",
							mainManager.isEnabled(mb.getModInfo().getName())));
		} else if (action.equals(IntentActions.BLOCKLAUNCHER_OPEN)) {
			c.startActivity(new Intent()
					.setClassName(
							c,
							c.getPackageName().equals(
									"net.zhuoweizhang.mcpelauncher.pro") ? "net.zhuoweizhang.mcpelauncher.pro.LauncherProActivity"
									: "net.zhuoweizhang.mcpelauncher.LauncherActivity"));
		}
	}

	public static void init(Context ctx, MainManager mm) {
		if (initFinished)
			return;
		if (ctx == null)
			throw new IllegalArgumentException("ctx == null");
		if (mm == null)
			throw new IllegalArgumentException("mm == null");
		IntentFilter infi = new IntentFilter();
		for (Field f : IntentActions.class.getFields()) {
			try {
				infi.addAction((String) f.get(null));
			} catch (IllegalAccessException ex) {
				// TODO 自動生成された catch ブロック
				MainManager.writeLogThrowable(mm, ex);
			} catch (IllegalArgumentException ex) {
				// TODO 自動生成された catch ブロック
				MainManager.writeLogThrowable(mm, ex);
			}
		}
		c.registerReceiver(new HelperMessenger(), infi);
	}
}
