package com.example.myapp.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myapp.domain.model.Region;


public interface RegionRepository extends JpaRepository<Region, Integer> {

}
