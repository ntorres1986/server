package com.ntorres.dev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.ntorres.dev.entity.Customer;
import com.ntorres.dev.repository.CustomerRepository;

@Service
public class CustomerService {

	 @Autowired
	 private CustomerRepository repository;
	 
	 public List<Customer> getCustomers() {
	     return (List<Customer>) repository.findAll();
	 }
	 
	 public Customer save(Customer customer) {
		return repository.save(customer);
	 }
	 
	 public Customer findById(Long id) {
		 return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
	 }
	 
	 public void delete(Customer customer){
		 repository.delete(customer);
	 }
}