package com.example.navalbattle.model;

import java.util.ArrayList;

public class PlayerBoard {
    public ArrayList<ArrayList<Character>> matrix = new ArrayList<>();;

    AircraftCarrier aircraft = new AircraftCarrier();
    Destroyer destroyer = new Destroyer();
    Frigate frigate = new Frigate();
    Submarine submarine = new Submarine();

    public PlayerBoard() {
        createMatrix();
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

    public void setCharacter(Character character, int row, int column){
        matrix.get(row).set(column, character);
    }

    public void getAircraftCarrier(){ return aircraft;}

    public void getDestroyer(){ return destroyer;}
    
    public void getFrigate(){ return frigate;}

    public void getSubmarine(){ return submarine; }
}
