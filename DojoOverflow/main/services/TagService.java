package com.codingdojo.dojooverflow.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.codingdojo.dojooverflow.models.Tag;
import com.codingdojo.dojooverflow.repositories.TagRepository;

@Service
public class TagService {
	private final TagRepository tagRepository;
	
	public TagService(TagRepository tagRepository) {
		this.tagRepository = tagRepository;
	}
	
	public ArrayList<Tag> findAllTags() {
		return (ArrayList<Tag>) tagRepository.findAll();
	}

	public Tag createTag(String tag) {
		return tagRepository.save(new Tag(tag));
	}
}