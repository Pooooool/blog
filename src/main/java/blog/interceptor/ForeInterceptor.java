package blog.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import blog.pojo.ArticleView;
import blog.pojo.SysView;
import blog.service.ArticleViewService;
import blog.service.SysViewService;

public class ForeInterceptor implements HandlerInterceptor{
	@Autowired
	SysViewService sysviewservice;
	@Autowired
	ArticleViewService articleviewservice;
	
	private SysView sysview = new SysView();
	private ArticleView articleview = new ArticleView();
 	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String ip = request.getRemoteAddr();
		String operation = request.getRequestURL().toString();
		
		sysview.setIp(ip);
		sysview.setOperation(operation);
		if (operation.contains("/api/article/")) {
			articleview.setIp(ip);
			Long articleID = null;			
			try {
				String requestparam = request.getRequestURL().toString();
				String[] parameterarr =  requestparam.split("/article/");
				articleID = Long.parseLong(parameterarr[parameterarr.length-1]);  
			} catch (Exception e) {
				
				sysviewservice.insertSelective(sysview);
				return true;
		
			}		
			articleview.setArticle_id(articleID);
			articleviewservice.insertSelective(articleview);
		}
		
		sysviewservice.insertSelective(sysview);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		
	}
	
}
