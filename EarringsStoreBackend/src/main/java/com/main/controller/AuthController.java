package com.main.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity; 

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.main.config.JwtTokenUtil;
import com.main.config.PasswordEncoderA;
import com.main.config.WebSecurityConfig;
import com.main.model.ApiResponse;
import com.main.model.AuthToken;
import com.main.model.UserModel;
import com.main.repository.UserRepository;
import com.main.services.MyUserDetailsService;
import com.payload.request.LoginRequest;
import com.payload.request.SignupRequest;
import com.payload.response.MessageResponse;
//import org.json.simple.JSONObject;

import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AuthController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	JwtTokenUtil jwtTokenUtil;

	@Autowired
	MyUserDetailsService service;

	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	/**
	 * @Autowired PasswordEncoder encoder;
	 **/
	@RequestMapping("/api/signup")
	@CrossOrigin(origins = "http://localhost:4200")

	public ResponseEntity<?> register(@RequestBody String data) {

		try {
			System.out.println("Data " + data);
			ObjectMapper objectMapper = new ObjectMapper();
		///	objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
			UserModel signup = new ObjectMapper().readValue(data, UserModel.class);
			System.out.println(signup.getId()+" "+signup.getUsername());
			PasswordEncoderA encode = new PasswordEncoderA();
			signup.setPassword(bCryptPasswordEncoder.encode(signup.getPassword()));
			userRepository.save(signup);
			System.out.println("Saved successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));

	}

	public boolean mismatchpassword(String password, String cpassword) {
		if (password.contentEquals(cpassword))
			return true;
		else
			return false;
	}

	@RequestMapping("/api/login")
	@CrossOrigin(origins = "http://localhost:4200")
	//public login(@RequestBody String data) {
	public ApiResponse<Object> login(@RequestBody String data) throws Exception {
		LoginRequest signin=null;
		try {
			System.out.println("Data "+data);
			
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
			signin = new ObjectMapper().readValue(data,LoginRequest.class);
			System.out.println(signin.getUsername()+" "+signin.getPassword());
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken( signin.getUsername(), (signin.getPassword())));
			WebSecurityConfig.currusername= signin.getUsername();
		} catch( Exception e) {
			throw new Exception("Incorrect username or password", e);
		}
		UserDetails user = service.loadUserByUsername( signin.getUsername());

		final String token = jwtTokenUtil.generateToken(user);
		System.out.println("Token " + token);
		return new ApiResponse<>(200, "success", new AuthToken(token, user.getUsername()));
	}

}

/**
 * if (userRepository.existsByUsername(signUpRequest.getUsername())) { return
 * ResponseEntity .badRequest() .body(new MessageResponse("Error: Username is
 * already taken!")); }
 * 
 * if (userRepository.existsByEmail(signUpRequest.getEmail())) { return
 * ResponseEntity .badRequest() .body(new MessageResponse("Error: Email is
 * already in use!")); }
 * 
 * if (userRepository.existsByEmail(signUpRequest.getEmail())) { return
 * ResponseEntity .badRequest() .body(new MessageResponse("Error: Email is
 * already in use!")); }
 * 
 * if(mismatchpassword(signUpRequest.getPassword(),signUpRequest.getPassword()))
 * { return ResponseEntity .badRequest() .body(new MessageResponse("Mismatch
 * password")); }
 **/
// Create new user's account
/**
 * UserModel user = new
 * UserModel(signUpRequest.getId(),signUpRequest.getUsername(),
 * signUpRequest.getEmail(),
 * encoder.encode(signUpRequest.getPassword()),signUpRequest.getCpassword(),signUpRequest.getTelephone());
 * 
 * System.out.println("Done");
 * 
 * UserModel user = new
 * UserModel(signUpRequest.getId(),signUpRequest.getUsername(),
 * signUpRequest.getEmail(),
 * (signUpRequest.getPassword()),signUpRequest.getConfirmPassword(),signUpRequest.getPhoneNumber());
 * System.out.println(signUpRequest.getId()+" "+signUpRequest.getUsername()+" "+
 * signUpRequest.getEmail()+" "+ signUpRequest.getPassword()+"
 * "+signUpRequest.getConfirmPassword()+" "+signUpRequest.getPhoneNumber());
 * userRepository.save(user);
 **/