package com.example.snakeladder;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;


public class Build_UI_UX {
    public  final int tileSize = 50, width = 10, height = 10;
    boolean firstPlayerTurn = false, secondPlayerTurn = false, startButton = true;
    public int diceValue;
    private Label label;
    private Button playerOneButton;
    private Button playerTwoButton;
    private Button startGameButton;
    Player firstPlayer = new Player(40, Color.DEEPPINK, Color.GREENYELLOW, "Krishna");
    Player secondPlayer = new Player(40, Color.DARKORANGE, Color.GREENYELLOW, "Devi");
    public Build_UI_UX() {

    }
    Label setLabel() {         // Set Label position to Display output
        label = new Label();
        label.setTranslateY(-10);
        label.setFont(new Font("Times New Roman", 14));
        label.setAlignment(Pos.CENTER);
        label.setTextAlignment(TextAlignment.CENTER);
        label.setWrapText(true);

        return label;
    }

    Pane setBoard() {         // Return pane to add to the top of the root (BorderPane)
        Pane pane = new Pane();
        pane.setPrefSize(500.0,500.0);

        for(int i = 0; i < width; i++) {
            for(int j = 0; j < height; j++) {
                Square square = new Square(tileSize);
                square.setTranslateX(i* tileSize);
                square.setTranslateY(j* tileSize);
                pane.getChildren().add(square);
            }
        }
        pane.getChildren().addAll(setImage(), firstPlayerCoin(), secondPlayerCoin());

        return pane;
    }


    ImageView setImage() {        // Set Board Image
        Image image = new Image("C:\\Users\\krish_uv7qyqm\\IdeaProjects\\SnakeLadder\\src\\main\\Snake and Ladder.jpg");
        ImageView boardImage = new ImageView(image);
        boardImage.setImage(image);
        boardImage.setFitHeight(tileSize*height);
        boardImage.setFitWidth(tileSize*width);

        return  boardImage;
    }

     Button setPlayerOneButtons() {   // First Player Button
         playerOneButton = new Button("Krishna");
         playerOneButton.setPrefWidth(90);
         playerOneButton.setDisable(true);
         playerOneButton.setTranslateX(40);
         playerOneButton.setTranslateY(15);
         playerOneButton.setTextFill(Color.DEEPPINK);
         playerOneButton.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 12));

         playerOneButton.setOnAction(actionEvent -> {
             if(firstPlayerTurn){
                 setDiceValue("Krishna's", Color.DEEPPINK);
                 firstPlayer.movePlayer(diceValue);
                 playerOneButton.setDisable(true);
                 playerTwoButton.setDisable(false);

                 if(firstPlayer.playerWon() != null) {
                     setDisplayText(firstPlayer.playerWon(), Color.DEEPPINK);
                     restartGame();
                 }
                 firstPlayerTurn = false;
                 secondPlayerTurn = true;
             }

         });

         return playerOneButton;
     }

    Button setPlayerTwoButton() {    // Second Player Button
        playerTwoButton = new Button("Devi");
        playerTwoButton.setPrefWidth(90);
        playerTwoButton.setDisable(true);
        playerTwoButton.setTranslateX(-40);
        playerTwoButton.setTranslateY(15);
        playerTwoButton.setTextFill(Color.DARKORANGE);
        playerTwoButton.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 12));

        playerTwoButton.setOnAction(actionEvent -> {
            if(secondPlayerTurn){
                setDiceValue("Devi's", Color.DARKORANGE);
                secondPlayer.movePlayer(diceValue);
                playerTwoButton.setDisable(true);
                playerOneButton.setDisable(false);

                if(secondPlayer.playerWon() != null) {
                    setDisplayText(secondPlayer.playerWon(), Color.DARKORANGE);
                    restartGame();
                }
                firstPlayerTurn = true;
                secondPlayerTurn = false;
            }

        });

        return playerTwoButton;
    }
    HBox setStartButton() {          // Set Start Button
        startGameButton = new Button("Start Game");
        startGameButton.setTranslateY(-20);
        startGameButton.setTextFill(Color.WHITE);
        startGameButton.setStyle("-fx-background-color: GREEN;margin: 25px;");
        startGameButton.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 12));
        startGameButton.setOnAction(actionEvent -> {
            if(startButton){
                firstPlayer.getCoinStartPosition();
                secondPlayer.getCoinStartPosition();

                setDisplayText("Game Started......", Color.GREEN);
                setTextToStartButton("Game Ongoing");

                startButton = false;
                firstPlayerTurn = true;
                startGameButton.setDisable(true);
                playerOneButton.setDisable(false);
            }

        });

        // Add Start Button to HBox Object and set to Center
        HBox hBox = new HBox();
        hBox.getChildren().add(startGameButton);
        hBox.setAlignment(Pos.CENTER);

        return hBox;
    }

    public void setDisplayText(String text, Color textColor) {  // Set text to display output
       label.setText(text);
       label.setMaxWidth(150);
       label.setTextFill(textColor);
    }

    public void setTextToStartButton(String text) {  // Set text to Start Button
        startGameButton.setText(text);
    }
    private void setDiceValue(String player, Color textColor){
        diceValue = (int) (Math.random()*6+1); // random() generates value between 0 and 1
        setDisplayText(player + " Dice Value : " + diceValue,textColor);
    }

    public void restartGame(){
        startGameButton.setDisable(false);
        startButton = true;
        setTextToStartButton("Restart Game");
        playerOneButton.setDisable(true);
        playerTwoButton.setDisable(true);
    }
    Circle firstPlayerCoin() {
        return firstPlayer.getCoin();
    }
    Circle secondPlayerCoin() {
        return secondPlayer.getCoin();
    }

}
