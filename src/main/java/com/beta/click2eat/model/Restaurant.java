package com.beta.click2eat.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TBL_RESTAURANT")
public class Restaurant implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RES_ID")
	private Integer restaurantId;
	
	@Column(name = "RES_NAME")
	private String restaurantName;
	
	@Column(name = "RES_ADDRESS")
	private String address;
	
	@Column(name = "RES_LATITUDE")
	private Double resLatitude;
	
	@Column(name = "RES_LONGITUDE")
	private Double resLongitude;
	
	@Column(name = "RES_SPECIAL")
	private String specialisation;
	
	@Column(name = "RES_IMAGE")
	private String image;
	
	@Column(name = "RES_RATING")
	private Double rating;
	
	@Column(name = "OPEN_NOW")
	private Boolean isOpen;
	
	@Column(name = "AVG_COST")
	private Double avgCost;
	
	@Column(name = "DISCOUNT")
	private String discountType;
	
	@Column(name = "DISCOUNT_VALUE")
	private Double discountValue;
	
	@Column(name = "TAKEAWAY_AVAILABLE")
	private Boolean isTakeaway;
	
	@Column(name = "DELIVERY_AVAILABLE")
	private Boolean isDelivery;
	
}
