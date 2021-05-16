package com.beta.click2eat.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "TBL_CUSTOMER")
public class Customer implements UserDetails{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final long OTP_VALID_DURATION = 5 * 60 * 1000;   // 5 minutes
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	private Integer userId;
	
	@Column(name = "PHONE_NUMBER")
	private Long phoneNumber;
	
	@Column(name = "PASSWORD")
	private String password;
	 
	@Column(name = "one_time_password")
	private String oneTimePassword;
	 
	@Column(name = "otp_requested_time")
	private Date otpRequestedTime;


	public boolean isOTPRequired() {
	    if (this.getOneTimePassword() == null) {
	        return false;
	    }
	     
	    long currentTimeInMillis = System.currentTimeMillis();
	    long otpRequestedTimeInMillis = this.otpRequestedTime.getTime();
	     
	    if (otpRequestedTimeInMillis + OTP_VALID_DURATION < currentTimeInMillis) {
	        // OTP expires
	        return false;
	    }
	     
	    return true;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}


	public Customer(Integer userId, String password, Long phoneNumber, String oneTimePassword) {
		super();
		this.userId = userId;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.oneTimePassword = oneTimePassword;
	}
	
	
	/*
	 * @Override public String getPassword() { if (customer.isOTPRequired()) {
	 * return customer.getOneTimePassword(); }
	 * 
	 * return customer.getPassword(); }
	 */

}
