package com.main.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.main.model.*;
import com.main.repository.SectionRepository;
import com.main.services.*;
@Controller

public class SectionsController {
	@Autowired
	SectionRepository sectionRepository;
	
	@Autowired
	SectionService sectionService;

	@Autowired
	RingsService ringsService;
	
	@Autowired
	EarringsService earringsService;

	@Autowired
	BraceletsSerice braceletsService;
	
	@Autowired
	NeckpiecesService neckpiecesService;
	
	@RequestMapping("/sections")
	@CrossOrigin(origins = "http://localhost:4200")

	public @ResponseBody List<SectionModel> findSections(Model model) {
		System.out.println("Sections Cotroller"+sectionRepository);
	   List sections = (List<SectionModel>) sectionService.findAll();
	   for(int i=0;i<sections.size();i++)
	   {
		   SectionModel model1=(SectionModel) sections.get(i);
		 //  System.out.println(model1.getName()+" "+model1.getUrl());
	   }

	    model.addAttribute("sections", sections);

	    return sections;
	}

	@RequestMapping("/earrings")
	@CrossOrigin(origins = "http://localhost:4200")

	public @ResponseBody List<EarringsModel> findEarrings(Model model) {
		System.out.println("Earrings Cotroller"+sectionRepository);
	   List earrings = (List<EarringsModel>) earringsService.findAll();
	   for(int i=0;i<earrings.size();i++)
	   {
		   EarringsModel model1=(EarringsModel) earrings.get(i);
		//   System.out.println(model1.getName()+" "+model1.getUrl());
	   }

	    model.addAttribute("sections", earrings);

	    return earrings;
	}

	@RequestMapping("/rings")
	@CrossOrigin(origins = "http://localhost:4200")

	public @ResponseBody List<RingsModel> findRings(Model model) {
	   List rings = (List<RingsModel>) ringsService.findAll();
	 
	   for(int i=0;i<rings.size();i++)
	   {
		   RingsModel model1=(RingsModel) rings.get(i);
	//	   System.out.println(model1.getName()+" "+model1.getUrl());
	   }

	    model.addAttribute("sections", rings);

	    return rings;
	}
	@RequestMapping("/neckpieces")
	@CrossOrigin(origins = "http://localhost:4200")

	public @ResponseBody List<NeckpiecesModel> findNeckpieces(Model model) {
	   List nickpieces = (List<NeckpiecesModel>)neckpiecesService.findAll();
	 
	   for(int i=0;i<nickpieces.size();i++)
	   {
		   NeckpiecesModel model1=(NeckpiecesModel) nickpieces.get(i);
	//	   System.out.println(model1.getName()+" "+model1.getUrl());
	   }

	    model.addAttribute("sections",nickpieces);

	    return nickpieces;
	}
	
	
	@RequestMapping("/bracelets")
	@CrossOrigin(origins = "http://localhost:4200")

	public @ResponseBody List<BraceletsModel> findBracelets(Model model) {
	   List bracelets = (List<BraceletsModel>) braceletsService.findAll();
	   for(int i=0;i<bracelets.size();i++)
	   {
		   BraceletsModel model1=(BraceletsModel) bracelets.get(i);
	//	   System.out.println(model1.getName()+" "+model1.getUrl());
	   }

	    model.addAttribute("sections", bracelets);

	    return bracelets;
	}
	
}
