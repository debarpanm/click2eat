package com.beta.click2eat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.beta.click2eat.dto.JwtResponse;
import com.beta.click2eat.dto.LoginRequestDto;
import com.beta.click2eat.dto.LoginResponseDto;
import com.beta.click2eat.model.Customer;
import com.beta.click2eat.service.LoginService;
import com.beta.click2eat.utils.JwtUtils;

@RestController
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtUtils jwtUtils;
	
	@RequestMapping(value = "/api/v1/customerRegister", method = RequestMethod.POST)
	public ResponseEntity<LoginResponseDto> generateOtp(@RequestBody LoginRequestDto loginRequestDto){
		
		LoginResponseDto loginResponseDto = new LoginResponseDto();
		
		loginResponseDto = this.loginService.registerCustomer(loginRequestDto.getMobile(),loginRequestDto.getType());
		
		return ResponseEntity.status(HttpStatus.OK).body(loginResponseDto);
		
	}
	
	@RequestMapping(value = "/api/v1/customerOtpSubmit", method = RequestMethod.POST)
	public ResponseEntity<JwtResponse> registerCustomer(@RequestBody LoginRequestDto loginRequestDto){
		
		Authentication authentication = this.authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequestDto.getMobile(), loginRequestDto.getOtp()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		String jwt = jwtUtils.generateToken(authentication);
		
		Customer customer = (Customer) authentication.getPrincipal();
		
		return ResponseEntity.ok(new JwtResponse(jwt, customer.getUserId(), customer.getPhoneNumber()));
		
	}

}
