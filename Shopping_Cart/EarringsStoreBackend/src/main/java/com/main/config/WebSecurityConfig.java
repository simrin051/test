package com.main.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;
import org.springframework.security.web.savedrequest.NullRequestCache;

import com.main.filters.JwtRequestFilter;
import com.main.services.MyUserDetailsService;

@Configuration
//@Order(1)
@EnableWebSecurity  // this enabled web security config to work
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	  
	  @Autowired
	private AuthEntryPointJwt unauthorizedHandler;

	  @Autowired
	  private MyUserDetailsService myUserDetailsService;
	  
	  @Autowired
	  private com.main.filters.JwtRequestFilter  jwtRequestFilter ;
	  
	  public static String currusername=null;
	  
	  @Override
	  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		  
		  auth.userDetailsService(myUserDetailsService);
		  

	    }
	  @Override
	  public void configure(WebSecurity web) throws Exception {
		  System.out.println("Configuring firewall");
		  super.configure(web);
		  web.httpFirewall(allowUrlEncodedSlashHttpFirewall()); 
	  }
	  @Override
	  protected void configure(HttpSecurity http) throws Exception {
		
		 
		  http.cors().and().csrf().disable()
			.exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
			.authorizeRequests()
			
			.antMatchers("http://localhost:4200/**").permitAll()
			.antMatchers("/api/login/**").permitAll()
			.antMatchers("/sections/**").permitAll()
		/**	.antMatchers("/add/cart/**").permitAll()  **/
			.antMatchers("/list/cart/**").permitAll()
			.antMatchers("/item/cart/**").permitAll()
			.antMatchers("/delete/**").permitAll()
			.antMatchers("/bracelets/**").permitAll()
			.antMatchers("/rings/**").permitAll()
			.antMatchers("/earrings/**").permitAll()
			.antMatchers("/").permitAll()
			.antMatchers("/neckpieces/**").permitAll()
			 .and()
		        .authorizeRequests();

			
			http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

	  }
	    @Override @Bean
	    public AuthenticationManager authenticationManagerBean() throws Exception {
	        return super.authenticationManagerBean();
	    }
	    
	    @Bean
	    public HttpFirewall allowUrlEncodedSlashHttpFirewall() {
	        StrictHttpFirewall firewall = new StrictHttpFirewall();
	        firewall.setAllowUrlEncodedSlash(true);    
	        return firewall;
	    }
}


