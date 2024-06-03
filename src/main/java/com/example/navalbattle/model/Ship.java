package com.example.navalbattle.model;

public class Ship {
    private final String name = "Barco";
    public int length;
    public int amount;
    public boolean available = true;

    public Ship(){
    }

    public int getLength() {
        return length;
    }

    public boolean getAvailability(){ return !available;}

    public void setAvailability(){
        this.available = false;
    }

    public boolean shipStatus(){
        amount--;
        return (amount == 0);
    }
}
