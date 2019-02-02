package com.ntorres.dev.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Customer implements Serializable {
	 
	private static final long serialVersionUID = 3800468449928892303L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
    @Column(nullable = false)
	private String address;
    
    @Column(nullable = false)
	private String city;
    
    @Column(nullable = false)
	private String telephone;
    
    
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<Card> card;
    
	 
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public List<Card> getCard() {
		return card;
	}
	public void setCard(List<Card> card) {
		this.card = card;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", address=" + address + ", city=" + city + ", telephone="
				+ telephone + ", card=" + card + "]";
	} 
	
}
