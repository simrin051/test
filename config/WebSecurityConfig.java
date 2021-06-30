package com.main.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.savedrequest.NullRequestCache;

import com.auth.filters.JwtRequestFilter;
import com.main.services.MyUserDetailsService;

@Configuration
@Order(1)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	  
	  @Autowired
	private AuthEntryPointJwt unauthorizedHandler;

	  @Autowired
	  private MyUserDetailsService myUserDetailsService;
	  
	  @Autowired
	  private JwtRequestFilter  jwtRequestFilter ;
	  
	  @Override
	  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		  
		  auth.userDetailsService(myUserDetailsService);

	    }
	
	  @Override
	  protected void configure(HttpSecurity http) throws Exception {
		  
			http.cors().and().csrf().disable()
			.exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
			.authorizeRequests().antMatchers("/admin").permitAll()
			.antMatchers("/api/signup/**").permitAll()
			.antMatchers("/api/login/**").permitAll()
			.antMatchers("/sections/**").permitAll()
			.antMatchers("**/cart/").permitAll()
		//	.antMatchers("/add/cart/").permitAll()
			.antMatchers("/bracelets/**").permitAll()
			.antMatchers("/rings/**").permitAll()
			.antMatchers("/earrings/**").permitAll()
			.antMatchers("/neckpieces/**").permitAll() 
			.anyRequest().authenticated() 
			.and().sessionManagement();
			http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

	  }
	    @Override @Bean
	    public AuthenticationManager authenticationManagerBean() throws Exception {
	        return super.authenticationManagerBean();
	    }
}


