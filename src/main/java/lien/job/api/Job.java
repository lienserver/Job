package lien.job.api;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import lien.job.api.cost.JobCost;
import lien.job.api.requirement.JobRequirement;


public abstract class Job 
{
	public Job(Map<String,Object> serial){
		for(Map.Entry<String,Object> ser : serial.entrySet()){
			try{
				this.getClass().getDeclaredField(ser.getKey()).set(this, ser.getValue());
			}
			catch (Exception e){
				e.printStackTrace();
			}
		}
	}
	public abstract String getName();
	public abstract ItemStack getJobIcon();
	public abstract void setJobIcon(ItemStack item);
	public abstract int getGUISlot();
	public abstract void setGUISlot(int slot);
	public abstract void giveJob(Player player);
	public abstract Location getSpawnLocation();
	public abstract void setSpawnLocation(Location loc);
	public abstract Location getTutorialLocation();
	public abstract void setTutorialLocation(Location loc);
	public abstract Job getParent();
	public abstract void setParent(Job parent);
	public abstract Map<Stat,Double> getDefaultStats();
	public abstract void setDefaultStats(Stat stat, Double value);
	public abstract void setDefaultStats(Map<Stat,Double> values);
	public abstract List<ItemStack> getDefaultItems();
	public abstract void addDefaultItems(ItemStack...itemStacks);
	public abstract void setDefaultItems(List<ItemStack> itemstacks);
	public abstract Map<String,Object> serialize(); //Yamlconfiguration 에 저장할수있게
	public abstract List<String> getPermission();
	public abstract String getPrefix(); //pex 사용
	public abstract String setPrefix(String prefix); 
	public abstract String getSuffix(); //pex 사용
	public abstract void setSuffix(String suffix); 
	public abstract String getTribe();
	public abstract String setTribe(String tribe);
	public abstract Set<JobCost> getCosts();
	public abstract void setCosts(Set<JobCost> cost);
	public abstract void addCosts(JobCost...jobCost);
	public abstract Set<JobRequirement> getRequirements();
	public abstract void setRequirements(Set<JobRequirement> requirement);
	public abstract void addRequirements(JobRequirement...jobRequirements);
	public abstract boolean canGiveJob(Player player);
}
