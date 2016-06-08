package com.example.myapp.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.myapp.domain.model.City;
import com.example.myapp.domain.repository.CityRepository;


@Service
@Transactional
public class CityService {
	@Autowired
	CityRepository cityRepository;

	// 町域全件取得
	public List<City> findAll() {
		return cityRepository.findAll();
	}

	// 町域1件取得
	public City findOne(Integer id) {
		return cityRepository.findOne(id);
	}
}
