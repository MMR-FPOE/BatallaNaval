package com.example.navalbattle.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ComputerBoard {
    public ArrayList<ArrayList<Character>> matrix = new ArrayList<>();;

    AircraftCarrier aircraft = new AircraftCarrier();
    Destroyer destroyer = new Destroyer();
    Frigate frigate = new Frigate();
    Submarine submarine = new Submarine();

    public ComputerBoard() {
        createMatrix();

        switch (new Random().nextInt(3)) {
            case 0:
                setFirstPosition();
                break;
            case 1:
                setSecondPosition();
                break;
            case 2:
                setThirdPosition();
                break;
        }

        fillMatrix();
    }

    private void setFirstPosition(){
        aircraft.addShipCoordinates(0, 6);
        aircraft.addShipCoordinates(0, 7);
        aircraft.addShipCoordinates(0, 8);
        aircraft.addShipCoordinates(0, 9);
        aircraft.submitShip();
        
        submarine.addShipCoordinates(2, 2);
        submarine.addShipCoordinates(3, 2);
        submarine.addShipCoordinates(4, 2);
        submarine.submitShip();
        
        submarine.addShipCoordinates(4, 6);
        submarine.addShipCoordinates(4, 7);
        submarine.addShipCoordinates(4, 8);
        submarine.submitShip();
        
        destroyer.addShipCoordinates(8, 9);
        destroyer.addShipCoordinates(9, 9);
        destroyer.submitShip();
        
        destroyer.addShipCoordinates(6, 4);
        destroyer.addShipCoordinates(6, 5);
        destroyer.submitShip();

        destroyer.addShipCoordinates(4, 0);
        destroyer.addShipCoordinates(5, 0);
        destroyer.submitShip();

        frigate.addShipCoordinates(8, 1);
        frigate.submitShip();
        
        frigate.addShipCoordinates(8, 6);
        frigate.submitShip();
        
        frigate.addShipCoordinates(0, 3);
        frigate.submitShip();

        frigate.addShipCoordinates(2, 5);
        frigate.submitShip();

    }

    private void setSecondPosition(){
        aircraft.addShipCoordinates(4, 5);
        aircraft.addShipCoordinates(5, 5);
        aircraft.addShipCoordinates(6, 5);
        aircraft.addShipCoordinates(7, 5);
        aircraft.submitShip();

        submarine.addShipCoordinates(1, 6);
        submarine.addShipCoordinates(1, 7);
        submarine.addShipCoordinates(1, 8);
        submarine.submitShip();

        submarine.addShipCoordinates(4, 2);
        submarine.addShipCoordinates(5, 2);
        submarine.addShipCoordinates(6, 2);
        submarine.submitShip();

        destroyer.addShipCoordinates(2, 0);
        destroyer.addShipCoordinates(2, 1);
        destroyer.submitShip();

        destroyer.addShipCoordinates(1, 3);
        destroyer.addShipCoordinates(1, 4);
        destroyer.submitShip();

        destroyer.addShipCoordinates(6, 8);
        destroyer.addShipCoordinates(7, 8);
        destroyer.submitShip();

        frigate.addShipCoordinates(8, 8);
        frigate.submitShip();

        frigate.addShipCoordinates(0, 0);
        frigate.submitShip();

        frigate.addShipCoordinates(3, 8);
        frigate.submitShip();

        frigate.addShipCoordinates(7, 0);
        frigate.submitShip();
    }

    private void setThirdPosition(){
        aircraft.addShipCoordinates(6, 4);
        aircraft.addShipCoordinates(6, 5);
        aircraft.addShipCoordinates(6, 6);
        aircraft.addShipCoordinates(6, 7);
        aircraft.submitShip();

        submarine.addShipCoordinates(9, 0);
        submarine.addShipCoordinates(9, 1);
        submarine.addShipCoordinates(9, 2);
        submarine.submitShip();

        submarine.addShipCoordinates(3, 7);
        submarine.addShipCoordinates(3, 8);
        submarine.addShipCoordinates(3, 9);
        submarine.submitShip();

        destroyer.addShipCoordinates(3, 1);
        destroyer.addShipCoordinates(4, 1);
        destroyer.submitShip();

        destroyer.addShipCoordinates(4, 4);
        destroyer.addShipCoordinates(4, 5);
        destroyer.submitShip();

        destroyer.addShipCoordinates(9, 7);
        destroyer.addShipCoordinates(9, 8);
        destroyer.submitShip();

        frigate.addShipCoordinates(1, 5);
        frigate.submitShip();

        frigate.addShipCoordinates(7, 9);
        frigate.submitShip();

        frigate.addShipCoordinates(6, 1);
        frigate.submitShip();

        frigate.addShipCoordinates(2, 1);
        frigate.submitShip();
    }

    private void createMatrix(){
        for(int i = 0; i < 10; i++){
            ArrayList<Character> row = new ArrayList<>();
            for(int j = 0; j < 10; j++){
                row.add(' ');
            }
            matrix.add(row);
        }
    }

    private void fillMatrix(){
        List<Ship> ships = Arrays.asList(aircraft, destroyer, frigate, submarine);

        for(Ship ship: ships) {
            for (LogicShip logicShip : ship.getLogicShip()) {
                for(Coordinate coordinate : logicShip.getShipCoordinates()){
                    matrix.get(coordinate.row).set(coordinate.column, ship.name);
                }
            }
        }
    }
}
