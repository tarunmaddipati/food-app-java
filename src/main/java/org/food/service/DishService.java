package org.food.service;

import org.food.exception.DishExistsException;
import org.food.exception.DishNotFoundException;
import org.food.model.Dish;

import java.util.List;

public interface DishService {
    public List<Dish> getDishesList();

    public Dish save(Dish dish) throws DishExistsException;
    public Dish getDishById(String id) throws DishNotFoundException;
    public Dish update(Dish dish) throws DishNotFoundException;

    public void delete(String id) throws DishNotFoundException;
}
