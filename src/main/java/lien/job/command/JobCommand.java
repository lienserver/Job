package lien.job.command;

import lien.job.JobPl;
import lien.job.part.JobFactory;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.gnurung.gunucommandmodule.Command;

import lien.job.api.Job;
import lien.job.api.Stat;
import lien.job.api.requirement.ItemStackRequirement;
import lien.job.api.requirement.JobRequirement;
import lien.job.api.requirement.LevelRequirement;
import lien.job.api.requirement.PermissionRequirement;
import lien.job.gui.JobSelectGUI;

public class JobCommand 
{
    //notice 나중에 커맨드 처리하는거 제대로 가져올게요

	@Command("/직업 <int>")
	public static void help(CommandSender sender, String[] args,int page)
	{
		//switch를 써야 간지가 남
		switch (page){
			case 1:
				sender.sendMessage("/직업 - 직업플러그인의 명령어를 봅니다");
				sender.sendMessage("/직업생성 <이름> // 직업을 생성합니다");
				sender.sendMessage("/직업삭제 <이름> // 직업을 삭제합니다");
				sender.sendMessage("/직업정보 <직업> // 전직의 정보를봅니다");
				sender.sendMessage("[도움말 1/5]");
				break;
			case 2:
				sender.sendMessage("/직업노드추가 <직업> <노드> // 노드를 추가합니다");
				sender.sendMessage("/직업노드삭제 <직업> <노드> // 노드를 삭제합니다");
				sender.sendMessage("/직업칭호설정 <직업> <칭호> // 칭호를  설정합니다");
				sender.sendMessage("/직업종족설정 <직업> <종족> // 종족을 설정합니다");
				sender.sendMessage("[도움말 2/5]");
				break;
			case 3:
				sender.sendMessage("/직업스텟설정 <직업> <능력치> <값> //기본능력치를 설정합니다");
				sender.sendMessage("/직업스텟삭제 <직업> <능력치> // 기본능력치를 삭제합니다");
				sender.sendMessage(" ");
				StringBuilder statm = new StringBuilder();
				for(Stat stat : Stat.values())
					statm.append(stat.getLocalizedName()).append(" ");
				sender.sendMessage(statm.toString());
				sender.sendMessage("[도움말 3/5]");
				break;
			case 4:
				sender.sendMessage("/직업스폰설정 <이름> // 스폰위치를 서있는곳으로 설정");
				sender.sendMessage("/직업튜토리얼설정 <이름> // 튜토리얼 시작위치를 서있는곳으로 설정");
				sender.sendMessage("/직업튜토리얼끝 // 직업선택창이 뜸");
				sender.sendMessage("/직업전직레벨 <이름> <레벨값> // 레벨제한을 겁니다");
				sender.sendMessage("/직업전직하기설정 <이름> <노드> // 노드제한을 겁니다");
				sender.sendMessage("[도움말 4/5]");
				break;
			case 5:
				sender.sendMessage("/직업gui설정 <이름> <gui칸번호> //gui를 설정합니다");
				sender.sendMessage("/직업gui설정 전직조건아이템 <이름> //전직필요아이템을 넣는 gui를 엽니다");
				sender.sendMessage("/직업gui설정 로어 <이름> <설명글> //ㅈㄱㄴ");
				sender.sendMessage("/직업gui설정 로어del <이름> <줄수> // ㅈㄱㄴ");
				sender.sendMessage("[도움말 5/5]");
				break;
		}
	}

