package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
    Piece darkPiece = new Piece("@");
    Piece kingedDarkPiece = new Piece("K");
    Piece lightPiece = new Piece("O");
    Piece kingedLightPiece = new Piece("Q");
    Piece blankPiece = new Piece(" ");

    //    Space b8 = new Space(false, lightPiece, "b8");    first 12 spaces can be in loop
//    Space d8 = new Space(false, lightPiece, "d8");
//    Space f8 = new Space(false, lightPiece, "f8");
//    Space h8 = new Space(false, lightPiece, "h8");
//    Space a7 = new Space(false, lightPiece, "a7");
//    Space c7 = new Space(false, lightPiece, "c7");
//    Space e7 = new Space(false, lightPiece, "e7");
//    Space g7 = new Space(false, lightPiece, "g7");
//    Space b6 = new Space(false, lightPiece, "b6");
//    Space d6 = new Space(false, lightPiece, "d6");
//    Space f6 = new Space(false, lightPiece, "f6");
//    Space h6 = new Space(false, lightPiece, "h6");
//    Space a5 = new Space(true, blankPiece, "a5");
//    Space c5 = new Space(true, blankPiece, "c5");
//    Space e5 = new Space(true, blankPiece, "e5");
//    Space g5 = new Space(true, blankPiece, "g5");
//    Space b4 = new Space(true, blankPiece, "b4");
//    Space d4 = new Space(true, blankPiece, "d4");
//    Space f4 = new Space(true, blankPiece, "f4");
//    Space h4 = new Space(true, blankPiece, "h4");
//    Space a3 = new Space(false, darkPiece, "a3");
//    Space c3 = new Space(false, darkPiece, "c3");
//    Space e3 = new Space(false, darkPiece, "e3");
//    Space g3 = new Space(false, darkPiece, "g3");
//    Space b2 = new Space(false, darkPiece, "b2");
//    Space d2 = new Space(false, darkPiece, "d2");
//    Space f2 = new Space(false, darkPiece, "f2");
//    Space h2 = new Space(false, darkPiece, "h2");
//    Space a1 = new Space(false, darkPiece, "a1");
//    Space c1 = new Space(false, darkPiece, "c1");
//    Space e1 = new Space(false, darkPiece, "e1");
//    Space g1 = new Space(false, darkPiece, "g1");

    //    Space[] spaces = {b8, d8, f8, h8, a7, c7, e7, g7, b6, d6, f6, h6, a5, c5, e5, g5, b4, d4, f4, h4, a3, c3, e3, g3, b2, d2, f2, h2, a1, c1, e1, g1};
    List<Space> spaces = new ArrayList<>();
    List<Space> backRow = new ArrayList<>();
    List<Space> firstRow = new ArrayList<>();
    //    Space[] backRow = {b8, d8, f8, h8};
