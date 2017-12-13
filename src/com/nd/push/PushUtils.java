package com.nd.push;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.dom4j.Element;
import org.quartz.impl.StdSchedulerFactory;

import cn.jpush.api.JPushClient;
import cn.jpush.api.common.resp.APIConnectionException;
import cn.jpush.api.common.resp.APIRequestException;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.IosNotification.Builder;
import cn.jpush.api.push.model.notification.Notification;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class PushUtils 
{
	public final static String Salt = "wuliangpsDkw_8675.Zz";
	private final static String appKey = "0c0f9a337fef0df332d3d76d";
	private final static String masterSecret = "f6c7466dc14d7dd0dff410e7";
	public final static String domain = "niuding.com";
	private static ExecutorService threadPool;
	private static StdSchedulerFactory factory;
	public static void pushMessage(String username, String content,String type)
	{
		JPushClient jpushClient = new JPushClient(masterSecret, appKey, 3);
	
	
	        // For push, all you need do is to build PushPayload object.
	        PushPayload payload = buildPushObject_all_all_alert(username.toLowerCase(), content, type);
	
	        try {
	            PushResult result = jpushClient.sendPush(payload);
	
	        } catch (APIConnectionException e) {
	            // Connection error, should retry later
//	            LOG.error("Connection error, should retry later", e);
	
	        } catch (APIRequestException e) {
	            // Should review the error, and fix the request
//	            LOG.error("Should review the error, and fix the request", e);
//	            LOG.info("HTTP Status: " + e.getStatus());
//	            LOG.info("Error Code: " + e.getErrorCode());
//	            LOG.info("Error Message: " + e.getErrorMessage());
	        }
	}
	public static PushPayload buildPushObject_all_all_alert(String username, String content, String type) {
		
		
		Builder builder = IosNotification.newBuilder();
		if("断电报警".equals(type))
		{
			
			builder
			.setAlert(content)
            .setSound("duandianbaojing.wav");
           
		}else if("震动报警".equals(type)||"震动报警测试".equals(type))
		{
			builder
			.setAlert(content)
            .setSound("zhendongbaojing.wav");
		           
		}else if ("围栏报警".equals(type))
		{
			builder
			.setAlert(content)
            .setSound("weilanbaojing.wav")
            ;
		            
		}else if("防拆报警".equals(type))
		{
			builder
			.setAlert(content)
            .setSound("fangchaibaojing.wav");
		}else if("低电报警".equals(type))
		{
			builder
			.setAlert(content)
            .setSound("didian.wav");
		}else if("充电完成".equals(type))
		{
			builder
			.setAlert(content)
            .setSound("mandian.wav");
		}else
		{
			builder
			.setAlert(content);
		}
		builder.addExtra("title",type);
		IosNotification iosNotification = builder.build();
        return PushPayload.newBuilder()
                .setPlatform(Platform.android_ios())
                .setAudience(Audience.alias(username))
                .setNotification(Notification.newBuilder()
                        .addPlatformNotification(iosNotification)
                        .addPlatformNotification(AndroidNotification.newBuilder().setAlert(content).build())
                        .build())
                .setOptions(Options.newBuilder().setApnsProduction(true).build()) //true为生成环境，false为开发环境
                .build();
    }
	public static InputStreamReader webServiceHelpWlk(String path){
		InputStream inputStream = getInputStreamWlk(path);
		InputStreamReader strInStream = null;
		if(inputStream!=null){
			try {
				strInStream = new InputStreamReader(inputStream, "UTF-8");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return strInStream;
	}
	
	private static InputStream getInputStreamWlk(String path){
		InputStream inputStream = null;
		try {
			URL url = new URL(path);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setUseCaches(false);
			conn.setConnectTimeout(10000);
			conn.setReadTimeout(30000);
			conn.setRequestMethod("GET");
			InputStream in = conn.getInputStream();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int len = 0;
			byte[] b = new byte[1024];
			while ((len = in.read(b, 0, b.length)) != -1) {                     
			    baos.write(b, 0, len);
			}
			byte[] bytes =  baos.toByteArray();
//			System.out.println("xml:"+new String(bytes));
			inputStream = new ByteArrayInputStream(bytes); 
			in.close();
			conn.disconnect();
		} catch (Exception e) {
//			System.out.println("wlk请求地址webservice失败 超时。。。。。");
			return null;
		}
		return inputStream;
	}
	public static JsonObject getInputStreamJson(String path){
		JsonObject resJson = null;
		try {
			URL url = new URL(path);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setUseCaches(false);
			conn.setConnectTimeout(10000);
			conn.setReadTimeout(30000);
			conn.setRequestMethod("GET");
			InputStream in = conn.getInputStream();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int len = 0;
			byte[] b = new byte[1024];
			while ((len = in.read(b, 0, b.length)) != -1) {                     
			    baos.write(b, 0, len);
			}
			byte[] bytes =  baos.toByteArray();
//			System.out.println("xml:"+new String(bytes));
//			inputStream = new ByteArrayInputStream(bytes); 
			
			String result = new String(bytes);
//			System.out.println("nd result:"+result);
			resJson = new JsonParser().parse(result).getAsJsonObject();
			
			in.close();
			conn.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
//			System.out.println("wlk请求地址webservice失败 超时。。。。。");
			return null;
		}
		return resJson;
	}
	public static String jdkSha1(String str)
	{
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			byte[] encodeBytes = md.digest(str.getBytes());
			StringBuffer sb = new StringBuffer(encodeBytes.length * 2);
			for (int i = 0; i < encodeBytes.length; i++) {
				sb.append(Character.forDigit((encodeBytes[i] & 240) >> 4, 16));
				sb.append(Character.forDigit(encodeBytes[i] & 15, 16));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
/*	public static void updataAlarm(String path,String param)
	{
		try {
			URL url = new URL(path);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setUseCaches(false);
			conn.setConnectTimeout(5000);
			conn.setReadTimeout(5000);
			conn.setRequestMethod("POST");
//			conn.setRequestProperty("id",id);
//			conn.setRequestProperty("jm",jm);
			OutputStream os = conn.getOutputStream();
			os.write(param.getBytes());
			os.close();
//			conn.getInputStream();
			// 当正确响应时处理数据   
			StringBuffer sb = new StringBuffer();   
			String readLine;   
			BufferedReader responseReader;   
			// 处理响应流，必须与服务器响应流输出的编码一致   
			 responseReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));   
//			while ((readLine = responseReader.readLine()) != null) {   
//				sb.append(readLine).append("\n"); 
//			}
			responseReader.close();
			conn.disconnect();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}*/
	public static void updataAlarm(String path,String param)
	{
		try {
			URL url = new URL(path);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setUseCaches(false);
			conn.setConnectTimeout(5000);
			conn.setReadTimeout(5000);
			conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");
			
			conn.setRequestMethod("POST");
//			conn.setRequestProperty("id",id);
//			conn.setRequestProperty("jm",jm);
			OutputStream os = conn.getOutputStream();
			os.write(param.getBytes());
			os.close();
//			conn.getInputStream();
			// 当正确响应时处理数据   
			StringBuffer sb = new StringBuffer();   
			String readLine;   
			BufferedReader responseReader;   
			// 处理响应流，必须与服务器响应流输出的编码一致   
			 responseReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));   
			while ((readLine = responseReader.readLine()) != null) {   
				sb.append(readLine).append("\n"); 
			}
//			System.out.println("nd response:"+sb);
			responseReader.close();
			conn.disconnect();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	public synchronized static ExecutorService getThreadPool()
	{
		if(threadPool == null)
		{
			threadPool = Executors.newCachedThreadPool();
		}
		return threadPool;
	}
/*	@SuppressWarnings("unchecked")
	public static void remindAll(Element root)
	{
		List<Element> list = root.elements("item");
		for(Element element : list)
		{
			String loginName = element.element("loginname").getText();
			String content = element.elementText("content");
			String type = element.elementText("type");
			final String id = element.elementText("id");
			String domain = element.elementText("domain");
			if(PushUtils.domain.equals(domain))
			{
				pushMessage(loginName, content, type);
				Future<?> future =  getThreadPool().submit(new Runnable(){
					@Override
					public void run()
					{
						// TODO Auto-generated method stub
						String jm2 = PushUtils.jdkSha1(id+"&"+PushUtils.Salt);
						String pathback = "http://apiv3.dkwgps.com/gpsAPI.asmx/remindUpID";
						String param = "id="+id+"&jm="+jm2.toUpperCase();
						updataAlarm(pathback, param);
					}
				});
			}
		
		}
	}*/
	public static void remindAll(JsonObject rootJson)
	{
		String result = rootJson.get("result").getAsString();
		if ("1".equals(result))
		{
			JsonArray jsonArray = rootJson.get("datas").getAsJsonArray();
			for (JsonElement jsonEle : jsonArray)
			{
				JsonObject jsonObj = jsonEle.getAsJsonObject();
				String loginName = jsonObj.get("loginname").getAsString();
				String content = jsonObj.get("content").getAsString();
				String type = jsonObj.get("type").getAsString();
				final String id = jsonObj.get("id").getAsString();
				String domain = jsonObj.get("domain").getAsString();
				if(PushUtils.domain.equals(domain))
				{
					pushMessage(loginName, content, type);
					
					Future<?> future =  getThreadPool().submit(new Runnable(){
						@Override
						public void run()
						{
							// TODO Auto-generated method stub
							String jm2 = PushUtils.jdkSha1(id+"&"+PushUtils.Salt);
							String pathback = "http://apiv4.dkwgps.com/Remind/remindUpID";
	//						String param = "id="+id+"&jm="+jm2.toUpperCase();
							JsonObject jsonObj = new JsonObject();
							jsonObj.addProperty("id", id);
							jsonObj.addProperty("jm", jm2.toUpperCase());
							String jsonStr = new Gson().toJson(jsonObj);
							updataAlarm(pathback, jsonStr);
						}
					});
				}
				
			}
			
		}
	}
	public static StdSchedulerFactory getSchedulerFactory()
	{
		if(factory == null)
		{
			factory = new StdSchedulerFactory();
		}
		return factory;
	}
	
}
