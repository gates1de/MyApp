package com.example.myapp.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.myapp.domain.model.Food;
import com.example.myapp.domain.model.City;


public interface FoodRepository extends JpaRepository<Food, Integer> {

	@Query (value = "select * from foods f inner join foods_cities fc on f.id = fc.food_id where fc.city_id = :cityId and f.is_specialty = true", nativeQuery = true)
	List<Food> findByCity(@Param("cityId") Integer cityId);

}
