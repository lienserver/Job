package lien.job.part;

import com.KimDiamond.API.RpgAPI;
import lien.job.api.Job;
import lien.job.api.Stat;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.permissions.Permission;

import java.util.*;

//abstruct 거의 안써봐서 여기다가 남길게요
public class part_job extends Job {
    private Job parent;

    private Location spawn;
    private Location tutorial;
    private List<ItemStack> defaultItem = new ArrayList<ItemStack>();
    private Map<Stat,Double> DefaultStats = null;

    public part_job(Map<String,Object> serial){super(serial);}

    public void giveJob(Player player){
        //give 'perm' to player
        //give items to player
        if(this.DefaultStats != null)
            for(Map.Entry<Stat,Double> entry : this.DefaultStats.entrySet())
            	entry.getKey().set(player, entry.getKey().get(player) + entry.getValue());
    }

    public Location getSpawnLocation(){return spawn;}
    public void setSpawnLocation(Location loc){spawn = loc;}
    public Location getTutorialLocation(){return tutorial;}
    public void setTutorialLocation(Location loc){tutorial = loc;}




    public Job getParent(){return parent;}
    public void setParent(Job parent){this.parent = parent;}




    //스탯 설정하는거 RpgAPI.getInstance().getPlayerCustomStatus(player).setWeaponDamage(double) 이렇게 되어있어요
    public Map<Stat,Double> getDefaultStats(){return this.DefaultStats;}
    public void setDefaultStats(Stat stat, Double value){
        if(this.DefaultStats == null){
            this.DefaultStats = new HashMap<>();
        }
        this.DefaultStats.put(stat,value);
    }
    public void setDefaultStats(Map<Stat,Double> values){this.DefaultStats = values;}




    public List<ItemStack> getDefaultItems(){return defaultItem;}
    public void addDefaultItems(ItemStack...itemStacks){defaultItem.addAll(Arrays.asList(itemStacks));}
    public void setDefaultItems(List<ItemStack> itemstacks){defaultItem = itemstacks;}




    //나중에(귀찮)
    public Map<String,Object> serialize(){ //Yamlconfiguration 에 저장할수있게
        return null; //TODO
    }



    private List<String> perm;//TODO:permission
    public List<String> getPermission(){return perm;}
    //setter?




    private String prefix;
    private String suffix;
    private String tribe;

    public String getPrefix() { return prefix; }
    public String setPrefix(String prefix) {
        this.prefix = prefix;
        return this.prefix;
    }

    public String getSuffix() { return suffix; }
    public void setSuffix(String suffix) { this.suffix = suffix; }
    public String getTribe() { return tribe; }
    public String setTribe(String tribe){
        this.tribe = tribe;
        return this.tribe;
    }
}