package com.example.navalbattle.model;

import java.util.ArrayList;

public class PlayerBoard extends Board{
    public ArrayList<ArrayList<Character>> matrix = new ArrayList<>();;

    String playerNickName;
    AircraftCarrier aircraft = new AircraftCarrier();
    Destroyer destroyer = new Destroyer();
    Frigate frigate = new Frigate();
    Submarine submarine = new Submarine();

    public PlayerBoard() {
        createMatrix();
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

    public void showMatrix(){
        System.out.println("Player Matrix");
        for(ArrayList<Character> row: matrix){
            for(Character character: row){
                System.out.print(character + " ");
            }
            System.out.println(" ");
        }
    }

    public void setCharacter(Character character, int row, int column){
        matrix.get(row).set(column, character);
    }

    public ArrayList<ArrayList<Character>> getMatrix() {
        return matrix;
    }

    public void setPlayerNickName(String playerNickName) {
        if (playerNickName == null){
            playerNickName = "Player";
        }
        this.playerNickName = playerNickName;
    }

    public String getPlayerNickName() {
        return playerNickName;
    }
}
