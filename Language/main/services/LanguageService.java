  
package com.codingdojo.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.languages.models.Languages;
import com.codingdojo.languages.repositories.LanguageRepository;

@Service
public class LanguageService {

	private final LanguageRepository languageRepository;
	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	

	public List<Languages> allLanguages(){
		return languageRepository.findAll();
	}

	public Languages createLanguage(Languages lang) {
		return languageRepository.save(lang);
	}

	public Languages findLang(Long id) {
		Optional<Languages> optionalLang = languageRepository.findById(id);
		if(optionalLang.isPresent()) {
			return optionalLang.get();
		}else {
			return null;
		}
	}

	public void deleteLanguage(Long id) {
		Optional<Languages> lang = languageRepository.findById(id);
		if(lang.isPresent()) {
			languageRepository.deleteById(id);
		}
	}
}