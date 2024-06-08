package com.example.navalbattle.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class PlayerBoard extends Board implements Serializable {
    public ArrayList<Ship> allShips;

    public PlayerBoard() {
        super.aircraft = new AircraftCarrier();
        super.destroyer = new Destroyer();
        super.frigate = new Frigate();
        super.submarine = new Submarine();
        super.matrix = new ArrayList<>();
        createMatrix();

        allShips = new ArrayList<>(Arrays.asList(aircraft, destroyer, frigate, submarine));
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

    public void setCharacter(Character character, int row, int column){
        super.matrix.get(row).set(column, character);
    }

    public ArrayList<ArrayList<Character>> getMatrix() {
        return super.matrix;
    }

    public AircraftCarrier getAircraftCarrier(){ return super.aircraft;}

    public Destroyer getDestroyer(){ return super.destroyer;}

    public Frigate getFrigate(){ return super.frigate;}

    public Submarine getSubmarine(){ return super.submarine;}

    public ArrayList<Ship> getAllShips(){ return allShips; }

}
