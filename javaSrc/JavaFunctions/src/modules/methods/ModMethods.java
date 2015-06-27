package modules.methods;

import java.io.InputStream;

import modules.MainManager;

public final class ModMethods {
	MainManager mm;
	public ModPEObject ModPE = new ModPEObject();
	public LevelObject Level = new LevelObject();
	public PlayerObject Player = new PlayerObject();
	public EntityObject Entity = new EntityObject();
	public ItemObject Item = new ItemObject();
	public BlockObject Block = new BlockObject();
	public ServerObject Server = new ServerObject();

	public ModMethods(MainManager mm) {
		this.mm = mm;
	}

	public void addItemInventory(int id, int amount, int damage) {
		mm.callMethod1("addItemInventory", new Object[] { id, amount, damage });
	}

	public void clientMessage(String text) {
		mm.callMethod1("clientMessage", new Object[] { text });
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
		public void addItemCreativeInv(int id, int amount, int damage) {
			mm.callMethod1("Player.addItemCreativeInv", new Object[] { id,
					amount, damage });
		}

		public void addItemInventory(int id, int amount, int damage) {
			mm.callMethod1("Player.addItemInventory", new Object[] { id,
					amount, damage });
		}

		public boolean canFly() {
			return (boolean) mm.callMethod1("Player.canFly", new Object[] {});
		}

		public void clearInventorySlot(int slot) {
			mm.callMethod1("Player.clearInventorySlot", new Object[] { slot });
		}

		public int getArmorSlot(int slot) {
			return (int) mm.callMethod1("Player.getArmorSlot",
					new Object[] { slot });
		}

		public int getArmorSlotDamage(int slot) {
			return (int) mm.callMethod1("Player.getArmorSlotDamage",
					new Object[] { slot });
		}

		public int getCarriedItem() {
			return (int) mm.callMethod1("Player.getCarriedItem",
					new Object[] {});
		}

		public int getCarriedItemCount() {
			return (int) mm.callMethod1("Player.getCarriedItemCount",
					new Object[] {});
		}

		public int getCarriedItemData() {
			return (int) mm.callMethod1("Player.getCarriedItemData",
					new Object[] {});
		}

		public Object getEntity() {
			return mm.callMethod1("Player.getEntity", new Object[] {});
		}

		public int getInventorySlot(int slot) {
			return (int) mm.callMethod1("Player.getInventorySlot",
					new Object[] { slot });
		}

		public int getInventorySlotCount(int slot) {
			return (int) mm.callMethod1("Player.getInventorySlotCount",
					new Object[] { slot });
		}

		public int getInventorySlotData(int slot) {
			return (int) mm.callMethod1("Player.getInventorySlotData",
					new Object[] { slot });
		}

		public String getName(Object s) {
			return (String) mm
					.callMethod1("Player.getName", new Object[] { s });
		}

		public int getPointedBlockData() {
			return (int) mm.callMethod1("Player.getPointedBlockData",
					new Object[] {});
		}

		public int getPointedBlockId() {
			return (int) mm.callMethod1("Player.getPointedBlockId",
					new Object[] {});
		}

		public int getPointedBlockSide() {
			return (int) mm.callMethod1("Player.getPointedBlockSide",
					new Object[] {});
		}

		public int getPointedBlockX() {
			return (int) mm.callMethod1("Player.getPointedBlockX",
					new Object[] {});
		}

		public int getPointedBlockY() {
			return (int) mm.callMethod1("Player.getPointedBlockY",
					new Object[] {});
		}

		public int getPointedBlockZ() {
			return (int) mm.callMethod1("Player.getPointedBlockZ",
					new Object[] {});
		}

		public Object getPointedEntity() {
			return mm.callMethod1("Player.getPointedEntity", new Object[] {});
		}

		public int getSelectedSlotId() {
			return (int) mm.callMethod1("Player.getSelectedSlotId",
					new Object[] {});
		}

		public int getX() {
			return (int) mm.callMethod1("Player.getX", new Object[] {});
		}

		public int getY() {
			return (int) mm.callMethod1("Player.getY", new Object[] {});
		}

		public int getZ() {
			return (int) mm.callMethod1("Player.getZ", new Object[] {});
		}

		public boolean isFlying() {
			return (boolean) mm.callMethod1("Player.isFlying", new Object[] {});
		}

		public boolean isPlayer(Object entity) {
			return (boolean) mm.callMethod1("Player.isPlayer",
					new Object[] { entity });
		}

		public void setArmorSlot(int slot, int id, int damage) {
			mm.callMethod1("Player.setArmorSlot", new Object[] { slot, id,
					damage });
		}

		public void setCanFly(boolean canFly) {
			mm.callMethod1("Player.setCanFly", new Object[] { canFly ? 1 : 0 });
		}

		public void setCanFly(int canFly) {
			mm.callMethod1("Player.setCanFly", new Object[] { canFly });
		}

		public void setFlying(boolean flying) {
			mm.callMethod1("Player.setFlying", new Object[] { flying });
		}

		public void setHealth(int health) {
			mm.callMethod1("Player.setHealth", new Object[] { health });
		}
	}

