package com.example.navalbattle.view;

import com.example.navalbattle.controller.BoardController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class BoardStage extends Stage {
    private BoardController boardController;

    public BoardStage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/navalbattle/board-view.fxml"));
        Parent root = loader.load();
        boardController = loader.getController();
        Scene scene = new Scene(root);
        setTitle("Naval Board");
        getIcons().add(
                new Image(
                        String.valueOf(getClass().getResource("/com/example/navalbattle/images/favicon.png"))));
        setResizable(false);
        setScene(scene);
        show();
    }

    public BoardController getBoardController(){return boardController;}

    public static BoardStage getInstance() throws IOException{
        return BoardStageHolder.INSTANCE != null ? BoardStageHolder.INSTANCE : (BoardStageHolder.INSTANCE = new BoardStage());
    }
    public static void deleteInstance(){
        BoardStageHolder.INSTANCE.close();
        BoardStageHolder.INSTANCE = null;
    }
    private static class BoardStageHolder{
        private static BoardStage INSTANCE;
    }
}
