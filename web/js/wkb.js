//获取状态
$.get("wkbele?flag=3", function(result){
	if(result == "stop")
	{
		var elestate = $("#wkbelestate");
		elestate.html("已关闭");
		elestate.css("color", "black");
	}
	if(result == "start")
	{
		var elestate = $("#wkbelestate");
		elestate.html("已开启");
		elestate.css("color", "red");
	}
});
$.get("wkbfence?flag=3", function(result){
	if(result == "stop")
	{
		var elestate = $("#wkbfencestate");
		elestate.html("已关闭");
		elestate.css("color", "black");
	}
	if(result == "start")
	{
		var elestate = $("#wkbfencestate");
		elestate.html("已开启");
		elestate.css("color", "red");
	}
});
$.get("wkbbalance?flag=3", function(result){
	if(result == "stop")
	{
		var elestate = $("#wkbbalancestate");
		elestate.html("已关闭");
		elestate.css("color", "black");
	}
	if(result == "start")
	{
		var elestate = $("#wkbbalancestate");
		elestate.html("已开启");
		elestate.css("color", "red");
	}
});
$.get("wkbexpire?flag=3", function(result){
	if(result == "stop")
	{
		var elestate = $("#wkbexpirestate");
		elestate.html("已关闭");
		elestate.css("color", "black");
	}
	if(result == "start")
	{
		var elestate = $("#wkbexpirestate");
		elestate.html("已开启");
		elestate.css("color", "red");
	}
});

$.get("wkbvibrate?flag=3", function(result){
	if(result == "stop")
	{
		var elestate = $("#wkbshakestate");
		elestate.html("已关闭");
		elestate.css("color", "black");
	}
	if(result == "start")
	{
		var elestate = $("#wkbshakestate");
		elestate.html("已开启");
		elestate.css("color", "red");
	}
});

$.get("wkbfangc?flag=3", function(result){
	if(result == "stop")
	{
		var elestate = $("#wkbfangcstate");
		elestate.html("已关闭");
		elestate.css("color", "black");
	}
	if(result == "start")
	{
		var elestate = $("#wkbfangcstate");
		elestate.html("已开启");
		elestate.css("color", "red");
	}
});

$.get("wkbcharge?flag=3", function(result){
	if(result == "stop")
	{
		var elestate = $("#wkbchargestate");
		elestate.html("已关闭");
		elestate.css("color", "black");
	}
	if(result == "start")
	{
		var elestate = $("#wkbchargestate");
		elestate.html("已开启");
		elestate.css("color", "red");
	}
});
$.get("wkblow?flag=3", function(result){
	if(result == "stop")
	{
		var elestate = $("#wkblowstate");
		elestate.html("已关闭");
		elestate.css("color", "black");
	}
	if(result == "start")
	{
		var elestate = $("#wkblowstate");
		elestate.html("已开启");
		elestate.css("color", "red");
	}
});
$.get("wkbsos?flag=3", function(result){
	if(result == "stop")
	{
		var elestate = $("#wkbsosstate");
		elestate.html("已关闭");
		elestate.css("color", "black");
	}
	if(result == "start")
	{
		var elestate = $("#wkbsosstate");
		elestate.html("已开启");
		elestate.css("color", "red");
	}
});
$.get("wkbspeed?flag=3", function(result){
	if(result == "stop")
	{
		var elestate = $("#wkbspeedstate");
		elestate.html("已关闭");
		elestate.css("color", "black");
	}
	if(result == "start")
	{
		var elestate = $("#wkbspeedstate");
		elestate.html("已开启");
		elestate.css("color", "red");
	}
});
$.get("wkbcard?flag=3", function(result){
	if(result == "stop")
	{
		var elestate = $("#wkbcardstate");
		elestate.html("已关闭");
		elestate.css("color", "black");
	}
	if(result == "start")
	{
		var elestate = $("#wkbcardstate");
		elestate.html("已开启");
		elestate.css("color", "red");
	}
});


