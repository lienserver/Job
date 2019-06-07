package lien.job.api.requirement;

import org.bukkit.entity.Player;

public class LevelRequirement implements JobRequirement
{
	int level;
	public LevelRequirement(int level) 
	{
		this.level = level;
	}
	@Override
	public boolean playerRequipred(Player p) 
	{
		if(p.getLevel() < level)
			return false;
		else return true;
	}
}
