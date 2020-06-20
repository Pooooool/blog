window.onload(){
	var articleId = getQueryParam("articleId");
	
$.ajax({
	url:"api/categroy/"+articleId,
	type:"GET",
	dataType:"json",
	success: function(json) {
		$("#articleTitle").html(json.title);
		$("#articleCreateBy").html(json.createby);
		$("#articleImg").html(json.image_path);
		$("#articleContent").html(json.content);
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