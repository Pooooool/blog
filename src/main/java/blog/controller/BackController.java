package blog.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import blog.dto.ArticleDto;
import blog.pojo.ArticleView;
import blog.pojo.ArticleViewExample;
import blog.pojo.Category;
import blog.pojo.CategoryExample;
import blog.pojo.SysView;
import blog.pojo.SysViewExample;
import blog.pojo.User;

@Controller
@RequestMapping("/admin")
public class BackController extends BaseController{
	private static String account = "admin";
	private static String password = "admin";
	
	@PostMapping("/tologin")
	public String login(User user,HttpServletRequest request,HttpServletResponse response) throws IOException {
		if (user.getName().equals(account) && user.getPassword().equals(password)) {
			request.getSession().setAttribute("user", user);
			response.sendRedirect(request.getContextPath()+"/admin/article.html");
		} else {
			response.sendRedirect(request.getContextPath()+"/admin/login.html");
		}
		return null;
	}
	
	
	/**
	 * 增加一篇文章
	 * @param articleDto
	 * @return
	 */
	@GetMapping("/article")
	public String addArticle(ArticleDto articleDto,
			@RequestParam(name = "file",required = false)String imgfile,
			@RequestParam(name = "topswitch",required = false)String topswitch) {
		if(topswitch!=null) {
			articleDto.setIs_top(true);
		}else {
			articleDto.setIs_top(false);
		}
		articleDto.setImage_path(imgfile);
		
	    Date dNow = new Date();	
	    SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
	    
	    
		
		articleservice.addArticle(articleDto);
		return "/admin/article.html";
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
		category.setNumber((long)0);
		categoryservice.insertSelective(category);
		
		return "redirect:/admin/category.html";
	}
	/**
	 * 更新分类
	 * @param category
	 * @return
	 */
	@PutMapping("/category")
	public String updateCategory(Category category,@RequestParam(name = "createtime")String create_by) {
		if (category!=null) {
			
			
			Date d = new Date();		
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				d = sdf.parse(sdf.format(d));
				//设置创建时间
				category.setCreate_by(sdf.parse(create_by));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			category.setModify_by(d);//设置修改时间
			
			categoryservice.updateByPrimaryKeySelective(category);
			return "redirect:/admin/category.html";
		}else{
			return "redirect:/error.html";
		}


	}
	
	
	@DeleteMapping("/category")
	public String deleteCategory(@RequestParam(name="id")long id) {
		categoryservice.deleteByPrimaryKey(id);	
		return null;
	}
	
	
	/**
	 * 获取文章访问
	 * @return
	 */
	 
	@GetMapping("/view/article")
	@ResponseBody
	public List<ArticleView> getArticleViews(){
		System.out.println(true);
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
	@GetMapping("view/article/{id}")
	public ArticleView getArticleView(@RequestParam(value = "id",required = true)Long id) {
		ArticleView articleView = articleviewservice.selectByPrimaryKey(id);
		return articleView;
		
	}
	/**
	 * 删除访问
	 * @param id
	 * @return
	 */
	@DeleteMapping("view/article/{id}")
	public String deleteArticleView(@RequestParam(value = "id",required = true)Long id) {
		articleservice.deleteArticle(id);
		return null;
		
	}
	/**
	 * 获取系统访问
	 * @return
	 */
	@GetMapping("/view/system")
	@ResponseBody
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
	@GetMapping("view/system/{id}")
	public SysView getSysView(@RequestParam(value = "id",required = true)Long id) {
		SysView sysView  = sysviewservice.selectByPrimaryKey(id);
		return sysView;
	}
	/**
	 * 删除访问
	 * @param id
	 * @return
	 */
	@DeleteMapping("view/system/{id}")
	public String deleteSysView(@RequestParam(value = "id",required = true)Long id) {
		sysviewservice.deleteByPrimaryKey(id);
		return null;
	}
	
	
}
