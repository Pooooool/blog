window.onload(){
	function getArticles() {
		//获取所有文章
		$.ajax({
			url:"api/articleinfo",
			type:"GET",
			dataType:"json",
			success: function(json) {
				$.each(json,function(i,category){
					var articleinfo = document.querySelector("#article");
					articleinfo.content.querySelector("#articleTitle").innerText = json.title;
					articleinfo.content.querySelector("#articleImg").src = json.image_path;
					document.querySelector(".list-item").appendChild(articleinfo.content.querySelector(".item").cloneNode(true);)
				});
			}
			)};
	}
}