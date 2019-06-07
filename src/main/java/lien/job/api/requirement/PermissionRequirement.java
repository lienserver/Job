package lien.job.api.requirement;

import org.bukkit.entity.Player;

public class PermissionRequirement implements JobRequirement
{
	String permission;
	public PermissionRequirement(String perm) 
	{
		this.permission = perm;
	}
	@Override
	public boolean playerRequipred(Player p) 
	{
		if(p.hasPermission(permission))
			return true;
		else return false;
	}
}
