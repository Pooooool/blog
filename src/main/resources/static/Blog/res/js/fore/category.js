var categoryName;
$(window).load(function(){
	var categoryId = getQueryParam("categoryId");
	$.ajax({
		url:"api/category",
		type:"GET",
		dataType:"json",
		async:false,
		success: function(json){
			var category = document.querySelector(".nav");
			var categoryinfo = document.querySelector("#category");
			$.each(json,function(i,articlecategory){
				categoryinfo.content.querySelector("a").id ="category"+articlecategory.id;
				categoryinfo.content.querySelector("a").href ="?categoryId="+articlecategory.id;
				categoryinfo.content.querySelector("a").innerText =articlecategory.name;
				category.appendChild(categoryinfo.content.querySelector("a").cloneNode(true));
			});
		}
	});
	
	if (categoryId==null) {
		//渲染所有文章
		getArticles();
	} else {
		//渲染特定分类文章
		//将特定分类设为选定	
		//获取categoryName
		categoryName = document.querySelector("#category1").innerText;
		getArticlesByCategory();
		
	}
	
	
});

function getArticles() {
	//获取所有文章
	$.ajax({
		url:"api/articleinfo",
		type:"GET",
		dataType:"json",
		success: function(json) {
			$.each(json,function(i,info){
				var articleinfo = document.querySelector("#article");
				articleinfo.content.querySelector(".text-cont").innerText = info.title;
				//题图暂时默认
				//articleinfo.content.querySelector("#articleImg").src = info.image_path;
				var time = info.create_by.split(" ");
				articleinfo.content.querySelector(".hour").innerText = time[1];
				articleinfo.content.querySelector(".date").innerText = time[0];
				document.querySelector(".article-list").appendChild(articleinfo.content.querySelector(".item-box").cloneNode(true));
			});
		}
	});
}

function getArticlesByCategory() {
	//获取特定分类文章
	$.ajax({
		url:"api/articleinfo/"+categoryName,
		type:"GET",
		dataType:"json",
		success: function(json) {
			$.each(json,function(i,info){
				var articleinfo = document.querySelector("#article");
				articleinfo.content.querySelector(".text-cont").innerText = info.title;
				articleinfo.content.querySelector("#articleImg").src = info.image_path;
				console.log(info.create_by);
				var time = info.create_by.split(" ");
				
				articleinfo.content.querySelector(".hour").innerText = time[1];
				articleinfo.content.querySelector(".date").innerText = time[0];
				document.querySelector(".article-list").appendChild(articleinfo.content.querySelector(".item-box").cloneNode(true));
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
	return null;
}