package com.example.snakeladder;

import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SnakeLadder extends Application {
    Build_UI_UX buildUIUX = new Build_UI_UX();

    BorderPane createContent() {
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: Black;");

        root.setTop(buildUIUX.setBoard());
        root.setCenter(buildUIUX.setLabel());
        root.setLeft(buildUIUX.setPlayerOneButtons());
        root.setRight(buildUIUX.setPlayerTwoButton());
        root.setBottom(buildUIUX.setStartButton());
        
        return root;
    }

    @Override
    public void start(Stage stage) {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        Scene scene = new Scene(createContent(),500,600);
        scene.setCursor(Cursor.OPEN_HAND);
        stage.setTitle("Snake and Ladder!");
        stage.getIcons().addAll(new Image("C:\\Users\\krish_uv7qyqm\\IdeaProjects\\SnakeLadder\\src\\main\\SnakeLadder Logo.png"));
        stage.setScene(scene);
        stage.setAlwaysOnTop(true);
        stage.setMaxHeight(640);
        stage.setMinHeight(640);
        stage.setMaxWidth(516);
        stage.setMinWidth(516);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}
