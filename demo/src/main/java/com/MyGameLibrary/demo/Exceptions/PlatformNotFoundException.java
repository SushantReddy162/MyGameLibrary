package com.MyGameLibrary.demo.Exceptions;

public class PlatformNotFoundException extends RuntimeException{

    public PlatformNotFoundException(String message){
        super(message);
    }
}
