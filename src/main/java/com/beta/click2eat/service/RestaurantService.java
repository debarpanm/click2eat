package com.beta.click2eat.service;

import java.util.List;

import com.beta.click2eat.dto.RestaurantDto;
import com.beta.click2eat.model.Restaurant;

public interface RestaurantService {
	
	List<RestaurantDto> getNearbyRestaurants(Double userLat, Double userLng);

}
