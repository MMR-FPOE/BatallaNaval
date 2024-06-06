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
        { pane.setStyle("-fx-background-color: #00000055");}
    }

    public void onPaneExited(){
        if(!isClicked){ pane.setStyle("");}
    }

    public void onPaneClicked(){
        pane.setStyle("-fx-background-color: #00000055");
        isClicked = true;
    }
    public Pane getPane(){
        return pane;
    }

    public boolean getIsClicked(){
        return isClicked;
    }

}
