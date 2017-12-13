package com.nd.push.task;

import java.util.Calendar;
import java.util.concurrent.ExecutorService;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.nd.push.PushUtils;

public class CardTask implements Job
{

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException
	{
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		final int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		String jm = PushUtils.jdkSha1(day + "&" + PushUtils.Salt);
		String path = "http://apiv6.dkwgps.com/Remind/wlCardNotify?jm="
				+ jm.toUpperCase();
		JsonObject jsonRes = PushUtils.getInputStreamJson(path);
		ExecutorService executor = PushUtils.getThreadPool();
		try
		{
			String result = jsonRes.get("result").getAsString();
			if ("1".equals(result))
			{
				JsonArray jsonArray = jsonRes.get("datas").getAsJsonArray();
				for (JsonElement jsonEle : jsonArray)
				{
					JsonObject jsonObj = jsonEle.getAsJsonObject();
					String loginName = jsonObj.get("loginname").getAsString();
					String content = jsonObj.get("content").getAsString();
					String type = jsonObj.get("type").getAsString();
					final String tid = jsonObj.get("t_id").getAsString();
					final String vid = jsonObj.get("vip_id").getAsString();
					String domain = jsonObj.get("domain").getAsString();
					if (PushUtils.domain.equals(domain))
					{
						PushUtils.pushMessage(loginName, content, type);
						executor.submit(new Runnable()
						{
							@Override
							public void run()
							{
								// TODO Auto-generated method stub
								String jm = PushUtils.jdkSha1(vid + "&"
										+ PushUtils.Salt);
								String pathback = "http://apiv4.dkwgps.com/WLCard/addMsgByTZ";
								JsonObject jsonObj = new JsonObject();
								jsonObj.addProperty("vip_id", vid);
								jsonObj.addProperty("t_id", tid);
								jsonObj.addProperty("jm", jm.toUpperCase());
								String jsonStr = new Gson().toJson(jsonObj);
								// String param =
								// "vip_id="+vid+"&t_id="+tid+"&jm="+jm.toUpperCase();
								PushUtils.updataAlarm(pathback, jsonStr);
							}
						});
					}
				}
			}
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
