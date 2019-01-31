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

import com.ntorres.dev.entity.Customer;
import com.ntorres.dev.service.CustomerService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api")
public class CustomerController {

	@Autowired
    private CustomerService customerService;
	
	@SuppressWarnings("rawtypes")
	@RequestMapping("/customers")
    @ResponseBody
    public ResponseEntity<List> getCustomers() {
        return new ResponseEntity<List>(customerService.getCustomers(), HttpStatus.OK);
    }
	
	@RequestMapping(value = "/customers/add", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Customer addCustomer(@RequestBody Customer customer) {
 
        return customerService.save(customer);
    }
	@GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable(value = "id") Long id) {
        return customerService.findById(id);
    }
	
	@PutMapping("/customers/{id}")
	public Customer updateCustomer(@PathVariable(value = "id") Long id, @Valid @RequestBody Customer customerIn) {

        Customer customer = customerService.findById(id);

        customer.setName(customerIn.getName());
        customer.setAddress(customerIn.getAddress());
        customer.setCity(customerIn.getCity());
        customer.setTelephone(customerIn.getTelephone());

        customer = customerService.save(customer);
	    return customer;
	}
	
	@DeleteMapping("/customers/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable(value = "id") Long id) {
		Customer customer = customerService.findById(id);
		customerService.delete(customer);
        return ResponseEntity.ok().build();
    }
}
