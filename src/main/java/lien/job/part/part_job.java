package lien.job.part;

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
    private List<String> perm;//TODO:permission
    private Location spawn;
    private Location tutorial;
    private List<ItemStack> defaultItem = new ArrayList<ItemStack>();

    public part_job(Map<String,Object> serial){super(serial);}

    public void giveJob(Player player){
        //give 'perm' to player
        //give items to player
        //set stats if exit
    }

    public Location getSpawnLocation(){return spawn;}
    public void setSpawnLocation(Location loc){spawn = loc;}
    public Location getTutorialLocation(){return tutorial;}
    public void setTutorialLocation(Location loc){tutorial = loc;}

    public Job getParent(){return parent;}
    public void setParent(Job parent){this.parent = parent;}

    //스탯 설정하는거 RpgAPI.getInstance().getPlayerCustomStatus(player).setWeaponDamage(double) 이렇게 되어있어요
    //public Map<Stat/*nope*/,Double> getDefaultStats(){}
    //public void setDefaultStats(Stat stat, Double value);
    //public void setDefaultStats(Map<Stat,Double> values);

    public List<ItemStack> getDefaultItems(){return defaultItem;}
    public void addDefaultItems(ItemStack...itemStacks){defaultItem.addAll(Arrays.asList(itemStacks));}
    public void setDefaultItems(List<ItemStack> itemstacks){defaultItem = itemstacks;}

    //나중에(귀찮)
    //public Map<String,Object> serialize(); //Yamlconfiguration 에 저장할수있게

    public List<String> getPermission(){return perm;}

    //이해못함
    /*public String getPrefix(); //pex 사용
    public String setPrefix(String prefix);
    public String getSuffix(); //pex 사용
    public void setSuffix(String suffix);
    public String getTribe();
    public String setTribe(String tribe);*/
}
