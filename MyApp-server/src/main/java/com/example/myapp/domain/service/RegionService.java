package com.example.myapp.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.myapp.domain.model.Region;
import com.example.myapp.domain.repository.RegionRepository;


@Service
@Transactional
public class RegionService {
	@Autowired
	RegionRepository regionRepository;

	// 地方区分全件取得
	public List<Region> findAll() {
		return regionRepository.findAll();
	}

	// 地方区分1件取得
	public Region findOne(Integer id) {
		return regionRepository.findOne(id);
	}
}
