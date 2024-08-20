package org.food.exception;

public class OrderExistsException extends Exception{
    public OrderExistsException(String message) {
        super(message);
    }
}
