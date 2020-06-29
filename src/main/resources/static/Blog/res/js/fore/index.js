$(window).load(function(){
	console.log("hello");
		//获取所有文章
		$.ajax({
			url:"http://127.0.0.1:80/api/articleinfo",
			type:"GET",
			dataType:"json",
			success: function(json) {
				$.each(json,function(i,category){
					var articleinfo = document.querySelector("#article");
					articleinfo.content.querySelector("#articleTitle").innerText = category.title;
					articleinfo.content.querySelector("#articleImg").src = category.image_path;
					articleinfo.content.querySelector(".go-icon").href="article.html?articleId="+category.id;
					document.querySelector(".list-item").appendChild(articleinfo.content.querySelector(".item").cloneNode(true));
				});
			}
			});
	
});
