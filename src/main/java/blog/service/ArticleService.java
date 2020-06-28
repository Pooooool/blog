package blog.service;

import java.util.List;

import org.springframework.stereotype.Service;

import blog.dto.ArticleDto;
import blog.pojo.ArticleContent;
import blog.pojo.ArticleContentExample;
import blog.pojo.ArticleInfo;

public interface ArticleService {
	 void addArticle(ArticleDto articleDto);
	 
	 List<ArticleDto> selectArticle();
	 
	 ArticleDto selectOneById(Long id);
	 
	 void updateArticle(ArticleDto articleDto);
	 
	 void deleteArticle(Long id);
	 
	 List<ArticleInfo> selectArticleInfo();
	 
	 List<ArticleInfo> selectArtcileInfoByCategory(String name);
}
