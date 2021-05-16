package com.beta.click2eat.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beta.click2eat.dto.FoodCategoryDto;
import com.beta.click2eat.model.FoodCategory;
import com.beta.click2eat.repo.FoodCategoryRepo;
import com.beta.click2eat.service.FoodCategoryService;
import com.beta.click2eat.utils.ObjectMapperUtils;

@Service
public class FoodCategoryServiceImpl implements FoodCategoryService{
	
	@Autowired
	FoodCategoryRepo foodCategoryRepo;

	@Override
	public List<FoodCategoryDto> findAllFoodCategories() {
		List<FoodCategory> foodCategories = this.foodCategoryRepo.findAll();
		List<FoodCategoryDto> allCategories = ObjectMapperUtils.mapAll(foodCategories, FoodCategoryDto.class);
		return allCategories;
	}

}