	public class EntityObject {
		public void addEffect(Object entity, int effectId, int effectTime,
				int effectLevel, int ambient, boolean showParticles) {
			mm.callMethod1("Entity.addEffect", new Object[] { entity, effectId,
					effectTime, effectLevel, ambient, showParticles });
		}

		public Object[] getAll() {
			return (Object[]) mm.callMethod1("Entity.getAll", new Object[] {});
		}

		public int getAnimalAge(Object entity) {
			return (int) mm.callMethod1("Entity.getAnimalAge",
					new Object[] { entity });
		}

		public int getEntityTypeId(Object entity) {
			return (int) mm.callMethod1("Entity.getEntityTypeId",
					new Object[] { entity });
		}

		public int getHealth(Object entity) {
			return (int) mm.callMethod1("Entity.getHealth",
					new Object[] { entity });
		}

		public int getItemEntityCount(Object entity) {
			return (int) mm.callMethod1("Entity.getItemEntityCount",
					new Object[] { entity });
		}

		public int getItemEntityData(Object entity) {
			return (int) mm.callMethod1("Entity.getItemEntityData",
					new Object[] { entity });
		}

		public int getItemEntityId(Object entity) {
			return (int) mm.callMethod1("Entity.getItemEntityId",
					new Object[] { entity });
		}

		public String getMobSkin(Object entity) {
			return (String) mm.callMethod1("Entity.getMobSkin",
					new Object[] { entity });
		}

		public String getNameTag(Object entity) {
			return (String) mm.callMethod1("Entity.getNameTag",
					new Object[] { entity });
		}

		public double getPitch(Object entity) {
			return (double) mm.callMethod1("Entity.getPitch",
					new Object[] { entity });
		}

		public int getRenderType(Object entity) {
			return (int) mm.callMethod1("Entity.getRenderType",
					new Object[] { entity });
		}

		public Object getRider(Object entity) {
			return mm.callMethod1("Entity.getRider", new Object[] { entity });
		}

		public Object getRiding(Object entity) {
			return mm.callMethod1("Entity.getRiding", new Object[] { entity });
		}

		public double getVelX(Object entity) {
			return (double) mm.callMethod1("Entity.getVelX",
					new Object[] { entity });
		}

		public double getVelY(Object entity) {
			return (double) mm.callMethod1("Entity.getVelY",
					new Object[] { entity });
		}

		public double getVelZ(Object entity) {
			return (double) mm.callMethod1("Entity.getVelZ",
					new Object[] { entity });
		}

		public double getX(Object entity) {
			return (double) mm.callMethod1("Entity.getX",
					new Object[] { entity });
		}

