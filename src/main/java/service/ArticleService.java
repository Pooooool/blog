package service;

import java.util.List;

import org.springframework.stereotype.Service;

import dto.ArticleDto;
import pojo.ArticleContent;
import pojo.ArticleContentExample;
import pojo.ArticleInfo;

public interface ArticleService {
	 void addArticle(ArticleDto articleDto);
	 
	 List<ArticleDto> selectArticle();
	 
	 ArticleDto selectOneById(Long id);
	 
	 void updateArticle(ArticleDto articleDto);
	 
	 void deleteArticle(Long id);
	 
	 List<ArticleInfo> selectArticleInfo();
	 
	 List<ArticleInfo> selectArtcileInfoByCategory(String name);
}
