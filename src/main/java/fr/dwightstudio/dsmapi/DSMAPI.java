package fr.dwightstudio.dsmapi;

import fr.dwightstudio.dsmapi.commands.TestExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public final class DSMAPI extends JavaPlugin {

    static private DSMAPI INSTANCE;

    public static DSMAPI getInstance() {
        return INSTANCE;
    }

    @Override
    public void onEnable() {
        INSTANCE = this;

        getCommand("dsm-test").setExecutor(new TestExecutor());

        getServer().getPluginManager().registerEvents(new EventListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
