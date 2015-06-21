package modules.methods;

import modules.MainManager;

public final class ModMethods {
	MainManager mm;
	public ModPEObject ModPE = new ModPEObject();

	public ModMethods(MainManager mm) {
		this.mm = mm;
	}

	public void addItemInventory(int id, int amount, int damage) {
		mm.callMethod1("addItemInventory", new Object[] { id, amount, damage });
	}

	public void clientMessgae(String text) {
		mm.callMethod1("clientMessgae", new Object[] { text });
	}

	public String getLevel() {
		return mm.callMethod1("getLevel", new Object[] {}).toString();
	}

	public void getPitch(double pitch) {
		mm.callMethod1("getPitch", new Object[] { pitch });
	}

	public Object getPlayerEnt() {
		return mm.callMethod1("getPlayerEnt", new Object[] {});
	}

	public double getPlayerX() {
		return (double) mm.callMethod1("getPlayerX", new Object[] {});
	}

	public double getPlayerY() {
		return (double) mm.callMethod1("getPlayerY", new Object[] {});
	}

	public double getPlayerZ() {
		return (double) mm.callMethod1("getPlayerZ", new Object[] {});
	}

	public int getTile(int x, int y, int z) {
		return (int) mm.callMethod1("getTile", new Object[] { x, y, z });
	}

	public int getYaw(int direction) {
		return (int) mm.callMethod1("getYaw", new Object[] { direction });
	}

	public void preventDefault() {
		mm.callMethod1("preventDefault", new Object[] {});
	}

	public void print(String text) {
		mm.callMethod1("print", new Object[] { text });
	}

	public void rideAnimal(Object ridable, Object rider) {
		mm.callMethod1("rideAnimal", new Object[] { ridable, rider });
	}

	public void setNightMode(boolean nightMode) {
		mm.callMethod1("setNightMode", new Object[] { nightMode });
	}

	public void setPosition(Object entity, double x, double y, double z) {
		mm.callMethod1("setPosition", new Object[] { entity, x, y, z });
	}

	public void setPositionRelative(Object entity, double x, double y, double z) {
		mm.callMethod1("setPositionRelative", new Object[] { entity, x, y, z });
	}

	public void setRot(Object ent, double vertical, double horizontal) {
		mm.callMethod1("setRot", new Object[] { ent, vertical, horizontal });
	}

	public void setTile(int x, int y, int z, int id, int damage) {
		mm.callMethod1("setTile", new Object[] { x, y, z, id, damage });
	}

	public void setVelX(Object entity, double speed) {
		mm.callMethod1("setVelX", new Object[] { entity, speed });
	}

	public void setVelY(Object entity, double speed) {
		mm.callMethod1("setVelY", new Object[] { entity, speed });
	}

	public void setVelZ(Object entity, double speed) {
		mm.callMethod1("setVelZ", new Object[] { entity, speed });
	}

	public void spawnChicken(double x, double y, double z, String skinURL) {
		mm.callMethod1("spawnChicken", new Object[] { x, y, z, skinURL });
	}

	public void spawnCow(double x, double y, double z, String skinURL) {
		mm.callMethod1("spawnCow", new Object[] { x, y, z, skinURL });
	}

	public void spawnPigZombie(double x, double y, double z, int id,
			String skinURL) {
		mm.callMethod1("spawnPigZombie", new Object[] { x, y, z, id, skinURL });
	}

	public class ModPEObject {
		public void dumpVtable(String s1, String s2) {
			mm.callMethod1("ModPE.dumpVtable", new Object[] { s1, s2 });
		}

		public byte[] getBytesFromTexturePack(String address) {
			return (byte[]) mm.callMethod1("ModPE.getBytesFromTexturePack",
					new Object[] { address });
		}

		public String getMinecraftVersion() {
			return (String) mm.callMethod1("ModPE.getMinecraftVersion",
					new Object[] {});
		}

		public void langEdit(String from, String to) {
			mm.callMethod1("ModPE.langEdit", new Object[] { from, to });
		}

		public void dumpVtable(String s) {
			mm.callMethod1("ModPE.dumpVtable", new Object[] { s });
		}

		public void dumpVtable(String s) {
			mm.callMethod1("ModPE.dumpVtable", new Object[] { s });
		}

		public void dumpVtable(String s) {
			mm.callMethod1("ModPE.dumpVtable", new Object[] { s });
		}

		public void dumpVtable(String s) {
			mm.callMethod1("ModPE.dumpVtable", new Object[] { s });
		}

		public void dumpVtable(String s) {
			mm.callMethod1("ModPE.dumpVtable", new Object[] { s });
		}

		public void dumpVtable(String s) {
			mm.callMethod1("ModPE.dumpVtable", new Object[] { s });
		}

		public void dumpVtable(String s) {
			mm.callMethod1("ModPE.dumpVtable", new Object[] { s });
		}

		public void dumpVtable(String s) {
			mm.callMethod1("ModPE.dumpVtable", new Object[] { s });
		}

		public void dumpVtable(String s) {
			mm.callMethod1("ModPE.dumpVtable", new Object[] { s });
		}

		public void dumpVtable(String s) {
			mm.callMethod1("ModPE.dumpVtable", new Object[] { s });
		}

		public void dumpVtable(String s) {
			mm.callMethod1("ModPE.dumpVtable", new Object[] { s });
		}

		public void dumpVtable(String s) {
			mm.callMethod1("ModPE.dumpVtable", new Object[] { s });
		}
	}
}
