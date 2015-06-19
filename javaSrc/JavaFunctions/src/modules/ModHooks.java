package modules;

public interface ModHooks {
	void useItem(int x, int y, int z, short itemId, short blockId, byte side,
			short itemDamage, short blockDamage);

	void destroyBlock(int x, int y, int z, byte side);

	void startDestroyBlock(int x, int y, int z, byte side);

	void newLevel(boolean isLocal);

	void selectLevelHook();

	void leaveGame();

	void modTick();

	void attackHook(Object attackerEnt, Object victimEnt);

	void procCmd(String text);

	void deathHook(Object murdererEnt, Object victimEnt);

	void entityRemovedHook(Object entity);

	void entityAddedHook(Object entity);

	void levelEventHook(Object entity, int eventType, int x, int y, int z,
			Object data);

	void blockEventHook(int x, int y, int z, int eventType, Object data);

	void serverMessageReceiveHook(String text);

	void chatReceiveHook(Object senderEnt, String message);
}
