package lien.job.command.parameter;

import com.gnurung.gunucommandmodule.module.ParameterType;

import lien.job.JobPl;

public class JobType implements ParameterType
{
	@Override
	public String regex(Object sender, String s)
	{
		if(JobPl.getInstance().getJob(s) == null) return "($^)";
		else return "("+s+")";
	}
	@Override
	public Object getObject(Object sender, String s)
	{
		return JobPl.getInstance().getJob(s);
	}
	@Override
	public String getName() {
		return "job";
	}


}
