package com.bcx.push.task;

import java.util.Calendar;
import java.util.concurrent.ExecutorService;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.bcx.push.PushUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class OtherTask implements Job
{

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException
	{
		// TODO Auto-generated method stub
		final int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		String jm = PushUtils.jdkSha1(day+"&"+PushUtils.Salt);
		String path ="http://apiv6.dkwgps.com/Information/advertPush?jm="+jm.toUpperCase();
		JsonObject jsonRes = PushUtils.getInputStreamJson(path);
		ExecutorService  executor = PushUtils.getThreadPool();
		try
		{
			String result = jsonRes.get("result").getAsString();
			if ("1".equals(result))
			{
				JsonArray jsonArray = jsonRes.get("datas").getAsJsonArray();
				System.out.println(jsonArray.toString());
				for (JsonElement jsonEle : jsonArray)
				{
					JsonObject jsonObj = jsonEle.getAsJsonObject();
					String loginName = jsonObj.get("loginname").getAsString();
					String content = jsonObj.get("content").getAsString();
					String type = jsonObj.get("type").getAsString();
					final String id = jsonObj.get("id").getAsString();
					
					PushUtils.pushMessage(loginName, content, type);
					/*
					Future<?> future =  executor.submit(new Runnable(){
						@Override
						public void run()
						{
							// TODO Auto-generated method stub
							String jm2 = PushUtils.jdkSha1(id+"&"+PushUtils.Salt);
							String pathback = "http://apiv6.dkwgps.com/Information/upAdvertPush";
//							String param = "id="+id+"&jm="+jm2.toUpperCase();
							JsonObject jsonObj = new JsonObject();
							jsonObj.addProperty("id", id);
							jsonObj.addProperty("jm", jm2.toUpperCase());
							String jsonStr = new Gson().toJson(jsonObj);
							PushUtils.updataAlarm(pathback, jsonStr);
						}
					});*/
					
				}
			}
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