//    Space[] firstRow = {a1, c1, e1, g1};

    public Board() {
        char positionChar = 'b';
        int positionNum = 8;
        for (int i = 1; i <= 32; i++) {
        StringBuilder spaceName = new StringBuilder();
            spaceName.append(positionChar);
            positionChar += 2;
            if (i % 4 == 0) {
                if (positionChar == 'j') {
                    positionChar = 'a';
                }
                if (positionChar == 'i') {
                    positionChar = 'b';
                }
                positionNum--;
            }
            spaceName.append(positionNum);
            if (i <= 12) {
                spaces.add(new Space(false, lightPiece, spaceName.toString()));
            } else if (i <= 20) {
                spaces.add(new Space(true, blankPiece, spaceName.toString()));
            } else {
                spaces.add(new Space(false, darkPiece, spaceName.toString()));
            }
            if (i <= 4) {
                backRow.add(spaces.get(i - 1));
            }
            if (i > 28) {
                firstRow.add(spaces.get(i - 1));
            }
        }
    }

    public String toString() {
        StringBuilder board = new StringBuilder();
        String top = "               _______________________________________________   \n";
        String bottom = "                 A     B     C     D     E     F     G     H        ";
        board.append(top);
        int spaceIndex = 0;
        for (int i = 1; i <= 8; i++) {
            String start;
            String blankRow;
            String end;
            if (i % 2 == 0) {
                start = "          " + (9 - i) + "   |  ";
                blankRow = "              |     |/////|     |/////|     |/////|     |/////|  \n";
                end = "\n";
            } else {
                start = "          " + (9 - i) + "   |/////|  ";
                blankRow = "              |/////|     |/////|     |/////|     |/////|     |  \n";
                end = "  |  \n";
            }
            String blank = "  |/////|  ";
            board.append(blankRow);
            board.append(start);
            for (int j = 1; j <= 4; j++) {
                board.append(spaces.get(spaceIndex));
                if (j != 4 || i % 2 == 0) {
                    board.append(blank);
                }
                spaceIndex++;
            }
            board.append(end);
            board.append(blankRow);
        }
        board.append(bottom);

        return board.toString();
        // order for string builder
        //  TOP
        //  loop of
        //  blank
        //  row
        //  blank
        // for each 4 spaces add the position
        //  after 8 sections
        //  BOTTOM
//        return "               _______________________________________________   \n" +
//
//                "              |/////|     |/////|     |/////|     |/////|     |  \n" +
//
//                "          8   |/////|  " + b8 + "  |/////|  " + d8 + "  |/////|  " + f8 + "  |/////|  " + h8 + "  |  \n" +
//
//                "              |/////|_____|/////|_____|/////|_____|/////|_____|  \n" +
//
//                "              |     |/////|     |/////|     |/////|     |/////|  \n" +
//                "          7   |  " + a7 + "  |/////|  " + c7 + "  |/////|  " + e7 + "  |/////|  " + g7 + "  |/////|  \n" +
//                "              |_____|/////|_____|/////|_____|/////|_____|/////|  \n" +
//
//                "              |/////|     |/////|     |/////|     |/////|     |  \n" +
//                "          6   |/////|  " + b6 + "  |/////|  " + d6 + "  |/////|  " + f6 + "  |/////|  " + h6 + "  |  \n" +
//                "              |/////|_____|/////|_____|/////|_____|/////|_____|  \n" +
//
//                "              |     |/////|     |/////|     |/////|     |/////|  \n" +
//                "          5   |  " + a5 + "  |/////|  " + c5 + "  |/////|  " + e5 + "  |/////|  " + g5 + "  |/////|  \n" +
//                "              |_____|/////|_____|/////|_____|/////|_____|/////|  \n" +
//
//                "              |/////|     |/////|     |/////|     |/////|     |  \n" +
//                "          4   |/////|  " + b4 + "  |/////|  " + d4 + "  |/////|  " + f4 + "  |/////|  " + h4 + "  |  \n" +
//                "              |/////|_____|/////|_____|/////|_____|/////|_____|  \n" +
//
//                "              |     |/////|     |/////|     |/////|     |/////|  \n" +
//                "          3   |  " + a3 + "  |/////|  " + c3 + "  |/////|  " + e3 + "  |/////|  " + g3 + "  |/////|  \n" +
//                "              |_____|/////|_____|/////|_____|/////|_____|/////|  \n" +
//
//                "              |/////|     |/////|     |/////|     |/////|     |  \n" +
//                "          2   |/////|  " + b2 + "  |/////|  " + d2 + "  |/////|  " + f2 + "  |/////|  " + h2 + "  |  \n" +
//                "              |/////|_____|/////|_____|/////|_____|/////|_____|  \n" +
//
//                "              |     |/////|     |/////|     |/////|     |/////|  \n" +
//                "          1   |  " + a1 + "  |/////|  " + c1 + "  |/////|  " + e1 + "  |/////|  " + g1 + "  |/////|  \n" +
//                "              |_____|/////|_____|/////|_____|/////|_____|/////|  \n" +
//
//                "                 A     B     C     D     E     F     G     H        ";
    }
}
