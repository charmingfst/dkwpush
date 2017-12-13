package com.wkb.push.task;

import java.util.Calendar;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.google.gson.JsonObject;
import com.wkb.push.PushUtils;

public class LowPowerTask implements Job
{
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException
	{
		final int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		String jm = PushUtils.jdkSha1(day+"&"+PushUtils.Salt);
		String path ="http://apiv6.dkwgps.com/Remind/remindLowD?jm="+jm.toUpperCase();
		JsonObject jobj = PushUtils.getInputStreamJson(path);
		try
		{
			PushUtils.remindAll(jobj);
//			List<Element> list = root.elements("Item");
//			for(Element element : list)
//			{
//				String loginName = element.element("LoginName").getText();
//				String content = element.elementText("Content");
//				String type = element.elementText("Type");
//				final String id = element.elementText("ID");
//				PushUtils.pushMessage(loginName, content,type);
//
//				executor.submit(new Runnable(){
//
//					@Override
//					public void run()
//					{
//						// TODO Auto-generated method stub
//						String jm2 = PushUtils.jdkSha1(hour+"&"+PushUtils.Salt);
//						String pathback = "http://api.dkwgps.com/vipMgr.asmx/AppUpID?";
//						String param = "id="+id+"&jm="+jm2.toUpperCase();
//						PushUtils.updataAlarm(pathback, param);
//					}
//				});		
//				
//			}
			
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
		
		}
		
	}
}
