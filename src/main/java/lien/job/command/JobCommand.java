package lien.job.command;

import org.bukkit.command.CommandSender;

import lien.job.api.Job;
import lien.job.api.Stat;

public class JobCommand 
{
	@Command("/직업")
	public static void help(CommandSender sender, String[] args)
	{
		
	}
	@Command("/직업생성 <string>!<job>")//(?!<job>)<string>
	public static void create(CommandSender sender, String[] args, String job)
	{
		
	}
	@Command("/직업삭제 <job>")
	public static void delete(CommandSender sender, String[] args, Job job)
	{
		
	}
	@Command("/직업부모설정 <job> <job>")
	public static void setparent(CommandSender sender, String[] args, Job job, Job parent)
	{
		
	}	
	@Command("/직업노드추가 <job> <string>")
	public static void addpermission(CommandSender sender, String[] args, Job job, String node)
	{
		
	}
	@Command("/직업노드삭제 <job> <string>")
	public static void removepermission(CommandSender sender, String[] args, Job job, String node)
	{
		
	}
	@Command("/직업칭호설정 <job> <string>")
	public static void setprefix(CommandSender sender, String[] args, Job job, String prefix)
	{
		
	}
	@Command("/직업종족설정 <job> <string>")
	public static void settribe(CommandSender sender, String[] args, Job job, String tribe)
	{
		
	}
	@Command("/직업스텟삭제 <job> <stat>")
	public static void deletestat(CommandSender sender, String[] args, Job job, Stat stat)
	{
		
	}
	@Command("/직업스텟설정 <job> <stat> <double>|<int>")
	public static void setstat(CommandSender sender, String[] args, Job job, Stat stat, double value)
	{
		
	}
	@Command("/직업스폰설정 <job>")
	public static void setspawn(CommandSender sender, String[] args, Job job)
	{
		
	}
	@Command("/직업튜토리얼설정 <job>")
	public static void settutorial(CommandSender sender, String[] args, Job job)
	{
		//튜토리얼 장소로 이동시켜줍니다
	}
	@Command("/직업튜토리얼끝 <job>")
	public static void endtutorial(CommandSender sender, String[] args, Job job)
	{
		//1차직업선택 GUI를 열어줍니다
	}
}
