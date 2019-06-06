package lien.job;

import org.bukkit.plugin.java.JavaPlugin;

public final class JobPl extends JavaPlugin {
    private static JobPl inst = null;

    public static JobPl getInstance(){
        return inst;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        inst = this;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
