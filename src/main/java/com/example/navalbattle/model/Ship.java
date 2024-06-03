package com.example.navalbattle.model;

import java.util.ArrayList;

public class Ship {
    private final String name = "Barco";
    private int length;
  
    public boolean available = true;
  
    private ArrayList<ArrayList<Coordinate>> positions = new ArrayList<>();
  
    public Ship(){
    }

    public void setPositions(ArrayList<Coordinate> positions) {
        this.positions.add(positions);
    }

    public ArrayList<ArrayList<Coordinate>> getPositions() {
        return positions;
    }
}

    public int getLength() {
        return length;
    }

    public boolean getAvailability(){ return !available;}

    public void setAvailability(){
        this.available = false;
    }

}