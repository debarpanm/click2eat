package com.beta.click2eat.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.beta.click2eat.model.Customer;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtils {
	
	 	@Value("${jwt.secret}")
	    private String secret;

	    /**
	     * Tries to parse specified String as a JWT token. If successful, returns User object with username, id and role prefilled (extracted from token).
	     * If unsuccessful (token is invalid or not containing all required user properties), simply returns null.
	     * 
	     * @param token the JWT token to parse
	     * @return the User object extracted from specified token or null if a token is invalid.
	     */
	    public Boolean validateToken(String token) {
	        try {
	            Jwts.parser()
	                    .setSigningKey(secret)
	                    .parseClaimsJws(token);           

	            return true;

	        } catch (JwtException | ClassCastException e) {
	            return null;
	        }
	    }

	    /**
	     * Generates a JWT token containing username as subject, and userId and role as additional claims. These properties are taken from the specified
	     * User object. Tokens validity is infinite.
	     * 
	     * @param u the user for which the token will be generated
	     * @return the JWT token
	     */
	    public String generateToken(Authentication authentication) {
			
			Customer customer = (Customer) authentication.getPrincipal(); 
			  
			return Jwts.builder()
					.setSubject(String.valueOf(customer.getPhoneNumber()))
					.signWith(SignatureAlgorithm.HS512, secret)
					.compact();	 
	    }
	    
	    public String getMobileFromJWT(String token) {
	    	Claims claims = Jwts.parser()
	    			.setSigningKey(secret)
	    			.parseClaimsJws(token)
	    			.getBody();
	    	return claims.getSubject();
	    }
	
}
