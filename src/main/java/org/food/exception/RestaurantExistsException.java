package org.food.exception;

public class RestaurantExistsException extends Exception {
    public RestaurantExistsException(String message) {
        super(message);
    }
}
