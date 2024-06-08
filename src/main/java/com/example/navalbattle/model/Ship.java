package com.example.navalbattle.model;

import java.util.ArrayList;

public class Ship implements IShip{
    public char name;
    public int length;
    public int amount;
    public Coordinate firstCoordinate;

    public boolean available = true;
    protected ArrayList<LogicShip> gameShips = new ArrayList<>();

    /**
     * Public ship constructor
     */

    public Ship(){
    }

    /**
     * Returns the length
     * @return            length of the ship
     */
    public int getLength() {
        return length;
    }

    /**
     * Returns the availability
     * @return            availability of the ship
     */
    public boolean getAvailability(){ return !available;}

    /**
     * Set the availability of the ship
     */
    public void setAvailability(){
        this.available = false;
    }

    /**
     * Method that reduces the number of ships by one
     * @return          the ships of the class
     */
    public boolean shipStatus(){
        amount--;
        return (amount == 0);
    }

    /**
     * Method that return the logic ships of the ships
     * @return              the logic ships objects
     */
    public ArrayList<LogicShip> getLogicShips(){
        return gameShips;
    }

    /**
     * Method that set the first coordinate of the ship
     * @param firstCoordinate    coordinate
     */
    public void setFirstCoordinate(Coordinate firstCoordinate) {
        this.firstCoordinate = firstCoordinate;
    }

    /**
     * Method that get the first coordinate of the ship
     */
    public Coordinate getFirstCoordinate() {
        return firstCoordinate;
    }
}