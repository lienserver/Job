package lien.job.api.requirement;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ItemStackRequirement implements JobRequirement
{

	ItemStack item;
	public ItemStackRequirement(ItemStack item) 
	{
		this.item = item;
	}
	@Override
	public boolean playerRequipred(Player p)
	{
		if(p.getInventory().removeItem(item).isEmpty()) 
		{
			p.getInventory().addItem(item);
			return true;
		}
		return false;
	}

}
