package com.beta.click2eat.service;

import java.util.List;

import com.beta.click2eat.dto.FoodCategoryDto;

public interface FoodCategoryService {
	
	List<FoodCategoryDto> findAllFoodCategories();

}
