package com.beta.click2eat.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RestaurantDto {
	
	private Integer restaurantId;
	
	private String restaurantName;
	
	private String address;
	
	private Double distance;
	
	private String unit;
	
	private String specialisation;
	
	private String image;
	
	private Double rating;
	
	private Boolean isOpen;
	
	private Double avgCost;
	
	private String discountType;
	
	private Double discountValue;
	
	private Boolean isTakeaway;
	
	private Boolean isDelivery;
	
	private Boolean isFavourite;

	public RestaurantDto(Integer restaurantId, String restaurantName, String address, Double distance,
			String specialisation, String image, Double rating, Boolean isOpen, Double avgCost, String discountType,
			Double discountValue, Boolean isTakeaway, Boolean isDelivery) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.address = address;
		this.distance = distance;
		this.specialisation = specialisation;
		this.image = image;
		this.rating = rating;
		this.isOpen = isOpen;
		this.avgCost = avgCost;
		this.discountType = discountType;
		this.discountValue = discountValue;
		this.isTakeaway = isTakeaway;
		this.isDelivery = isDelivery;
	}

}
