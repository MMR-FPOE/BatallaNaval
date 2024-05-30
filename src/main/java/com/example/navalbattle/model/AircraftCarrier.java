package com.example.navalbattle.model;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class AircraftCarrier extends Ship{
    private final String name = "Aircraft carrier";
    private int length = 4;
    public AircraftCarrier(){
    }

    public void drawAircraftCarrier(Stage stage){
        Pane root = new Pane();

        root.setPrefSize(800, 400);
        root.setStyle("""
                -fx-padding: 10;
            """);

        Polyline polyline = new Polyline();
        polyline.getPoints().addAll(
                400.0, 0.0,
                410.0, 0.0,
                420.0, 40.0,
                430.0, 50.0,
                430.0, 130.0,
                425.0, 135.0,
                385.0, 135.0,
                380.0, 130.0,
                380.0, 50.0,
                390.0, 40.0,
                400.0, 0.0
        );
        polyline.setStroke(Color.BLACK);
        polyline.setFill(Color.GRAY);

        Rectangle rectangle = new Rectangle(415, 78, 11, 30);
        rectangle.setFill(Color.DARKGRAY);
        Rectangle rectangle2 = new Rectangle(415, 60, 10, 10);
        Rectangle rectangle3 = new Rectangle(415, 115, 11, 12);
        rectangle3.setFill(Color.DARKSLATEGRAY);

        Line line6 = new Line (402, 10, 402, 130);
        line6.setStroke(Color.WHITE);
        Line line7 = new Line (390, 50, 390, 130);
        line7.setStroke(Color.WHITE);
        Line line8 = new Line (382, 70, 402, 70);
        line8.setStroke(Color.WHITE);
        Line line9 = new Line (382, 90, 402, 90);
        line9.setStroke(Color.WHITE);
        Line line10 = new Line (382, 110, 402, 110);
        line10.setStroke(Color.WHITE);
        Line line11 = new Line (382, 50, 402, 50);
        line11.setStroke(Color.WHITE);
        Line line12 = new Line (392.98, 30, 402, 30);
        line12.setStroke(Color.WHITE);
        Line line13 = new Line (399, 10, 402, 10);
        line13.setStroke(Color.WHITE);
        Line line14 = new Line (382, 130, 402, 130);
        line14.setStroke(Color.WHITE);

        root.getChildren().addAll(polyline, rectangle, rectangle2, rectangle3, line6, line7, line8, line9, line10, line11, line12, line13, line14);
        Scene scene = new Scene(root);
        stage.setTitle("Aircraft Carrier");
        stage.setScene(scene);
        stage.show();

    }

}
