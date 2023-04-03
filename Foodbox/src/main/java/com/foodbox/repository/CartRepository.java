package com.foodbox.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodbox.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long>{
	
	List<Cart> findAllByCustomerId(Long id);
}
