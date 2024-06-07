package com.example.navalbattle.model;

import java.util.*;

public class ComputerBoard extends Board{
    public ComputerBoard() {
        super.aircraft = new AircraftCarrier();
        super.destroyer = new Destroyer();
        super.frigate = new Frigate();
        super.submarine = new Submarine();
        super.matrix = new ArrayList<>();
        
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
        super.aircraft.addShipCoordinates(0, 6, true);
        super.aircraft.addShipCoordinates(0, 7, true);
        super.aircraft.addShipCoordinates(0, 8, true);
        super.aircraft.addShipCoordinates(0, 9, true);
        super.aircraft.submitShip();
        
        super.submarine.addShipCoordinates(2, 2, false);
        super.submarine.addShipCoordinates(3, 2, false);
        super.submarine.addShipCoordinates(4, 2, false);
        super.submarine.submitShip();
        
        super.submarine.addShipCoordinates(4, 6, true);
        super.submarine.addShipCoordinates(4, 7, true);
        super.submarine.addShipCoordinates(4, 8, true);
        super.submarine.submitShip();
        
        super.destroyer.addShipCoordinates(8, 9,false );
        super.destroyer.addShipCoordinates(9, 9, false);
        super.destroyer.submitShip();
        
        super.destroyer.addShipCoordinates(6, 4, true);
        super.destroyer.addShipCoordinates(6, 5, true);
        super.destroyer.submitShip();

        super.destroyer.addShipCoordinates(4, 0, false);
        super.destroyer.addShipCoordinates(5, 0, false);
        super.destroyer.submitShip();

        super.frigate.addShipCoordinates(8, 1, false);
        super.frigate.submitShip();
        
        super.frigate.addShipCoordinates(8, 6, true);
        super.frigate.submitShip();
        
        super.frigate.addShipCoordinates(0, 3, false);
        super.frigate.submitShip();

        super.frigate.addShipCoordinates(2, 5, true);
        super.frigate.submitShip();

    }

    private void setSecondPosition(){
        super.aircraft.addShipCoordinates(4, 5, false);
        super.aircraft.addShipCoordinates(5, 5, false);
        super.aircraft.addShipCoordinates(6, 5, false);
        super.aircraft.addShipCoordinates(7, 5, false);
        super.aircraft.submitShip();

        super.submarine.addShipCoordinates(1, 6, true);
        super.submarine.addShipCoordinates(1, 7, true);
        super.submarine.addShipCoordinates(1, 8, true);
        super.submarine.submitShip();

        super.submarine.addShipCoordinates(4, 2, false);
        super.submarine.addShipCoordinates(5, 2, false);
        super.submarine.addShipCoordinates(6, 2, false);
        super.submarine.submitShip();

        super.destroyer.addShipCoordinates(2, 0, true);
        super.destroyer.addShipCoordinates(2, 1, true);
        super.destroyer.submitShip();

        super.destroyer.addShipCoordinates(1, 3, true);
        super.destroyer.addShipCoordinates(1, 4, true);
        super.destroyer.submitShip();

        super.destroyer.addShipCoordinates(6, 8,false);
        super.destroyer.addShipCoordinates(7, 8, false);
        super.destroyer.submitShip();

        super.frigate.addShipCoordinates(8, 8, true);
        super.frigate.submitShip();

        super.frigate.addShipCoordinates(0, 0, true);
        super.frigate.submitShip();

        super.frigate.addShipCoordinates(3, 8, false);
        super.frigate.submitShip();

        super.frigate.addShipCoordinates(7, 0, false);
        super.frigate.submitShip();
    }

    private void setThirdPosition(){
        super.aircraft.addShipCoordinates(6, 4, true);
        super.aircraft.addShipCoordinates(6, 5, true);
        super.aircraft.addShipCoordinates(6, 6, true);
        super.aircraft.addShipCoordinates(6, 7, true);
        super.aircraft.submitShip();

        super.submarine.addShipCoordinates(9, 0, true);
        super.submarine.addShipCoordinates(9, 1, true);
        super.submarine.addShipCoordinates(9, 2, true);
        super.submarine.submitShip();

        super.submarine.addShipCoordinates(3, 7, true);
        super.submarine.addShipCoordinates(3, 8,true);
        super.submarine.addShipCoordinates(3, 9,true);
        super.submarine.submitShip();

        super.destroyer.addShipCoordinates(3, 1, false);
        super.destroyer.addShipCoordinates(4, 1,false);
        super.destroyer.submitShip();

        super.destroyer.addShipCoordinates(4, 4, true);
        super.destroyer.addShipCoordinates(4, 5, true);
        super.destroyer.submitShip();

        super.destroyer.addShipCoordinates(9, 7, true);
        super.destroyer.addShipCoordinates(9, 8, true);
        super.destroyer.submitShip();

        super.frigate.addShipCoordinates(1, 5, true);
        super.frigate.submitShip();

        super.frigate.addShipCoordinates(7, 9, false);
        super.frigate.submitShip();

        super.frigate.addShipCoordinates(6, 1, false);
        super.frigate.submitShip();

        super.frigate.addShipCoordinates(2, 1, false);
        super.frigate.submitShip();
    }

    public void createMatrix(){
        for(int i = 0; i < 10; i++){
            ArrayList<Character> row = new ArrayList<>();
            for(int j = 0; j < 10; j++){
                row.add(' ');
            }
            super.matrix.add(row);
        }
    }

    private void fillMatrix(){
        List<Ship> ships = Arrays.asList(super.aircraft, super.destroyer, super.frigate, super.submarine);

        for(Ship ship: ships) {
            for (LogicShip logicShip : ship.getLogicShips()) {
                for(Coordinate coordinate : logicShip.getShipCoordinates()){
                    super.matrix.get(coordinate.row).set(coordinate.column, ship.name);
                }
            }
        }
    }

    public ArrayList<ArrayList<Character>> getMatrix() {
        return super.matrix;
    }

    public void setCharacter(Character character, int row, int column){
        super.matrix.get(row).set(column, character);
    }

    public Coordinate trowBomb(){
        Random random = new Random();
        int row = random.nextInt(10);
        int column = random.nextInt(10);

        Coordinate coord = new Coordinate(row, column);

        return coord;
    }
}