//点击事件 开启和关闭
$("#wkbelestart").click(function(){
			
			$.get("wkbele?flag=1", function(result){
	//			alert("start");
				var ele = $("#wkbelestate");
				ele.html("已开启");
				ele.css("color","red");
			  });
		});
		$("#wkbelestop").click(function(){
			$.get("wkbele?flag=2", function(result){
				var ele = $("#wkbelestate");
				ele.html("已关闭");
				ele.css("color","black");
			  });
			
		});
		$("#wkbfencestart").click(function(){
			
			$.get("wkbfence?flag=1", function(result){
				var elestate = $("#wkbfencestate");
				elestate.html("已开启");
				elestate.css("color", "red");
			  });
		});
		$("#wkbfencestop").click(function(){
			$.get("wkbfence?flag=2", function(result){
				var elestate = $("#wkbfencestate");
				elestate.html("已关闭");
				elestate.css("color", "black");
			  });
		});
		
		$("#wkbbalancestart").click(function(){
			$.get("wkbbalance?flag=1", function(result){
				var elestate = $("#wkbbalancestate");
				elestate.html("已开启");
				elestate.css("color", "red");
			});
		});
		$("#wkbbalancestop").click(function(){
			$.get("wkbbalance?flag=2", function(result){
				var elestate = $("#wkbbalancestate");
				elestate.html("已关闭");
				elestate.css("color", "black");
			});
		});
		$("#wkbexpirestart").click(function(){
			$.get("wkbexpire",{flag:1},function(result){
				var elestate = $("#wkbexpirestate");
				elestate.html("已开启");
				elestate.css("color", "red");
			});
		});	
		$("#wkbexpirestop").click(function(){
			$.get("wkbexpire",{flag:2},function(result){
				var elestate = $("#wkbexpirestate");
				elestate.html("已关闭");
				elestate.css("color", "black");
			});
		});	
		$("#wkbshakestart").click(function(){
			$.get("wkbvibrate",{flag:1},function(result){
				var elestate = $("#wkbshakestate");
				elestate.html("已开启");
				elestate.css("color", "red");
			});
		});
		$("#wkbshakestop").click(function(){
			$.get("wkbvibrate",{flag:2},function(result){
				var elestate = $("#wkbshakestate");
				elestate.html("已关闭");
				elestate.css("color", "black");
			});
		});
		
		$("#wkbfangcstart").click(function(){
			$.get("wkbfangc",{flag:1},function(result){
				var elestate = $("#wkbfangcstate");
				elestate.html("已开启");
				elestate.css("color", "red");
			});
		});
		$("#wkbfangcstop").click(function(){
			$.get("wkbfangc",{flag:2},function(result){
				var elestate = $("#wkbfangcstate");
				elestate.html("已关闭");
				elestate.css("color", "black");
			});
		});
		// $("#wkbotherstart").click(function(){
		// 	$.get("otherpush",function(result){
		// 		var elestate = $("#otherstate");
		// 		elestate.html(result);
		// 		elestate.css("color", "black");
		// 	});
		// });
		$("#wkbchargestart").click(function(){
			$.get("wkbcharge",{flag:1},function(result){
				var elestate = $("#wkbchargestate");
				elestate.html("已开启");
				elestate.css("color", "red");
			});
		});
		$("#wkbchargestop").click(function(){
			$.get("wkbcharge",{flag:2},function(result){
				var elestate = $("#wkbchargestate");
				elestate.html("已关闭");
				elestate.css("color", "black");
			});
		});
		$("#wkblowstart").click(function(){
			$.get("wkblow",{flag:1},function(result){
				var elestate = $("#wkblowstate");
				elestate.html("已开启");
				elestate.css("color", "red");
			});
		});
		$("#wkblowstop").click(function(){
			$.get("wkblow",{flag:2},function(result){
				var elestate = $("#wkblowstate");
				elestate.html("已关闭");
				elestate.css("color", "black");
			});
		});
		$("#wkbsosstart").click(function(){
			
			$.get("wkbsos?flag=1", function(result){
				var elestate = $("#wkbsosstate");
				elestate.html("已开启");
				elestate.css("color", "red");
			  });
		});
		$("#wkbsosstop").click(function(){
			$.get("wkbsos?flag=2", function(result){
				var elestate = $("#wkbsosstate");
				elestate.html("已关闭");
				elestate.css("color", "black");
			  });
		});
		$("#wkbspeedstart").click(function(){
			
			$.get("wkbspeed?flag=1", function(result){
				var elestate = $("#wkbspeedstate");
				elestate.html("已开启");
				elestate.css("color", "red");
			  });
		});
		$("#wkbspeedstop").click(function(){
			$.get("wkbspeed?flag=2", function(result){
				var elestate = $("#wkbspeedstate");
				elestate.html("已关闭");
				elestate.css("color", "black");
			  });
		});
		$("#wkbcardstart").click(function(){
			
			$.get("wkbcard?flag=1", function(result){
				var elestate = $("#wkbcardstate");
				elestate.html("已开启");
				elestate.css("color", "red");
			  });
		});
		$("#wkbcardstop").click(function(){
			$.get("wkbcard?flag=2", function(result){
				var elestate = $("#wkbcardstate");
				elestate.html("已关闭");
				elestate.css("color", "black");
			  });
		});