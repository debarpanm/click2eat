package com.beta.click2eat.utils;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class OtpGenerator {
	
	private final SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
	
	public OtpGenerator() throws NoSuchAlgorithmException {
    }
	
	public String generateOtp(int maxLength, String allowedChars) {
        final StringBuilder otp = new StringBuilder(maxLength);
        for (int i = 0; i < maxLength; i++) {
            otp.append(allowedChars.charAt(secureRandom.nextInt(allowedChars.length())));
        }
        return otp.toString();
    }
}
