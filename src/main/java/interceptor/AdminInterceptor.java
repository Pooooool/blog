package interceptor;

/*import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import pojo.User;

public class AdminInterceptor extends HandlerInterceptorAdapter{
	private String name = "admin";
	private String password = "123456";
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		User user = (User) request.getAttribute("user");
		if (user != null) {
			if(user.getName().equals(name) && user.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
}*/
