package com.wkb.push.task;

import java.util.Calendar;
import java.util.concurrent.ExecutorService;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.wkb.push.PushUtils;

public class ExpireAlarmTask implements Job
{
	@Override
	@SuppressWarnings("unchecked")
	public void execute(JobExecutionContext arg0) throws JobExecutionException
	{
		// TODO Auto-generated method stub
				final int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
				String jm = PushUtils.jdkSha1(day+"&"+PushUtils.Salt);
				String path ="http://apiv6.dkwgps.com/Remind/remindDQ?jm="+jm.toUpperCase();
				JsonObject jsonRes = PushUtils.getInputStreamJson(path);
				ExecutorService  executor = PushUtils.getThreadPool();
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
							final String content = jsonObj.get("content").getAsString();
							final String sn = jsonObj.get("sn").getAsString();
							String type = jsonObj.get("type").getAsString();
							String ys = jsonObj.get("yuesend").getAsString();
							final String vid = jsonObj.get("vid").getAsString();
							final String lon = jsonObj.get("lon").getAsString();
							final String lat = jsonObj.get("lat").getAsString();
							String domain = jsonObj.get("domain").getAsString();
							if(PushUtils.domain.equals(domain))
							{
								PushUtils.pushMessage(loginName, content, type);
								// TODO Auto-generated method stub
								
								executor.submit(new Runnable(){
			
									@Override
									public void run()
									{
										String jm = PushUtils.jdkSha1(sn+"&"+PushUtils.Salt);
										String pathback = "http://apiv6.dkwgps.com/Remind/addUpload";
										Gson gson = new Gson();
										
										JsonObject json = new JsonObject();
										json.addProperty("sn", sn);
										json.addProperty("types", "7");
										json.addProperty("content", content);
										json.addProperty("vip_id", vid);
										json.addProperty("lon", lon);
										json.addProperty("lat", lat);
										json.addProperty("jm", jm.toUpperCase());
										String jsonStr = gson.toJson(json);
			//							String param = "sn="+sn+"&types="+"8"+"&content="+content+
			//									"&vip_id="+vid+"&lon="+lon+"&lat="+lat+"&jm="+jm.toUpperCase();				
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
