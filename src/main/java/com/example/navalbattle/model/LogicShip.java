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

    /**
     * Method that adds the ships coordinates
     * @param column     ship's column
     * @param row        ship's row
     * @param shipOrientation       orientation of teh ship
     */
    public void addShip(int row, int column, boolean shipOrientation){
        shipCoordinates.add(new Coordinate(row,column));
        this.shipOrientation = shipOrientation;
    }

    /**
     * Method that adds the ships coordinates
     * @param coordinates           coordinates of the sip
     * @param shipOrientation       orientation of the ship
     */
    public void setShips(ArrayList<Coordinate> coordinates, boolean shipOrientation){
        shipCoordinates = coordinates;
        this.shipOrientation = shipOrientation;
    }

    /**
     * Method that return the ship coordinates
     * @return        the array of the ship coordinates
     */
    public ArrayList<Coordinate> getShipCoordinates(){
        return shipCoordinates;
    }

    /**
     *  Method that decreases the life of the logic ship
     */
    public void lostALife() { lifes--; }

    /**
     *  Method verifies if the ship is died
     *  return          the
     */
    public boolean isDied() {
        return (lifes == 0);
    }

    /**
     *  Method verifies the orientation of the ship
     *  return          orientation
     */
    public boolean getShipOrientation(){
        return this.shipOrientation;
    }

    /**
     *  Method obtains the first coordinate
     *  return          coordinate
     */
    public Coordinate getFirstCoordinate() {
        return shipCoordinates.get(0);
    }
}
