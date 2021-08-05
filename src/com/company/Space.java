package com.company;

public class Space {
    boolean isEmpty;
    Piece currentPiece;
    String position;

    public Space(boolean isEmpty, Piece currentPiece, String position){
        this.isEmpty = isEmpty;
        this.currentPiece = currentPiece;
        this.position = position;
    }

    public String toString(){
        return currentPiece.symbol;
    }
}
