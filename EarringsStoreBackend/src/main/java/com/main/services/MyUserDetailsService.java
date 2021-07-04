package com.main.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.main.model.UserModel;
import com.main.repository.UserRepository;


@Service
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	UserRepository repository;
	
	public Optional<UserModel>  findUser(String username)
	{
		Optional<UserModel> model=repository.findByUsername(username);
		return model;
	}


	public User loadUserByUsername(String username)  {
		Optional<UserModel> model=repository.findByUsername(username);
		UserModel umodel =model.get();
		if(model.isPresent())
		{
		
		return new User(umodel.getUsername(),umodel.getPassword(),new ArrayList<>());
		}
		return null;
	}

}
