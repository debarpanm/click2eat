package com.beta.click2eat.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtResponse {
	
	private String token;
	
	private String type = "Bearer";
	
	private Integer userId;
	
	private Long mobile;

	public JwtResponse(String token, Integer userId, Long mobile) {
		super();
		this.token = token;
		this.userId = userId;
		this.mobile = mobile;
	}

}
