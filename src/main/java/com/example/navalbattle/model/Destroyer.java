package com.example.navalbattle.model;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

import java.util.ArrayList;

public class Destroyer extends Ship{
    public int amount = 3;

    public LogicShip logicShip;

    public Destroyer(){
        super.name = 'D';
        super.length = 2;
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

    public void setShips(ArrayList<Coordinate> coordinates, boolean shipOrientation){
        logicShip.setShips(coordinates, shipOrientation);
        this.submitShip();
    }

    public Group drawShip(boolean rotate){
        Group destroyerGroup = new Group();

        Path path = new Path();
        MoveTo moveto = new MoveTo(12, 50);

        HLineTo l1 = new HLineTo(24);
        LineTo l2 = new LineTo(30, 60);
        LineTo l3 = new LineTo(30, 100);
        LineTo l4 = new LineTo(18,  120);
        LineTo l5 = new LineTo(6, 100);
        LineTo l6 = new LineTo(6, 60);
        LineTo l7 = new LineTo(12, 50);

        Rectangle r1 = new Rectangle(10, 82, 8, 10);
        r1.setFill(Color.DIMGRAY);

        Rectangle r2 = new Rectangle(10, 62, 12, 12);
        r2.setFill(Color.DARKSLATEGRAY);
        r2.setStroke(Color.BLACK);

        Rectangle r3 = new Rectangle(18, 75, 4, 4);

        Circle c1 = new Circle(18, 100, 3);
        c1.setFill(Color.WHITE);
        c1.setStroke(Color.BLACK);

        Path white = new Path(
                new MoveTo(10, 55),
                new HLineTo(26)
        );
        white.setStroke(Color.WHITE);

        Path white2 = new Path(
                new MoveTo(14, 50.5),
                new VLineTo(55)
        );
        white2.setStroke(Color.WHITE);

        Path white3 = new Path(
                new MoveTo(20, 50.5),
                new VLineTo(55)
        );
        white3.setStroke(Color.WHITE);

        path.getElements().addAll(moveto, l1, l2, l3, l4, l5, l6, l7);
        path.setFill(Color.LIGHTSLATEGRAY);
        destroyerGroup.getChildren().addAll(path, r1, r2, r3, c1, white, white2, white3);

        if(rotate)
            destroyerGroup.setRotate(90);

        return destroyerGroup;

    }
}
