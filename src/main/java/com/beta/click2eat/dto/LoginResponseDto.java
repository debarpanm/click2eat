package com.beta.click2eat.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LoginResponseDto {
	
	private Integer userId;
	
	private Long mobile;
	
	private String otp;
	
}
