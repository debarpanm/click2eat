package com.beta.click2eat.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.beta.click2eat.model.Customer;
import com.beta.click2eat.serviceImpl.LoginServiceImpl;

@Component
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{
	
	@Autowired
    private LoginServiceImpl customerService;
     
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
            HttpServletResponse response, Authentication authentication)
                throws IOException, ServletException {
         
         
		/*
		 * CustomerUserDetails customerDetails = (CustomerUserDetails)
		 * authentication.getPrincipal();
		 * 
		 * Customer customer = customerDetails.getCustomer();
		 * 
		 * if (customer.isOTPRequired()) { customerService.clearOTP(customer); }
		 * 
		 * super.onAuthenticationSuccess(request, response, authentication);
		 */
    }

}
