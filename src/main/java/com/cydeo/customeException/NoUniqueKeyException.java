package com.cydeo.customeException;

public class NoUniqueKeyException extends RuntimeException{
    public NoUniqueKeyException(String errorMessage){
        super(errorMessage);
    }
}
