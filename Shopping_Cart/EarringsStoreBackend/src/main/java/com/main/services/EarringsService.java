package com.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.model.EarringsModel;
import com.main.model.SectionModel;
import com.main.repository.*;

@Service
public class EarringsService {
	@Autowired
    EarringsRepository repository;

	 
	    public  List<EarringsModel> findAll() {
	    	
	        return (List<EarringsModel>) repository.findAll();
	    }
}
