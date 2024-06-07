package com.example.navalbattle.controller;

import com.example.navalbattle.model.*;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import java.util.ArrayList;


public class GameController {
    @FXML
    private Label playerNickname;

    @FXML
    private GridPane playerBattleField;

    @FXML
    private GridPane computerBattleField;

    @FXML
    private Label turnLabel;

    @FXML
    BattleFieldPane battleFieldPane;

    PlayerBoard playerBoard;
    ComputerBoard computerBoard;

    ArrayList<ArrayList<BattleFieldPane>>  playerFieldMatrix = new ArrayList<>();
    ArrayList<ArrayList<BattleFieldPane>>  computerFieldMatrix = new ArrayList<>();



    ImageView image;
    private boolean isPlayerTurn = true;
    private boolean isComputerTurn = false;

    public void initialize(PlayerBoard playerBoard, String nickname) {
        this.playerBoard = playerBoard;
        playerNickname.setText(nickname);

        drawShips();
        createBattleFields(playerBattleField, playerFieldMatrix);
        createBattleFields(computerBattleField, computerFieldMatrix);

        for (ArrayList<BattleFieldPane> row : playerFieldMatrix) {
            for (BattleFieldPane pane : row) {
                pane.getPane().setDisable(true);
            }
        }

        updatePaneState();
        turnLabel.setText("Tu turno");
    }

    public void drawShips(){
        Coordinate coordinate;
        for(Ship ship: playerBoard.getAllShips()){
            Node node = null;
            for(LogicShip logicShip: ship.getLogicShips()){
                coordinate = logicShip.getFirstCoordinate();
                if (ship instanceof AircraftCarrier){
                    node = ((AircraftCarrier) ship).drawShip(logicShip.getShipOrientation());
                }else if (ship instanceof Submarine) {
                    node = ((Submarine) ship).drawShip(logicShip.getShipOrientation());
                } else if (ship instanceof Destroyer) {
                    node = ((Destroyer) ship).drawShip(logicShip.getShipOrientation());
                } else if (ship instanceof Frigate) {
                    node = ((Frigate) ship).drawShip(logicShip.getShipOrientation());
                }

                playerBattleField.add(node, coordinate.getColumn(), coordinate.getRow());

                GridPane.setHalignment(node, HPos.CENTER);
                GridPane.setValignment(node, VPos.CENTER);

                if (logicShip.getShipOrientation())
                    GridPane.setColumnSpan(node, ship.length);
                else
                    GridPane.setRowSpan(node, ship.length);
            }
        }

    }


    public void createBattleFields(GridPane BattleField, ArrayList<ArrayList<BattleFieldPane>>  BattleFieldMatrix ) {
        for (int i = 0; i < 10; i++) {
            ArrayList<BattleFieldPane> row = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                battleFieldPane = new BattleFieldPane(i, j);
                battleFieldPane.getPane().setOnMouseClicked(MouseEvent -> MouseEventClick(MouseEvent, "clicked"));
                BattleField.add(battleFieldPane.getPane(), j, i);
                row.add(battleFieldPane);
            }
            BattleFieldMatrix.add(row);
        }
    }

    private void MouseEventClick(MouseEvent mouseEvent, String type) {
        Pane pane = (Pane) mouseEvent.getSource();
        int row = GridPane.getRowIndex(pane);
        int column = GridPane.getColumnIndex(pane);

        if (type.equals("clicked") && isPlayerTurn) {
            if(computerBoard.getMatrix().get(row).get(column) != '0'){
                setTurn(row, column, pane, computerBoard);
                PauseTransition pause = new PauseTransition(Duration.seconds(2));
                pause.setOnFinished(event -> {
                    computerTurn();
                });
                pause.play();
            }
        }
    }

    public void computerTurn(){
        Coordinate shot = computerBoard.trowBomb();
        Pane computerPane = playerFieldMatrix.get(shot.row).get(shot.column).getPane();
        if(playerBoard.getMatrix().get(shot.row).get(shot.column) == '0'){
            computerTurn();
        } else {
            setTurn(shot.getRow(), shot.getColumn(), computerPane, playerBoard);
        }
    }

    public void setTurn(int row, int column, Pane pane, Board board){
        if (board.getMatrix().get(row).get(column) != '0'){
            if (board.getMatrix().get(row).get(column) == ' ') {
                image = setImage("splash");
                pane.getChildren().add(image);
            }else{
                image = setImage("bomb");
                pane.getChildren().add(image);
                Character name = board.getMatrix().get(row).get(column);
                ArrayList<LogicShip> allShips;

                switch (name){
                    case 'A':
                        allShips = board.getAircraftCarrier().getLogicShips();
                        break;
                    case 'D':
                        allShips = board.getDestroyer().getLogicShips();
                        break;
                    case 'F':
                        allShips = board.getFrigate().getLogicShips();
                        break;
                    default:
                        allShips = board.getSubmarine().getLogicShips();
                        break;
                    }

                for (LogicShip logicShip: allShips){
                    for (Coordinate coordinate: logicShip.getShipCoordinates()){
                        if(row == coordinate.row && column == coordinate.column){
                            logicShip.lostALife();
                            if(logicShip.isDied()){
                                shipIsDied(logicShip, pane);
                                // Here will be whole win or lose code
                            }
                        }
                    }
                }

            }
            board.setCharacter('0',row, column);
            switchTurn();
            updatePaneState();
        }
    }

    public ImageView setImage(String indentifier){
        ImageView image = new ImageView(new javafx.scene.image.Image(String.valueOf(getClass().getResource("/com/example/navalbattle/images/" + indentifier + ".png"))));
        image.setFitWidth(40);
        image.setFitHeight(40);
        return image;
    }

    private void shipIsDied(LogicShip logicShip, Pane pane){
        GridPane gridPane = (GridPane) pane.getParent();
        for(Coordinate coordinate: logicShip.getShipCoordinates()){
            image = setImage("detonation");
            gridPane.add(image, coordinate.column, coordinate.row);
        }
    }

    private void updatePaneState() {

        for (ArrayList<BattleFieldPane> row : computerFieldMatrix) {
            for (BattleFieldPane pane : row) {
                pane.getPane().setDisable(isComputerTurn);
            }
        }
    }

    private void switchTurn() {
        isPlayerTurn = !isPlayerTurn;
        isComputerTurn = !isComputerTurn;
        updatePaneState();

        if (isPlayerTurn){
            turnLabel.setText("Tu turno");
        }else{
            turnLabel.setText("turno de Machine");
        }
    }

    public void checkMatrix(){}

    public void turn(){}

    public void setComputerBoard(ComputerBoard computerBoard){
        this.computerBoard = computerBoard;
    }
}
