package com.example.navalbattle.model;

import java.util.ArrayList;

public class Coordinate {

    int column;
    int row;

    public Coordinate(int row, int column){
        this.column = column;
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

  

}
