package com.MyGameLibrary.demo.Exceptions;

public class GameNotFoundException extends RuntimeException{

    public  GameNotFoundException(String message){
        super(message);
    }
}
