package modules.methods;

import java.io.InputStream;

import modules.MainManager;

public final class ModMethods {
	MainManager mm;
	public ModPEObject ModPE = new ModPEObject();
	public LevelObject Level = new LevelObject();

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

		public void leaveGame(String s) {
			mm.callMethod1("ModPE.leaveGame", new Object[] {});
		}

		public void log(String s) {
			mm.callMethod1("ModPE.log", new Object[] { s });
		}

		public InputStream openInputStreamFromTexturePack(String address) {
			return (InputStream) mm.callMethod1(
					"ModPE.openInputStreamFromTexturePack",
					new Object[] { address });
		}

		public void overrideTexture(String target, String url) {
			mm.callMethod1("ModPE.overrideTexture",
					new Object[] { target, url });
		}

		public void resetFov() {
			mm.callMethod1("ModPE.resetFov", new Object[] {});
		}

		public void resetImages(String s) {
			mm.callMethod1("ModPE.resetImages", new Object[] {});
		}

		public void selectLevel(String worldName, String worldDir,
				String worldSeed, byte worldGamemode) {
			mm.callMethod1("ModPE.selectLevel", new Object[] { worldName,
					worldDir, worldSeed, worldGamemode });
		}

		public void setCamera(Object entity) {
			mm.callMethod1("ModPE.setCamera", new Object[] { entity });
		}

		public void setFoodItem(short id, String textureName, String group,
				int healthRegen, String itemName, int stackLimit) {
			mm.callMethod1("ModPE.setFoodItem", new Object[] { id, textureName,
					group, healthRegen, itemName, stackLimit });
		}

		public void setFov(double value) {
			mm.callMethod1("ModPE.setFov", new Object[] { value });
		}

		public void setGameSpeed(double ticks) {
			mm.callMethod1("ModPE.setGameSpeed", new Object[] { ticks });
		}

		public void setItem(short id, String textureName, String group,
				int healthRegen, String itemName, int stackLimit) {
			mm.callMethod1("ModPE.setItem", new Object[] { id, textureName,
					group, healthRegen, itemName, stackLimit });
		}

		public void setGuiBlocks(String address) {
			mm.callMethod1("ModPE.setGuiBlocks", new Object[] { address });
		}

		public void setItems(String address) {
			mm.callMethod1("ModPE.setItems", new Object[] { address });
		}

		public void setTerrain(String address) {
			mm.callMethod1("ModPE.setTerrain", new Object[] { address });
		}

		public void showTipMessage(String tip) {
			mm.callMethod1("ModPE.showTipMessage", new Object[] { tip });
		}

