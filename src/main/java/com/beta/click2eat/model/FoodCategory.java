package com.beta.click2eat.model;

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
@Table(name = "TBL_FOOD_CATEGORY")
public class FoodCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="CATEGORY_ID")
	private Integer foodCategoryId;
	
	@Column(name ="CATEGORY_NAME")
	private String foodCategoryName;
	
	@Column(name ="CATEGORY_IMAGE")
	private String foodCategotyImage;

}
