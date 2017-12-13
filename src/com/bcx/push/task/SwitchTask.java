package com.bcx.push.task;

import java.util.Calendar;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.bcx.push.PushUtils;
import com.google.gson.JsonObject;

public class SwitchTask implements Job
{

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException
	{
		// TODO Auto-generated method stub
				final int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
				String jm = PushUtils.jdkSha1(day+"&"+PushUtils.Salt);
				String path ="http://apiv6.dkwgps.com/Remind/remindDM?jm="+jm.toUpperCase();
				JsonObject jobj = PushUtils.getInputStreamJson(path);
				try
				{
					PushUtils.remindAll(jobj);
	
				} catch (Exception e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally
				{
				
				}
	}

}
