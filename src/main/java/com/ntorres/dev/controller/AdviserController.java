package com.ntorres.dev.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.ntorres.dev.entity.Adviser;
import com.ntorres.dev.service.AdviserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api")
public class AdviserController {

	@Autowired
    private AdviserService adviserService;
	
	@RequestMapping("/advisers")
    @ResponseBody
    public List<Adviser> getAdvisers() {
		return  adviserService.getAdvisers();
    }
	
	@RequestMapping(value = "/adviser-add", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Adviser addAdviser(@RequestBody Adviser adviser) {
		return adviserService.save(adviser);
    }
	
	@GetMapping("/adviser/{id}")
    public Adviser getAdviserById(@PathVariable(value = "id") Long id) {
        return adviserService.findById(id);
    }
	
	@PutMapping("/adviser/{id}")
	public Adviser updateAdviser(@PathVariable(value = "id") Long id, @Valid @RequestBody Adviser adviserIn) {
        
		Adviser adviser = adviserService.findById(id);
        adviser.setName(adviserIn.getName());
        adviser.setSpecialty(adviserIn.getSpecialty());
        adviser = adviserService.save(adviser);
        
	    return adviser;
	}
	
	@DeleteMapping("/adviser/{id}")
    public ResponseEntity<?> deleteAdviser(@PathVariable(value = "id") Long id) {
		Adviser adviser = adviserService.findById(id);
		adviserService.delete(adviser);
        return ResponseEntity.ok().build();
	}
	
}
