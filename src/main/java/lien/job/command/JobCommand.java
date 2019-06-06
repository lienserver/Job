package lien.job.command;

import org.bukkit.command.CommandSender;

import lien.job.api.Job;

public class JobCommand 
{
	@Command("/직업")
	public static void help(CommandSender sender, String[] args)
	{
		
	}
	@Command("/직업생성 <string>!<job>")//(?!<job>)<string>
	public static void help(CommandSender sender, String[] args, String job)
	{
		
	}
	@Command("/직업삭제 <job>")
	public static void help(CommandSender sender, String[] args, Job job)
	{
		
	}
	@Command("/직업부모설정 <job> <job>")
	public static void help(CommandSender sender, String[] args, Job job, Job parent)
	{
		
	}	
	@Command("/직업노드추가 <job> <string>")
	public static void help(CommandSender sender, String[] args, Job job, String node)
	{
		
	}
	@Command("/직업노드삭제 <job> <string>")
	public static void help(CommandSender sender, String[] args, Job job, String node)
	{
		
	}
	@Command("/직업칭호설정 <job> <string>")
	public static void help(CommandSender sender, String[] args, Job job, String prefix)
	{
		
	}
	@Command("/직업종족설정 <job> <string>")
	public static void help(CommandSender sender, String[] args, Job job, String tribe)
	{
		
	}
}
