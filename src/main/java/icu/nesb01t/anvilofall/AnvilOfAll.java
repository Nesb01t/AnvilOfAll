package icu.nesb01t.anvilofall;

import icu.nesb01t.anvilofall.cmds.GiveItemsCmd;
import icu.nesb01t.anvilofall.events.AnvilClickEvent;
import icu.nesb01t.anvilofall.events.AnvilOpenEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class AnvilOfAll extends JavaPlugin {

    public static AnvilOfAll plugin;

    @Override
    public void onEnable() {
        plugin = this;

        getLogger().info("AnvilOfAll has been enabled!");
        getServer().getPluginManager().registerEvents(new AnvilClickEvent(), this);
        getServer().getPluginManager().registerEvents(new AnvilOpenEvent(), this);
        getCommand("giveitems").setExecutor(new GiveItemsCmd());
    }

    @Override
    public void onDisable() {
        getLogger().info("AnvilOfAll has been disabled!");
    }
}
