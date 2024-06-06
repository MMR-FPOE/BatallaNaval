package com.example.navalbattle.model;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Submarine extends Ship{
    public int amount = 2;

    public LogicShip logicShip;

    public Submarine(){
        super.name = 'S';
        super.length = 3;
        super.available = true;
        logicShip = new LogicShip(super.length);
    }

    public boolean shipStatus(){
        amount--;
        return (amount == 0);
    }

    public void submitShip(){
        gameShips.add(logicShip);
        logicShip = new LogicShip(super.length);
    }

    public void addShipCoordinates(int row, int column, boolean shipOrientation){
        logicShip.addShip(row,column, shipOrientation);
    }

    public Group drawShip(boolean rotate){
        Group submarineGroup = new Group();

        Path path = new Path();
        MoveTo moveto = new MoveTo(410, 50);
        ArcTo arc = new ArcTo();
        arc.setRadiusX(15);
        arc.setRadiusY(30);
        arc.setX(390);
        arc.setY(50);
        VLineTo l1 = new VLineTo(110);
        LineTo l3 = new LineTo(400, 150);
        LineTo l4 = new LineTo(410, 110);
        VLineTo l2 = new VLineTo(50);
        new ClosePath();

        Rectangle r1 = new Rectangle(410, 55, 7, 8);
        Rectangle r2 = new Rectangle(383, 55, 7, 8);
        Rectangle r3 = new Rectangle(395, 69, 10, 16);
        Rectangle r4 = new Rectangle(397.5, 73, 5, 8);
        r3.setFill(Color.DIMGRAY);
        r3.setStroke(Color.BLACK);
        r4.setFill(Color.DARKSLATEGRAY);
        r4.setStroke(Color.GRAY);

        Path aleta = new Path(
                new MoveTo(397, 137),
                new LineTo(395, 147),
                new HLineTo(405),
                new LineTo(403, 137),
                new HLineTo(397)
        );

        aleta.setFill(Color.BLACK);
        path.getElements().addAll(moveto, arc, l1, l3, l4, l2);
        path.setFill(Color.DARKGREY);
        path.setStroke(Color.BLACK);

        submarineGroup.getChildren().addAll(path, r1, r2, r3, r4, aleta);

        if(rotate)
            submarineGroup.setRotate(90);

        return submarineGroup;
    }

}
