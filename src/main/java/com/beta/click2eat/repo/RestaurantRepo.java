package com.beta.click2eat.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.beta.click2eat.dto.RestaurantDto;
import com.beta.click2eat.model.Restaurant;

public interface RestaurantRepo extends JpaRepository<Restaurant, Integer>{
	
	String HAVERSINE_FORMULA = "(6371 * acos(cos(radians(:latitude)) * cos(radians(res.resLatitude)) *" +
	        " cos(radians(res.resLongitude) - radians(:longitude)) + sin(radians(:latitude)) * sin(radians(res.resLatitude))))";
	
	@Query("SELECT new com.beta.click2eat.dto.RestaurantDto(res.restaurantId, res.restaurantName, res.address, " + HAVERSINE_FORMULA + ",res.specialisation,res.image,"
			+ "res.rating,res.isOpen,res.avgCost,res.discountType,res.discountValue,res.isTakeaway,res.isDelivery) FROM Restaurant res WHERE " + HAVERSINE_FORMULA + " < :distance ORDER BY "+ HAVERSINE_FORMULA + " DESC")
	List<RestaurantDto> findRestaurantWithInDistance(@Param("latitude") Double latitude, @Param("longitude") Double longitude, 
			@Param("distance") Double distanceWithInKM);

}
