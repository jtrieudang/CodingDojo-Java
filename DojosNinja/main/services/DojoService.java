package com.codingdojo.dojosninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.dojosninjas.models.Dojo;
import com.codingdojo.dojosninjas.repositories.DojoRepo;
import com.codingdojo.dojosninjas.repositories.DojoRepository;

@Service
public class DojoService {
	private final DojoRepository dojoRepository;

	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepo = dojoRepo;
	}

	public List<Dojo> getAllDojos() {
		return (List<Dojo>) dojoRepository.findAll();
	}

	public Dojo createDojo(Dojo dojo) {
		return dojoRepository.save(dojo);
	}

	public Dojo findDojoById(Long id) {
		Optional<Dojo> findDojo = dojoRepo.findById(id);
		if (findDojo.isPresent()) {
			return findDojo.get();
		} else {
			return null;
		}
	}
}