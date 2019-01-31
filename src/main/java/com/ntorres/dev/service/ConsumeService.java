package com.ntorres.dev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.ntorres.dev.entity.Consume;
import com.ntorres.dev.repository.ConsumeRepository;

@Service
public class ConsumeService {

	 @Autowired
	 private ConsumeRepository repository;
	 
	 public List<Consume> getCards(Long cardId) {
	     return (List<Consume>) repository.findByCard(cardId);
	 }
	 public Consume save(Consume consume) {
		return repository.save(consume);
	 }
	 public Consume findById(Long id) {
		 return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
	 }
	 public void delete(Consume consume)
	 {
		 repository.delete(consume);
	 }
}

