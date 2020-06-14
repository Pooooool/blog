package service;

import java.util.List;


import pojo.ArticleView;
import pojo.ArticleViewExample;

public interface ArticleViewService {
		void deleteByPrimaryKey(Long id);

	    void insertSelective(ArticleView articleView);

	    List<ArticleView> selectByExample(ArticleViewExample example);

	    ArticleView selectByPrimaryKey(Long id);

	  
}
