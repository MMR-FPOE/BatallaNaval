package com.example.navalbattle.model;

import java.util.ArrayList;

public class LogicShip {
    public int lifes;

    public ArrayList<Coordinate> shipCoordinates;

    public LogicShip(int lifes){
        this.lifes = lifes;
        shipCoordinates = new ArrayList<>();
    }

    public void addShip(int row, int column){
        shipCoordinates.add(new Coordinate(row,column));
    }

    public ArrayList<Coordinate> getShipCoordinates(){
        return shipCoordinates;
    }

}
