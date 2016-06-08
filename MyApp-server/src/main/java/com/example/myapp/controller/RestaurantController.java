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

import com.example.myapp.domain.model.Restaurant;
import com.example.myapp.domain.service.RestaurantService;

@RestController
@RequestMapping("/api/v1/restaurants")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @RequestMapping(method = RequestMethod.GET)
		public List<Restaurant> getRestaurants() {
			return restaurantService.findAll();
		}

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
		public Restaurant getRestaurant(@PathVariable Integer id) {
			return restaurantService.findOne(id);
		}
}
