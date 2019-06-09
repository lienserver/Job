package lien.job;

import lien.job.api.Job;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

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

    private Map<String, Job> jobMap = new HashMap<>();

    public void addJob(Job job){
        jobMap.put(job.getName(),job);
    }

    public Job getJob(String name){
        return jobMap.get(name);
    }
}