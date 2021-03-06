

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("service")
@MapperScan("mapper")
@ComponentScan("controller")
@EnableAutoConfiguration
public class BlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class,args);
	}

}