		public void takeScreenshot(String s) {
			mm.callMethod1("ModPE.takeScreenshot", new Object[] { s });
		}
	}

	public class LevelObject {
		public void addParticle(int type, double startX, double startY,
				double startZ, double directionX, double directionY,
				double directionZ, int size) {
			mm.callMethod1("Level.addParticle", new Object[] { type, startX,
					startY, startZ, directionX, directionY, directionZ, size });
		}

		public void biomeIdToName(int id) {
			mm.callMethod1("Level.biomeIdToName", new Object[] { id });
		}

		public void destroyBlock(int x, int y, int z, boolean drop) {
			mm.callMethod1("Level.destroyBlock", new Object[] { x, y, z, drop });
		}

		public void dropItem(double x, double y, double z, double bounceHeight,
				int id, int amount, int damage) {
			mm.callMethod1("Level.dropItem", new Object[] { x, y, z,
					bounceHeight, id, amount, damage });
		}

		public void explode(int x, int y, int z, int explodeRadius) {
			mm.callMethod1("Level.explode", new Object[] { x, y, z,
					explodeRadius });
		}

		public String getAddress() {
			return (String) mm.callMethod1("Level.getAddress", new Object[] {});
		}

		public int getBiome(int x, int z) {
			return (int) mm
					.callMethod1("Level.getBiome", new Object[] { x, z });
		}

		public String getBiomeName(int x, int z) {
			return (String) mm.callMethod1("Level.getBiomeName", new Object[] {
					x, z });
		}

		public int getBrightness(int x, int y, int z) {
			return (int) mm.callMethod1("Level.getBrightness", new Object[] {
					x, y, z });
		}

		public int getChestSlot(int x, int y, int z, int slotId) {
			return (int) mm.callMethod1("Level.getChestSlot", new Object[] { x,
					y, z });
		}

		public int getChestSlotCount(int x, int y, int z, int slotId) {
			return (int) mm.callMethod1("Level.getChestSlotCount",
					new Object[] { x, y, z });
		}

		public int getChestSlotData(int x, int y, int z, int slotId) {
			return (int) mm.callMethod1("Level.getChestSlotData", new Object[] {
					x, y, z });
		}

		public int getData(int x, int y, int z) {
			return (int) mm.callMethod1("Level.getData",
					new Object[] { x, y, z });
		}

		public int getFurnaceSlot(int x, int y, int z, int slotId) {
			return (int) mm.callMethod1("Level.getFurnaceSlot", new Object[] {
					x, y, z });
		}

		public int getFurnaceSlotCount(int x, int y, int z, int slotId) {
			return (int) mm.callMethod1("Level.getFurnaceSlotCount",
					new Object[] { x, y, z });
		}

		public int getFurnaceSlotData(int x, int y, int z, int slotId) {
			return (int) mm.callMethod1("Level.getFurnaceSlotData",
					new Object[] { x, y, z });
		}

		public int getGameMode() {
			return (int) mm.callMethod1("Level.getGameMode", new Object[] {});
		}

		public int getGrassColor(int x, int z) {
			return (int) mm.callMethod1("Level.getGrassColor", new Object[] {
					x, z });
		}

		public String getSignText(int x, int y, int z, int line) {
			return (String) mm.callMethod1("Level.getSignText", new Object[] {
					x, y, z, line });
		}

		public int getTile(int x, int y, int z) {
			return (int) mm.callMethod1("Level.dumpVtable", new Object[] { x,
					y, z });
		}

		public int getTime() {
			return (int) mm.callMethod1("Level.getTime", new Object[] {});
		}

		public String getWorldDir() {
			return (String) mm
					.callMethod1("Level.getWorldDir", new Object[] {});
		}

		public String getWorldName() {
			return (String) mm.callMethod1("Level.getWorldName",
					new Object[] {});
		}

		public void playSound(int x, int y, int z, String soundName,
				int volume, double pitch) {
			mm.callMethod1("Level.playSound", new Object[] { x, y, z,
					soundName, volume, pitch });
		}

		public void playSoundEnt(Object entity, int x, int y, int z,
				String soundName, int volume, double pitch) {
			mm.callMethod1("Level.playSoundEnt", new Object[] { entity, x, y,
					z, soundName, volume, pitch });
		}

		public void setChestSlot(int x, int y, int z, int slot, int id,
				int damage, int amount) {
			mm.callMethod1("Level.setChestSlot", new Object[] { x, y, z, slot,
					id, damage, amount });
		}

		public void setFurnaceSlot(int x, int y, int z, int slot, int id,
				int damage, int amount) {
			mm.callMethod1("Level.setFurnaceSlot", new Object[] { x, y, z,
					slot, id, damage, amount });
		}

		public void setGameMode(int gm) {
			mm.callMethod1("Level.setGameMode", new Object[] { gm });
		}

		public void setGrassColor(int x, int z, int color) {
			mm.callMethod1("Level.setGrassColor", new Object[] { x, z, color });
		}

		public void setNightMode(boolean value) {
			mm.callMethod1("Level.setNightMode", new Object[] { value });
		}

		public void setSignText(int x, int y, int z, int line, String text) {
			mm.callMethod1("Level.setSignText", new Object[] { x, y, z, line,
					text });
		}

		public void setSpawn(int x, int y, int z) {
			mm.callMethod1("Level.setSpawn", new Object[] { x, y, z });
		}

		public void setSpawnerEntityType(int x, int y, int z, int entId) {
			mm.callMethod1("Level.setSpawnerEntityType", new Object[] { x, y,
					z, entId });
		}

		public void setTile(int x, int y, int z, int id, int damage) {
			mm.callMethod1("Level.setTile",
					new Object[] { x, y, z, id, damage });
		}

		public void setTime(int time) {
			mm.callMethod1("Level.setTime", new Object[] { time });
		}

		public void spawnChicken(double x, double y, double z, String skinUrl) {
			mm.callMethod1("Level.spawnChicken", new Object[] { x, y, z,
					skinUrl });
		}

		public void spawnCow(double x, double y, double z, String skinUrl) {
			mm.callMethod1("Level.spawnCow", new Object[] { x, y, z, skinUrl });
		}

		public void spawnMob(double x, double y, double z, int entTypeId,
				String skinUrl) {
			mm.callMethod1("Level.spawnMob", new Object[] { x, y, z, entTypeId,
					skinUrl });
		}
	}

	public class PlayerObject {
		public void dumpVtable(String s) {
			mm.callMethod1("Level.dumpVtable", new Object[] { s });
		}

		public void dumpVtable(String s) {
			mm.callMethod1("Level.dumpVtable", new Object[] { s });
		}

		public void dumpVtable(String s) {
			mm.callMethod1("Level.dumpVtable", new Object[] { s });
		}

		public void dumpVtable(String s) {
			mm.callMethod1("Level.dumpVtable", new Object[] { s });
		}

		public void dumpVtable(String s) {
			mm.callMethod1("Level.dumpVtable", new Object[] { s });
		}

		public void dumpVtable(String s) {
			mm.callMethod1("Level.dumpVtable", new Object[] { s });
		}

		public void dumpVtable(String s) {
			mm.callMethod1("Level.dumpVtable", new Object[] { s });
		}

		public void dumpVtable(String s) {
			mm.callMethod1("Level.dumpVtable", new Object[] { s });
		}

		public void dumpVtable(String s) {
			mm.callMethod1("Level.dumpVtable", new Object[] { s });
		}

		public void dumpVtable(String s) {
			mm.callMethod1("Level.dumpVtable", new Object[] { s });
		}

		public void dumpVtable(String s) {
			mm.callMethod1("Level.dumpVtable", new Object[] { s });
		}

		public void dumpVtable(String s) {
			mm.callMethod1("Level.dumpVtable", new Object[] { s });
		}

		public void dumpVtable(String s) {
			mm.callMethod1("Level.dumpVtable", new Object[] { s });
		}

		public void dumpVtable(String s) {
			mm.callMethod1("Level.dumpVtable", new Object[] { s });
		}

		public void dumpVtable(String s) {
			mm.callMethod1("Level.dumpVtable", new Object[] { s });
		}

		public void dumpVtable(String s) {
			mm.callMethod1("Level.dumpVtable", new Object[] { s });
		}

		public void dumpVtable(String s) {
			mm.callMethod1("Level.dumpVtable", new Object[] { s });
		}

		public void dumpVtable(String s) {
			mm.callMethod1("Level.dumpVtable", new Object[] { s });
		}

		public void dumpVtable(String s) {
			mm.callMethod1("Level.dumpVtable", new Object[] { s });
		}

		public void dumpVtable(String s) {
			mm.callMethod1("Level.dumpVtable", new Object[] { s });
		}

		public void dumpVtable(String s) {
			mm.callMethod1("Level.dumpVtable", new Object[] { s });
		}

		public void dumpVtable(String s) {
			mm.callMethod1("Level.dumpVtable", new Object[] { s });
		}

		public void dumpVtable(String s) {
			mm.callMethod1("Level.dumpVtable", new Object[] { s });
		}

		public void dumpVtable(String s) {
			mm.callMethod1("Level.dumpVtable", new Object[] { s });
		}

		public void dumpVtable(String s) {
			mm.callMethod1("Level.dumpVtable", new Object[] { s });
		}

		public void dumpVtable(String s) {
			mm.callMethod1("Level.dumpVtable", new Object[] { s });
		}

		public void dumpVtable(String s) {
			mm.callMethod1("Level.dumpVtable", new Object[] { s });
		}

		public void dumpVtable(String s) {
			mm.callMethod1("Level.dumpVtable", new Object[] { s });
		}

		public void dumpVtable(String s) {
			mm.callMethod1("Level.dumpVtable", new Object[] { s });
		}

		public void dumpVtable(String s) {
			mm.callMethod1("Level.dumpVtable", new Object[] { s });
		}

		public void dumpVtable(String s) {
			mm.callMethod1("Level.dumpVtable", new Object[] { s });
		}

		public void dumpVtable(String s) {
			mm.callMethod1("Level.dumpVtable", new Object[] { s });
		}

		public void dumpVtable(String s) {
			mm.callMethod1("Level.dumpVtable", new Object[] { s });
		}

		public void dumpVtable(String s) {
			mm.callMethod1("Level.dumpVtable", new Object[] { s });
		}

		public void dumpVtable(String s) {
			mm.callMethod1("Level.dumpVtable", new Object[] { s });
		}

		public void dumpVtable(String s) {
			mm.callMethod1("Level.dumpVtable", new Object[] { s });
		}

		public void dumpVtable(String s) {
			mm.callMethod1("Level.dumpVtable", new Object[] { s });
		}

		public void dumpVtable(String s) {
			mm.callMethod1("Level.dumpVtable", new Object[] { s });
		}

		public void dumpVtable(String s) {
			mm.callMethod1("Level.dumpVtable", new Object[] { s });
		}

		public void dumpVtable(String s) {
			mm.callMethod1("Level.dumpVtable", new Object[] { s });
		}

		public void dumpVtable(String s) {
			mm.callMethod1("Level.dumpVtable", new Object[] { s });
		}

		public void dumpVtable(String s) {
			mm.callMethod1("Level.dumpVtable", new Object[] { s });
		}

		public void dumpVtable(String s) {
			mm.callMethod1("Level.dumpVtable", new Object[] { s });
		}

		public void dumpVtable(String s) {
			mm.callMethod1("Level.dumpVtable", new Object[] { s });
		}

		public void dumpVtable(String s) {
			mm.callMethod1("Level.dumpVtable", new Object[] { s });
		}

		public void dumpVtable(String s) {
			mm.callMethod1("Level.dumpVtable", new Object[] { s });
		}

		public void dumpVtable(String s) {
			mm.callMethod1("Level.dumpVtable", new Object[] { s });
		}

		public void dumpVtable(String s) {
			mm.callMethod1("Level.dumpVtable", new Object[] { s });
		}

		public void dumpVtable(String s) {
			mm.callMethod1("Level.dumpVtable", new Object[] { s });
		}

		public void dumpVtable(String s) {
			mm.callMethod1("Level.dumpVtable", new Object[] { s });
		}
	}
}
