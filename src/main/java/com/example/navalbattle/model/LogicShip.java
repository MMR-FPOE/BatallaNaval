package com.example.navalbattle.model;

import java.io.Serializable;
import java.util.ArrayList;

public class LogicShip implements Serializable {
    public int lifes;

    public ArrayList<Coordinate> shipCoordinates;

    boolean shipOrientation;

    public LogicShip(int lifes){
        this.lifes = lifes;
        shipCoordinates = new ArrayList<>();
            }

    public void addShip(int row, int column, boolean shipOrientation){
        shipCoordinates.add(new Coordinate(row,column));
        this.shipOrientation = shipOrientation;
    }

    public void setShips(ArrayList<Coordinate> coordinates, boolean shipOrientation){
        shipCoordinates = coordinates;
        this.shipOrientation = shipOrientation;
    }

    public ArrayList<Coordinate> getShipCoordinates(){
        return shipCoordinates;
    }

    public void lostALife() { lifes--; }
    public boolean isDied() {
        return (lifes == 0);
    }

    public boolean getShipOrientation(){
        return this.shipOrientation;
    }

    public Coordinate getFirstCoordinate() {
        return shipCoordinates.get(0);
    }
}
