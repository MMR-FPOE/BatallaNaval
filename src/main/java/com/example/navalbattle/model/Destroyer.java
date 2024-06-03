package com.example.navalbattle.model;

public class Destroyer extends Ship{
    private final String name = "Destructor";
    public int amount = 3;

    public Destroyer(){
        super.length = 2;
        super.available = true;
    }

    @Override
    public boolean shipStatus(){
        amount--;
        return (amount == 0);
    }
}
