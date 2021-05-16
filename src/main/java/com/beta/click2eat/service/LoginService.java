package com.beta.click2eat.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.beta.click2eat.dto.LoginResponseDto;

public interface LoginService extends UserDetailsService{
	
	public LoginResponseDto registerCustomer(Long mobile, Integer type);
	
}
