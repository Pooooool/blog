package blog.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import blog.dto.ArticleDto;
import blog.pojo.ArticleInfo;
import blog.pojo.ArticleView;
import blog.pojo.Category;
import blog.pojo.CategoryExample;
import blog.pojo.SysView;

@RestController
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
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@GetMapping("/api/article/{articleId}")
	public ArticleDto getArticle(@PathVariable("articleId")Long articleId,HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse)  {
		Long id = (Long)articleId;
		ArticleDto articleDto = articleservice.selectOneById(id);
		if (articleDto==null) {
			try {
				httpServletResponse.sendRedirect("/error.html");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
		return articleDto;
	}
	/**
	 * 获取所有分类
	 * @return
	 */
	@GetMapping("/api/category")
	public HashMap getCategories(){
		CategoryExample example = new CategoryExample();
		example.setOrderByClause("id asc");
		List<Category> categories = categoryservice.selectByExample(example);
		HashMap hashMap = new HashMap();
		hashMap.put("code", 0);
		hashMap.put("msg", "");
		hashMap.put("count", categories.size());
		hashMap.put("data", categories);
		return hashMap;
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
	public List<ArticleInfo> getArticleInfoByCategory(@PathVariable(value = "name",required = true)String categoryName){
		List<ArticleInfo> articleInfos = articleservice.selectArtcileInfoByCategory(categoryName);
		return articleInfos;
		
	}
	
}
