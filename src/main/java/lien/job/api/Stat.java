package lien.job.api;

import com.KimDiamond.API.RpgAPI;
import com.KimDiamond.Classes.PlayerCustomStatus;
import lien.job.JobPl;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.lang.reflect.Method;

public enum Stat {
    WeaponDamage("WeaponDamage","무기데미지"),
    CriticalPercent("CriticalPercent","CriticalPercent"),
    CriticalDamage("CriticalDamage","치명타피해량"),
    Piercing("Piercing"),
    TakeDamage("TakeDamage"),
    Defence("Defence","방어력"),
    Drain("Drain"),
    MaxHealth("MaxHealth","최대체력"),
    DodgePercent("DodgePercent","회피율"),
    AccuraccyPercent("AccuraccyPercent","명중률"),
    FireElementIncrease("FireElementIncrease"),
    WaterElementIncrease("WaterElementIncrease"),
    LightElementIncrease("LightElementIncrease"),
    DarkElementIncrease("DarkElementIncrease"),
    FireElementProtect("FireElementProtect"),
    WaterElementProtect("WaterElementProtect"),
    LightElementProtect("LightElementProtect"),
    DarkElementProtect("DarkElementProtect"),
    AttackSpeed("AttackSpeed","공격속도"),
    WalkSpeed("WalkSpeed","이동속도"),
    ShieldReduction("ShieldReduction","방패방어"),
    ExperienceBuff("ExperienceBuff"),
    DropPercentBuff("DropPercentBuff"),
    DamageScaleToNormal("DamageScaleToNormal"),
    DamageScaleToNamed("DamageScaleToNamed"),
    DamageScaleToBoss("DamageScaleToBoss"),
    DamageScaleToPlayer("DamageScaleToPlayer"),
    HPRegen("HPRegen"),
    MPRegen("MPRegen");

    private final String methodName;
    private String localizedName;
    Stat(String methodName,String localizedName){
        this.methodName = methodName;
        this.localizedName = localizedName;
    }
    Stat(String methodName){
        this.methodName = methodName;
        this.localizedName = methodName;
    }
    public String getMethodName(){
        return this.methodName;
    }
    public String getLocalizedName()
    {
    	return this.localizedName;
    }

    public Method getSetter(){
        try{
            return PlayerCustomStatus.class.getMethod("set" + methodName);
        }
        catch (Exception e){
            e.printStackTrace();
            Bukkit.getLogger().warning("If u see this, you fucked");
        }
        return null;
    }
    public Method getGetter(){
        try{
            return PlayerCustomStatus.class.getMethod("get" + methodName);
        }
        catch (Exception e){
            e.printStackTrace();
            Bukkit.getLogger().warning("If u see this, you fucked");
        }
        return null;
    }
    public double get(Player player)
    {
    	try
    	{	
    		getGetter().invoke(	RpgAPI.getInstance().getPlayerCustomStatus(player));		
    	}
    	catch (Exception e){ e.printStackTrace();}
    }
    public void set(Player player, double val)
    {
    	try
    	{	
    		getSetter().invoke(	RpgAPI.getInstance().getPlayerCustomStatus(player),val);		
    	}
    	catch (Exception e){ e.printStackTrace();}
    }
    public static Stat getByLocalizedName(String name)
    {
    	for(Stat st:values())
    		if(st.getLocalizedName() != null && st.getLocalizedName().equals(name))
    			return st;
    	return null;
    }
}
