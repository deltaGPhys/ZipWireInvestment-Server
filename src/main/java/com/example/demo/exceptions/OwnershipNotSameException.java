package com.example.demo.exceptions;

public class OwnershipNotSameException extends Exception {

    public OwnershipNotSameException (){

    }

    public OwnershipNotSameException(String message){
        super(message);
    }
}
