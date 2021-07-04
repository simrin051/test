package com.main.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.main.config.JwtTokenUtil;
import com.main.services.MyUserDetailsService;

@Component
public class JwtRequestFilter extends OncePerRequestFilter{
	
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@Autowired
	private JwtTokenUtil jwtutil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		final String authorizationHeader=request.getHeader("Authorization");
		String username=null;
		String jwt=null;
		if(authorizationHeader!=null && authorizationHeader.startsWith("Bearer "))
		{
			jwt = authorizationHeader.substring(7);
			username=jwtutil.getUsernameFromToken(jwt);
		}
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null)
		{
			UserDetails userdetails=this.userDetailsService.loadUserByUsername(username);
			if(jwtutil.validateToken(jwt, userdetails))
			{
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userdetails,null,userdetails.getAuthorities());
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}
		filterChain.doFilter(request, response);
	}

}
