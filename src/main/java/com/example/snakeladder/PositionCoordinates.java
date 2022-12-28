package com.example.snakeladder;

import javafx.util.Pair;

import java.util.ArrayList;

public class PositionCoordinates {
    Build_UI_UX buildUIUX = new Build_UI_UX();

    public PositionCoordinates(){
        populatePositionCoordinates();
    }
    private ArrayList<Pair<Integer, Integer>> positionCoordinates;

    private void populatePositionCoordinates(){
        positionCoordinates = new ArrayList<>();
        positionCoordinates.add(new Pair<>(-25, 475));//dummy Values added at Zero index
        int x, y = 10, xPos, yPos;
        for (int i = 0; i < buildUIUX.height ; i++) {

            x = 1;
            for (int j = 0; j < buildUIUX.width; j++) {
                if(y%2==0){
                    xPos = x* buildUIUX.tileSize - buildUIUX.tileSize/2;
                }
                else {
                    xPos = buildUIUX.width* buildUIUX.tileSize - (x* buildUIUX.tileSize - buildUIUX.tileSize/2);
                }
                yPos = y* buildUIUX.tileSize - buildUIUX.tileSize/2;
                positionCoordinates.add(new Pair<>(xPos, yPos));
                x++;
            }
            y--;
        }
    }
    public int getXCoordinate(int position){
        return positionCoordinates.get(position).getKey();
    }
    public int getYCoordinate(int position){
        return positionCoordinates.get(position).getValue();
    }

//    public static void main(String[] args) {
//        PositionCoordinates board = new PositionCoordinates();
//        board.populatePositionCoordinates();
//        for (int i = 0; i < board.positionCoordinates.size(); i++) {
//            System.out.println(i+"# x: " + board.positionCoordinates.get(i).getKey() + " y: "+
//                    board.positionCoordinates.get(i).getValue());
//        }
//    }
}
