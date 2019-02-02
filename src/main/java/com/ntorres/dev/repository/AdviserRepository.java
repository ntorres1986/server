package com.ntorres.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ntorres.dev.entity.Adviser;;

public interface AdviserRepository extends JpaRepository<Adviser, Long>{
	
}