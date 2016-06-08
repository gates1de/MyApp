package com.example.myapp.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.myapp.domain.model.Food;
import com.example.myapp.domain.repository.FoodRepository;


@Service
@Transactional
public class FoodService {
	@Autowired
	FoodRepository foodRepository;

	// 料理全件取得
	public List<Food> findAll() {
		return foodRepository.findAll();
	}

	// 料理1件取得
	public Food findOne(Integer id) {
		return foodRepository.findOne(id);
	}

	// 市区町村のidに紐づく料理を全て取得
	public List<Food> findByCity(Integer cityId) {
		return foodRepository.findByCity(cityId);
	}
}
