package com.example.navalbattle.model;

import java.util.ArrayList;

public class Ship {
    private String name;
    private int length;
    private  ArrayList<ArrayList<Coordinate>> positions = new ArrayList<>();
    public Ship(){
    }

    public void setPositions(ArrayList<Coordinate> positions) {
        this.positions.add(positions);
    }

    public ArrayList<ArrayList<Coordinate>> getPositions() {
        return positions;
    }
}
