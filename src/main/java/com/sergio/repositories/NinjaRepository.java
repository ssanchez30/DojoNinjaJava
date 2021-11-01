package com.sergio.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;


import com.sergio.models.Ninja;

public interface NinjaRepository extends Repository<Ninja, Long> {
	
	List<Ninja> findAll();
	List<Ninja>findAllById(Long id);
	Ninja save(Ninja ninja);
	Optional<Ninja> findById(int id);

}
