package blog.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import blog.mapper.CategoryMapper;
import blog.pojo.Category;
import blog.pojo.CategoryExample;
import blog.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	CategoryMapper categorymapper;
	
	@Override
	public void deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		categorymapper.deleteByPrimaryKey(id);
	}
	
	@Override
	public void insertSelective(Category record) {
		// TODO Auto-generated method stub
		categorymapper.insertSelective(record);
	}
	
	@Override
	public List<Category> selectByExample(CategoryExample example) {
		List<Category> categories = categorymapper.selectByExample(example);
		return categories;
	}
	
	@Override
	public Category selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		Category category = categorymapper.selectByPrimaryKey(id);
		return category;
	}
	
	@Override
	public void updateByPrimaryKeySelective(Category record) {
		// TODO Auto-generated method stub
		categorymapper.updateByPrimaryKey(record);
		
	}
	
}
