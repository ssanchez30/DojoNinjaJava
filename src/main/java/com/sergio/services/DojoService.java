package com.sergio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sergio.models.Dojo;
import com.sergio.models.Ninja;
import com.sergio.repositories.DojoRepository;

@Service
public class DojoService {

	private final DojoRepository dojoRepository;
	
	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}
	
	public List<Dojo> getAllDojos(){
		return dojoRepository.findAll();
	}
	
	public List<Dojo> getAllNinjasByDojo(Long id){
		return dojoRepository.findAllById(id);
	}
	
	public Dojo createDojo(Dojo dojo) {
		return dojoRepository.save(dojo);
	}
	
	public Dojo getDojoById(Long id) {
		Optional<Dojo>optionalDojo = dojoRepository.findById(id);
		if (optionalDojo.isPresent()) {
			return optionalDojo.get();
		}else {
			return null;
		}
	}
}
