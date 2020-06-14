package controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dto.ArticleDto;
import pojo.ArticleView;
import pojo.Category;
import pojo.CategoryExample;
import pojo.SysView;

public class ForeController extends BaseController{
	/**
	 * 获取所有文章
	 * @return
	 */
	@GetMapping("/api/article")
	public List<ArticleDto> getArticles(){
		List<ArticleDto> articleDtos = articleservice.selectArticle();
		return articleDtos;
		
	}
	/**
	 * 获取某一文章
	 * @param id
	 * @return
	 */
	@GetMapping("/api/article/{id}")
	public ArticleDto getArticle(@RequestParam(value = "id",required = true)Long id) {
		ArticleDto articleDto = articleservice.selectOneById(id);
		return articleDto;
	}
	/**
	 * 获取所有分类
	 * @return
	 */
	@GetMapping("/api/category")
	public List<Category> getCategories(){
		CategoryExample example = new CategoryExample();
		example.setOrderByClause("id asc");
		List<Category> categories = categoryservice.selectByExample(example);
		return categories;
	}
	/**
	 * 获取某一分类
	 * @param id
	 * @return
	 */
	@GetMapping("/api/category/{id}")
	public Category getCategory(@RequestParam(value = "id",required = true)Long id) {
		Category category = categoryservice.selectByPrimaryKey(id);
		return category;
	}
	/**
	 * 增加文章访问
	 * @param articleview
	 * @return
	 */
	@PostMapping("/api/view/article")
	public String addArticleView(ArticleView articleview) {
		articleviewservice.insertSelective(articleview);
		return null;
	}
	/**
	 * 增加系统访问
	 * @param sysview
	 * @return
	 */
	@PostMapping("/api/view/system")
	public String addSysView(SysView sysview) {
		sysviewservice.insertSelective(sysview);
		return null;
	}
}
