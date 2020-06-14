package service.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapper.ArticleViewMapper;
import pojo.ArticleView;
import pojo.ArticleViewExample;
import service.ArticleViewService;
@Service
public class ArticleViewServiceImpl implements ArticleViewService{
	@Autowired
	ArticleViewMapper articleviewmapper;
	
	@Override
	public void deleteByPrimaryKey(Long id) {
		
		articleviewmapper.deleteByPrimaryKey(id);
	}

	@Override
	public void insertSelective(ArticleView articleview) {

		articleviewmapper.insertSelective(articleview);
		
	}
	
	@Override
	public List<ArticleView> selectByExample(ArticleViewExample example) {
		List<ArticleView> articleViews = new ArrayList<ArticleView>();
		articleViews = articleviewmapper.selectByExample(example);
		return articleViews;
	}
	@Override
	public ArticleView selectByPrimaryKey(Long id) {
		ArticleView articleView = articleviewmapper.selectByPrimaryKey(id);	
		return articleView;
	}
}
