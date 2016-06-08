package com.example.myapp.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.myapp.domain.model.Prefecture;
import com.example.myapp.domain.repository.PrefectureRepository;


@Service
@Transactional
public class PrefectureService {
	@Autowired
	PrefectureRepository prefectureRepository;

	// 都道府県全件取得
	public List<Prefecture> findAll() {
		return prefectureRepository.findAll();
	}

	// 都道府県1件取得
	public Prefecture findOne(Integer id) {
		return prefectureRepository.findOne(id);
	}
}
