package com.example.navalbattle.model;

import java.util.ArrayList;

public interface IShip{

    int getLength();

    boolean getAvailability();

    void  setAvailability();

    boolean shipStatus();

     ArrayList<LogicShip> getLogicShips();

    void setFirstCoordinate(Coordinate firstCoordinate);

     Coordinate getFirstCoordinate();


}
