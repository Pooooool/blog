window.onload(){
	
	$.ajax({
		url:"admin/view/system",
		type:"GET",
		dataType:"json",
		success: function(json) {
			var sysViewInfo = document.querySelector("#sysviewinfo");
			var itemlist = document.querySelector("#itemlist");
			$.each(json,function(i,sysview){
				
				articleViewInfo.content.querySelector("#sysview-id").innerText = sysview.id;
				articleViewInfo.content.querySelector("#sysview-ip").innerText = sysview.ip;
				articleViewInfo.content.querySelector("#sysview-operation").innerText = sysview.operation;
				articleViewInfo.content.querySelector("#sysview-createby").innerText = sysview.create_by;
				
				itemlist.appendChild(articleViewInfo.content.querySelector("tr").cloneNode(true));
			});
		}
	});
	
}