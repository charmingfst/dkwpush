<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<script type="text/javascript" src="js/jquery-1.4.4.min.js"></script>
	<script type="text/javascript">
		//获得状态
		$(function(){
			
			$.get("elepush?flag=3", function(result){
				if(result == "stop")
				{
					var elestate = $("#elestate");
					elestate.html("已关闭");
					elestate.css("color", "bkack");
				}
				if(result == "start")
				{
					var elestate = $("#elestate");
					elestate.html("已开启");
					elestate.css("color", "red");
				}
			});
			$.get("fencepush?flag=3", function(result){
				if(result == "stop")
				{
					var elestate = $("#fencestate");
					elestate.html("已关闭");
					elestate.css("color", "black");
				}
				if(result == "start")
				{
					var elestate = $("#fencestate");
					elestate.html("已开启");
					elestate.css("color", "red");
				}
			});
			$.get("balancepush?flag=3", function(result){
				if(result == "stop")
				{
					var elestate = $("#balancestate");
					elestate.html("已关闭");
					elestate.css("color", "black");
				}
				if(result == "start")
				{
					var elestate = $("#balancestate");
					elestate.html("已开启");
					elestate.css("color", "red");
				}
			});
			$.get("expirepush?flag=3", function(result){
				if(result == "stop")
				{
					var elestate = $("#expirestate");
					elestate.html("已关闭");
					elestate.css("color", "black");
				}
				if(result == "start")
				{
					var elestate = $("#expirestate");
					elestate.html("已开启");
					elestate.css("color", "red");
				}
			});
			
			$.get("vibratepush?flag=3", function(result){
				if(result == "stop")
				{
					var elestate = $("#shakestate");
					elestate.html("已关闭");
					elestate.css("color", "black");
				}
				if(result == "start")
				{
					var elestate = $("#shakestate");
					elestate.html("已开启");
					elestate.css("color", "red");
				}
			});
			
			$.get("fangcpush?flag=3", function(result){
				if(result == "stop")
				{
					var elestate = $("#fangcstate");
					elestate.html("已关闭");
					elestate.css("color", "black");
				}
				if(result == "start")
				{
					var elestate = $("#fangcstate");
					elestate.html("已开启");
					elestate.css("color", "red");
				}
			});
			
			$.get("chargepush?flag=3", function(result){
				if(result == "stop")
				{
					var elestate = $("#chargestate");
					elestate.html("已关闭");
					elestate.css("color", "black");
				}
				if(result == "start")
				{
					var elestate = $("#chargestate");
					elestate.html("已开启");
					elestate.css("color", "red");
				}
			});
			$.get("lowpush?flag=3", function(result){
				if(result == "stop")
				{
					var elestate = $("#lowstate");
					elestate.html("已关闭");
					elestate.css("color", "black");
				}
				if(result == "start")
				{
					var elestate = $("#lowstate");
					elestate.html("已开启");
					elestate.css("color", "red");
				}
			});
			$.get("sospush?flag=3", function(result){
				if(result == "stop")
				{
					var elestate = $("#sosstate");
					elestate.html("已关闭");
					elestate.css("color", "black");
				}
				if(result == "start")
				{
					var elestate = $("#sosstate");
					elestate.html("已开启");
					elestate.css("color", "red");
				}
			});
			$.get("speedpush?flag=3", function(result){
				if(result == "stop")
				{
					var elestate = $("#speedstate");
					elestate.html("已关闭");
					elestate.css("color", "black");
				}
				if(result == "start")
				{
					var elestate = $("#speedstate");
					elestate.html("已开启");
					elestate.css("color", "red");
				}
			});
			$.get("cardpush?flag=3", function(result){
				if(result == "stop")
				{
					var elestate = $("#cardstate");
					elestate.html("已关闭");
					elestate.css("color", "black");
				}
				if(result == "start")
				{
					var elestate = $("#cardstate");
					elestate.html("已开启");
					elestate.css("color", "red");
				}
			});
			$.get("switchpush?flag=3", function(result){
				if(result == "stop")
				{
					var elestate = $("#switchstate");
					elestate.html("已关闭");
					elestate.css("color", "black");
				}
				if(result == "start")
				{
					var elestate = $("#switchstate");
					elestate.html("已开启");
					elestate.css("color", "red");
				}
			});
//			$.get("otherpush?flag=3", function(result){
//				if(result == "stop")
//				{
//					var elestate = $("#otherstate");
//					elestate.html("已关闭");
//					elestate.css("color", "black");
//				}
//				if(result == "start")
//				{
//					var elestate = $("#otherstate");
//					elestate.html("已开启");
//					elestate.css("color", "red");
//				}
//			});
			
		});
		
	</script>
