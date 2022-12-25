package com.example.snakeladder;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Square extends Rectangle {
    public Square(int size){
        setHeight(size);
        setWidth(size);
        setFill(Color.RED);
        setStroke(Color.BLACK);
    }
}
