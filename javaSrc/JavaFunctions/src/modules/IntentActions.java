package modules;

/**
 * @hide
 * */
public final class IntentActions {

	private IntentActions() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	/**
	 * @hide
	 * */
	public final static String ACTION_PREFIX = "com.nao20010128nao.DMLH.";

	public final static String BLOCKLAUNCHER_OPEN = ACTION_PREFIX
			+ "BLOCKLAUNCHER_OPEN";

	public final static String LOADER_ENABLED_NOTIFY = ACTION_PREFIX
			+ "LOADER_ENABLED";
	public final static String LOADER_DISABLED_NOTIFY = ACTION_PREFIX
			+ "LOADER_DISABLED";
	public final static String LOADER_DISABLE_ALL_TEMPORARILY = ACTION_PREFIX
			+ "LOADER_DISABLE_ALL_TEMPORARILY";
	public final static String LOADER_INTERNAL_LOG = ACTION_PREFIX
			+ "LOADER_INTERNAL_LOG";

	public final static String MOD_ENABLED_NOTIFY = ACTION_PREFIX
			+ "MOD_ENABLED";
	public final static String MOD_DISABLED_NOTIFY = ACTION_PREFIX
			+ "MOD_DISABLED";

	public final static String MOD_ENABLE_REQUEST = ACTION_PREFIX
			+ "MOD_ENABLE_REQUEST";
	public final static String MOD_DISABLE_REQUEST = ACTION_PREFIX
			+ "MOD_DISABLE_REQUEST";

	public final static String MOD_LOADED_LIST = ACTION_PREFIX
			+ "MOD_LOADED_LIST";
	public final static String MOD_ENABLED_LIST = ACTION_PREFIX
			+ "MOD_ENABLED_LIST";

	public final static String MOD_DETAIL = ACTION_PREFIX + "MOD_DETAIL";

	public final static String HELPER_MAIN_OPEN = ACTION_PREFIX
			+ "HELPER_MAIN_OPEN";
	public final static String HELPER_SERVER_START = ACTION_PREFIX
			+ "HELPER_SERVER_RESTART";
	public final static String HELPER_SERVER_STOP = ACTION_PREFIX
			+ "HELPER_SERVER_STOP";

	public final static String HELPER_REQUEST_GET_MODS = ACTION_PREFIX
			+ "HELPER_REQUEST_GET_MODS";
	public final static String HELPER_REQUEST_MOD_DETAIL = ACTION_PREFIX
			+ "HELPER_REQUEST_MOD_DETAIL";
	public final static String HELPER_REQUEST_LOADER_LOG = ACTION_PREFIX
			+ "HELPER_REQUEST_LOADER_LOG";
}
