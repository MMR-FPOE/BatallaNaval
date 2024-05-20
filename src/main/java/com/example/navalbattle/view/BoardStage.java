package com.example.navalbattle.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class BoardStage extends Stage {

    // private BoardController boardController;

    public BoardStage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/navalbattle/game-view.fxml"));
        Parent root = loader.load();
        //   boardController = loader.getController();
        Scene scene = new Scene(root);
        setTitle("Naval Board");
        getIcons().add(
                new Image(
                        String.valueOf(getClass().getResource("/com/example/navalbattle/images/favicon.png"))));
        setResizable(false);
        setScene(scene);
        show();
    }
    //public BoardController getGameController(){return boardController;}

    //mejora del patrón Singlenton
    public static BoardStage getInstance() throws IOException{
        return BoardStage.BoardStageHolder.INSTANCE != null ?
                BoardStage.BoardStageHolder.INSTANCE :
                (BoardStage.BoardStageHolder.INSTANCE = new BoardStage());
    }
    public static void deleteInstance(){
        BoardStageHolder.INSTANCE.close();
        BoardStageHolder.INSTANCE = null;
    }
    private static class BoardStageHolder{
        private static BoardStage INSTANCE;
    }
}
