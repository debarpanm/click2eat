package com.beta.click2eat.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.beta.click2eat.dto.RestaurantDto;
import com.beta.click2eat.service.RestaurantService;

@RestController
@RequestMapping(value = "/api/v1")
public class RestaurantController {
	
	@Autowired
	RestaurantService restaurantService;
	
	@RequestMapping(value="/restaurant/nearest",method = RequestMethod.GET)
	public ResponseEntity<List<RestaurantDto>> getAllRestaurants(
			@RequestParam(value = "userLat", required = true) Double userLat,
			@RequestParam(value = "userLng", required = true) Double userLng) {
		List<RestaurantDto> nearByRestaurants = this.restaurantService.getNearbyRestaurants(userLat, userLng);
		return ResponseEntity.status(HttpStatus.OK).body(nearByRestaurants);
	}

}
