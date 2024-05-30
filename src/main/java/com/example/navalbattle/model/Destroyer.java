package com.example.navalbattle.model;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class Destroyer extends Ship{
    private final String name = "Destroyer";
    private int length = 2;
    public Destroyer(){
    }

    public void drawFrigate(Stage stage){
        Pane root = new Pane();
        root.setPrefSize(800, 400);
        root.setStyle("""
                -fx-padding: 10;
            """);
        Path path = new Path();

        MoveTo moveto = new MoveTo(412, 50);

        HLineTo l1 = new HLineTo(420);
        LineTo l2 = new LineTo(422.5, 60);
        LineTo l3 = new LineTo(423, 90);
        LineTo l4 = new LineTo(417,  100);
        LineTo l5 = new LineTo(410, 90);
        LineTo l6 = new LineTo(410, 60);
        LineTo l7 = new LineTo(412, 50);
        Rectangle r1 = new Rectangle(413, 71.5, 5, 7.5);
        r1.setFill(Color.DIMGRAY);

        Rectangle r2 = new Rectangle(414.5, 62, 4, 4);
        r2.setFill(Color.DARKSLATEGRAY);
        r2.setStroke(Color.BLACK);
        Rectangle r3 = new Rectangle(418, 71.5, 3, 3);
        Circle c1 = new Circle(416.5, 86, 1.5);
        c1.setFill(Color.WHITE);
        c1.setStroke(Color.BLACK);

        Path white = new Path(
                new MoveTo(412, 55),
                new HLineTo(420)
        );
        white.setStroke(Color.WHITE);

        Path white2 = new Path(
                new MoveTo(414, 50.5),
                new VLineTo(55)
        );
        white2.setStroke(Color.WHITE);

        Path white3 = new Path(
                new MoveTo(418, 50.5),
                new VLineTo(55)
        );
        white3.setStroke(Color.WHITE);

        path.getElements().addAll(moveto, l1, l2, l3, l4, l5, l6, l7);
        path.setFill(Color.LIGHTSLATEGRAY);
        root.getChildren().addAll(path, r1, r2, r3, c1, white, white2, white3);
        Scene scene = new Scene(root);
        stage.setTitle("Destroyer");
        stage.setScene(scene);
        stage.show();
    }


}
