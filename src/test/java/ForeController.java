

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import application.BlogApplication;
import dto.ArticleDto;
import mapper.ArticleContentMapper;
import mapper.ArticleInfoMapper;
import pojo.ArticleContent;
import pojo.ArticleContentExample;
import pojo.ArticleView;
import pojo.Category;
import pojo.CategoryExample;
import pojo.SysView;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BlogApplication.class)
public class ForeController extends BaseController{
	@Autowired
	ArticleInfoMapper articleinfomapper;
	@Autowired
	ArticleContentMapper articlecontentmapper;
	/**
	 * 获取所有文章
	 * @return
	 */
	
	@Test
	public void getArticles(){
		Long id = (long) 1;
		System.out.println(articlecontentmapper.selectByPrimaryKey(id).getContent()); 
		ArticleContentExample articleContentExample = new ArticleContentExample();
		articleContentExample.setOrderByClause("id asc");
		List<ArticleContent> articleContents = articlecontentmapper.selectByExampleWithBLOBs(articleContentExample);
		for (ArticleContent articleContent : articleContents) {
			System.out.println(articleContent.toString());
		}
		List<ArticleDto> articleDtos = articleservice.selectArticle();
		for (ArticleDto articleDto : articleDtos) {
			System.out.println(articleDto.toString());
		}
		
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
