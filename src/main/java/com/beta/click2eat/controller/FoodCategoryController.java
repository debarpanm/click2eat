package com.beta.click2eat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.beta.click2eat.dto.FoodCategoryDto;
import com.beta.click2eat.service.FoodCategoryService;

@RestController
@RequestMapping(value = "/api/v1")
public class FoodCategoryController {
	
	@Autowired
	FoodCategoryService foodCategoryService;
	
	@RequestMapping(value = "/categories/allCategories", method = RequestMethod.GET)
	public ResponseEntity<List<FoodCategoryDto>> findAllFoodCategories() {
		List<FoodCategoryDto> allCategories =
				this.foodCategoryService.findAllFoodCategories();
		return ResponseEntity.status(HttpStatus.OK).body(allCategories);
	}

}
