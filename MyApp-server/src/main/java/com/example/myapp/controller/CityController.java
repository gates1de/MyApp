package com.example.myapp.controller;

import java.lang.Iterable;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.myapp.domain.model.City;
import com.example.myapp.domain.model.Restaurant;
import com.example.myapp.domain.model.Food;
import com.example.myapp.domain.service.CityService;
import com.example.myapp.domain.service.RestaurantService;
import com.example.myapp.domain.service.FoodService;

@RestController
@RequestMapping("/api/v1/cities")
public class CityController {

    @Autowired
    CityService cityService;

    @Autowired
    RestaurantService restaurantService;

    @Autowired
    FoodService foodService;

    @RequestMapping(method = RequestMethod.GET)
		public List<City> getCities() {
			return cityService.findAll();
		}

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
		public City getCity(@PathVariable Integer id) {
			return cityService.findOne(id);
		}

    @RequestMapping(value = "{id}/foods", method = RequestMethod.GET)
		public List<Food> getFoods(@PathVariable Integer id) {
			return foodService.findByCity(id);
		}

    @RequestMapping(value = "{id}/restaurants", method = RequestMethod.GET)
		public List<Restaurant> getRestaurants(@PathVariable Integer id) {
			return restaurantService.findByCity(id);
		}
}
