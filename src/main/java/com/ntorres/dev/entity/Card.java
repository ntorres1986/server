package com.ntorres.dev.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@NamedQuery(name = "Card.findByCustomer",
query = "SELECT c from Card c WHERE c.customer.id = :customer_id")
public class Card implements Serializable{

	
	private static final long serialVersionUID = 2302196605909954340L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	
	@Column(nullable = false)
	private String number;
	
	@Column(nullable = false)
	private Integer ccv;
	
	@JsonIgnore
	@ManyToOne
    @JoinColumn(name = "fk_customer", nullable = false, updatable = false)
    private Customer customer;
    
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "card")
    private List<Consume> consume;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public List<Consume> getConsume() {
		return consume;
	}
	public void setConsume(List<Consume> consume) {
		this.consume = consume;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Integer getCcv() {
		return ccv;
	}
	public void setCcv(Integer ccv) {
		this.ccv = ccv;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
