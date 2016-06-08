package com.example.myapp.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.myapp.domain.model.Restaurant;
import com.example.myapp.domain.model.City;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

	@Query (value = "select * from restaurants r inner join cities c on r.city_id = c.id where r.city_id = :cityId", nativeQuery = true)
	List<Restaurant> findByCity(@Param("cityId") Integer cityId);
}
