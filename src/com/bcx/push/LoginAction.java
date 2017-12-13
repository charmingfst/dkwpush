package com.bcx.push;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport
{
	private String myname="dkwpush";
	private String mypwd="00b7691d86d96aebd21dd9e138f90840";
	private String username;
	private String password;
	
	@Override
	public String execute() throws Exception
	{
//		System.out.println(username);
//		System.out.println(password);
		// TODO Auto-generated method stub
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter writer = response.getWriter();
		
		if(myname.equals(username)&&mypwd.equals(password))
		{
			request.getSession().setAttribute("login","True");
		
			writer.write("True");
			
		}else
		{
			writer.write("False");
		}
		return null;
		
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}
	
}
