//获取状态
$.get("ndele?flag=3", function(result){
	if(result == "stop")
	{
		var elestate = $("#ndelestate");
		elestate.html("已关闭");
		elestate.css("color", "black");
	}
	if(result == "start")
	{
		var elestate = $("#ndelestate");
		elestate.html("已开启");
		elestate.css("color", "red");
	}
});
$.get("ndfence?flag=3", function(result){
	if(result == "stop")
	{
		var elestate = $("#ndfencestate");
		elestate.html("已关闭");
		elestate.css("color", "black");
	}
	if(result == "start")
	{
		var elestate = $("#ndfencestate");
		elestate.html("已开启");
		elestate.css("color", "red");
	}
});
$.get("ndbalance?flag=3", function(result){
	if(result == "stop")
	{
		var elestate = $("#ndbalancestate");
		elestate.html("已关闭");
		elestate.css("color", "black");
	}
	if(result == "start")
	{
		var elestate = $("#ndbalancestate");
		elestate.html("已开启");
		elestate.css("color", "red");
	}
});
$.get("ndexpire?flag=3", function(result){
	if(result == "stop")
	{
		var elestate = $("#ndexpirestate");
		elestate.html("已关闭");
		elestate.css("color", "black");
	}
	if(result == "start")
	{
		var elestate = $("#ndexpirestate");
		elestate.html("已开启");
		elestate.css("color", "red");
	}
});

$.get("ndvibrate?flag=3", function(result){
	if(result == "stop")
	{
		var elestate = $("#ndshakestate");
		elestate.html("已关闭");
		elestate.css("color", "black");
	}
	if(result == "start")
	{
		var elestate = $("#ndshakestate");
		elestate.html("已开启");
		elestate.css("color", "red");
	}
});

$.get("ndfangc?flag=3", function(result){
	if(result == "stop")
	{
		var elestate = $("#ndfangcstate");
		elestate.html("已关闭");
		elestate.css("color", "black");
	}
	if(result == "start")
	{
		var elestate = $("#ndfangcstate");
		elestate.html("已开启");
		elestate.css("color", "red");
	}
});

$.get("ndcharge?flag=3", function(result){
	if(result == "stop")
	{
		var elestate = $("#ndchargestate");
		elestate.html("已关闭");
		elestate.css("color", "black");
	}
	if(result == "start")
	{
		var elestate = $("#ndchargestate");
		elestate.html("已开启");
		elestate.css("color", "red");
	}
});
$.get("ndlow?flag=3", function(result){
	if(result == "stop")
	{
		var elestate = $("#ndlowstate");
		elestate.html("已关闭");
		elestate.css("color", "black");
	}
	if(result == "start")
	{
		var elestate = $("#ndlowstate");
		elestate.html("已开启");
		elestate.css("color", "red");
	}
});
$.get("ndsos?flag=3", function(result){
	if(result == "stop")
	{
		var elestate = $("#ndsosstate");
		elestate.html("已关闭");
		elestate.css("color", "black");
	}
	if(result == "start")
	{
		var elestate = $("#ndsosstate");
		elestate.html("已开启");
		elestate.css("color", "red");
	}
});
$.get("ndspeed?flag=3", function(result){
	if(result == "stop")
	{
		var elestate = $("#ndspeedstate");
		elestate.html("已关闭");
		elestate.css("color", "black");
	}
	if(result == "start")
	{
		var elestate = $("#ndspeedstate");
		elestate.html("已开启");
		elestate.css("color", "red");
	}
});
$.get("ndcard?flag=3", function(result){
	if(result == "stop")
	{
		var elestate = $("#ndcardstate");
		elestate.html("已关闭");
		elestate.css("color", "black");
	}
	if(result == "start")
	{
		var elestate = $("#ndcardstate");
		elestate.html("已开启");
		elestate.css("color", "red");
	}
});


