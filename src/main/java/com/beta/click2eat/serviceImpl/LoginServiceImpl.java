package com.beta.click2eat.serviceImpl;

import java.security.NoSuchAlgorithmException;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.beta.click2eat.dto.LoginResponseDto;
import com.beta.click2eat.model.Customer;
import com.beta.click2eat.repo.CustomerRepository;
import com.beta.click2eat.service.LoginService;
import com.beta.click2eat.utils.OtpGenerator;

@Service
@Transactional
public class LoginServiceImpl implements LoginService{
	
	@Autowired 
	CustomerRepository customerRepo;
     
    @Autowired 
    PasswordEncoder passwordEncoder;
    
    @Override
	public LoginResponseDto registerCustomer(Long mobile, Integer type) {
    	
    	Customer customer = this.customerRepo.findByPhoneNumber(mobile);
    	
    	String otp = null;
    	
    	try {
    		otp = generateOneTimePassword();
    		System.out.println("OTP value **** " + otp);
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	
    	if(customer!=null) {		
    		customer.setOneTimePassword(passwordEncoder.encode(otp));
    		customer.setPassword(passwordEncoder.encode(otp));
    	    customer.setOtpRequestedTime(new Date());
    	    customerRepo.save(customer);
    	}else {
    		Customer cust = new Customer();
    		cust.setPhoneNumber(mobile);
    		cust.setOneTimePassword(passwordEncoder.encode(otp));
    		cust.setPassword(passwordEncoder.encode(otp));
    		cust.setOtpRequestedTime(new Date());
   	     	customerRepo.saveAndFlush(cust);
    	}
    	
    	Customer cus = this.customerRepo.findByPhoneNumber(mobile);
    	LoginResponseDto loginResponseDto = new LoginResponseDto();
    	loginResponseDto.setMobile(mobile);
    	loginResponseDto.setOtp(otp);
    	loginResponseDto.setUserId(cus.getUserId());
    	
		return loginResponseDto;
	}
     
    private String generateOneTimePassword() throws NoSuchAlgorithmException {
    	
    	OtpGenerator otpGenerator = new OtpGenerator();
    	String otp = otpGenerator.generateOtp(4, "123456789");
        
        //String encodedOTP = passwordEncoder.encode(OTP);
         
        return otp;          
    }
 
    public void clearOTP(Customer customer) {
    	
    	customer.setOneTimePassword(null);
        customer.setOtpRequestedTime(null);
        customerRepo.save(customer);
    }
    
    public Customer getCustomerByEmail(Integer phone) {
    	return customerRepo.findById(phone).orElse(new Customer());
    }

	@Override
	public UserDetails loadUserByUsername(String mobile) throws UsernameNotFoundException {
		Customer customer = customerRepo.findByPhoneNumber(Long.valueOf(mobile));
		
		if (customer == null) {
			System.out.println("No User Found");
		}
		
		return new Customer(customer.getUserId(),  customer.getPassword(),
				Long.valueOf(mobile), customer.getOneTimePassword());
	}

}
