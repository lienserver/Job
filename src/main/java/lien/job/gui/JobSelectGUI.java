package lien.job.gui;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

import com.gnurung.gunugui.api.Item;
import com.gnurung.gunugui.bukkit.BukkitItem;
import com.gnurung.gunugui.bukkit.ChestInventoryGUI;
import com.gnurung.gunugui.bukkit.event.gui.GUIClickEvent;

import lien.job.JobPl;
import lien.job.api.Job;

public class JobSelectGUI extends ChestInventoryGUI implements GUIClickEvent
{
	private static int[] jobSlots = new int[] {1,2,3,4}; //...
	private List<JobSelectButton> jobList = new ArrayList<JobSelectButton>();
	private final Job parent;
	public JobSelectGUI(Player p) 
	{
		super(JobPl.getInstance(), "전직하기", 3);
		parent = ;
		for(Job job : JobPl.getInstance().getJobs())
			if((parent == null && parent == job) || parent.equals(parent))
			{
				JobSelectButton jsb = new JobSelectButton(job);
				setItem(jobSlots[jobList.size()], jsb);
				jobList.add(jsb);
			}
		
	}

	@Override
	public void setItem(int slot, Item item) 
	{
		if(item instanceof BukkitItem)
			setItemInInventory((BukkitItem) item, slot);
	}

	@Override
	public Item getItem(int slot)
	{
		for(int i = 0; i < jobSlots.length; i++)
			if(jobSlots[i] == slot)
				return jobList.get(i);
		return null;
	}

	@Override
	public Collection<? extends Item> getItems() 
	{
		return jobList;
	}

	@Override
	public void onGUIClicked(InventoryClickEvent e) 
	{
		//GUI가 어케생겼는지 몰라서..
	}

}
