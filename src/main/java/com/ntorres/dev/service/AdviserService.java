package com.ntorres.dev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.ntorres.dev.entity.Adviser;
import com.ntorres.dev.repository.AdviserRepository;

@Service
public class AdviserService {

	 @Autowired
	 private AdviserRepository repository;
	 
	 public List<Adviser> getAdvisers() {
	     return (List<Adviser>) repository.findAll();
	 }
	 public Adviser save(Adviser adviser) {
		return repository.save(adviser);
	 }
	 public Adviser findById(Long id) {
		 return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
	 }
	 public void delete(Adviser adviser)
	 {
		 repository.delete(adviser);
	 }
}

