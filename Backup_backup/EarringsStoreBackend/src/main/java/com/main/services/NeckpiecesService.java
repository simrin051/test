package com.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.model.*;
import com.main.repository.*;

@Service
public class NeckpiecesService {
	@Autowired
	NeckpiecesRepository neckpiecesrepository;

	 
	    public  List<NeckpiecesModel> findAll() {
	    	
	        return (List<NeckpiecesModel>) neckpiecesrepository.findAll();
	    }
}
