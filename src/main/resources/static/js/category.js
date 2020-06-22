window.onload(){
	var categoryId = var articleId = getQueryParam("articleId");
	var categoryName;
	$.ajax({
		url:"api/categroy/"+articleId,
		type:"GET",
		dataType:"json",
		success: function(json) {
			categoryName = $("#categoryName").html = json.name;
			$("#articleNumber").html = json.number;
		}
	});
	
	$.ajax({
		url:"api/categroy/article"+categoryName,
		type:"GET",
		dataType:"json",
		success: function(json) {
			$.each(json,function(i,articleDto){
				
				//获取置顶分类文章 置顶文章
			});
	
		}
	});
	
}

function getQueryParam(targetParam) {
	var URL =  window.location.search.substring(1);
	var parameters = URL.split("&");
	for (var i = 0; i < parameters.length; i++) {
		var parameter = parameters[i].split("=");
		if(parameter[0] == targetParam){
			return parameter[1];
		}
	}
	return false;
}