package com.example.navalbattle.controller;

import com.example.navalbattle.model.*;
import com.example.navalbattle.view.BoardStage;
import com.example.navalbattle.view.GameStage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.VPos;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class BoardController {
    Ship ship;
    int shipLength = 1;
    boolean shipOrientation = true;
    int gameReadyToStart = 0;
    String nickname;

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
        ship = playerBoard.getFrigate();
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
    }

    private void mouseEventClick(MouseEvent event, String type){
        Pane pane = (Pane) event.getSource();
        int row = GridPane.getRowIndex(pane);
        int column = GridPane.getColumnIndex(pane);
        int iter;

        if(shipOrientation){ iter = column;}
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
                    if(shipOrientation) {
                        bPane = battleFieldMatrix.get(row).get(i);
                        coordinate = new Coordinate(row, i);
                    }else{
                        bPane = battleFieldMatrix.get(i).get(column);
                        coordinate = new Coordinate(i, column);
                    }
                  
                    if (i == iter){
                        ship.setFirstCoordinate(coordinate);
                    }

                    if(bPane.getIsClicked()){
                        isClickable = false;
                        break;}
                    arrayList.add(bPane);
                    coordinates.add(coordinate);}

                if(isClickable){
                    for (BattleFieldPane element : arrayList){
                        element.onPaneClicked();}

                    Node node = null;

                    if (ship instanceof AircraftCarrier){
                        node = ((AircraftCarrier) ship).drawShip(shipOrientation);
                        playerBoard.getAircraftCarrier().setShips(coordinates, shipOrientation);
                    }else if (ship instanceof Submarine) {
                        node = ((Submarine) ship).drawShip(shipOrientation);
                        playerBoard.getSubmarine().setShips(coordinates, shipOrientation);
                    } else if (ship instanceof Destroyer) {
                        node = ((Destroyer) ship).drawShip(shipOrientation);
                        playerBoard.getDestroyer().setShips(coordinates, shipOrientation);
                    } else if (ship instanceof Frigate) {
                        node = ((Frigate) ship).drawShip(shipOrientation);
                        playerBoard.getFrigate().setShips(coordinates, shipOrientation);
                    }



                    battleField.add(node, ship.getFirstCoordinate().getColumn(), ship.getFirstCoordinate().getRow());

                    GridPane.setHalignment(node, HPos.CENTER);
                    GridPane.setValignment(node, VPos.CENTER);

                    if (shipOrientation)
                        GridPane.setColumnSpan(node, shipLength);
                    else
                        GridPane.setRowSpan(node, shipLength);


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
                    if(shipOrientation){bPane = battleFieldMatrix.get(row).get(i);}
                    else{bPane = battleFieldMatrix.get(i).get(column);}
                    if(!bPane.getIsClicked())
                        bPane.onPaneEntered();}
                break;

            case "exited":
                for(int i = iter; i < iter + shipLength; i++){
                    BattleFieldPane bPane;
                    if(shipOrientation){bPane = battleFieldMatrix.get(row).get(i);}
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
            ship = playerBoard.getFrigate();
        }
        else if(Objects.equals(button.getId(), "destroyerButton")){
            ship = playerBoard.getDestroyer();
        }
        else if(Objects.equals(button.getId(),"submarineButton")){
            ship = playerBoard.getSubmarine();
        }
        else if(Objects.equals(button.getId(), "aircraftCarrierButton")){
            ship = playerBoard.getAircraftCarrier();
        }
        shipLength = ship.getLength();
    }

    public void changeShipOrientation(ActionEvent event){
        shipOrientation = !shipOrientation;
        if(shipOrientation){ shipOrientationButton.setText("\uD83E\uDC58");}
        else{shipOrientationButton.setText("\uD83E\uDC59");}
    }

    public void startGame() throws IOException {
        GameController controller = GameStage.getInstance().getGameController();
        controller.initialize(playerBoard, nickname);
        controller.setComputerBoard(computerBoard);
        BoardStage.deleteInstance();
    }

    public void getPlayerNickname(String nickname){
        this.nickname = nickname;
        playerNickname.setText("Bienvenido: " + nickname);
    }

}
