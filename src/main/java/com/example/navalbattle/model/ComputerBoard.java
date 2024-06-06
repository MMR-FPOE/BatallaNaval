package com.example.navalbattle.model;

import java.util.*;

public class ComputerBoard extends Board{
    public ArrayList<ArrayList<Character>> matrix = new ArrayList<>();;

    public ArrayList<Coordinate> shotsFired = new ArrayList<>();
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
        aircraft.addShipCoordinates(0, 6, true);
        aircraft.addShipCoordinates(0, 7, true);
        aircraft.addShipCoordinates(0, 8, true);
        aircraft.addShipCoordinates(0, 9, true);
        aircraft.submitShip();
        
        submarine.addShipCoordinates(2, 2, false);
        submarine.addShipCoordinates(3, 2, false);
        submarine.addShipCoordinates(4, 2, false);
        submarine.submitShip();
        
        submarine.addShipCoordinates(4, 6, true);
        submarine.addShipCoordinates(4, 7, true);
        submarine.addShipCoordinates(4, 8, true);
        submarine.submitShip();
        
        destroyer.addShipCoordinates(8, 9,false );
        destroyer.addShipCoordinates(9, 9, false);
        destroyer.submitShip();
        
        destroyer.addShipCoordinates(6, 4, true);
        destroyer.addShipCoordinates(6, 5, true);
        destroyer.submitShip();

        destroyer.addShipCoordinates(4, 0, false);
        destroyer.addShipCoordinates(5, 0, false);
        destroyer.submitShip();

        frigate.addShipCoordinates(8, 1, false);
        frigate.submitShip();
        
        frigate.addShipCoordinates(8, 6, true);
        frigate.submitShip();
        
        frigate.addShipCoordinates(0, 3, false);
        frigate.submitShip();

        frigate.addShipCoordinates(2, 5, true);
        frigate.submitShip();

    }

    private void setSecondPosition(){
        aircraft.addShipCoordinates(4, 5, false);
        aircraft.addShipCoordinates(5, 5, false);
        aircraft.addShipCoordinates(6, 5, false);
        aircraft.addShipCoordinates(7, 5, false);
        aircraft.submitShip();

        submarine.addShipCoordinates(1, 6, true);
        submarine.addShipCoordinates(1, 7, true);
        submarine.addShipCoordinates(1, 8, true);
        submarine.submitShip();

        submarine.addShipCoordinates(4, 2, false);
        submarine.addShipCoordinates(5, 2, false);
        submarine.addShipCoordinates(6, 2, false);
        submarine.submitShip();

        destroyer.addShipCoordinates(2, 0, true);
        destroyer.addShipCoordinates(2, 1, true);
        destroyer.submitShip();

        destroyer.addShipCoordinates(1, 3, true);
        destroyer.addShipCoordinates(1, 4, true);
        destroyer.submitShip();

        destroyer.addShipCoordinates(6, 8,false);
        destroyer.addShipCoordinates(7, 8, false);
        destroyer.submitShip();

        frigate.addShipCoordinates(8, 8, true);
        frigate.submitShip();

        frigate.addShipCoordinates(0, 0, true);
        frigate.submitShip();

        frigate.addShipCoordinates(3, 8, false);
        frigate.submitShip();

        frigate.addShipCoordinates(7, 0, false);
        frigate.submitShip();
    }

    private void setThirdPosition(){
        aircraft.addShipCoordinates(6, 4, true);
        aircraft.addShipCoordinates(6, 5, true);
        aircraft.addShipCoordinates(6, 6, true);
        aircraft.addShipCoordinates(6, 7, true);
        aircraft.submitShip();

        submarine.addShipCoordinates(9, 0, true);
        submarine.addShipCoordinates(9, 1, true);
        submarine.addShipCoordinates(9, 2, true);
        submarine.submitShip();

        submarine.addShipCoordinates(3, 7, true);
        submarine.addShipCoordinates(3, 8,true);
        submarine.addShipCoordinates(3, 9,true);
        submarine.submitShip();

        destroyer.addShipCoordinates(3, 1, false);
        destroyer.addShipCoordinates(4, 1,false);
        destroyer.submitShip();

        destroyer.addShipCoordinates(4, 4, true);
        destroyer.addShipCoordinates(4, 5, true);
        destroyer.submitShip();

        destroyer.addShipCoordinates(9, 7, true);
        destroyer.addShipCoordinates(9, 8, true);
        destroyer.submitShip();

        frigate.addShipCoordinates(1, 5, true);
        frigate.submitShip();

        frigate.addShipCoordinates(7, 9, false);
        frigate.submitShip();

        frigate.addShipCoordinates(6, 1, false);
        frigate.submitShip();

        frigate.addShipCoordinates(2, 1, false);
        frigate.submitShip();
    }

    public void createMatrix(){
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
            for (LogicShip logicShip : ship.getLogicShips()) {
                for(Coordinate coordinate : logicShip.getShipCoordinates()){
                    matrix.get(coordinate.row).set(coordinate.column, ship.name);
                }
            }
        }
    }

    public void showMatrix(){
        System.out.println("Computer Matrix");
        for(ArrayList<Character> row: matrix){
            for(Character character: row){
                System.out.print(character + " ");
            }
            System.out.println(" ");
        }
    }

    public ArrayList<ArrayList<Character>> getMatrix() {
        return this.matrix;
    }

    public void setCharacter(Character character, int row, int column){
        matrix.get(row).set(column, character);
    }

    public Coordinate trowBomb(){

        Random random = new Random();
        int row = random.nextInt(10);
        int column = random.nextInt(10);

        Coordinate coord = new Coordinate(row, column);

        return coord;
    }
}