	@Command("/직업")
	public static void help(CommandSender sender, String[] args)
	{
		help(sender, args, 1);
	}
	@Command("/직업생성 <string><job>!")//(?!<job>)<string>
	public static void create(CommandSender sender, String[] args, String job)
	{
		JobPl.getInstance().addJob(JobFactory.createBasic(job)); //TODO
		sender.sendMessage("Create job " + job);
		return;
	}
	@Command("/직업정보 <job>")
	public static void information(CommandSender sender, String[] args, Job job)
	{
		
	}
	@Command("/직업삭제 <job>")
	public static void delete(CommandSender sender, String[] args, Job job)
	{
		// (유저가 그직업에있을시 직업이 아예사라지므로 1차직업선택gui창이 열리게됩니다)
	}
	@Command("/직업부모설정 <job> <job>")
	public static void setparent(CommandSender sender, String[] args, Job job, Job parent)
	{
		if(parent.equals(job.getParent()))
			sender.sendMessage(job.getName() + "직업의 부모는 이미" + parent.getName() + "입니다");
		else
		{
			job.setParent(parent);
			sender.sendMessage(job.getName() + "직업의 부모는 " + parent.getName() + "가 되었습니다");
		}
	}	
	@Command("/직업노드추가 <job> <string>")
	public static void addpermission(CommandSender sender, String[] args, Job job, String node)
	{
		if(job.getPermission().contains(node))
			 sender.sendMessage("직업의 노드에는 " + node + "가 이미 존재힙니다");

		else 
		{
			job.getPermission().add(node);
			sender.sendMessage("직업의 노드중" + node + "가 추가되었습니다");
		}
	}
	@Command("/직업노드삭제 <job> <string>")
	public static void removepermission(CommandSender sender, String[] args, Job job, String node)
	{
		if(job.getPermission().contains(node))
		{
			job.getPermission().remove(node);
			sender.sendMessage("직업의 노드중" + node + "가 삭제되었습니다");
		}
		else sender.sendMessage("직업의 노드에는 " + node + "가 존재하지 않습니다");
	}
	@Command("/직업칭호설정 <job> <string>")
	public static void setprefix(CommandSender sender, String[] args, Job job, String prefix)
	{
		job.setPrefix(prefix);
		sender.sendMessage("직업의 접두사가 " + prefix + "로 변경되었습니다");
	}
	@Command("/직업종족설정 <job> <string>")
	public static void settribe(CommandSender sender, String[] args, Job job, String tribe)
	{
		job.setTribe(tribe);
		sender.sendMessage("종족이 " + tribe + "로 변경되었습니다");
	}
	@Command("/직업스텟삭제 <job> <stat>")
	public static void deletestat(CommandSender sender, String[] args, Job job, Stat stat)
	{
		job.setDefaultStats(stat, null);
		sender.sendMessage("기본스텟 " + stat.getLocalizedName() +" 이 삭제되었습니다");
	}
	@Command("/직업스텟설정 <job> <stat> <double>|<int>")
	public static void setstat(CommandSender sender, String[] args, Job job, Stat stat, double value)
	{
		job.setDefaultStats(stat, value);
		sender.sendMessage("기본스텟 " + stat.getLocalizedName() +" 이 "+ value + " 로 설정되었습니다");
	}
	@Command("/직업스폰설정 <job>")
	public static void setspawn(Player sender, String[] args, Job job)
	{
		job.setSpawnLocation(sender.getLocation());
		sender.sendMessage("직업 스폰이 설정되었습니다");
	}
	@Command("/직업튜토리얼설정 <job>")
	public static void settutorial(Player sender, String[] args, Job job)
	{
		job.setTutorialLocation(sender.getLocation());
		sender.sendMessage("튜토리얼 스폰이 설정되었습니다");
	}
	@Command("/직업튜토리얼끝 <job>")
	public static void endtutorial(Player sender, String[] args, Job job)
	{
		new JobSelectGUI(sender).open();
	}
	@Command("/직업(gui|GUI)설정 <job> <int>")
	public static void setGui(CommandSender sender, String[] args, Job job, int slot)
	{
		job.setGUISlot(slot);
		sender.sendMessage("직업 GUI 슬롯이 설정되었습니다");
	}
	@Command("/직업(gui|GUI)설정 전직조건아이템 <job>")
	public static void upgradeRequiredItem(Player sender, String[] args, Job job)
	{
		ItemStack item = sender.getInventory().getItemInMainHand();
		if(item != null && item.getType() != Material.AIR)
		{
			JobRequirement req = new ItemStackRequirement(item);
			job.addRequirements(req);
			sender.sendMessage("직업 전직을 위해 필요한 아이템이 설정되었습니다");
		}
		else
			sender.sendMessage("손에 아이템을 들어야합니다");
	}
	@Command("/직업 로어 <string*>")
	public static void setlore(CommandSender sender, String[] args, Job job,String str)
	{
		ItemStack item = job.getJobIcon();
		ItemMeta im = item.getItemMeta();
		List<String> lore = im.hasLore() ? im.getLore() : new ArrayList<>();
		lore.add(str);
		im.setLore(lore);
		item.setItemMeta(im);
		job.setJobIcon(item);
		sender.sendMessage("로어를 추가했습니다");
	}
	@Command("/직업 로어del <job> <int>")
	public static void removelore(CommandSender sender, String[] args, Job job,int i)
	{
		ItemStack item = job.getJobIcon();
		ItemMeta im = item.getItemMeta();
		List<String> lore = im.hasLore() ? im.getLore() : new ArrayList<>();
		lore.remove(i);
		im.setLore(lore);
		item.setItemMeta(im);
		job.setJobIcon(item);
		sender.sendMessage("로어를 설정했습니다");
	}
	@Command("/직업전직레벨 <job> <int>")
	public static void setminlv(CommandSender sender, String[] args, Job job,int level)
	{
		for(JobRequirement req : job.getRequirements())
		{
			if(req instanceof LevelRequirement)
			{
				job.getRequirements().remove(req);
				break;
			}
		}
		job.addRequirements(new LevelRequirement(level));
		sender.sendMessage("필요레벨이 설정되었습니다");
	}
	@Command("/직업전직하기설정 <job> <string>")
	public static void removelore(CommandSender sender, String[] args, Job job,String node)
	{
		for(JobRequirement req : job.getRequirements())
		{
			if(req instanceof PermissionRequirement)
			{
				job.getRequirements().remove(req);
				break;
			}
		}
		job.addRequirements(new PermissionRequirement(node));
		sender.sendMessage("필요 노드가 설정되었습니다");
	}
}
