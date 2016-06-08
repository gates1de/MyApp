package com.example.myapp.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.myapp.domain.model.Genre;
import com.example.myapp.domain.repository.GenreRepository;


@Service
@Transactional
public class GenreService {
	@Autowired
	GenreRepository genreRepository;

	// ジャンル全件取得
	public List<Genre> findAll() {
		return genreRepository.findAll();
	}

	// ジャンル1件取得
	public Genre findOne(Integer id) {
		return genreRepository.findOne(id);
	}
}
