package com.ntorres.dev.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ntorres.dev.entity.Card;
import com.ntorres.dev.service.CardService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api")
public class CardController {

	@Autowired
    private CardService cardService;
	
	@SuppressWarnings("rawtypes")
	@RequestMapping("/cards/{customerId}")
    @ResponseBody
    public ResponseEntity<List> getCards(@PathVariable(value = "customerId") Long customerId) {
		return new ResponseEntity<List>(cardService.getCards(customerId), HttpStatus.OK);
    }
	
	@RequestMapping(value = "/cards-add", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    
    public Card addCard(@RequestBody Card card) {
		return cardService.save(card);
    }
	
	@GetMapping("/card/{id}")
    public Card getCardById(@PathVariable(value = "id") Long id) {
        return cardService.findById(id);
    }
	
	@PutMapping("/card/{id}")
	public Card updateCard(@PathVariable(value = "id") Long id, @Valid @RequestBody Card cardIn) {
        
		Card card = cardService.findById(id);
        card.setCcv(cardIn.getCcv());
        card.setNumber(cardIn.getNumber());
        card = cardService.save(card);
        
	    return card;
	}
	
	@DeleteMapping("/card/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable(value = "id") Long id) {
		Card card = cardService.findById(id);
		cardService.delete(card);
        return ResponseEntity.ok().build();
	}
	
}
