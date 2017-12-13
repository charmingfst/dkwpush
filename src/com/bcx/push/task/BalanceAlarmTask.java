package com.bcx.push.task;

import java.util.Calendar;
import java.util.concurrent.ExecutorService;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.bcx.push.PushUtils;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class BalanceAlarmTask implements Job
{

	@Override
	@SuppressWarnings("unchecked")
	public void execute(JobExecutionContext arg0) throws JobExecutionException
	{
		// TODO Auto-generated method stub
		final int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		String jm = PushUtils.jdkSha1(day+"&"+PushUtils.Salt);
//		System.out.println(jm.toUpperCase());
		String path ="http://apiv6.dkwgps.com/Remind/remindYE?jm="+jm.toUpperCase();
		JsonObject jsonRes = PushUtils.getInputStreamJson(path);
		ExecutorService  executor = PushUtils.getThreadPool();
		try
		{
//			SAXReader sr = new SAXReader();//获取读取xml的对象。
//			Document doc = sr.read(in);
//			in.close();
//			Element root = doc.getRootElement();		
//			List<Element> list = root.elements("item");
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
					PushUtils.pushMessage(loginName, content, type);
					System.out.println("content:"+content);
					// TODO Auto-generated method stub
					String jm2 = PushUtils.jdkSha1(sn+"&"+PushUtils.Salt);
					String pathback = "http://apiv6.dkwgps.com/Remind/remindUpYE";
					Gson gson = new Gson();
					
					JsonObject json = new JsonObject();
					json.addProperty("sn", sn);
					json.addProperty("yue", ys);
					json.addProperty("jm", jm2.toUpperCase());
					String jsonStr = gson.toJson(json);
					
					
					String param = "sn="+sn+"&yue="+ys+"&jm="+jm2.toUpperCase();
//					System.out.println(jm2.toUpperCase());
					PushUtils.updataAlarm(pathback, jsonStr);
					
				
					executor.submit(new Runnable(){

						@Override
						public void run()
						{
							String jm = PushUtils.jdkSha1(sn+"&"+PushUtils.Salt);
							String pathback = "http://apiv6.dkwgps.com/Remind/addUpload";
							Gson gson = new Gson();
							
							JsonObject json = new JsonObject();
							json.addProperty("sn", sn);
							json.addProperty("types", "8");
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
			/*for(Element element : list)
			{
				String loginName = element.element("loginname").getText();
				final String content = element.elementText("content");
				final String sn = element.elementText("sn");
				String type = element.elementText("type");
				String ys = element.elementText("yuesend");
				final String vid = element.elementText("vid");
				final String lon = element.elementText("lon");
				final String lat = element.elementText("lat");
//				System.out.println(loginName + " " + content);
				PushUtils.pushMessage(loginName, content, type);

				// TODO Auto-generated method stub
				String jm2 = PushUtils.jdkSha1(sn+"&"+PushUtils.Salt);
				String pathback = "http://apiv4.dkwgps.com/Remind/remindUpYE";
				Gson gson = new Gson();
				
				JsonObject json = new JsonObject();
				json.addProperty("sn", sn);
				json.addProperty("yue", ys);
				json.addProperty("jm", jm2.toUpperCase());
				String jsonStr = gson.toJson(json);
				
				
				String param = "sn="+sn+"&yue="+ys+"&jm="+jm2.toUpperCase();
//				System.out.println(jm2.toUpperCase());
				PushUtils.updataAlarm(pathback, jsonStr);
				
			
				executor.submit(new Runnable(){

					@Override
					public void run()
					{
						String jm = PushUtils.jdkSha1(sn+"&"+PushUtils.Salt);
						String pathback = "http://apiv3.dkwgps.com/gpsAPI.asmx/addUpload";
						String param = "sn="+sn+"&types="+"8"+"&content="+content+
								"&vip_id="+vid+"&lon="+lon+"&lat="+lat+"&jm="+jm.toUpperCase();				
						PushUtils.updataAlarm(pathback, param);
					}		
				});
			}*/
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			if(executor != null)
			{
//				executor.shutdown();
			}
		}
	}

}
