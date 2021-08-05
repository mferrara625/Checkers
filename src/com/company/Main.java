package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Board board = new Board();
        for (int i = 0; i < 50; i++){
            turn(scan, board);
        }
        System.out.println("Game Over");
    }

    private static void turn(Scanner scan, Board board) {
        kingCheck(board.backRow, board.darkPiece, board.kingedDarkPiece);
        kingCheck(board.firstRow, board.lightPiece, board.kingedLightPiece);
        System.out.println(board);
        System.out.println("Enter coordinates of piece to move ( letter then number, ex. a1, b2 )");
        String input = scan.nextLine();
        for(Space space : board.spaces)
        if (input.equals(space.position) && !space.isEmpty){
            System.out.println("Enter coordinates of target destination");
            String input2 = scan.nextLine();
            moveToTargetDestination(board, space, input2);
            System.out.println("Enter coordinates to remove a piece or enter 9 to continue");
            String input3 = scan.nextLine();
            if (input3.equals("9"))
            break;
            else {
                for (Space space3 : board.spaces)
                    if(input3.equals(space3.position) && !space3.isEmpty){
                        space3.isEmpty = true;
                        space3.currentPiece = board.blankPiece;
                    }
            }
        }
    }

    private static void moveToTargetDestination(Board board, Space space, String input2) {
        for (Space space2 : board.spaces)
         if(input2.equals(space2.position) && space2.isEmpty){
            space.isEmpty = true;
            if(space.currentPiece == board.darkPiece)
                space2.currentPiece = board.darkPiece;
            else if (space.currentPiece == board.lightPiece)
                space2.currentPiece = board.lightPiece;
            space.currentPiece = board.blankPiece;
            space2.isEmpty = false;
        }
    }

    private static void kingCheck(Space[] row, Piece piece, Piece kingedPiece) {
        for (Space space : row) {
            if (space.currentPiece == piece)
                space.currentPiece = kingedPiece;
        }
    }
}
