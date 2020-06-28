window.onload(){
	
	$.ajax({
		url:"admin/view/article",
		type:"GET",
		dataType:"json",
		success: function(json) {
			var articleViewInfo = document.querySelector("#articleviewinfo");
			var itemlist = document.querySelector("#itemlist");
			$.each(json,function(i,articleview){
				
				articleViewInfo.content.querySelector("#articleview-id").innerText = articleview.id;
				articleViewInfo.content.querySelector("#articleview-ip").innerText = articleview.ip;
				articleViewInfo.content.querySelector("#articleview-articleid").innerText = articleview.article_id;
				articleViewInfo.content.querySelector("#articleview-createby").innerText = articleview.create_by;
				
				itemlist.appendChild(articleViewInfo.content.querySelector("tr").cloneNode(true));
			});
		}
	});
	
}