$(window).load(function(){
	var articleId = getQueryParam("articleId");
	if (articleId!=null) {
		$.ajax({
			url:"http://127.0.0.1:80/api/article/"+articleId,
			type:"GET",
			dataType:"json",
			success: function(json) {
				document.querySelector("#articleTitle").innerText =json.title;
				document.querySelector("#articleCreateBy").innerText= json.create_by;
				document.querySelector("#articleImg").src = json.image_path;
				document.querySelector("#articleContent").innerHtml = json.content;
			}
		});	
	}
});

function getQueryParam(targetParam) {
	var URL =  window.location.search.substring(1);
	var parameters = URL.split("&");
	for (var i = 0; i < parameters.length; i++) {
		var parameter = parameters[i].split("=");
		if(parameter[0] == targetParam){
			return parameter[1];
		}
	}
	return null;
}