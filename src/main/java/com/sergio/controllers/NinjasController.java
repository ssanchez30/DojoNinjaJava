package com.sergio.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sergio.models.Dojo;
import com.sergio.models.Ninja;
import com.sergio.services.DojoService;
import com.sergio.services.NinjaService;

@Controller
public class NinjasController {

private final NinjaService ninjaService;
private final DojoService dojoService;

	
	public NinjasController (NinjaService ninjaService, DojoService dojoService) {
		this.ninjaService = ninjaService;
		this.dojoService = dojoService;
	}
	
	
	@RequestMapping(value="/ninja/add", method=RequestMethod.GET)
	public String addNinja(Model model) {
		
		List<Dojo> dojoList = dojoService.getAllDojos();
		
		model.addAttribute("dojoList", dojoList);
		
		
		return "ninjas.jsp";
	}


	
	@RequestMapping(value="/ninja/create", method=RequestMethod.POST)
	public String createNinja(@RequestParam(value="ninjaName")String ninjaName, @RequestParam(value="ninjaLast")String ninjaLast,
			@RequestParam(value="ninjaAge")String ninjaAge, @RequestParam(value="dojo_id") Long dojo_id, RedirectAttributes redirectAttributes) {
		
		
		if (!ninjaName.equalsIgnoreCase("") && !ninjaLast.equalsIgnoreCase("") && !ninjaAge.equalsIgnoreCase("") ) {
		
		Dojo dojoSelected = dojoService.getDojoById(dojo_id);
		int edad = Integer.parseInt(ninjaAge);
		
		
		Long id = Long.parseLong("0");
		Date created = new Date();
		Date updated = new Date();
		
		Ninja newNinja = new Ninja(id, ninjaName, ninjaLast, edad, dojoSelected, created, updated);
		ninjaService.createNinja(newNinja);
		
		redirectAttributes.addFlashAttribute("errorMessage", "Ninja created successfully!!")
		.addFlashAttribute("clase", "success");
		
		return "redirect:/";
		
		
		}else {
			
			redirectAttributes.addFlashAttribute("errorMessage", "Please check any blank input on the form!!")
			.addFlashAttribute("clase", "danger");
			
			return "redirect:/ninja/add";
			
		}
		
	}
	
}
