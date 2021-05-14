package com.beta.click2eat.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beta.click2eat.dto.RestaurantDto;
import com.beta.click2eat.repo.RestaurantRepo;
import com.beta.click2eat.service.RestaurantService;

@Service
public class RestaurantServiceImpl implements RestaurantService{
	
	private static final Double ALLOWED_DISTANCE_IN_KM = 70.0;
	
	@Autowired
	RestaurantRepo restaurantRepo;

	@Override
	public List<RestaurantDto> getNearbyRestaurants(Double userLat, Double userLng) {
		
		List<RestaurantDto> nearByRestaurants = this.restaurantRepo.findRestaurantWithInDistance(userLat, userLng, 
				ALLOWED_DISTANCE_IN_KM);
		return nearByRestaurants;
	}

}
