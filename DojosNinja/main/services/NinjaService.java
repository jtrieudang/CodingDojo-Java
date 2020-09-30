package com.codingdojo.dojosninjas.services;

import org.springframework.stereotype.Service;

import com.codingdojo.dojosninjas.models.Ninja;
import com.codingdojo.dojosninjas.repositories.NinjaRepo;

@Service
public class NinjaService {
	private final NinjaRepository ninjaRepository;
	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
	
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepository.save(ninja);
	}
}