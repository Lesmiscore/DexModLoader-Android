/* Java Mods Loader for BlockLauncher(Android)
 * Created by nao20010128nao.
 * DO NOT REDISTRIBUTE!
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
//Code Loader
var io = java.io;
var lang = java.lang;
var mainDex = "";
var dxTool = "";
var mainManager, dxClass,hookObserver;
var ctx = com.mojang.minecraftpe.MainActivity.currentMainActivity.get();
{
    //CLASSLOADER AREA
    /*Base 64 string of the DEX file*/
    var array = android.util.Base64.decode(mainDex, 0);
    var fi = io.File(ctx.getFilesDir(), "javaModLoaderMain.dex");
    var fos;
    try {
        fos = io.FileOutputStream(fi);
        fos.write(array);
    } finally {
        if (fos) fos.close();
    }
    var dcodedir;
    if ((android.os.Build.VERSION.SDK_INT - 21) < 0) {
        dcodedir = ctx.getDir("optimizedDex", 0);/*Older Android(~4.4W)*/
    } else {
        dcodedir = ctx.getCodeCacheDir();/*Newer Android(5.0~)*/
    }
    var dxc = lang.Class.forName("dalvik.system.DexClassLoader")
        .getConstructor(strCls, strCls, strCls, lang.Class.forName("java.lang.ClassLoader"))
        .newInstance(fi.toString(), dcodedir.toString(), null, ctx.getClassLoader());
    //The main object in the DEX file.
    mainManager = dxc.loadClass("modules.MainManager").getConstructor(lang.Class.forName("android.content.Context")).newInstance(ctx);
    //CLASSLOADER AREA END
}
{
    //CLASSLOADER AREA
    /*Base 64 string of the DEX file*/
    var array = android.util.Base64.decode(dxTool, 0);
    var fi = io.File(ctx.getFilesDir(), "javaModLoaderDxTool.dex");
    var fos;
    try {
        fos = io.FileOutputStream(fi);
        fos.write(array);
    } finally {
        if (fos) fos.close();
    }
    var dcodedir;
    if ((android.os.Build.VERSION.SDK_INT - 21) < 0) {
        dcodedir = ctx.getDir("optimizedDex", 0);/*Older Android(~4.4W)*/
    } else {
        dcodedir = ctx.getCodeCacheDir();/*Newer Android(5.0~)*/
    }
    var dxc = lang.Class.forName("dalvik.system.DexClassLoader")
        .getConstructor(strCls, strCls, strCls, lang.Class.forName("java.lang.ClassLoader"))
        .newInstance(fi.toString(), dcodedir.toString(), null, ctx.getClassLoader());
    //The main object in the DEX file.
    dxClass = dxc.loadClass("com.android.dx.command.Main");
    //CLASSLOADER AREA END
}
{
    mainManager.loadCode();
    hookObserver = mainManager.getModHooksObserver();
    var regMethod = mainManager.registerMethod;

    regMethod("addItemInventory", addItemInventory);
    regMethod("clientMessgae", clientMessgae);
    regMethod("getLevel", getLevel);
    regMethod("getPitch", getPitch);
    regMethod("getPlayerEnt", getPlayerEnt);
    regMethod("getPlayerX", getPlayerX);
    regMethod("getPlayerY", getPlayerY);
    regMethod("getPlayerZ", getPlayerZ);
    regMethod("getTile", getTile);
    regMethod("getYaw", getYaw);
    regMethod("preventDefault", preventDefault);
    regMethod("print", print);
    regMethod("rideAnimal", rideAnimal);
    regMethod("setNightMode", setNightMode);
    regMethod("setPosition", setPosition);
    regMethod("setPositionRelative", setPositionRelative);
    regMethod("setRot", setRot);
    regMethod("setTile", setTile);
    regMethod("setVelX", setVelX);
    regMethod("setVelY", setVelY);
    regMethod("setVelZ", setVelZ);
    regMethod("spawnChicken", spawnChicken);
    regMethod("spawnCow", spawnCow);
    regMethod("spawnPigZombie", spawnPigZombie);

    regMethod("ModPE.dumpVtable", ModPE.dumpVtable);
    regMethod("ModPE.getBytesFromTexturePack", ModPE.getBytesFromTexturePack);
    regMethod("ModPE.getMinecraftVersion", ModPE.getMinecraftVersion);
    regMethod("ModPE.langEdit", ModPE.langEdit);
    regMethod("ModPE.leaveGame", ModPE.leaveGame);
    regMethod("ModPE.log", ModPE.log);
    regMethod("ModPE.openInputStreamFromTexturePack", ModPE.openInputStreamFromTexturePack);
    regMethod("ModPE.overrideTexture", ModPE.overrideTexture);
    regMethod("ModPE.saveData", ModPE.saveData);
    regMethod("ModPE.readData", ModPE.readData);
    regMethod("ModPE.removeData", ModPE.removeData);
    regMethod("ModPE.resetFov", ModPE.resetFov);
    regMethod("ModPE.resetImages", ModPE.resetImages);
    regMethod("ModPE.selectLevel", ModPE.selectLevel);
    regMethod("ModPE.setCamera", ModPE.setCamera);
    regMethod("ModPE.setFoodItem", ModPE.setFoodItem);
    regMethod("ModPE.setFov", ModPE.setFov);
    regMethod("ModPE.setGameSpeed", ModPE.setGameSpeed);
    regMethod("ModPE.setItem", ModPE.setItem);
    regMethod("ModPE.setGuiBlocks", ModPE.setGuiBlocks);
    regMethod("ModPE.setItems", ModPE.setItems);
    regMethod("ModPE.setTerrain", ModPE.setTerrain);
    regMethod("ModPE.showTipMessage", ModPE.showTipMessage);
    regMethod("ModPE.takeScreenshot", ModPE.takeScreenshot);

    regMethod("Level.addParticle", Level.addParticle);
    regMethod("Level.biomeIdToName", Level.biomeIdToName);
    regMethod("Level.destroyBlock", Level.destroyBlock);
    regMethod("Level.dropItem", Level.dropItem);
    regMethod("Level.explode", Level.explode);
    regMethod("Level.getAddress", Level.getAddress);
    regMethod("Level.getBiome", Level.getBiome);
    regMethod("Level.getBiomeName", Level.getBiomeName);
    regMethod("Level.getBrightness", Level.getBrightness);
    regMethod("Level.getChestSlot", Level.getChestSlot);
    regMethod("Level.getChestSlotCount", Level.getChestSlotCount);
    regMethod("Level.getChestSlotData", Level.getChestSlotData);
    regMethod("Level.getData", Level.getData);
    regMethod("Level.getFurnaceSlot", Level.getFurnaceSlot);
    regMethod("Level.getFurnaceSlotCount", Level.getFurnaceSlotCount);
    regMethod("Level.getFurnaceSlotData", Level.getFurnaceSlotData);
    regMethod("Level.getGameMode", Level.getGameMode);
    regMethod("Level.getGrassColor", Level.getGrassColor);
    regMethod("Level.getSignText", Level.getSignText);
    regMethod("Level.getTile", Level.getTile);
    regMethod("Level.getTime", Level.getTime);
    regMethod("Level.getWorldDir", Level.getWorldDir);
    regMethod("Level.getWorldName", Level.getWorldName);
    regMethod("Level.playSound", Level.playSound);
    regMethod("Level.playSoundEnt", Level.playSoundEnt);
    regMethod("Level.setChestSlot", Level.setChestSlot);
    regMethod("Level.setFurnaceSlot", Level.setFurnaceSlot);
    regMethod("Level.setGameMode", Level.setGameMode);
    regMethod("Level.setGrassColor", Level.setGrassColor);
    regMethod("Level.setNightMode", Level.setNightMode);
    regMethod("Level.setSignText", Level.setSignText);
    regMethod("Level.setSpawn", Level.setSpawn);
    regMethod("Level.setSpawnerEntityType", Level.setSpawnerEntityType);
    regMethod("Level.setTile", Level.setTile);
    regMethod("Level.setTime", Level.setTime);
    regMethod("Level.spawnChicken", Level.spawnChicken);
    regMethod("Level.spawnCow", Level.spawnCow);
    regMethod("Level.spawnMob", Level.spawnMob);

    regMethod("Player.addItemCreativeInv", Player.addItemCreativeInv);
    regMethod("Player.addItemInventory", Player.addItemInventory);
    regMethod("Player.canFly", Player.canFly);
    regMethod("Player.clearInventorySlot", Player.clearInventorySlot);
    regMethod("Player.getArmorSlot", Player.getArmorSlot);
    regMethod("Player.getArmorSlotDamage", Player.getArmorSlotDamage);
    regMethod("Player.getCarriedItem", Player.getCarriedItem);
    regMethod("Player.getCarriedItemCount", Player.getCarriedItemCount);
    regMethod("Player.getCarriedItemData", Player.getCarriedItemData);
    regMethod("Player.getEntity", Player.getEntity);
    regMethod("Player.getInventorySlot", Player.getInventorySlot);
    regMethod("Player.getInventorySlotCount", Player.getInventorySlotCount);
    regMethod("Player.getInventorySlotData", Player.getInventorySlotData);
    regMethod("Player.getName", Player.getName);
    regMethod("Player.getPointedBlockData", Player.getPointedBlockData);
    regMethod("Player.getPointedBlockId", Player.getPointedBlockId);
    regMethod("Player.getPointedBlockSide", Player.getPointedBlockSide);
    regMethod("Player.getPointedBlockX", Player.getPointedBlockX);
    regMethod("Player.getPointedBlockY", Player.getPointedBlockY);
    regMethod("Player.getPointedBlockZ", Player.getPointedBlockZ);
    regMethod("Player.getPointedEntity", Player.getPointedEntity);
    regMethod("Player.getSelectedSlotId", Player.getSelectedSlotId);
    regMethod("Player.getX", Player.getX);
    regMethod("Player.getY", Player.getY);
    regMethod("Player.getZ", Player.getZ);
    regMethod("Player.isFlying", Player.isFlying);
    regMethod("Player.isPlayer", Player.isPlayer);
    regMethod("Player.setArmorSlot", Player.setArmorSlot);
    regMethod("Player.setCanFly", Player.setCanFly);
    regMethod("Player.setFlying", Player.setFlying);
    regMethod("Player.setHealth", Player.setHealth);

    regMethod("Entity.addEffect", Entity.addEffect);
    regMethod("Entity.getAll", Entity.getAll);
    regMethod("Entity.getAnimalAge", Entity.getAnimalAge);
    regMethod("Entity.getEntityTypeId", Entity.getEntityTypeId);
    regMethod("Entity.getHealth", Entity.getHealth);
    regMethod("Entity.getItemEntityCount", Entity.getItemEntityCount);
    regMethod("Entity.getItemEntityData", Entity.getItemEntityData);
    regMethod("Entity.getItemEntityId", Entity.getItemEntityId);
    regMethod("Entity.getMobSkin", Entity.getMobSkin);
    regMethod("Entity.getNameTag", Entity.getNameTag);
    regMethod("Entity.getPitch", Entity.getPitch);
    regMethod("Entity.getRenderType", Entity.getRenderType);
    regMethod("Entity.getRider", Entity.getRider);
    regMethod("Entity.getRiding", Entity.getRiding);
    regMethod("Entity.getUniqueId", Entity.getUniqueId);
    regMethod("Entity.getVelX", Entity.getVelX);
    regMethod("Entity.getVelY", Entity.getVelY);
    regMethod("Entity.getVelZ", Entity.getVelZ);
    regMethod("Entity.getX", Entity.getX);
    regMethod("Entity.getY", Entity.getY);
    regMethod("Entity.getZ", Entity.getZ);
    regMethod("Entity.getYaw", Entity.getYaw);
    regMethod("Entity.remove", Entity.remove);
    regMethod("Entity.removeAllEffects", Entity.removeAllEffects);
    regMethod("Entity.removeEffect", Entity.removeEffect);
    regMethod("Entity.rideAnimal", Entity.rideAnimal);
    regMethod("Entity.setAnimalAge", Entity.setAnimalAge);
    regMethod("Entity.setCape", Entity.setCape);
    regMethod("Entity.setCarriedItem", Entity.setCarriedItem);
    regMethod("Entity.setCollisionSize", Entity.setCollisionSize);
    regMethod("Entity.setFireTicks", Entity.setFireTicks);
    regMethod("Entity.setHealth", Entity.setHealth);
    regMethod("Entity.setMobSkin", Entity.setMobSkin);
    regMethod("Entity.setNameTag", Entity.setNameTag);
    regMethod("Entity.setPosition", Entity.setPosition);
    regMethod("Entity.setPositionRelative", Entity.setPositionRelative);
    regMethod("Entity.setRenderType", Entity.setRenderType);
    regMethod("Entity.setRot", Entity.setRot);
    regMethod("Entity.setSneaking", Entity.setSneaking);
    regMethod("Entity.setVelX", Entity.setVelX);
    regMethod("Entity.setVelY", Entity.setVelY);
    regMethod("Entity.setVelZ", Entity.setVelZ);
    regMethod("Entity.spawnMob", Entity.spawnMob);

    regMethod("Item.addCraftRecipe", Item.addCraftRecipe);
    regMethod("Item.addFurnaceRecipe", Item.addFurnaceRecipe);
    regMethod("Item.addShapedRecipe", Item.addShapedRecipe);
    regMethod("Item.defineArmor", Item.defineArmor);
    regMethod("Item.getName", Item.getName);
    regMethod("Item.setCategory", Item.setCategory);
    regMethod("Item.setHandEquipped", Item.setHandEquipped);
    regMethod("Item.setMaxDamage", Item.setMaxDamage);

    regMethod("Block.defineBlock", Block.defineBlock);
    regMethod("Block.getRenderType", Block.getRenderType);
    regMethod("Block.setColor", Block.setColor);
    regMethod("Block.setDestroyTime", Block.setDestroyTime);
    regMethod("Block.setExplosionResistance", Block.setExplosionResistance);
    regMethod("Block.setLightLevel", Block.setLightLevel);
    regMethod("Block.setLightOpacity", Block.setLightOpacity);
    regMethod("Block.setRenderLayer", Block.setRenderLayer);
    regMethod("Block.setRenderType", Block.setRenderType);
    regMethod("Block.setShape", Block.setShape);

    regMethod("Server.getAddress", Server.getAddress);
    regMethod("Server.getAllPlayerNames", Server.getAllPlayerNames);
    regMethod("Server.getAllPlayers", Server.getAllPlayers);
    regMethod("Server.getPort", Server.getPort);
    regMethod("Server.joinServer", Server.joinServer);
    regMethod("Server.sendChat", Server.sendChat);
}

