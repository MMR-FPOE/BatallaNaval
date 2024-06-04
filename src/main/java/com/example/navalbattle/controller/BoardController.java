package com.example.navalbattle.controller;

import com.example.navalbattle.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.Objects;

public class BoardController {
    Ship ship;
    AircraftCarrier aircraft = new AircraftCarrier();
    Destroyer destroyer = new Destroyer();
    Frigate frigate = new Frigate();
    Submarine submarine = new Submarine();

    int shipLength = 1;
    int shipOrientation = 1;
    int gameReadyToStart = 0;

    ToggleButton button;

    BattleFieldPane battleFieldPane;
    ArrayList<ArrayList<BattleFieldPane>> battleFieldMatrix = new ArrayList<>();

    PlayerBoard playerBoard = new PlayerBoard();
    ComputerBoard computerBoard = new ComputerBoard();

    @FXML
    private Label playerNickname;

    @FXML
    private GridPane battleField;

    @FXML
    private Button shipOrientationButton;

    @FXML
    private Button startGameButton;

    @FXML
    private ToggleButton frigateButton;

    public void initialize() {
        ship = frigate;
        button = frigateButton;
        for (int i = 0; i < 10; i++) {
            ArrayList<BattleFieldPane> row = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                battleFieldPane = new BattleFieldPane(i, j);
                battleFieldPane.getPane().setOnMouseClicked(MouseEvent -> mouseEventClick(MouseEvent, "clicked"));
                battleFieldPane.getPane().setOnMouseEntered(MouseEvent -> mouseEventClick(MouseEvent, "entered"));
                battleFieldPane.getPane().setOnMouseExited(MouseEvent -> mouseEventClick(MouseEvent, "exited"));
                battleField.add(battleFieldPane.getPane(), j, i);
                row.add(battleFieldPane);
            }
            battleFieldMatrix.add(row);
        }
        computerBoard.showMatrix();
    }

    private void mouseEventClick(MouseEvent event, String type){
        Pane pane = (Pane) event.getSource();
        int row = GridPane.getRowIndex(pane);
        int column = GridPane.getColumnIndex(pane);
        int iter;

        if(shipOrientation == 1){ iter = column;}
        else{ iter = row;}
        if(iter + shipLength > 9){ iter = 10 - shipLength;}
        if(ship.getAvailability()){ type = "unavailable";}

        switch(type){
            case "clicked":
                ArrayList<BattleFieldPane> arrayList = new ArrayList<>();
                ArrayList<Coordinate> coordinates = new ArrayList<>();
                boolean isClickable = true;

                for(int i = iter; i < iter + shipLength; i++){
                    BattleFieldPane bPane;
                    Coordinate coordinate;
                    if(shipOrientation == 1){
                        bPane = battleFieldMatrix.get(row).get(i);
                        coordinate = new Coordinate(row,i);
                    }
                    else{
                        bPane = battleFieldMatrix.get(i).get(column);
                        coordinate = new Coordinate(i, column);
                    }

                    if(bPane.getIsClicked()){
                        isClickable = false;
                        break;}
                    arrayList.add(bPane);
                    coordinates.add(coordinate);}

                if(isClickable){
                    for (BattleFieldPane element : arrayList){
                        element.onPaneClicked();}

                    for (Coordinate coordinate: coordinates){
                        playerBoard.setCharacter(ship.name, coordinate.row, coordinate.column);
                    }

                    if (ship.shipStatus()){
                        button.setDisable(true);
                        ship.setAvailability();
                        gameReadyToStart++;}

                    if (gameReadyToStart == 4){startGameButton.setDisable(false);}
                }

            case "entered":
                for(int i = iter; i < iter + shipLength; i++){
                    BattleFieldPane bPane;
                    if(shipOrientation == 1){bPane = battleFieldMatrix.get(row).get(i);}
                    else{bPane = battleFieldMatrix.get(i).get(column);}
                    if(!bPane.getIsClicked())
                        bPane.onPaneEntered();}
                break;

            case "exited":
                for(int i = iter; i < iter + shipLength; i++){
                    BattleFieldPane bPane;
                    if(shipOrientation == 1){bPane = battleFieldMatrix.get(row).get(i);}
                    else{bPane = battleFieldMatrix.get(i).get(column);}
                    if(!bPane.getIsClicked())
                        bPane.onPaneExited();}
                break;

            case "unavailable":
                break;
        }
    }

    public void toggleButtonPressed(ActionEvent event){
        button = (ToggleButton) event.getSource();
        if(Objects.equals(button.getId(), "frigateButton")){
            ship = frigate;
        }
        else if(Objects.equals(button.getId(), "destroyerButton")){
            ship = destroyer;
        }
        else if(Objects.equals(button.getId(),"submarineButton")){
            ship = submarine;
        }
        else if(Objects.equals(button.getId(), "aircraftCarrierButton")){
            ship = aircraft;
        }
        shipLength = ship.getLength();
    }

    public void changeShipOrientation(ActionEvent event){
        shipOrientation *= -1;
        if(shipOrientation == -1){ shipOrientationButton.setText("\uD83E\uDC59");}
        else{shipOrientationButton.setText("\uD83E\uDC58");}
    }

    public void startGame(){
        playerBoard.showMatrix();
    }

    public void getPlayerNickname(String nickname){
        playerNickname.setText("Bienvenido: " + nickname);
    }
}
