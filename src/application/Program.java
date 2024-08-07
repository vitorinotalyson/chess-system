package src.application;

import src.boardgame.Board;
import src.boardgame.Position;
import src.chess.ChessException;
import src.chess.ChessMatch;
import src.chess.ChessPiece;
import src.chess.ChessPosition;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ChessMatch chessmatch = new ChessMatch();
        while (true){
            try {
                UI.clearScreen();
                UI.printBoard(chessmatch.getPieces());
                System.out.println();
                System.out.print("Source: ");
                ChessPosition source = UI.readChessPosition(sc);

                System.out.println();
                System.out.print("Target: ");
                ChessPosition target = UI.readChessPosition(sc);

                ChessPiece capturedPiece = chessmatch.performChessMove(source,
                        target);
            }
            catch (ChessException e){
                System.out.println(e.getMessage());
                sc.nextLine();
            }
            catch (InputMismatchException f){
                System.out.println(f.getMessage());
                sc.nextLine();
            }


        }
    }
    
}
