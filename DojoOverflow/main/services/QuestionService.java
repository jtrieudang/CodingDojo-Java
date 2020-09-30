package com.codingdojo.dojooverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.dojooverflow.models.Question;
import com.codingdojo.dojooverflow.repositories.QuestionRepository;

@Service
public class QuestionService {
	private final QuestionRepository questionRepository;
	public QuestionService(QuestionRepository questionRepository) {
		this.questionRepository = questionRepository;
	}
	
	public Question createQuestion(Question question) {
		return questionRepository.save(question);
	}

	public Question findQ(Long id) {
		Optional<Question> myQ = questionRepository.findById(id);
		if (myQ.isPresent()) {
			return myQ.get();
		}else {
			return null;
		}
    }
    
	public List<Question> findAll(){
		return questionRepository.findAll();
	}
}