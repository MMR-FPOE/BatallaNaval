package com.example.navalbattle.model;

public class BoardException extends Exception{

    public BoardException(String cause){
        super(cause);
    }

    public BoardException(String message, Throwable cause){
        super(message, cause);
    }


}
