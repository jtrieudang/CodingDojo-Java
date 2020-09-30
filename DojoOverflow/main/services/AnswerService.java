package com.codingdojo.dojooverflow.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.dojooverflow.models.Answer;
import com.codingdojo.dojooverflow.repositories.AnswerRepo;

@Service
public class AnswerService {
	private final AnswerRepository answerRepository;
	public AnswerService(AnswerRepository answerRepository) {
		this.answerRepository = answerRepository;
	}
	public Answer createAns(Answer answer) {
		return answerRepository.save(answer);
	}
	public List<Answer> getAll() {
		return answerRepository.findAll();
	}

}