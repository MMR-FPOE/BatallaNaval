package com.example.navalbattle.model;

import javafx.scene.layout.Pane;

public class BattleFieldPane {
    Pane pane;
    int row, column;
    boolean isClicked = false;

    public BattleFieldPane(int i, int j){
        row = i;
        column = j;

        pane = new Pane();
        pane.setPrefSize(40,40);
    }

    public void onPaneEntered(){
        { pane.setStyle("-fx-background-color: red");}
    }

    public void onPaneExited(){
        if(!isClicked){ pane.setStyle("");}
    }

    public void onPaneClicked(){
        pane.setStyle("-fx-background-color: orange");
        isClicked = true;
    }

    public Pane getPane(){
        return pane;
    }

    public void setIsClicked(){
        isClicked = true;
    }

    public boolean getIsClicked(){
        return isClicked;
    }

    public int getRow(){
        return row;
    }

    public int getColumn(){
        return column;
    }
}
