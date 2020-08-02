package blog.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import blog.interceptor.BackInterceptor;
import blog.interceptor.ForeInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer{
	  @Bean
	    public HandlerInterceptor getBackInterceptor() {
	        return new BackInterceptor();
	    }
	  @Bean
	    public HandlerInterceptor getForeInterceptor() {
		  return new ForeInterceptor();
	  }
	  
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(getBackInterceptor()).excludePathPatterns("/admin/tologin","/admin/login.html").addPathPatterns("/admin/**");
		registry.addInterceptor(getForeInterceptor()).addPathPatterns("/**").excludePathPatterns("/admin/tologin","/admin/login.html","/js/**", "/css/**", "/img/**","/res/**");
		WebMvcConfigurer.super.addInterceptors(registry);
	}
	
}	
