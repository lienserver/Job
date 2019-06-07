package lien.job.api;

import com.KimDiamond.Classes.PlayerCustomStatus;
import lien.job.JobPl;
import org.bukkit.Bukkit;

import java.lang.reflect.Method;

public enum Stat {
    WeaponDamage("WeaponDamage"),
    CriticalPercent("CriticalPercent"),
    CriticalDamage("CriticalDamage"),
    Piercing("Piercing"),
    TakeDamage("TakeDamage"),
    Defence("Defence"),
    Drain("Drain"),
    MaxHealth("MaxHealth"),
    DodgePercent("DodgePercent"),
    AccuraccyPercent("AccuraccyPercent"),
    FireElementIncrease("FireElementIncrease"),
    WaterElementIncrease("WaterElementIncrease"),
    LightElementIncrease("LightElementIncrease"),
    DarkElementIncrease("DarkElementIncrease"),
    FireElementProtect("FireElementProtect"),
    WaterElementProtect("WaterElementProtect"),
    LightElementProtect("LightElementProtect"),
    DarkElementProtect("DarkElementProtect"),
    AttackSpeed("AttackSpeed"),
    WalkSpeed("WalkSpeed"),
    ShieldReduction("ShieldReduction"),
    ExperienceBuff("ExperienceBuff"),
    DropPercentBuff("DropPercentBuff"),
    DamageScaleToNormal("DamageScaleToNormal"),
    DamageScaleToNamed("DamageScaleToNamed"),
    DamageScaleToBoss("DamageScaleToBoss"),
    DamageScaleToPlayer("DamageScaleToPlayer"),
    HPRegen("HPRegen"),
    MPRegen("MPRegen");

    private String methodName;

    Stat(String methodName){
        this.methodName = methodName;
    }

    public String getMethodName(){
        return this.methodName;
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
}
