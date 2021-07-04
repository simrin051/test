package com.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.model.*;
import com.main.repository.*;

@Service
public class BraceletsSerice {
	@Autowired
   BraceletsRepository repository;

	 
	    public  List<BraceletsModel> findAll() {
	    	
	        return (List<BraceletsModel>) repository.findAll();
	    }
}
