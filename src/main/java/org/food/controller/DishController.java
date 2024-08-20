package org.food.controller;

import org.food.exception.DishExistsException;
import org.food.exception.DishNotFoundException;
import org.food.model.Dish;
import org.food.service.DishServiceImpl;

import java.util.List;

public class DishController {
    private DishServiceImpl dishService;

    public DishController(DishServiceImpl dishService) {
        this.dishService = dishService;
    }

    public List<Dish> getDisesList(){
        return this.dishService.getDishesList();
    }

    public Dish save(Dish dish) throws DishExistsException {
        return this.dishService.save(dish);
    }

    public Dish getDishById(String id) throws DishNotFoundException {
        return this.dishService.getDishById(id);
    }

    public Dish update(Dish dish) throws DishNotFoundException {
        return this.dishService.update(dish);
    }

    public void deleteDish(String id) throws DishNotFoundException{
        this.dishService.delete(id);
    }
}
