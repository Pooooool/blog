package blog.service;

import java.util.List;

import blog.pojo.Category;
import blog.pojo.CategoryExample;

public interface CategoryService {
	   	void deleteByPrimaryKey(Long id);

	    void insertSelective(Category record);

	    List<Category> selectByExample(CategoryExample example);

	    Category selectByPrimaryKey(Long id);

	    void updateByPrimaryKeySelective(Category record);

}
