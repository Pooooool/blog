$(window).load(function(){
	
	$.ajax({
		url:"http://127.0.0.1:80/admin/view/system",
		type:"GET",
		dataType:"json",
		success: function(json) {
			var sysViewInfo = document.querySelector("#sysviewinfo");
			var itemlist = document.querySelector("#itemlist");
			$.each(json,function(i,sysview){
				
				sysViewInfo.content.querySelector("#sysview-id").innerText = sysview.id;
				sysViewInfo.content.querySelector("#sysview-ip").innerText = sysview.ip;
				sysViewInfo.content.querySelector("#sysview-operation").innerText = sysview.operation;
				sysViewInfo.content.querySelector("#sysview-createby").innerText = sysview.create_by;
				
				itemlist.appendChild(sysViewInfo.content.querySelector("tr").cloneNode(true));
			});
		}
	});
	
});