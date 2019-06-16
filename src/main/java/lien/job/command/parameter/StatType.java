package lien.job.command.parameter;

import com.gnurung.gunucommandmodule.module.ParameterType;

import lien.job.api.Stat;

public class StatType implements ParameterType
{

	@Override
	public String getName() 
	{
		return "stat";
	}

	@Override
	public Object getObject(Object arg0, String arg1)
	{
		return Stat.getByLocalizedName(arg1);
	}

	@Override
	public String regex(Object arg0, String arg1) 
	{
		if(Stat.getByLocalizedName(arg1) == null) return "$^";
		else return "(["+arg1+"])";
	}

}
