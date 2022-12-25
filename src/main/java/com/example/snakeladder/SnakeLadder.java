package com.example.snakeladder;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.IOException;

public class SnakeLadder extends Application {
    public static final int tileSize = 50, width = 10, height = 10;
    boolean firstPlayerTurn = false, secondPlayerTurn = false, startButton = true;
    Button startGameButton = new Button("Start Game");
    Button playerOneButton = new Button("Player One");
    Button playerTwoButton = new Button("Player Two");
    public int diceValue;
    Label rolledDiceValueLabel;
    Player firstPlayer = new Player(tileSize-10, Color.DEEPPINK, Color.GREENYELLOW, "Krishna");
    Player secondPlayer = new Player(tileSize-10, Color.DARKORANGE, Color.GREENYELLOW, " Devi");

    Pane createContent(){
        Pane root = new Pane();
        root.setPrefSize(tileSize*width, tileSize*height+100);
        root.setStyle("-fx-background-color: BLACK;");

        // create rectangles to move players
        for(int i = 0; i < width; i++){
            for(int j = 0; j < height; j++){
                Square square = new Square(tileSize);
                square.setTranslateX(i*tileSize);
                square.setTranslateY(j*tileSize);

                root.getChildren().add(square);
            }
        }

        // Set Board image
        Image image = new Image("C:\\Users\\krish_uv7qyqm\\IdeaProjects\\SnakeLadder\\src\\main\\Snake and Ladder.jpg");
        ImageView boardImage = new ImageView(image);
        boardImage.setImage(image);
        boardImage.setFitHeight(tileSize*height);
        boardImage.setFitWidth(tileSize*width);

        rolledDiceValueLabel = new Label("");
      //  rolledDiceValueLabel.setBackground(Background.fill(Color.WHITE));
//        rolledDiceValueLabel.setTextFill(Color.WHITE);
        rolledDiceValueLabel.setTranslateY(((tileSize*height+13)+(tileSize*height+13))/2);

        // Disable players buttons
        playerOneButton.setDisable(true);
        playerTwoButton.setDisable(true);

        // Start Button
        startGameButton.setTextFill(Color.WHITE);
        startGameButton.setStyle("-fx-background-color: GREEN;margin: 25px;");
        startGameButton.setFont(Font.font("Comic Sans MS", FontWeight.BOLD,13));
        startGameButton.setTranslateX((tileSize*width)/2-35);
        startGameButton.setTranslateY(tileSize*height +50);
        startGameButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(startButton){
                    firstPlayer.getCoinPosition();
                    secondPlayer.getCoinPosition();

                    rolledDiceValueLabel.setText("Game Started");
                    rolledDiceValueLabel.setTranslateX((tileSize*width)/2 - 35);
                    rolledDiceValueLabel.setTextFill(Color.WHITE);

                    startButton = false;
                    startGameButton.setDisable(true);
                    firstPlayerTurn = true;
                    playerOneButton.setDisable(false);

                    startGameButton.setText("Game Ongoing");
                    startGameButton.setTranslateX((tileSize*width)/2-45);

                }
            }
        });

        // Player One Button
        playerOneButton.setTextFill(Color.DEEPPINK);
        playerOneButton.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 13));
        playerOneButton.setTranslateX(tileSize);
        playerOneButton.setTranslateY(tileSize*height+13);
        playerOneButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(firstPlayerTurn){
                    setDiceValue("Player1", Color.DEEPPINK);
                    firstPlayer.movePlayer(diceValue);
                    playerOneButton.setDisable(true);
                    playerTwoButton.setDisable(false);

                    if(firstPlayer.playerWon() != null) {
                        rolledDiceValueLabel.setText(firstPlayer.playerWon());
                        rolledDiceValueLabel.setTextFill(Color.WHITE);
                        restartGame();
                    }
                    firstPlayerTurn = false;
                    secondPlayerTurn = true;
                }

            }
        });

        // Player Two Button
        playerTwoButton.setTextFill(Color.DARKORANGE);
        playerTwoButton.setFont(Font.font("Comic Sans MS",FontWeight.BOLD, 13));
        playerTwoButton.setTranslateX(tileSize*width-123);
        playerTwoButton.setTranslateY(tileSize*height+13);
        playerTwoButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(secondPlayerTurn){
                    setDiceValue("Player2", Color.DARKORANGE);
                    secondPlayer.movePlayer(diceValue);
                    playerTwoButton.setDisable(true);
                    playerOneButton.setDisable(false);

                    if(secondPlayer.playerWon() != null) {
                        rolledDiceValueLabel.setText(secondPlayer.playerWon());
                        rolledDiceValueLabel.setTextFill(Color.WHITE);
                        restartGame();
                    }
                    firstPlayerTurn = true;
                    secondPlayerTurn = false;
                }

            }
        });

        root.getChildren().addAll(boardImage, rolledDiceValueLabel, startGameButton,
                playerOneButton, playerTwoButton, firstPlayer.getCoin(),
                secondPlayer.getCoin());

        return root;
    }

    private void setDiceValue(String player, Color textColor){
        diceValue = (int) (Math.random()*6+1); // random() generates value between 0 and 1
        rolledDiceValueLabel.setText(player + " Dice Value : " + diceValue);

        rolledDiceValueLabel.setTranslateX((tileSize*width)/2 - 54);
        rolledDiceValueLabel.setTextFill(textColor);
    }

    public void restartGame(){

        rolledDiceValueLabel.setTranslateX(tileSize*width/2 - 60);
        rolledDiceValueLabel.setTranslateY(((tileSize*height+13)+(tileSize*height+13))/2);
        startGameButton.setDisable(false);
        startButton = true;
        startGameButton.setText("Restart Game");
        playerOneButton.setDisable(true);
        playerTwoButton.setDisable(true);

//        firstPlayer.getCoinPosition();
//        secondPlayer.getCoinPosition();

    }

    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(createContent());
        stage.setTitle("Snake and Ladder!");
        stage.getIcons().addAll(new Image("C:\\Users\\krish_uv7qyqm\\IdeaProjects\\SnakeLadder\\src\\main\\SnakeLadder Logo.png"));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}