		public double getY(Object entity) {
			return (double) mm.callMethod1("Entity.getY",
					new Object[] { entity });
		}

		public double getZ(Object entity) {
			return (double) mm.callMethod1("Entity.getZ",
					new Object[] { entity });
		}

		public double getYaw(Object entity) {
			return (double) mm.callMethod1("Entity.getYaw",
					new Object[] { entity });
		}

		public void removeAllEffects(Object entity) {
			mm.callMethod1("Entity.remove", new Object[] { entity });
		}

		public void removeEffect(Object entity, int effectId) {
			mm.callMethod1("Entity.remove", new Object[] { entity, effectId });
		}

		public void remove(Object entity) {
			mm.callMethod1("Entity.remove", new Object[] { entity });
		}

		public void rideAnimal(Object rider, Object ridden) {
			mm.callMethod1("Entity.rideAnimal", new Object[] { rider, ridden });
		}

		public void setAnimalAge(Object entity, int age) {
			mm.callMethod1("Entity.setAnimalAge", new Object[] { entity, age });
		}

		public void setCape(Object entity, String address) {
			mm.callMethod1("Entity.setCape", new Object[] { entity, address });
		}

		public void setCarriedItem(Object entity, int id, int amount, int damage) {
			mm.callMethod1("Entity.setCarriedItem", new Object[] { entity, id,
					amount, damage });
		}

		public void setCollisionSize(Object entity, double xz, double y) {
			mm.callMethod1("Entity.setCollisionSize", new Object[] { entity,
					xz, y });
		}

		public void setFireTicks(Object entity, int time) {
			mm.callMethod1("Entity.setFireTicks", new Object[] { entity, time });
		}

		public void setHealth(Object entity, int health) {
			mm.callMethod1("Entity.setHealth", new Object[] { entity, health });
		}

		public void setMobSkin(Object entity, String address) {
			mm.callMethod1("Entity.setMobSkin",
					new Object[] { entity, address });
		}

		public void setNameTag(Object entity, String name) {
			mm.callMethod1("Entity.setNameTag", new Object[] { entity, name });
		}

		public void setPosition(Object entity, double x, double y, double z) {
			mm.callMethod1("Entity.setPosition",
					new Object[] { entity, x, y, z });
		}

		public void setPositionRelative(Object entity, double x, double y,
				double z) {
			mm.callMethod1("Entity.setPositionRelative", new Object[] { entity,
					x, y, z });
		}

		public void setRenderType(Object entity, int renderType) {
			mm.callMethod1("Entity.setRenderType", new Object[] { entity,
					renderType });
		}

		public void setRot(Object entity, double horizontal, double vertical) {
			mm.callMethod1("Entity.setRot", new Object[] { entity, horizontal,
					vertical });
		}

		public void setSneaking(Object entity, boolean sneaking) {
			mm.callMethod1("Entity.setSneaking", new Object[] { entity,
					sneaking });
		}

		public void setVelX(Object entity, double speed) {
			mm.callMethod1("Entity.setVelX", new Object[] { entity, speed });
		}

		public void setVelY(Object entity, double speed) {
			mm.callMethod1("Entity.setVelY", new Object[] { entity, speed });
		}

		public void setVelZ(Object entity, double speed) {
			mm.callMethod1("Entity.setVelZ", new Object[] { entity, speed });
		}

		public void spawnMob(double x, double y, double z, int entityId,
				String skinUrl) {
			mm.callMethod1("Entity.spawnMob", new Object[] { x, y, z, entityId,
					skinUrl });
		}
	}

	public class ItemObject {
		public void addCraftRecipe(int id, int amount, int damage,
				Object[] recipe) {
			mm.callMethod1("Item.addCraftRecipe", new Object[] { id, amount,
					damage, recipe });
		}

		public void addFurnaceRecipe(int material, int result, int damage) {
			mm.callMethod1("Item.addFurnaceRecipe", new Object[] { material,
					result, damage });
		}