//Hooks Observer
function useItem(x, y, z, itemId, blockId, side, itemDamage, blockDamage) {
    hookObserver.useItem(x, y, z, itemId, blockId, side, itemDamage, blockDamage);
}

function destroyBlock(x, y, z, side) {
    hookObserver.destroyBlock(x, y, z, side);
}

function startDestroyBlock(x, y, z, side) {
    hookObserver.startDestroyBlock(x, y, z, side);
}

function newLevel(hasLevel) {
    hookObserver.newLevel(hasLevel);
}

function selectLevelHook() {
    hookObserver.selectLevelHook();
}

function leaveGame() {
    hookObserver.leaveGame();
}

function attackHook(attacker, victim) {
    hookObserver.attackHook(attacker, victim);
}

function modTick() {
    hookObserver.modTick();
}

function procCmd(command) {
    hookObserver.procCmd(command);
}

function deathHook(murderer, victim) {
    hookObserver.deathHook(murderer, victim);
}

function entityRemovedHook(entity) {
    hookObserver.entityRemovedHook(entity);
}

function entityAddedHook(entity) {
    hookObserver.entityAddedHook(entity);
}

function levelEventHook(entity, eventType, x, y, z, data) {
    hookObserver.levelEventHook(entity, eventType, x, y, z, data);
}

function blockEventHook(x, y, z, eventType, data) {
    hookObserver.levelEventHook(entity, eventType, x, y, z, data);
}

function serverMessageReceiveHook(message) {
    hookObserver.serverMessageReceiveHook(message);
}

function chatReceiveHook(sender, message) {
    hookObserver.chatReceiveHook(sender, message);
}