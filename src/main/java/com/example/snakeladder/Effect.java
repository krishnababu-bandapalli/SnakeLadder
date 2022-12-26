package com.example.snakeladder;

import javafx.animation.RotateTransition;
import javafx.scene.effect.Bloom;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class Effect {
    Bloom bloom = new Bloom();
    public Effect() {
        bloom.setThreshold(1.0);
    }

    GridPane textPane = new GridPane();
    public Pane textArea() {
        textPane.setPrefSize(SnakeLadder.tileSize*SnakeLadder.width, 100);
        textPane.setTranslateX(SnakeLadder.tileSize*SnakeLadder.height);
        textPane.setTranslateY(SnakeLadder.tileSize*SnakeLadder.width);
        return textPane;
    }

    public void animateLadder() {
        Image ladderImage = new Image("C:\\Users\\krish_uv7qyqm\\IdeaProjects\\SnakeLadder\\src\\main\\Ladder.png");
        ImageView ladder = new ImageView(ladderImage);
        ladder.setImage(ladderImage);
        ladder.setFitHeight(500);
        ladder.setFitWidth(500);
        ladder.setEffect(bloom);
    }

    public void animateSnake() {
        Image ladderImage = new Image("C:\\Users\\krish_uv7qyqm\\IdeaProjects\\SnakeLadder\\src\\main\\Ladder.png");
        ImageView ladder = new ImageView(ladderImage);
        ladder.setImage(ladderImage);
        ladder.setFitHeight(500);
        ladder.setFitWidth(500);
        ladder.setEffect(bloom);
    }
}
