package com.ntorres.dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ntorres.dev.entity.Consume;


public interface ConsumeRepository extends JpaRepository<Consume, Long>{
	List<Consume> findByCard(Long cardId);
}
