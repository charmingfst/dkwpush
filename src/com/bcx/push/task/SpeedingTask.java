package com.bcx.push.task;

import java.util.Calendar;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.bcx.push.PushUtils;
import com.google.gson.JsonObject;

public class SpeedingTask implements Job
{

	@Override
	@SuppressWarnings("unchecked")
	public void execute(JobExecutionContext arg0) throws JobExecutionException
	{
		// TODO Auto-generated method stub
		final int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		String jm = PushUtils.jdkSha1(day+"&"+PushUtils.Salt);
		String path ="http://apiv6.dkwgps.com/Remind/remindCS?jm="+jm.toUpperCase();
		JsonObject jobj = PushUtils.getInputStreamJson(path);
		try
		{
			PushUtils.remindAll(jobj);
			/*SAXReader sr = new SAXReader();//获取读取xml的对象。
			Document doc = sr.read(in);
			in.close();
			Element root = doc.getRootElement();
			PushUtils.remindAll(root);*/
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
		
		}
	}

}
