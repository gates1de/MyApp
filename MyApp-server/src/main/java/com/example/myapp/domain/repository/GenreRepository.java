package com.example.myapp.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myapp.domain.model.Genre;


public interface GenreRepository extends JpaRepository<Genre, Integer> {

}
