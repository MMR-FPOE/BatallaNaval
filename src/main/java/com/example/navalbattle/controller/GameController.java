package com.example.navalbattle.controller;

import com.example.navalbattle.model.*;
import com.example.navalbattle.view.alert.AlertBox;
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

import java.io.*;
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

    int playerNumOfShips = 10;
    int machineNumOfShips = 10;
    ImageView image;
    private boolean isPlayerTurn = true;
    private boolean isComputerTurn = false;

    /**
     * Start controller class
     *
     * @param playerBoard         player's board
     */
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

    /**
     * Method that draw the ships on the gridPane
     */
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

    /**
     * Method associated with a Button selecting the type of boat
     *
     * @param BattleField        Gridpane of the player
     * @param BattleFieldMatrix  Matrix of battlefield pane's
     */
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

    /**
     * Method associated with each pane in the gridPane
     * @param type                  Click type
     */
    private void MouseEventClick(MouseEvent mouseEvent, String type) {
        Pane pane = (Pane) mouseEvent.getSource();
        int row = GridPane.getRowIndex(pane);
        int column = GridPane.getColumnIndex(pane);

        if (type.equals("clicked") && isPlayerTurn) {
            if(computerBoard.getMatrix().get(row).get(column) != '0'){
                setTurn(row, column, pane, computerBoard);
                PauseTransition pause = new PauseTransition(Duration.seconds(1.5));
                pause.setOnFinished(event -> {
                    computerTurn();
                });
                pause.play();
            }
        }
    }

    /**
     * Method that executes the machine's turn
     */
    public void computerTurn(){
        Coordinate shot = computerBoard.trowBomb();
        Pane computerPane = playerFieldMatrix.get(shot.row).get(shot.column).getPane();
        if(playerBoard.getMatrix().get(shot.row).get(shot.column) == '0'){
            computerTurn();
        } else {
            setTurn(shot.getRow(), shot.getColumn(), computerPane, playerBoard);
        }
    }

    /**
     * Method executes each turn
     * @param row                  shooting row
     * @param column                shooting column
     */
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

                                if (isPlayerTurn){
                                    machineNumOfShips--;
                                    if (machineNumOfShips == 0){
                                        new AlertBox().WinOrLose("Ganaste " + playerNickname.getText(), "El juego terminó", "¡Derrotaste a la máquina!");
                                    }
                                }else{
                                    playerNumOfShips--;
                                    if (playerNumOfShips == 0){
                                        new AlertBox().WinOrLose("Perdiste " + playerNickname.getText(), "El juego terminó", "La máquina gana!");
                                    }
                                }

                            }
                        }
                    }
                }

            }
            board.setCharacter('0',row, column);
            switchTurn();
            updatePaneState();
            serialize(board);
        }
    }

    /**
     * Method that set the image according to the identifier
     * @param indentifier     image identifier
     * @return                imageView object
     */
    public ImageView setImage(String indentifier){
        ImageView image = new ImageView(new javafx.scene.image.Image(String.valueOf(getClass().getResource("/com/example/navalbattle/images/" + indentifier + ".png"))));
        image.setFitWidth(40);
        image.setFitHeight(40);
        return image;
    }

    /**
     * Method that set the image according to the identifier
     * @param logicShip         coordinates of each board
     * @param pane              pane to distinguish the grid
     */
    private void shipIsDied(LogicShip logicShip, Pane pane){
        GridPane gridPane = (GridPane) pane.getParent();
        for(Coordinate coordinate: logicShip.getShipCoordinates()){
            image = setImage("detonation");
            gridPane.add(image, coordinate.column, coordinate.row);
        }
    }

    /**
     * Method that disables the pane depending on machine's turn
     */
    private void updatePaneState() {

        for (ArrayList<BattleFieldPane> row : computerFieldMatrix) {
            for (BattleFieldPane pane : row) {
                pane.getPane().setDisable(isComputerTurn);
            }
        }
    }

    /**
     * Method that switch turn and updates the pane
     */
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

    /**
     * Method that switch turn and updates the pane
     */
    public void setComputerBoard(ComputerBoard computerBoard){
        this.computerBoard = computerBoard;
    }

    /**
     * Method that deserialize
     * @param board             player's board or machine's board
     */
    public void serialize(Board board){
        try (FileOutputStream fileout = new FileOutputStream("board.naval")) {
            ObjectOutputStream out = new ObjectOutputStream(fileout);
            out.writeObject(board);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Method that deserialize
     */
    public void deserialize(){
        try (FileInputStream fileIn = new FileInputStream("board.naval");
             ObjectInputStream in = new ObjectInputStream(fileIn)){
             Board board = (Board) in.readObject();
             System.out.println(board.getMatrix());

        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
