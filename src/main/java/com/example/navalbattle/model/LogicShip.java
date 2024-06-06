package com.example.navalbattle.model;

import java.util.ArrayList;

public class LogicShip {
    public int lifes;

    public ArrayList<Coordinate> shipCoordinates;

    public Coordinate firstCoordinate;

    boolean shipOrientation;

    public LogicShip(int lifes){
        this.lifes = lifes;
        shipCoordinates = new ArrayList<>();
            }

    public void addShip(int row, int column, boolean shipOrientation){
        shipCoordinates.add(new Coordinate(row,column));
        this.shipOrientation = shipOrientation;
    }

    public ArrayList<Coordinate> getShipCoordinates(){
        return shipCoordinates;
    }



    public int getLifes() {
        return lifes;
    }

    public boolean getShipOrientation(){
        return this.shipOrientation;
    }

    public Coordinate getFirstCoordinate() {
        return firstCoordinate;
    }
}
