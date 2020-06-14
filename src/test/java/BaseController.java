

import org.springframework.beans.factory.annotation.Autowired;

import pojo.ArticleView;
import pojo.Category;
import service.ArticleService;
import service.ArticleViewService;
import service.CategoryService;
import service.SysViewService;

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
