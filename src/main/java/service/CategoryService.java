package service;

import java.util.List;

import pojo.Category;
import pojo.CategoryExample;

public interface CategoryService {
	   	void deleteByPrimaryKey(Long id);

	    void insertSelective(Category record);

	    List<Category> selectByExample(CategoryExample example);

	    Category selectByPrimaryKey(Long id);

	    void updateByPrimaryKeySelective(Category record);

}
