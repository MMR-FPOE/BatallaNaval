package com.example.navalbattle.model;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Submarine extends Ship{

    private final String name = "Submarine";
    private int length = 3;

    public Submarine(){
    }

    public void drawSubmarine(Stage stage){

        Pane root = new Pane();
        root.setPrefSize(800, 400);
        root.setStyle("""
                -fx-padding: 10;
            """);
        Path path = new Path();

        MoveTo moveto = new MoveTo(410, 50);
        ArcTo arc = new ArcTo();
        arc.setRadiusX(8);
        arc.setRadiusY(30);
        arc.setX(390);
        arc.setY(49.99999999999999);
        VLineTo l1 = new VLineTo(110);
        LineTo l3 = new LineTo(400, 153);
        LineTo l4 = new LineTo(410, 110);
        VLineTo l2 = new VLineTo(50);
        new ClosePath();
        Rectangle r1 = new Rectangle(410, 46, 7, 8);
        Rectangle r2 = new Rectangle(383, 46, 7, 8);
        Rectangle r4 = new Rectangle(395, 69, 10, 15);
        r4.setFill(Color.DIMGRAY);
        r4.setStroke(Color.BLACK);
        Rectangle r5 = new Rectangle(397.5, 73, 5, 7.5);
        r5.setFill(Color.DARKSLATEGRAY);
        r5.setStroke(Color.GRAY);

        Path aleta = new Path(

                new MoveTo(407.4, 122),
                new LineTo(410, 130),
                new VLineTo(134),
                new HLineTo(404)
        );
        aleta.setFill(Color.BLACK);

        Path aleta2 = new Path(

                new MoveTo(393, 122),
                new LineTo(390.4, 130),
                new VLineTo(134),
                new HLineTo(396.4)

        );
        aleta2.setFill(Color.BLACK);

        Path aleta3 = new Path(
                new MoveTo(397, 139),
                new LineTo(395, 150),
                new HLineTo(405),
                new LineTo(403, 139),
                new HLineTo(397)
        );
        aleta3.setFill(Color.BLACK);
        path.getElements().addAll(moveto, arc, l1, l3, l4, l2);
        path.setFill(Color.DARKGREY);
        path.setStroke(Color.BLACK);

        root.getChildren().addAll(path, r1, r2,r4, r5, aleta, aleta2, aleta3);
        Scene scene = new Scene(root);
        stage.setTitle("Submarine");
        stage.setScene(scene);
        stage.show();
    }

}
