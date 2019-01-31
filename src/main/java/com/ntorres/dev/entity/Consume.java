package com.ntorres.dev.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "Card.findConsumeByCardId", query = "SELECT c from Consume c WHERE c.card.id = :cardId")
public class Consume implements Serializable{

	private static final long serialVersionUID = 2646127772016170677L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	
	
	@Column(nullable = false)
	private Date date;
	
	@Column(nullable = false)
	private String description;
	
	@Column(nullable = false)
	private Double amount;
	
	
	@ManyToOne
    @JoinColumn(name = "fk_card", nullable = false, updatable = false)
    private Card card;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	
}
