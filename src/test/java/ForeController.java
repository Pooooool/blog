

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dto.ArticleDto;
import pojo.ArticleView;
import pojo.Category;
import pojo.CategoryExample;
import pojo.SysView;
import service.ArticleService;
import service.ArticleViewService;
import service.CategoryService;
import service.SysViewService;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BlogApplication.class)
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
	@Test
	public void getCategories(){
		CategoryExample example = new CategoryExample();
		example.setOrderByClause("id asc");
		List<Category> categories = categoryservice.selectByExample(example);
		System.out.println(categories);
	}
	/**
	 * 获取某一分类
	 * @param id
	 * @return
	 */
	@GetMapping("/api/category/{id}")
	public Category getCategory(@RequestParam(value = "id",required = true)Long id) {
		Category category = null;
		System.out.println("id");
		return category;
	}
	/**
	 * 
	 * @param name
	 * @return
	 */
	@GetMapping("/api/category/{name}")
	public List<ArticleDto> getArticleByCategory(@RequestParam(value = "name",required = true)String name) {
		List<ArticleDto> articleDtos =null;
		System.out.println("name");
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
}
