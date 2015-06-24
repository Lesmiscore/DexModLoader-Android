package modules;

import android.content.Context;
import android.content.SharedPreferences;

public abstract class ModBase implements ModHooks {
	MainManager mm;
	Context androidContext;
	SharedPreferences config;

	protected ModBase(MainManager mainManager, Context ctx) {
		this.mm = mainManager;
		this.androidContext = ctx;
		this.config = ctx.getSharedPreferences("javaModLoader-Config-"
				+ getModInfo().getName(), 755);
	}

	public abstract ModInfo getModInfo();

	public abstract void onEnable();

	public abstract void onDisable();

	public MainManager getMainManager() {
		return mm;
	}

	public Context getAndroidContext() {
		return androidContext;
	}

	public SharedPreferences getConfig() {
		return config;
	}

	@Override
	public void useItem(int x, int y, int z, short itemId, short blockId,
			byte side, short itemDamage, short blockDamage) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void destroyBlock(int x, int y, int z, byte side) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void startDestroyBlock(int x, int y, int z, byte side) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void newLevel(boolean isLocal) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void selectLevelHook() {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void leaveGame() {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void modTick() {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void attackHook(Object attackerEnt, Object victimEnt) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void procCmd(String text) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void deathHook(Object murdererEnt, Object victimEnt) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void entityRemovedHook(Object entity) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void entityAddedHook(Object entity) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void levelEventHook(Object entity, int eventType, int x, int y,
			int z, Object data) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void blockEventHook(int x, int y, int z, int eventType, Object data) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void serverMessageReceiveHook(String text) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void chatReceiveHook(Object senderEnt, String message) {
		// TODO 自動生成されたメソッド・スタブ

	}
}