package com.nd.push;

import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.ExecutorService;

import javax.print.attribute.standard.Severity;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.opensymphony.xwork2.ActionSupport;

public class OtherAction extends ActionSupport
{
	@Override
	public String execute() throws Exception
	{
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter writer = response.getWriter();
		String path ="http://api.dkwgps.com/vipMgr.asmx/wrong";
		InputStreamReader in = PushUtils.webServiceHelpWlk(path);
		try
		{
//			File file = new File("E:\\test.xml");
			SAXReader sr = new SAXReader();//获取读取xml的对象。
			Document doc = sr.read(in);
			in.close();
			Element root = doc.getRootElement();
			List<Element> list = root.elements("Item");
			for(Element element : list)
			{
				String loginName = element.element("LoginName").getText();
				String content = element.elementText("Content");
//				String type = element.elementText("Type");
//				final String id = element.elementText("ID");
				PushUtils.pushMessage(loginName, content, "other");
			}
			
			writer.write("end");
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			writer.write("fail");
			e.printStackTrace();
		}finally
		{
		
		}
		return null;
	}
}
