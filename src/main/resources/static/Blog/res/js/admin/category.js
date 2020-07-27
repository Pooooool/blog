$(window).load(function(){
		$.ajax({
			url:"http://127.0.0.1:80/api/category",
			type:"GET",
			dataType:"json",
			success: function(json) {
				var categoryoptions = document.querySelector("#category");
				var option = categoryoptions.content.querySelector("option");
				var select = document.querySelector("select");
				$.each(json,function(i,catgory){
					option.value = category.name;
					option.innerText = category.name;
					select.appendChild(option.cloneNode(true));
				});
			}
		});	
	
});
