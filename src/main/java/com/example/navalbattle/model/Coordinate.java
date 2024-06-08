package com.example.navalbattle.model;

import java.io.Serializable;

public class Coordinate implements Serializable {
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