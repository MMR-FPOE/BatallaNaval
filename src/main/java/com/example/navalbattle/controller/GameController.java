package com.example.navalbattle.controller;

import com.example.navalbattle.model.*;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
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
    private SplitPane splitPane;

    PlayerBoard playerBoard;
    ComputerBoard computerBoard;

    String nickname;

    ArrayList<ArrayList<BattleFieldPane>>  playerFieldMatrix = new ArrayList<>();
    ArrayList<ArrayList<BattleFieldPane>>  computerFieldMatrix = new ArrayList<>();

    @FXML
    BattleFieldPane battleFieldPane;


    private boolean isPlayerTurn = true;
    private boolean isComputerTurn = false;

    public void initialize() {
        createBattleFields(playerBattleField, playerFieldMatrix);
        createBattleFields(computerBattleField, computerFieldMatrix);

        for (ArrayList<BattleFieldPane> row : playerFieldMatrix) {
            for (BattleFieldPane pane : row) {
                pane.getPane().setDisable(true);
            }
        }
        updatePaneState();
        turnLabel.setText("turno de " + nickname);
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
            setTurn(row, column, pane, computerBoard);
            PauseTransition pause = new PauseTransition(Duration.seconds(2));
            pause.setOnFinished(event -> {
                Computerturn();
            });
            pause.play();

        }
    }

    public void Computerturn(){
        Coordinate shot = computerBoard.trowBomb();
        Pane computerPane = playerFieldMatrix.get(shot.row).get(shot.column).getPane();
        setTurn(shot.getRow(), shot.getColumn(), computerPane, playerBoard);
    }

    public void setTurn(int row, int column, Pane pane, Board board){
        if (board.getMatrix().get(row).get(column) == ' ') {
            setImage("splash", pane);
            board.setCharacter('0',row, column);
            board.showMatrix();
            switchTurn();
            updatePaneState();
        }else{
            setImage("bomb", pane);
            board.setCharacter('X',row, column);
            board.showMatrix();
            switchTurn();
            updatePaneState();
        }

    }

    public void setImage(String indentifier, Pane pane){

        ImageView image = new ImageView(new javafx.scene.image.Image(String.valueOf(getClass().getResource("/com/example/navalbattle/images/" + indentifier + ".png"))));
        image.setFitWidth(pane.getWidth());
        image.setFitHeight(pane.getHeight());
        pane.getChildren().add(image);
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
            turnLabel.setText("turno de " + nickname);
        }else{
            turnLabel.setText("turno de computer");
        }
    }


    public void checkMatrix(){}

    public void turn(){}

    public void setPlayerNickname(String playerNickname) {
        if (nickname == null){
            this.nickname = "Player";
        }
        nickname = playerNickname;
        this.playerNickname.setText(nickname);
    }

    public void setPlayerBoard(PlayerBoard playerBoard) {
        this.playerBoard = playerBoard;

    }
    public void setComputerBoard(ComputerBoard computerBoard){
        this.computerBoard = computerBoard;
    }
}
