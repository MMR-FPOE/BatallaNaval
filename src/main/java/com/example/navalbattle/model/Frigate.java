package com.example.navalbattle.model;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Frigate extends Ship {

    private final String name = "Frigate";
    public int amount = 4;

    public Frigate(){
        super.length = 1;
        super.available = true;
    }

    public boolean shipStatus(){
        amount--;
        return (amount == 0);
    }

    public void drawFrigate(Stage stage){
        Pane root = new Pane();
        root.setPrefSize(800, 400);
        root.setStyle("""
                -fx-padding: 10;
            """);
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

        root.getChildren().addAll(path, r1, c1, white);
        Scene scene = new Scene(root);
        stage.setTitle("frigate");
        stage.setScene(scene);
        stage.show();
    }
}
