package com.example.snakeladder;

import com.example.snakeladder.PositionCoordinates;
import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Player {
    public Player() {}
    private Circle coin;
    private String name;
    private int coinPosition;

    private static PositionCoordinates coinPositionCoordinates = new PositionCoordinates();

    public Player(int tileSize, Color coinColor, Color stroke, String playerName){
        coinPosition = 1;
        name = playerName;
        coin = new Circle(tileSize/2);
        coin.setFill(coinColor);
        coin.setStroke(stroke);
        coin.setPickOnBounds(true);
        coin.setTranslateX(25);
        coin.setTranslateY(475);
    }



    public void movePlayer(int diceValue){
        if(coinPosition + diceValue <= 100) {
            coinPosition += diceValue;
//            coin.setTranslateX(gameBoard.getXCoordinate(coinPosition));
//            coin.setTranslateY(gameBoard.getYCoordinate(coinPosition));
            if(coinPosition == 4) coinPosition = 14;
            if(coinPosition == 9) coinPosition = 31;
            if(coinPosition == 17) coinPosition = 7;
            if(coinPosition == 21) coinPosition = 42;
            if(coinPosition == 28) coinPosition = 84;
            if(coinPosition == 51) coinPosition = 67;
            if(coinPosition == 28) coinPosition = 84;
            if(coinPosition == 54) coinPosition = 34;
            if(coinPosition == 62) coinPosition = 19;
            if(coinPosition == 64) coinPosition = 60;
            if(coinPosition == 71) coinPosition = 91;
            if(coinPosition == 80) coinPosition = 99;
            if(coinPosition == 87) coinPosition = 24;
            if(coinPosition == 93) coinPosition = 73;
            if(coinPosition == 95) coinPosition = 75;
            if(coinPosition == 98) coinPosition = 79;

            translatePlayer();
        }
    }

    public String playerWon(){
        if(coinPosition == 100) {
            String won = name + " won the GAME!";
            return won;
        }
        return null;
    }
    private void translatePlayer(){
        TranslateTransition move = new TranslateTransition(Duration.millis(600), this.coin);
        move.setToX(coinPositionCoordinates.getXCoordinate(coinPosition));
        move.setToY(coinPositionCoordinates.getYCoordinate(coinPosition));
        move.setAutoReverse(false);
        move.play();
    }

    public Circle getCoin() {
        return coin;
    }
    public void getCoinPosition() {
        coinPosition = 1;
        setCoinPosition(coinPosition);
    }
    public void setCoinPosition(int coinPosition) {
        this.coinPosition = coinPosition;
        setCoin();
    }

    public void setCoin() {
        coin.setTranslateX(25);
        coin.setTranslateY(475);
    }
}
