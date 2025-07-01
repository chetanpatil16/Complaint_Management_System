package com.milkfirst.exception;

public class ComplaintNotFound extends RuntimeException{

    public ComplaintNotFound(String message){
        super(message);
    }
}
