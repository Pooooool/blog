

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
@SpringBootApplication
@ComponentScan("service")
@MapperScan("mapper")
public class BlogApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(BlogApplication.class,args);
	}

}
