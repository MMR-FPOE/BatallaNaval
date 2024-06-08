package com.example.navalbattle.model;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

import java.io.Serializable;
import java.util.ArrayList;

public class Frigate extends Ship implements Serializable {
    public int amount = 4;

    public LogicShip logicShip;

    public Frigate(){
        super.name = 'F';
        super.length = 1;
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
        Group frigateGroup = new Group();

        Path path = new Path();

        MoveTo moveto = new MoveTo(412, 50);

        HLineTo l1 = new HLineTo(424);
        VLineTo l2 = new VLineTo(66);
        LineTo l3 = new LineTo(418, 76);
        LineTo l4 = new LineTo(412, 65);
        VLineTo l5 = new VLineTo(50);

        Rectangle r1 = new Rectangle(416, 55, 4, 6 );
        r1.setStroke(Color.WHITE);
        Circle c1 = new Circle(418, 66, 1);
        c1.setFill(Color.WHITE);
        c1.setStroke(Color.BLACK);

        Path white = new Path(
                new MoveTo(413.5, 52),
                new HLineTo(422.5)
        );
        white.setStroke(Color.WHITE);

        path.getElements().addAll(moveto, l1, l2, l3, l4, l5);
        path.setFill(Color.LIGHTSLATEGRAY);
        frigateGroup.getChildren().addAll(path, r1, c1, white);

        if(rotate)
            frigateGroup.setRotate(90);

        return frigateGroup;
    }
}
