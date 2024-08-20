package org.food.exception;

public class CustomerExistsException extends Exception{
    public CustomerExistsException(String message) {
        super(message);
    }
}