//点击事件 开启和关闭
$("#ndelestart").click(function(){
			
			$.get("ndele?flag=1", function(result){
	//			alert("start");
				var ele = $("#ndelestate");
				ele.html("已开启");
				ele.css("color","red");
			  });
		});
		$("#ndelestop").click(function(){
			$.get("ndele?flag=2", function(result){
				var ele = $("#ndelestate");
				ele.html("已关闭");
				ele.css("color","black");
			  });
			
		});
		$("#ndfencestart").click(function(){
			
			$.get("ndfence?flag=1", function(result){
				var elestate = $("#ndfencestate");
				elestate.html("已开启");
				elestate.css("color", "red");
			  });
		});
		$("#ndfencestop").click(function(){
			$.get("ndfence?flag=2", function(result){
				var elestate = $("#ndfencestate");
				elestate.html("已关闭");
				elestate.css("color", "black");
			  });
		});
		
		$("#ndbalancestart").click(function(){
			$.get("ndbalance?flag=1", function(result){
				var elestate = $("#ndbalancestate");
				elestate.html("已开启");
				elestate.css("color", "red");
			});
		});
		$("#ndbalancestop").click(function(){
			$.get("ndbalance?flag=2", function(result){
				var elestate = $("#ndbalancestate");
				elestate.html("已关闭");
				elestate.css("color", "black");
			});
		});
		$("#ndexpirestart").click(function(){
			$.get("ndexpire",{flag:1},function(result){
				var elestate = $("#ndexpirestate");
				elestate.html("已开启");
				elestate.css("color", "red");
			});
		});	
		$("#ndexpirestop").click(function(){
			$.get("ndexpire",{flag:2},function(result){
				var elestate = $("#ndexpirestate");
				elestate.html("已关闭");
				elestate.css("color", "black");
			});
		});	
		$("#ndshakestart").click(function(){
			$.get("ndvibrate",{flag:1},function(result){
				var elestate = $("#ndshakestate");
				elestate.html("已开启");
				elestate.css("color", "red");
			});
		});
		$("#ndshakestop").click(function(){
			$.get("ndvibrate",{flag:2},function(result){
				var elestate = $("#ndshakestate");
				elestate.html("已关闭");
				elestate.css("color", "black");
			});
		});
		
		$("#ndfangcstart").click(function(){
			$.get("ndfangc",{flag:1},function(result){
				var elestate = $("#ndfangcstate");
				elestate.html("已开启");
				elestate.css("color", "red");
			});
		});
		$("#ndfangcstop").click(function(){
			$.get("ndfangc",{flag:2},function(result){
				var elestate = $("#ndfangcstate");
				elestate.html("已关闭");
				elestate.css("color", "black");
			});
		});
		// $("#ndotherstart").click(function(){
		// 	$.get("otherpush",function(result){
		// 		var elestate = $("#otherstate");
		// 		elestate.html(result);
		// 		elestate.css("color", "black");
		// 	});
		// });
		$("#ndchargestart").click(function(){
			$.get("ndcharge",{flag:1},function(result){
				var elestate = $("#ndchargestate");
				elestate.html("已开启");
				elestate.css("color", "red");
			});
		});
		$("#ndchargestop").click(function(){
			$.get("ndcharge",{flag:2},function(result){
				var elestate = $("#ndchargestate");
				elestate.html("已关闭");
				elestate.css("color", "black");
			});
		});
		$("#ndlowstart").click(function(){
			$.get("ndlow",{flag:1},function(result){
				var elestate = $("#ndlowstate");
				elestate.html("已开启");
				elestate.css("color", "red");
			});
		});
		$("#ndlowstop").click(function(){
			$.get("ndlow",{flag:2},function(result){
				var elestate = $("#ndlowstate");
				elestate.html("已关闭");
				elestate.css("color", "black");
			});
		});
		$("#ndsosstart").click(function(){
			
			$.get("ndsos?flag=1", function(result){
				var elestate = $("#ndsosstate");
				elestate.html("已开启");
				elestate.css("color", "red");
			  });
		});
		$("#ndsosstop").click(function(){
			$.get("ndsos?flag=2", function(result){
				var elestate = $("#ndsosstate");
				elestate.html("已关闭");
				elestate.css("color", "black");
			  });
		});
		$("#ndspeedstart").click(function(){
			
			$.get("ndspeed?flag=1", function(result){
				var elestate = $("#ndspeedstate");
				elestate.html("已开启");
				elestate.css("color", "red");
			  });
		});
		$("#ndspeedstop").click(function(){
			$.get("ndspeed?flag=2", function(result){
				var elestate = $("#ndspeedstate");
				elestate.html("已关闭");
				elestate.css("color", "black");
			  });
		});
		$("#ndcardstart").click(function(){
			
			$.get("ndcard?flag=1", function(result){
				var elestate = $("#ndcardstate");
				elestate.html("已开启");
				elestate.css("color", "red");
			  });
		});
		$("#ndcardstop").click(function(){
			$.get("ndcard?flag=2", function(result){
				var elestate = $("#ndcardstate");
				elestate.html("已关闭");
				elestate.css("color", "black");
			  });
		});