package com.example.navalbattle.model;

import java.util.ArrayList;

public class Ship {
    public char name;
    public int length;
    public int amount;
    public Coordinate firstCoordinate;

    public boolean available = true;

    protected ArrayList<LogicShip> gameShips = new ArrayList<>();

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

    public ArrayList<LogicShip> getLogicShip(){
        return gameShips;
    }

    public void setFirstCoordinate(Coordinate firstCoordinate) {
        this.firstCoordinate = firstCoordinate;
    }

    public Coordinate getFirstCoordinate() {
        return firstCoordinate;
    }
}