package org.food.controller;

import org.food.exception.RestaurantExistsException;
import org.food.exception.RestaurantNotFoundException;
import org.food.model.Restaurant;
import org.food.service.RestaurantServiceImpl;

import java.util.List;

public class RestaurantController {
    private final RestaurantServiceImpl restaurantService;

    public RestaurantController(RestaurantServiceImpl restaurantService) {
        this.restaurantService = restaurantService;
    }

    public List<Restaurant> getRestaurantList(){
        return this.restaurantService.getRestaurantList();
    }

    public Restaurant saveRestaurant(Restaurant restaurant) throws RestaurantExistsException {
        return this.restaurantService.save(restaurant);
    }

    public Restaurant getRestaurantById(String id) throws RestaurantNotFoundException{
        return this.restaurantService.getRestaurantById(id);
    }

    public Restaurant updateRestaurant(Restaurant restaurant) throws RestaurantNotFoundException{
        return this.restaurantService.updateRestaurant(restaurant);
    }

    public void deleteRestaurant(String id) throws RestaurantNotFoundException {
        this.restaurantService.deleteRestaurant(id);
    }
}
