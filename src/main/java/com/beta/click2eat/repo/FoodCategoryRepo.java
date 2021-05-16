package com.beta.click2eat.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.beta.click2eat.model.FoodCategory;

public interface FoodCategoryRepo extends JpaRepository<FoodCategory, Integer>{

}
