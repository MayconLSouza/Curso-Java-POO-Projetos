package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

/**
 * Main entry point for the chess game application.
 * <p>
 * This class contains the main game loop that drives the chess match.
 * It handles user input, displays the game state, and manages the flow
 * of the game including moves, captures, and pawn promotion.
 * </p>
 */
public class Program {
     
    /**
     * Main method that runs the chess game.
     * <p>
     * The game loop continues until checkmate is reached. Each iteration:
     * 1. Clears the screen and displays the current game state
     * 2. Prompts for source and target positions
     * 3. Shows possible moves for the selected piece
     * 4. Executes the move and handles captures
     * 5. Manages pawn promotion when applicable
     * </p>
     * 
     * @param args command-line arguments (not used)
     * @throws Exception if any unexpected error occurs during execution
     */
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();
        List<ChessPiece> captured = new ArrayList<>();
        
        while (!chessMatch.getCheckMate())
        {
            try 
            {
                UI.clearScreen();
                UI.printMatch(chessMatch, captured);
                System.out.println();
                System.out.print("Source: ");
                ChessPosition source = UI.readChessPosition(sc);
                
                boolean[][] possibleMoves = chessMatch.possibleMoves(source);
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces(), possibleMoves);                

                System.out.println();
                System.out.print("Target: ");
                ChessPosition target = UI.readChessPosition(sc);

                ChessPiece capturedPiece = chessMatch.performChessMove(source, target);

                if(capturedPiece != null)
                {
                    captured.add(capturedPiece);
                }

                if(chessMatch.getPromoted() != null)
                {
                    System.out.print("Enter piece for promotion (B/N/R/Q): ");
                    String type = sc.nextLine().toUpperCase();
                    while(!type.equals("B") && !type.equals("N") && !type.equals("R") && !type.equals("Q"))
                    {
                        System.out.print("Invalid value! Enter piece for promotion (B/N/R/Q): ");
                        type = sc.nextLine().toUpperCase();
                    }
                    chessMatch.replacePromotedPiece(type);
                }
            } 
            catch (ChessException e) 
            {
                System.err.println(e.getMessage());
                sc.nextLine();
            }
            catch (InputMismatchException e) 
            {
                System.err.println(e.getMessage());
                sc.nextLine();
            }
        }

        UI.clearScreen();
        UI.printMatch(chessMatch, captured);
    }
}
