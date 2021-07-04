package com.main.earringsstore;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//@ComponentScan({"com.main.controller","com.main.services","com.main.config","com.payload.request","com.payload.response","com.auth.filters"})

@ComponentScan({"com.main.controller","com.main.services","com.main.config","com.main.filters"})
@EntityScan("com.main.model")
@EnableJpaRepositories(basePackages = "com.main.repository")
@SpringBootApplication 
public class Application {

	
		// TODO Auto-generated method stub
		public static void main(String[] args) {
	        SpringApplication.run(Application.class, args);
	    }
		@Bean
		   public WebMvcConfigurer corsConfigurer() {
		      return new WebMvcConfigurerAdapter() {
			
		         @Override
		         public void addCorsMappings(CorsRegistry registry) {
		            registry.addMapping("/").allowedOrigins("http://localhost:4200");
		         }
		      };
		   }

}
