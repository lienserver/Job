package lien.job.gui;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

import com.gnurung.gunugui.bukkit.BukkitItem;
import com.gnurung.gunugui.bukkit.event.item.ItemClickEvent;

import lien.job.Message;
import lien.job.api.Job;
import lien.job.api.cost.JobCost;

public class JobSelectButton extends BukkitItem implements ItemClickEvent
{
	private final Job job;
	public JobSelectButton(Job job) 
	{
		super(job.getJobIcon());
		this.job = job;
	}

	@Override
	public void onItemClick(InventoryClickEvent e) 
	{
		if(e.getWhoClicked() instanceof Player)
		{
			Player p = (Player)e.getWhoClicked();
			if(job.canGiveJob(p))
			{
				for(JobCost cost : job.getCosts())
					cost.pay(p);
				job.giveJob(p);
			}
			else
			{
				p.sendMessage(Message.CANNOT_GIVE_JOB.toString(p));
			}
		}
		
		
	}

}
