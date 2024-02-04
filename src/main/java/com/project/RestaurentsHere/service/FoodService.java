package com.project.RestaurentsHere.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.RestaurentsHere.model.Food;
import com.project.RestaurentsHere.repository.FoodRepository;

@Service
public class FoodService {
	
	@Autowired
	private FoodRepository foodRepository;
	
	public List<Food> listAll(String keyword)
	{
		if(keyword!=null)
		{
			return foodRepository.findAll(keyword);
		}
		
		return foodRepository.findAll();
	}
	
	public Food findById(int fid)
	{
		Food food=foodRepository.findById(fid).get();
		return food;
	}
	
	public void save(Food food)
	{
		foodRepository.save(food);
	}
	
	public void deleteById(int id)
	{
		foodRepository.deleteById(id);
	}

}
