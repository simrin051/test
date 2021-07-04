package com.main.services;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.main.model.SectionModel;
import com.main.repository.SectionRepository;

@Service
public class SectionService {

		@Autowired
       SectionRepository repository;

	 
	    public  List<SectionModel> findAll() {
	    	System.out.println("Section repo"+repository);
	        return (List<SectionModel>) repository.findAll();
	    }
}
