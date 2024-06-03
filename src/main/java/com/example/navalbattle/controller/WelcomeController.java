package com.example.navalbattle.controller;

import com.example.navalbattle.view.BoardStage;
import com.example.navalbattle.view.WelcomeStage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.Objects;

public class WelcomeController {
    @FXML
    private TextField playerName;

    /**
     * Method associated with a Button that start BoardStage
     *
     * @param event         Event called when we push the button
     */

    @FXML
    void startGame(ActionEvent event) throws IOException {
        String getNickname = playerName.getText();
        if(Objects.equals(getNickname, "")){
            getNickname = "Player";
        }
        BoardController controller = BoardStage.getInstance().getBoardController();
        controller.getPlayerNickname(getNickname);
        WelcomeStage.deleteInstance();
    }
}
