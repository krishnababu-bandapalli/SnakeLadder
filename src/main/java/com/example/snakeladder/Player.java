package com.example.snakeladder;

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
    private Effect effect = new Effect();

    public Player(int tileSize, Color coinColor, Color stroke, String playerName){
        coinPosition = 0;
        name = playerName;
        coin = new Circle(tileSize/2);
        coin.setFill(coinColor);
        coin.setStroke(stroke);
        coin.setTranslateX(-25);
        coin.setTranslateY(475);
    }

    public void movePlayer(int diceValue){

        if(coinPosition + diceValue <= 100) {
            coinPosition += diceValue;
            translatePlayer();

            if(coinPosition == 1 || coinPosition == 4 || coinPosition == 9 || coinPosition == 21
                                 || coinPosition == 28 || coinPosition == 51 || coinPosition == 71
                                 || coinPosition == 80) {
                ladderPosition();
            }
            if(coinPosition == 17 || coinPosition == 54 || coinPosition == 62 || coinPosition == 64
                                  || coinPosition == 87 || coinPosition == 93 || coinPosition == 95
                                  || coinPosition == 98) {
                snakePosition();
            }
        }

    }

    private void ladderPosition(){
        if(coinPosition == 1){
            coinPosition = 38;
        }
        if(coinPosition == 4){
            coinPosition = 14;
        }
        if(coinPosition == 9) {
            coinPosition = 31;
        }
        if(coinPosition == 21){
            coinPosition = 42;
        }
        if(coinPosition == 28){
            coinPosition = 84;
        }
        if(coinPosition == 51){
            coinPosition = 67;
        }
        if(coinPosition == 71){
            coinPosition = 91;
        }
        if(coinPosition == 80){
            coinPosition = 99;
        }

        translatePlayer();
    }

    private void snakePosition() {
        if(coinPosition == 17){
            coinPosition = 7;
        }
        if(coinPosition == 54){
            coinPosition = 34;
        }
        if(coinPosition == 62){
            coinPosition = 19;
        }
        if(coinPosition == 64){
            coinPosition = 60;
        }
        if(coinPosition == 87){
            coinPosition = 24;
        }
        if(coinPosition == 93){
            coinPosition = 73;
        }
        if(coinPosition == 95){
            coinPosition = 75;
        }
        if(coinPosition == 98){
            coinPosition = 79;
        }
        translatePlayer();
    }
    private void translatePlayer(){
        TranslateTransition move = new TranslateTransition(Duration.millis(600), this.coin);
        move.setToX(coinPositionCoordinates.getXCoordinate(coinPosition));
        move.setToY(coinPositionCoordinates.getYCoordinate(coinPosition));
        move.setAutoReverse(false);
        move.play();
    }

    public String playerWon(){
        if(coinPosition == 100) {
            String won = name + " won the GAME!";
            return won;
        }
        return null;
    }

    public Circle getCoin() {
        return coin;
    }
    public void getCoinPosition() {
        coinPosition = 0;
        translatePlayer();
    }
    public void setCoinPosition(int coinPosition) {
        this.coinPosition = coinPosition;
        getCoinPosition();
    }

}
