package com.wkb.push.task;

import java.util.Calendar;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.google.gson.JsonObject;
import com.wkb.push.PushUtils;

//断电报警
public class EleAlarmTask implements Job
{

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException
	{
		// TODO Auto-generated method stub
		final int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		String jm = PushUtils.jdkSha1(day+"&"+PushUtils.Salt);
		String path ="http://apiv6.dkwgps.com/Remind/remindDD?jm="+jm.toUpperCase();
		JsonObject jobj = PushUtils.getInputStreamJson(path);
		try
		{
			PushUtils.remindAll(jobj);
//			List<Element> list = root.elements("item");
//			for(Element element : list)
//			{
//				String loginName = element.element("loginname").getText();
//				String content = element.elementText("content");
//				String type = element.elementText("type");
//				final String id = element.elementText("id");
//				PushUtils.pushMessage(loginName, content, type);
//				
//				Future<?> future =  executor.submit(new Runnable(){
//					@Override
//					public void run()
//					{
//						// TODO Auto-generated method stub
//						String jm2 = PushUtils.jdkSha1(id+"&"+PushUtils.Salt);
//						String pathback = "http://apiv3.dkwgps.com/gpsAPI.asmx/remindUpID";
//						String param = "id="+id+"&jm="+jm2.toUpperCase();
//						PushUtils.updataAlarm(pathback, param);
//					}
//				});
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
