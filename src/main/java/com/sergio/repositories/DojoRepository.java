package com.sergio.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.sergio.models.Dojo;
import com.sergio.models.Ninja;

public interface DojoRepository extends Repository<Dojo, Long> {
	
	List<Dojo> findAll();
	List<Dojo>findAllById(Long id);
	Dojo save(Dojo dojo);
	Optional<Dojo> findById(Long id);

}
