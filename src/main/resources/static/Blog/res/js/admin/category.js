function updateCategoryName(obj){
		var id = obj.id;
		var name = obj.name;
		var number = obj.number;
		$.ajax({
			url:"http://127.0.0.1:80/api/category?id="id+"name="+name+"number="+number,
			type:"PUT",
			dataType:"json"
		});	
	//完成后表格重载
};
