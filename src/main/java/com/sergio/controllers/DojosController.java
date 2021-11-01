package com.sergio.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sergio.models.Dojo;
import com.sergio.models.Ninja;
import com.sergio.services.DojoService;
import com.sergio.services.NinjaService;

@Controller
public class DojosController {
	
	private final DojoService dojoService;
	private final NinjaService ninjaService;
	
	public DojosController (DojoService dojoService, NinjaService ninjaService) {
		this.dojoService = dojoService;
		this.ninjaService = ninjaService;
	}

	@RequestMapping (value="/", method=RequestMethod.GET)
	public String displayMain(Model model) {
		
		List<Dojo> dojoList = dojoService.getAllDojos();
		
		model.addAttribute("dojoList", dojoList);
		
		return "dojos.jsp";
	}
	
	@RequestMapping(value="/dojo/create", method=RequestMethod.POST)
	public String createDojo(@RequestParam(value="dojoName")String dojoName, RedirectAttributes redirectAttributes) {
		
		if (dojoName != "") {
		
			Long id = Long.parseLong("0");
			Date created = new Date();
			Date updated = new Date();
			
			Dojo newDojo = new Dojo(id, dojoName, created, updated);
			dojoService.createDojo(newDojo);
			
			redirectAttributes.addFlashAttribute("errorMessage", "Dojo created successfully!!!")
			.addFlashAttribute("clase", "success");
			
			return "redirect:/";
		}else {
	
			redirectAttributes.addFlashAttribute("errorMessage", "Please enter a name for the dojo!!")
			.addFlashAttribute("clase", "danger");
			
			return "redirect:/";
		}
		
	
		
	}
	
	@RequestMapping(value="/dojo/{id}", method=RequestMethod.GET)
	public String getNinjasFromDojo(@PathVariable("id")Long id, Model model) {
		
		List<Dojo> dojoList = dojoService.getAllNinjasByDojo(id);
		model.addAttribute(dojoList);
		
		System.out.println(dojoList);
		
		return "index.jsp";
	}
	

	
}