		public void addShapedRecipe(int id, int amount, int damage,
				String[] materialPlace, Object[] matrialInfo) {
			mm.callMethod1("Item.addShapedRecipe", new Object[] { id, amount,
					damage, materialPlace, matrialInfo });
		}

		public void defineArmor(int id, String inventoryTextureName, int order,
				int itemName, String armorTextureName, int defensePower,
				int maxDamage, int armorTypeId) {
			mm.callMethod1("Item.defineArmor", new Object[] { id,
					inventoryTextureName, order, itemName, armorTextureName,
					defensePower, maxDamage, armorTypeId });
		}

		public String getName(int id, int damage, boolean willGet) {
			return (String) mm.callMethod1("Item.dumpVtable", new Object[] {
					id, damage, willGet });
		}

		public void setCategory(int id, int category, Object whatever) {
			mm.callMethod1("Item.setCategory", new Object[] { id, category,
					whatever });
		}

		/**
		 * Equalent as {@code setCategory(id, category, null);}
		 * */
		public void setCategory(int id, int category) {
			setCategory(id, category, null);
		}

		public void setHandEquipped(int itemId, boolean isGripping) {
			mm.callMethod1("Item.setHandEquipped", new Object[] { itemId,
					isGripping });
		}

		public void setMaxDamage(int itemId, int damage) {
			mm.callMethod1("Item.setMaxDamage", new Object[] { itemId, damage });
		}
	}

	public class BlockObject {
		public void defineBlock(int id, String showName,
				Object[][] textureForSides, int toolMatch, boolean translucent,
				int[] blockShape) {
			mm.callMethod1("Block.defineBlock", new Object[] { id, showName,
					textureForSides, toolMatch, translucent, blockShape });
		}

		public int getRenderType(int id) {
			return (int) mm.callMethod1("Block.getRenderType",
					new Object[] { id });
		}

		public void setColor(int id, int color) {
			mm.callMethod1("Block.setColor", new Object[] { id, color });
		}

		public void setDestroyTime(int id, int time) {
			mm.callMethod1("Block.setDestroyTime", new Object[] { id, time });
		}

		public void setExplosionResistance(int id, int resistance) {
			mm.callMethod1("Block.setExplosionResistance", new Object[] { id,
					resistance });
		}

		public void setLightLevel(int id, int lightLevel) {
			mm.callMethod1("Block.setLightLevel",
					new Object[] { id, lightLevel });
		}

		public void setLightOpacity(int id, int lightOpacity) {
			mm.callMethod1("Block.setLightOpacity", new Object[] { id,
					lightOpacity });
		}

		public void setRenderLayer(int id, int layerNumber) {
			mm.callMethod1("Block.setRenderLayer", new Object[] { id,
					layerNumber });
		}

		public void setRenderType(int id, int typeNumber) {
			mm.callMethod1("Block.setRenderType",
					new Object[] { id, typeNumber });
		}

		public void setShape(int id, double startX, double startY,
				double startZ, double endX, double endY, double endZ) {
			mm.callMethod1("Block.setShape", new Object[] { id, startX, startY,
					startZ, endX, endY, endZ });
		}
	}

	public class ServerObject {
		public String getAddress() {
			return (String) mm
					.callMethod1("Server.getAddress", new Object[] {});
		}

		public String[] getAllPlayerNames() {
			return (String[]) mm.callMethod1("Server.getAllPlayerNames",
					new Object[] {});
		}

		public Object[] getAllPlayers() {
			return (String[]) mm.callMethod1("Server.getAllPlayers",
					new Object[] {});
		}

		public short getPort() {
			return (short) mm.callMethod1("Server.getPort", new Object[] {});
		}

		public void joinServer(String host, short port) {
			mm.callMethod1("Server.joinServer", new Object[] { host, port });
		}

		public void sendChat(String s) {
			mm.callMethod1("Server.sendChat", new Object[] { s });
		}
	}
}
