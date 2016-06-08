package com.example.myapp.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myapp.domain.model.Area;


public interface AreaRepository extends JpaRepository<Area, Integer> {

}
