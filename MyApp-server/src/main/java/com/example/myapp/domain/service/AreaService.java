package com.example.myapp.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.myapp.domain.model.Area;
import com.example.myapp.domain.repository.AreaRepository;


@Service
@Transactional
public class AreaService {
	@Autowired
	AreaRepository areaRepository;

	// 地域全件取得
	public List<Area> findAll() {
		return areaRepository.findAll();
	}

	// 地域区分1件取得
	public Area findOne(Integer id) {
		return areaRepository.findOne(id);
	}
}
