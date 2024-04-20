package fr.dwightstudio.dsmapi;

import fr.dwightstudio.dsmapi.commands.TestExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public final class DSMAPI extends JavaPlugin {

    static private DSMAPI INSTANCE;
    static private JavaPlugin EXTERNAL_INSTANCE;

    public static DSMAPI getInstance() {
        return INSTANCE;
    }

    public static JavaPlugin getPlugin() {
        return INSTANCE == null ? EXTERNAL_INSTANCE : INSTANCE;
    }

    public static void initialize(JavaPlugin plugin) {
        EXTERNAL_INSTANCE = plugin;
    }

    @Override
    public void onEnable() {
        INSTANCE = this;

        getCommand("dsm-test").setExecutor(new TestExecutor());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
