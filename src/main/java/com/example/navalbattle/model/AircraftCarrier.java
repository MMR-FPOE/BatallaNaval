package com.example.navalbattle.model;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class AircraftCarrier extends Ship{
    public int amount = 1;

    public LogicShip logicShip;

    public AircraftCarrier(){
        super.name = 'A';
        super.length = 4;
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
        Group aircraftGroup = new Group();

        Polyline polyline = new Polyline();
        polyline.getPoints().addAll(
                15.0, 0.0,
                25.0, 0.0,
                30.0, 40.0,
                35.0, 50.0,
                35.0, 140.0,
                32.5, 145.0,
                7.5, 145.0,
                5.0, 140.0,
                5.0, 50.0,
                10.0, 40.0,
                15.0, 0.0
        );
        polyline.setStroke(Color.BLACK);
        polyline.setFill(Color.GRAY);

        Rectangle rectangle3 = new Rectangle(25, 105, 5, 12);
        rectangle3.setFill(Color.DARKSLATEGRAY);
        Rectangle rectangle = new Rectangle(25, 68, 5, 30);
        rectangle.setFill(Color.DARKGRAY);
        Rectangle rectangle2 = new Rectangle(25, 50, 5, 10);

        Line line6 = new Line (20, 1, 20, 144);
        line6.setStroke(Color.WHITE);
        Line line7 = new Line (10, 50, 10, 144);
        line7.setStroke(Color.WHITE);
        Line line8 = new Line (6, 50, 20, 50);
        line8.setStroke(Color.WHITE);
        Line line9 = new Line (6, 70, 20, 70);
        line9.setStroke(Color.WHITE);
        Line line10 = new Line (6, 90, 20, 90);
        line10.setStroke(Color.WHITE);
        Line line11 = new Line (6, 110, 20, 110);
        line11.setStroke(Color.WHITE);
        Line line12 = new Line (6, 130, 20, 130);
        line12.setStroke(Color.WHITE);

        aircraftGroup.getChildren().addAll(polyline, rectangle, rectangle2, rectangle3, line6, line7, line8, line9, line10, line11, line12);

        if(rotate)
            aircraftGroup.setRotate(90);

        return aircraftGroup;
    }

}
