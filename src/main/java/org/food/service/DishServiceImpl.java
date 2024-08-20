package org.food.service;

import org.food.exception.DishExistsException;
import org.food.exception.DishNotFoundException;
import org.food.model.Dish;
import org.food.repository.DishRepository;

import java.util.List;
import java.util.Optional;

public class DishServiceImpl implements DishService {

    private final DishRepository dishRepository;

    public DishServiceImpl(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @Override
    public List<Dish> getDishesList() {
        return this.dishRepository.getDishList();
    }

    @Override
    public Dish save(Dish dish) throws DishExistsException {
        Optional<Dish> dishById = this.dishRepository.findDishById(dish.getId());
        if (dishById.isPresent())
            throw new DishExistsException("Dish Already Exists with this Id  :" + dish.getId());
        return this.dishRepository.saveDish(dish);
    }

    @Override
    public Dish getDishById(String id) throws DishNotFoundException {
        Optional<Dish> dishById = this.dishRepository.findDishById(id);
        if (dishById.isEmpty())
            throw new DishNotFoundException("Dish Not Found With This Id  :" + id);
        return dishById.get();
    }

    @Override
    public Dish update(Dish dish) throws DishNotFoundException {
        Optional<Dish> dishById = this.dishRepository.findDishById(dish.getId());
        if (dishById.isEmpty())
            throw new DishNotFoundException("Dish Not Found with Id : " + dish.getId());
        return this.dishRepository.updateDish(dish);
    }

    @Override
    public void delete(String id) throws DishNotFoundException {
        Optional<Dish> dishById = this.dishRepository.findDishById(id);
        if (dishById.isEmpty())
            throw new DishNotFoundException("Dish Not Found with Id : " + id);
        this.dishRepository.deleteDish(dishById.get());
    }

}