package com.ntorres.dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ntorres.dev.entity.Card;

public interface CardRepository extends JpaRepository<Card, Long>{

	List<Card> findByCustomer(Long customer_id);
}
