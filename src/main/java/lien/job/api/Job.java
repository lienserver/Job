package lien.job.api;

import java.util.List;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;


public abstract class Job 
{
	public Job(Map<String,Object> serial){}
	public abstract void giveJob(Player player);
	public abstract Location spawnLocation();
	public abstract Job getParent();
	public abstract Map<Stat,Double> getDefaultStats();
	public abstract List<ItemStack> getDefaultItems();
	public abstract Map<String,Object> serialize(); //Yamlconfiguration 에 저장할수있게
	public abstract String[] getPermission();
	public abstract String getPrefix(); //pex 사용
	public abstract String getSuffix(); //pex 사용
}
enum Stat
{
	
}
