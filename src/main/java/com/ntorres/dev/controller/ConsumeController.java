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

import com.ntorres.dev.entity.Consume;
import com.ntorres.dev.service.ConsumeService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api")
public class ConsumeController {

	@Autowired
    private ConsumeService consumeService;
	
	@SuppressWarnings("rawtypes")
	@RequestMapping("/consumes/{cardId}")
    @ResponseBody
    public ResponseEntity<List> getConsumes(@PathVariable(value = "cardId") Long cardId) {
		return new ResponseEntity<List>(consumeService.getConsumes(cardId), HttpStatus.OK);
    }
	
	@RequestMapping(value = "consume/add", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Consume addConsume(@RequestBody Consume consume) {
		return consumeService.save(consume);
    }
	
	@GetMapping("/consume/{id}")
    public Consume getConsumeById(@PathVariable(value = "id") Long id) {
        return consumeService.findById(id);
    }
	
	@PutMapping("/consume/{id}")
	public Consume updateCard(@PathVariable(value = "id") Long id, @Valid @RequestBody Consume consumeIn) {
        
		Consume consume = consumeService.findById(id);
        consume.setAmount(consumeIn.getAmount());
        consume.setDate(consumeIn.getDate());
        consume.setDescription(consumeIn.getDescription());
        
        consume = consumeService.save(consume);
        
	    return consume;
	}
	
	@DeleteMapping("/consume/{id}")
    public ResponseEntity<?> deleteConsume(@PathVariable(value = "id") Long id) {
		Consume consume = consumeService.findById(id);
		consumeService.delete(consume);
        return ResponseEntity.ok().build();
	}
	
}
