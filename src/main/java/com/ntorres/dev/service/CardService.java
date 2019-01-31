package com.ntorres.dev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.ntorres.dev.entity.Card;
import com.ntorres.dev.repository.CardRepository;

@Service
public class CardService {

	 @Autowired
	 private CardRepository repository;
	 
	 public List<Card> getCards(Long customerId) {
	     return (List<Card>) repository.findByCustomer(customerId);
	 }
	 public Card save(Card card) {
		return repository.save(card);
	 }
	 public Card findById(Long id) {
		 return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
	 }
	 public void delete(Card card)
	 {
		 repository.delete(card);
	 }
}

