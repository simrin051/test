package com.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.model.*;
import com.main.repository.*;

@Service
public class RingsService {
	@Autowired
	RingsRepository repository;

	 
	    public  List<RingsModel> findAll() {
	    	
	        return (List<RingsModel>) repository.findAll();
	    }
}
