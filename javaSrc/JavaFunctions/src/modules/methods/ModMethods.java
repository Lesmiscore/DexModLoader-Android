package modules.methods;

import modules.MainManager;

public final class ModMethods {
	MainManager mm;

	public ModMethods(MainManager mm) {
		this.mm = mm;
	}

	public void addItemInventory(int id, int amount, int damage) {
		MainManager.callMethod("addItemInventory", new Object[] { id, amount,
				damage });
	}

	public void clientMessgae(String text) {
		MainManager.callMethod("clientMessgae", new Object[] { text });
	}

	public String getLevel() {
		return MainManager.callMethod("getLevel", new Object[] {}).toString();
	}

	public void getPitch(double pitch) {
		MainManager.callMethod("getPitch", new Object[] { pitch });
	}

	public Object getPlayerEnt() {
		return MainManager.callMethod("getPlayerEnt", new Object[] {});
	}

	public double getPlayerX() {
		return (double) MainManager.callMethod("getPlayerX", new Object[] {});
	}

	public double getPlayerY() {
		return (double) MainManager.callMethod("getPlayerY", new Object[] {});
	}

	public double getPlayerZ() {
		return (double) MainManager.callMethod("getPlayerZ", new Object[] {});
	}

	public int getTile(int x, int y, int z) {
		return (int) MainManager
				.callMethod("getTile", new Object[] { x, y, z });
	}

	public int getYaw(int direction) {
		return (int) MainManager.callMethod("getYaw",
				new Object[] { direction });
	}

	public void preventDefault() {
		MainManager.callMethod("preventDefault", new Object[] {});
	}

	public void print(String text) {
		MainManager.callMethod("print", new Object[] { text });
	}

	public void rideAnimal(Object ridable, Object rider) {
		MainManager.callMethod("rideAnimal", new Object[] { ridable, rider });
	}

	public void setNightMode(boolean nightMode) {
		MainManager.callMethod("setNightMode", new Object[] { nightMode });
	}

	public void setPosition(Object entity, double x, double y, double z) {
		MainManager.callMethod("setPosition", new Object[] { entity, x, y, z });
	}

	public void setPositionRelative(Object entity, double x, double y, double z) {
		MainManager.callMethod("setPositionRelative", new Object[] { entity, x,
				y, z });
	}

	public void setRot(Object ent, double vertical, double horizontal) {
		MainManager.callMethod("setRot", new Object[] { ent, vertical,
				horizontal });
	}

	public void setTile(int x, int y, int z, int id, int damage) {
		MainManager.callMethod("setTile", new Object[] { x, y, z, id, damage });
	}

	public void setVelX(Object entity, double speed) {
		MainManager.callMethod("setVelX", new Object[] { entity, speed });
	}

	public void setVelY(Object entity, double speed) {
		MainManager.callMethod("setVelY", new Object[] { entity, speed });
	}

	public void setVelZ(Object entity, double speed) {
		MainManager.callMethod("setVelZ", new Object[] { entity, speed });
	}

	public void spawnChicken(double x, double y, double z, String skinURL) {
		MainManager.callMethod("spawnChicken",
				new Object[] { x, y, z, skinURL });
	}

	public void spawnCow(double x, double y, double z, String skinURL) {
		MainManager.callMethod("spawnCow", new Object[] { x, y, z, skinURL });
	}

	public void spawnPigZombie(double x, double y, double z, int id,
			String skinURL) {
		MainManager.callMethod("spawnPigZombie", new Object[] { x, y, z, id,
				skinURL });
	}
}
