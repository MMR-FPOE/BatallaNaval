package com.example.navalbattle.model;

import java.util.ArrayList;
import java.util.Arrays;

public class Board {
    public ArrayList<ArrayList<Character>> matrix = new ArrayList<>();
    AircraftCarrier aircraft;
    Destroyer destroyer;
    Frigate frigate;
    Submarine submarine;

    public Board() {}

    public void createMatrix(){
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

    public ArrayList<ArrayList<Character>> getMatrix() {
        return matrix;
    }

    public AircraftCarrier getAircraftCarrier(){ return aircraft;}

    public Destroyer getDestroyer(){ return destroyer;}

    public Frigate getFrigate(){ return frigate;}

    public Submarine getSubmarine(){ return submarine;}
}