</head>
<body>
	<table>
		<tr><td>断电推送</td><td><button id="elestart">开始推送</button></td><td><button id="elestop">停止推送</button></td><td id="elestate">未开启0</td></tr>
		<tr><td>围栏推送</td><td><button id="fencestart">开始推送</button></td><td><button id="fencestop">停止推送</button></td><td id="fencestate">未开启1</td></tr>
		<tr><td>震动推送</td><td><button id="shakestart">开始推送</button></td><td><button id="shakestop">停止推送</button></td><td id="shakestate">未开启2</td></tr>
		<!-- <tr><td>余额推送</td><td><button id="balancestart">开始推送</button></td><td><button id="balancestop">停止推送</button></td><td id="balancestate">未开启3</td></tr> -->
		<!-- <tr><td>到期推送</td><td><button id="expirestart">开始推送</button></td><td><button id="expirestop">停止推送</button></td><td id="expirestate">未开启4</td></tr> -->
		<tr><td>防拆推送</td><td><button id="fangcstart">开始推送</button></td><td><button id="fangcstop">停止推送</button></td><td id="fangcstate">未开启5</td></tr>
		<tr><td>充电推送</td><td><button id="chargestart">开始推送</button></td><td><button id="chargestop">停止推送</button></td><td id="chargestate">未开启5</td></tr>
		<tr><td>低电推送</td><td><button id="lowstart">开始推送</button></td><td><button id="lowstop">停止推送</button></td><td id="lowstate">未开启5</td></tr>
		<tr><td>SOS推送</td><td><button id="sosstart">开始推送</button></td><td><button id="sosstop">停止推送</button></td><td id="sosstate">未开启5</td></tr>
		<tr><td>超速推送</td><td><button id="speedstart">开始推送</button></td><td><button id="speedstop">停止推送</button></td><td id="speedstate">未开启5</td></tr>
		<tr><td>物联卡到期</td><td><button id="cardstart">开始推送</button></td><td><button id="cardstop">停止推送</button></td><td id="cardstate">未开启5</td></tr>
		<tr><td>电门报警</td><td><button id="switchstart">开始推送</button></td><td><button id="switchstop">停止推送</button></td><td id="switchstate">未开启5</td></tr>
		
		<tr><td>其他推送</td><td><button id="otherstart">开始推送</button></td><td id="otherstate">状态</td></tr>
	</table>
	<br>
	<h3>牛丁推送</h3>
	<table>
		<tr><td>断电推送</td><td><button id="ndelestart">开始推送</button></td><td><button id="ndelestop">停止推送</button></td><td id="ndelestate">未开启0</td></tr>
		<tr><td>围栏推送</td><td><button id="ndfencestart">开始推送</button></td><td><button id="ndfencestop">停止推送</button></td><td id="ndfencestate">未开启1</td></tr>
		<tr><td>震动推送</td><td><button id="ndshakestart">开始推送</button></td><td><button id="ndshakestop">停止推送</button></td><td id="ndshakestate">未开启2</td></tr>
		<!-- <tr><td>余额推送</td><td><button id="ndbalancestart">开始推送</button></button></td><td><button id="ndbalancestop">停止推送</button></td><td id="ndbalancestate">未开启3</td></tr> -->
		<!-- <tr><td>到期推送</td><td><button id="ndexpirestart">开始推送</button></button></td><td><button id="ndexpirestop">停止推送</button></td><td id="ndexpirestate">未开启4</td></tr> -->
		<tr><td>防拆推送</td><td><button id="ndfangcstart">开始推送</button></td><td><button id="ndfangcstop">停止推送</button></td><td id="ndfangcstate">未开启5</td></tr>
		<tr><td>充电推送</td><td><button id="ndchargestart">开始推送</button></td><td><button id="ndchargestop">停止推送</button></td><td id="ndchargestate">未开启5</td></tr>
		<tr><td>低电推送</td><td><button id="ndlowstart">开始推送</button></td><td><button id="ndlowstop">停止推送</button></td><td id="ndlowstate">未开启5</td></tr>
		<tr><td>SOS推送</td><td><button id="ndsosstart">开始推送</button></td><td><button id="ndsosstop">停止推送</button></td><td id="ndsosstate">未开启5</td></tr>
		<tr><td>超速推送</td><td><button id="ndspeedstart">开始推送</button></td><td><button id="ndspeedstop">停止推送</button></td><td id="ndspeedstate">未开启5</td></tr>
		<tr><td>物联卡到期</td><td><button id="ndcardstart">开始推送</button></td><td><button id="ndcardstop">停止推送</button></td><td id="ndcardstate">未开启5</td></tr>
	
	</table>
	<br>
	<h3>悟空宝推送</h3>
	<table>
		<tr><td>断电推送</td><td><button id="wkbelestart">开始推送</button></td><td><button id="wkbelestop">停止推送</button></td><td id="wkbelestate">未开启0</td></tr>
		<tr><td>围栏推送</td><td><button id="wkbfencestart">开始推送</button></td><td><button id="wkbfencestop">停止推送</button></td><td id="wkbfencestate">未开启1</td></tr>
		<tr><td>震动推送</td><td><button id="wkbshakestart">开始推送</button></td><td><button id="wkbshakestop">停止推送</button></td><td id="wkbshakestate">未开启2</td></tr>
		<!-- <tr><td>余额推送</td><td><button id="wkbbalancestart">开始推送</button></td><td><button id="wkbbalancestop">停止推送</button></td><td id="wkbbalancestate">未开启3</td></tr> -->
		<!-- <tr><td>到期推送</td><td><button id="wkbexpirestart">开始推送</button></td><td><button id="wkbexpirestop">停止推送</button></td><td id="wkbexpirestate">未开启4</td></tr> -->
		<tr><td>防拆推送</td><td><button id="wkbfangcstart">开始推送</button></td><td><button id="wkbfangcstop">停止推送</button></td><td id="wkbfangcstate">未开启5</td></tr>
		<tr><td>充电推送</td><td><button id="wkbchargestart">开始推送</button></td><td><button id="wkbchargestop">停止推送</button></td><td id="wkbchargestate">未开启5</td></tr>
		<tr><td>低电推送</td><td><button id="wkblowstart">开始推送</button></td><td><button id="wkblowstop">停止推送</button></td><td id="wkblowstate">未开启5</td></tr>
		<tr><td>SOS推送</td><td><button id="wkbsosstart">开始推送</button></td><td><button id="wkbsosstop">停止推送</button></td><td id="wkbsosstate">未开启5</td></tr>
		<tr><td>超速推送</td><td><button id="wkbspeedstart">开始推送</button></td><td><button id="wkbspeedstop">停止推送</button></td><td id="wkbspeedstate">未开启5</td></tr>
		<tr><td>物联卡到期</td><td><button id="wkbcardstart">开始推送</button></td><td><button id="wkbcardstop">停止推送</button></td><td id="wkbcardstate">未开启5</td></tr>
	</table>
	<script type="text/javascript">
	$("#switchstart").click(function(){
		
		$.get("switchpush?flag=1", function(result){
//			alert("start");
			var ele = $("#switchstate");
			ele.html("已开启");
			ele.css("color","red");
		  });
	});
	$("#switchstop").click(function(){
		$.get("switchpush?flag=2", function(result){
			var ele = $("#switchstate");
			ele.html("已关闭");
			ele.css("color","black");
		  });
		
	});
		$("#elestart").click(function(){
			
			$.get("elepush?flag=1", function(result){
	//			alert("start");
				var ele = $("table tr:first td:last");
				ele.html("已开启");
				ele.css("color","red");
			  });
		});
		$("#elestop").click(function(){
			$.get("elepush?flag=2", function(result){
				var ele = $("table tr:first td:last");
				ele.html("已关闭");
				ele.css("color","black");
			  });
			
		});
		$("#fencestart").click(function(){
			
			$.get("fencepush?flag=1", function(result){
				var elestate = $("#fencestate");
				elestate.html("已开启");
				elestate.css("color", "red");
			  });
		});
		$("#fencestop").click(function(){
			$.get("fencepush?flag=2", function(result){
				var elestate = $("#fencestate");
				elestate.html("已关闭");
				elestate.css("color", "black");
			  });
		});
		
		$("#balancestart").click(function(){
			$.get("balancepush?flag=1", function(result){
				var elestate = $("#balancestate");
				elestate.html("已开启");
				elestate.css("color", "red");
			});
		});
		$("#balancestop").click(function(){
			$.get("balancepush?flag=2", function(result){
				var elestate = $("#balancestate");
				elestate.html("已关闭");
				elestate.css("color", "black");
			});
		});
		$("#expirestart").click(function(){
			$.get("expirepush",{flag:1},function(result){
				var elestate = $("#expirestate");
				elestate.html("已开启");
				elestate.css("color", "red");
			});
		});	
		$("#expirestop").click(function(){
			$.get("expirepush",{flag:2},function(result){
				var elestate = $("#expirestate");
				elestate.html("已关闭");
				elestate.css("color", "black");
			});
		});	
		$("#shakestart").click(function(){
			$.get("vibratepush",{flag:1},function(result){
				var elestate = $("#shakestate");
				elestate.html("已开启");
				elestate.css("color", "red");
			});
		});
		$("#shakestop").click(function(){
			$.get("vibratepush",{flag:2},function(result){
				var elestate = $("#shakestate");
				elestate.html("已关闭");
				elestate.css("color", "black");
			});
		});
		
		$("#fangcstart").click(function(){
			$.get("fangcpush",{flag:1},function(result){
				var elestate = $("#fangcstate");
				elestate.html("已开启");
				elestate.css("color", "red");
			});
		});
		$("#fangcstop").click(function(){
			$.get("fangcpush",{flag:2},function(result){
				var elestate = $("#fangcstate");
				elestate.html("已关闭");
				elestate.css("color", "black");
			});
		});
		$("#otherstart").click(function(){
			$.get("otherpush",function(result){
				var elestate = $("#otherstate");
				elestate.html(result);
				elestate.css("color", "red");
			});
		});
		/*$("#otherstop").click(function(){
			$.get("otherpush",{flag:2},function(result){
				var elestate = $("#otherstate");
				elestate.html("已关闭");
				elestate.css("color", "black");
			});
		});*/
		$("#chargestart").click(function(){
			$.get("chargepush",{flag:1},function(result){
				var elestate = $("#chargestate");
				elestate.html("已开启");
				elestate.css("color", "red");
			});
		});
		$("#chargestop").click(function(){
			$.get("chargepush",{flag:2},function(result){
				var elestate = $("#chargestate");
				elestate.html("已关闭");
				elestate.css("color", "black");
			});
		});
		$("#lowstart").click(function(){
			$.get("lowpush",{flag:1},function(result){
				var elestate = $("#lowstate");
				elestate.html("已开启");
				elestate.css("color", "red");
			});
		});
		$("#lowstop").click(function(){
			$.get("lowpush",{flag:2},function(result){
				var elestate = $("#lowstate");
				elestate.html("已关闭");
				elestate.css("color", "black");
			});
		});
		$("#sosstart").click(function(){
			
			$.get("sospush?flag=1", function(result){
				var elestate = $("#sosstate");
				elestate.html("已开启");
				elestate.css("color", "red");
			  });
		});
		$("#sosstop").click(function(){
			$.get("sospush?flag=2", function(result){
				var elestate = $("#sosstate");
				elestate.html("已关闭");
				elestate.css("color", "black");
			  });
		});
		$("#speedstart").click(function(){
			
			$.get("speedpush?flag=1", function(result){
				var elestate = $("#speedstate");
				elestate.html("已开启");
				elestate.css("color", "red");
			  });
		});
		$("#speedstop").click(function(){
			$.get("speedpush?flag=2", function(result){
				var elestate = $("#speedstate");
				elestate.html("已关闭");
				elestate.css("color", "black");
			  });
		});
		$("#cardstart").click(function(){
			
			$.get("cardpush?flag=1", function(result){
				var elestate = $("#cardstate");
				elestate.html("已开启");
				elestate.css("color", "red");
			  });
		});
		$("#cardstop").click(function(){
			$.get("cardpush?flag=2", function(result){
				var elestate = $("#cardstate");
				elestate.html("已关闭");
				elestate.css("color", "black");
			  });
		});
	</script>
	<script type="text/javascript" src="js/nd.js"></script>
	<script type="text/javascript" src="js/wkb.js"></script>
</body>
</html>