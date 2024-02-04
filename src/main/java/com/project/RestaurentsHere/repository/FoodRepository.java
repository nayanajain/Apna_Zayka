package com.project.RestaurentsHere.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.RestaurentsHere.model.Food;


public interface FoodRepository extends JpaRepository<Food, Integer> {

//	public List<Food> findFoodByUser(@Param("email")String email);
	
	@Query("Select f FROM Food f WHERE f.name LIKE %?1% OR f.catagory LIKE %?1%  OR f.price LIKE %?1%")
	
	public List<Food> findAll(String keyword);
}
