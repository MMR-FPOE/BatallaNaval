package com.example.navalbattle;

import com.example.navalbattle.controller.GameController;
import com.example.navalbattle.model.BoardException;
import com.example.navalbattle.view.GameStage;
import com.example.navalbattle.view.WelcomeStage;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args){launch(args);}

    @Override
    public void start(Stage primaryStage) throws IOException{
        try{
            FileInputStream fileIn = new FileInputStream("board.naval");
            GameController controller = GameStage.getInstance().getGameController();
            controller.deserialize();
            throw new BoardException("Exception");
        } catch (FileNotFoundException | BoardException e) {
            e.getCause();
        } finally {
            try{
            GameStage.deleteInstance();
            } catch (NullPointerException e){
                e.getCause();
            }
            WelcomeStage.getInstance();
        }
    }
}
