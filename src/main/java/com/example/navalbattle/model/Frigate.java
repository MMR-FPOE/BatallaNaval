package com.example.navalbattle.model;

public class Frigate extends Ship{
    private final String name = "Fragata";
    public int amount = 4;

    public Frigate(){
        super.length = 1;
        super.available = true;
    }

    @Override
    public boolean shipStatus(){
        amount--;
        return (amount == 0);
    }
}
