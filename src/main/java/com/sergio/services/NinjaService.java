package com.sergio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sergio.models.Ninja;
import com.sergio.repositories.NinjaRepository;

@Service
public class NinjaService {

private final NinjaRepository ninjaRepository;
	
	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
	
	public List<Ninja> getAllNinjas(){
		return ninjaRepository.findAll();
	}
	
	public List<Ninja> getAllNinjasByDojo(Long id){
		return ninjaRepository.findAllById(id);
	}
	
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepository.save(ninja);
	}
	
	public Ninja getNinjaById(int id) {
		Optional<Ninja>optionalNinja = ninjaRepository.findById(id);
		if (optionalNinja.isPresent()) {
			return optionalNinja.get();
		}else {
			return null;
		}
	}
	
	
}
