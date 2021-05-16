package com.beta.click2eat.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestDto {
	
	private Long mobile;
	
	private Integer type;
	
	private Integer otp;

}
