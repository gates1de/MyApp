package com.example.myapp.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myapp.domain.model.Prefecture;


public interface PrefectureRepository extends JpaRepository<Prefecture, Integer> {

}
