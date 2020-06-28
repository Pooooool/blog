package blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import blog.pojo.ArticleView;
import blog.pojo.Category;
import blog.service.ArticleService;
import blog.service.ArticleViewService;
import blog.service.CategoryService;
import blog.service.SysViewService;
@Controller
public abstract class BaseController {
	@Autowired
	ArticleService articleservice;
	@Autowired
	ArticleViewService articleviewservice;
	@Autowired
	CategoryService categoryservice;
	@Autowired
	SysViewService sysviewservice;
}
