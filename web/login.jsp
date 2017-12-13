<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<script type="text/javascript" src="js/jquery-1.4.4.min.js"></script>
	<script type="text/javascript" src="js/md5.js"></script>
	<script type="text/javascript">
	</script>
</head>
<body>

	用户名:<input type="text" id="username" name="username"></br>
	密      码:<input type="password" id="password" name="password" onkeydown="enterKey()"></br>
	<input type="button" value="提交" onclick='submit()'>
	<div id="msg"></div>
<script type="text/javascript">
function validate()
{
	var username = $("#username").val();
	var password = $("#password").val();
	password = hex_md5(password);
	var vcode = $("#Vcode").val();

	if(username.length == 0 || username.match(/^\s*$/))
	{
		$("#msg").css("color","red");
		$("#msg").html("用户名不能为空！");
		return false;
	}else if(password.length == 0)
	{
		$("#msg").css("color","red");
		$("#msg").html("密码不能为空！");
		return false;
	}
//	else if(vcode.length == 0 || vcode.match(/^\s*$/))
//	{
//		$("#msg").css("color","red");
//		$("#msg").html("请输入验证码！");
//		return false;
	//}
	else
	{
		return true;	
	}
	
}
$("#password").keyup(function(){
    if(event.keyCode == 13){
        //这里写你要执行的事件;
        submit();
    }
});
function enterKey(event)
{
  if (event.keyCode == 13)
  {
   	subimt();
  }
}
function submit()
{
	if(validate())
	{$.post("loginaction.action",{username:$("#username").val(),password:hex_md5($("#password").val()),Vcode: $("#Vcode").val(),remeber: $("#remeber").attr("checked")},function(rData){
		if(rData == "True")
		{
			window.location.href="start.jsp";
		}
		else if(rData == "False")
		{
			$("#msg").css("color","red");
			$("#msg").html("用户名或密码有误！");	
		}else
		{
			$("#msg").css("color", "red");
			$("#msg").html(rData);
		}
		
	});
	}
}	
</script>
</body>
</html>