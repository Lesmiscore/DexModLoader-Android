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
var mainManager, dxClass;
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
mainManager.loadCode();

//Hooks Observer
function useItem(x, y, z, itemId, blockId, side, itemDamage, blockDamage) {

}

function destroyBlock(x, y, z, side) {

}

function startDestroyBlock(x, y, z, side) {

}

function newLevel(hasLevel) {

}

function selectLevelHook() {

}

function leaveGame() {

}

function attackHook(attacker, victim) {

}

function modTick() {

}

function procCmd(command) {

}

function deathHook(murderer, victim) {

}

function entityRemovedHook(entity) {

}

function entityAddedHook(entity) {

}

function levelEventHook(entity, eventType, x, y, z, data) {

}

function blockEventHook(x, y, z, eventType, data) {

}

function serverMessageReceiveHook(message) {

}

function chatReceiveHook(sender, message) {

}