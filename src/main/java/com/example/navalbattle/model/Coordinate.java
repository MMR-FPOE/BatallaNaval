package com.example.navalbattle.model;

public class Coordinate{
    public int column;
    public int row;

    public Coordinate(int row, int column){
        this.column = column;
        this.row = row;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}