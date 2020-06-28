package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dto.ArticleDto;
import pojo.ArticleView;
import pojo.ArticleViewExample;
import pojo.Category;
import pojo.SysView;
import pojo.SysViewExample;

@Controller
public class BackController extends BaseController{
	/**
	 * 增加一篇文章
	 * @param articleDto
	 * @return
	 */
	@PostMapping("/article")
	public String addArticle(ArticleDto articleDto) {
		articleservice.addArticle(articleDto);
		return null;
	}
	/**	
	 * 更新一篇文章
	 * @param articleDto
	 * @return
	 */
	@PutMapping("/article/{id}")
	public String updateArticle(ArticleDto articleDto,@RequestParam(value = "id",required = true)Long id) {
		articleDto.setId(id);
		articleservice.updateArticle(articleDto);
		return null;
	}
	/**
	 *删除文章
	 * @param id
	 * @return
	 */
	@DeleteMapping("/article/{id}")
	public String deleteArticle(@RequestParam(value = "id",required = true)Long id) {
		articleservice.deleteArticle(id);
		return null;
	}
	/**
	 * 新增分类
	 * @param category
	 * @return
	 */
	@PostMapping("/category")
	public String addCategory(Category category) {
		categoryservice.insertSelective(category);
		return null;
	}
	/**
	 * 更新分类
	 * @param category
	 * @return
	 */
	@PutMapping("/categroy")
	public String updateCategory(Category category) {
		categoryservice.updateByPrimaryKeySelective(category);
		return null;
	}
	/**
	 * 获取文章访问
	 * @return
	 */
	 
	@GetMapping("/admin/view/article")
	public List<ArticleView> getArticleViews(){
		ArticleViewExample example = new ArticleViewExample();
		example.setOrderByClause("id asc");
		List<ArticleView> articleViews = articleviewservice.selectByExample(example);
		return articleViews;
	}
	/**
	 * 获取某一文章访问
	 * @param id
	 * @return
	 */
	@GetMapping("/admin/view/article/{id}")
	public ArticleView getArticleView(@RequestParam(value = "id",required = true)Long id) {
		ArticleView articleView = articleviewservice.selectByPrimaryKey(id);
		return articleView;
		
	}
	/**
	 * 删除访问
	 * @param id
	 * @return
	 */
	@DeleteMapping("/admin/view/article/{id}")
	public String deleteArticleView(@RequestParam(value = "id",required = true)Long id) {
		articleservice.deleteArticle(id);
		return null;
		
	}
	/**
	 * 获取系统访问
	 * @return
	 */
	@GetMapping("/admin/view/system")
	public List<SysView> getSysViews(){
		SysViewExample example = new SysViewExample();
		example.setOrderByClause("id asc");
		List<SysView> sysViews = sysviewservice.selectByExample(example);
		return sysViews;
	}
	/**
	 * 获取某一系统访问
	 * @param id
	 * @return
	 */
	@GetMapping("/admin/view/system/{id}")
	public SysView getSysView(@RequestParam(value = "id",required = true)Long id) {
		SysView sysView  = sysviewservice.selectByPrimaryKey(id);
		return sysView;
	}
	/**
	 * 删除访问
	 * @param id
	 * @return
	 */
	@DeleteMapping("/admin/view/system/{id}")
	public String deleteSysView(@RequestParam(value = "id",required = true)Long id) {
		sysviewservice.deleteByPrimaryKey(id);
		return null;
	}
	
	@ResponseBody
	public String adminLogin(String account,String password) {
		
		return null;
	}
	
	@RequestMapping("/")
	public String toIndex() {
		return "index.html";
	}
}
