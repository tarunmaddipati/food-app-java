package org.food.service;

import org.food.exception.DishNotFoundException;
import org.food.exception.RestaurantExistsException;
import org.food.exception.RestaurantNotFoundException;
import org.food.model.Dish;
import org.food.model.Restaurant;

import java.util.List;

public interface RestaurantService {
    public List<Restaurant> getRestaurantList();
    public Restaurant save(Restaurant restaurant) throws RestaurantExistsException;

    public Restaurant getRestaurantById(String id) throws RestaurantNotFoundException;

    public Restaurant updateRestaurant(Restaurant restaurant) throws RestaurantNotFoundException;

    public void deleteRestaurant(String id) throws RestaurantNotFoundException;

    public List<Dish> getDishItems(String id) throws RestaurantNotFoundException, DishNotFoundException;
}
