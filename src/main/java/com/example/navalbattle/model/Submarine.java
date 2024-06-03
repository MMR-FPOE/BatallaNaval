package com.example.navalbattle.model;

public class Submarine extends Ship{
    private final String name = "Submarino";
    public int amount = 2;

    public Submarine(){
        super.length = 3;
        super.available = true;
    }

    @Override
    public boolean shipStatus(){
        amount--;
        return (amount == 0);
    }
}
