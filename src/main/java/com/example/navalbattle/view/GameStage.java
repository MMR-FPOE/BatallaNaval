package com.example.navalbattle.view;

import com.example.navalbattle.controller.GameController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class GameStage extends Stage {

   // private GameController gameController;

    public GameStage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/navalbattle/game-view.fxml"));
        Parent root = loader.load();
     //   gameController = loader.getController();
        Scene scene = new Scene(root);
        setTitle("Naval Battle");
        getIcons().add(
                new Image(
                        String.valueOf(getClass().getResource("/com/example/navalbattle/images/favicon.png"))));
        setResizable(false);
        setScene(scene);
        show();
    }
    //public GameController getGameController(){return gameController;}

    //mejora del patrón Singlenton
    public static GameStage getInstance() throws IOException{
        return GameStageHolder.INSTANCE != null ?
                GameStageHolder.INSTANCE :
                (GameStageHolder.INSTANCE = new GameStage());
    }
    public static void deleteInstance(){
        GameStageHolder.INSTANCE.close();
        GameStageHolder.INSTANCE = null;
    }
    private static class GameStageHolder{
        private static GameStage INSTANCE;
    }

}
