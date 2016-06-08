package com.example.myapp.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.myapp.domain.model.Restaurant;
import com.example.myapp.domain.repository.RestaurantRepository;


@Service
@Transactional
public class RestaurantService {
	@Autowired
	RestaurantRepository restaurantRepository;

	// 店舗全件取得
	public List<Restaurant> findAll() {
		return restaurantRepository.findAll();
	}

	// 店舗1件取得
	public Restaurant findOne(Integer id) {
		return restaurantRepository.findOne(id);
	}

	// 市区町村のidに紐づく店舗を全て取得
	public List<Restaurant> findByCity(Integer cityId) {
		return restaurantRepository.findByCity(cityId);
	}
}
