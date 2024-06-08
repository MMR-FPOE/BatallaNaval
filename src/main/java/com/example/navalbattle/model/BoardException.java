package com.example.navalbattle.model;

public class BoardException extends Exception{

    public BoardException(Throwable cause){
        super(cause);
    }

    public BoardException(String message, Throwable cause){
        super(message, cause);
    }


}
