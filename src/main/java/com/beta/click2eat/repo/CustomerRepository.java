package com.beta.click2eat.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.beta.click2eat.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	Customer findByPhoneNumber(Long mobile);
	
}
