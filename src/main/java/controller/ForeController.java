package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dto.ArticleDto;
import pojo.ArticleInfo;
import pojo.ArticleView;
import pojo.Category;
import pojo.CategoryExample;
import pojo.SysView;

@Controller
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
	 * 2020年6月25日之前
	 * 获取分类下文章信息
	 * @param name
	 * @return
	 */
	@GetMapping("/api/category/article/{name}")
	public List<ArticleDto> getArticleByCategory(@RequestParam(value = "name",required = true)String name) {
		List<ArticleDto> articleDtos  = getArticles();
		for (ArticleDto articleDto : articleDtos) {
			if (!articleDto.getCategory().equals(name)) {
				articleDtos.remove(articleDto);
			}
		}
		return articleDtos;
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
	/**
	 * 获取文章信息
	 * @return
	 */
	@GetMapping("/api/articleinfo")
	public List<ArticleInfo> getArticleInfo(){
		List<ArticleInfo> articleInfos = articleservice.selectArticleInfo();
		return articleInfos;
	}
	/**
	 * 获取分类下文章信息
	 * @param categoryName
	 * @return
	 */
	@GetMapping("/api/articleinfo/{name}")
	public List<ArticleInfo> getArticleInfoByCategory(@RequestParam(value = "name",required = true)String categoryName){
		List<ArticleInfo> articleInfos = articleservice.selectArtcileInfoByCategory(categoryName);
		return articleInfos;
		
	}
	
	@RequestMapping("/")
	public String toIndex() {
		return "index.html";
	}
	
	@RequestMapping("/test")
	public String test() {
		System.out.println("test");
		return "test";
	}
	
}
