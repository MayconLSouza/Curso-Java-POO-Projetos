package application;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.Color;

/**
 * User Interface class for the chess game console application.
 * <p>
 * This class provides methods for displaying the chess board, reading user input,
 * and printing game status information. It handles console colors and screen
 * clearing for different operating systems.
 * </p>
 */
public class UI {

    // ANSI escape codes for console colors
    // Source: https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    /**
     * Clears the console screen.
     * <p>
     * This method uses different commands for Windows and Unix-like systems
     * (Linux, macOS) to clear the console. It falls back to ANSI escape codes
     * if the platform-specific command fails.
     * </p>
     */
    public static void clearScreen() 
    {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\u001B[H\u001B[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.print("\u001B[H\u001B[2J");
            System.out.flush();
        }
    }

    /**
     * Reads a chess position from user input.
     * <p>
     * Expects input in algebraic notation (e.g., "e4", "a1"). The input
     * should consist of a letter (a-h) followed by a number (1-8).
     * </p>
     * 
     * @param sc the Scanner object to read input from
     * @return the parsed ChessPosition
     * @throws InputMismatchException if the input format is invalid
     */
    public static ChessPosition readChessPosition(Scanner sc)
    {
        try 
        {
            String s = sc.nextLine();
            char column = s.charAt(0);
            int row = Integer.parseInt(s.substring(1));
            return new ChessPosition(column, row);
        } 
        catch (Exception e) 
        {
            throw new InputMismatchException("Error reading ChessPosition. Valid values are from a1 to h8.");
        }
    }

    /**
     * Prints the current match state including board, captured pieces, and game status.
     * 
     * @param chessMatch the current chess match
     * @param captured the list of captured pieces
     */
    public static void printMatch(ChessMatch chessMatch, List<ChessPiece> captured)
    {
        printBoard(chessMatch.getPieces());
        System.err.println();
        printCapturedPieces(captured);
        System.out.println();
        System.out.println("Turn: " + chessMatch.getTurn());

        if(!chessMatch.getCheckMate())
        {
            System.out.println("Waiting player: " + chessMatch.getCurrentPlayer());

            if(chessMatch.getCheck())
            {
                System.out.println("CHECK!");
            }
        }
        else 
        {
            System.out.println("CHECKMATE!");
            System.out.println("Winner: " + chessMatch.getCurrentPlayer());
        }
    }

    /**
     * Prints the chess board with pieces in their current positions.
     * 
     * @param pieces the 2D array of chess pieces representing the board
     */
    public static void printBoard(ChessPiece[][] pieces) {
        for (int i = 0; i < pieces.length; i++) {
            System.out.print((8 - i) + " ");
            for (int j = 0; j < pieces.length; j++) {
                printPiece(pieces[i][j], false);
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
    }

    /**
     * Prints the chess board with possible moves highlighted.
     * <p>
     * This version is used when showing available moves for a selected piece.
     * </p>
     * 
     * @param pieces the 2D array of chess pieces representing the board
     * @param possibleMoves boolean matrix indicating valid move positions
     */
    public static void printBoard(ChessPiece[][] pieces, boolean[][] possibleMoves) {
        for (int i = 0; i < pieces.length; i++) {
            System.out.print((8 - i) + " ");
            for (int j = 0; j < pieces.length; j++) {
                printPiece(pieces[i][j], possibleMoves[i][j]);
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
    }

    /**
     * Prints a single chess piece with optional background highlighting.
     * <p>
     * White pieces are displayed in white, black pieces in yellow.
     * Empty squares are shown as "-". Possible move squares have a blue background.
     * </p>
     * 
     * @param piece the chess piece to print (or `null` for empty square)
     * @param background `true` to highlight with blue background for possible moves
     */
    private static void printPiece(ChessPiece piece, boolean background) {
        if (background) 
        {
            System.out.print(ANSI_BLUE_BACKGROUND);    
        }
        if(piece == null) {
            System.out.print("-" + ANSI_RESET);
        } else {
            if (piece.getColor() == Color.WHITE) {
                System.out.print(ANSI_WHITE + piece + ANSI_RESET);
            }
            else {
                System.out.print(ANSI_YELLOW + piece + ANSI_RESET);
            }
        }
        System.out.print(" ");
    }

    /**
     * Prints the lists of captured pieces separated by color.
     * 
     * @param captured the list of all captured pieces
     */
    private static void printCapturedPieces(List<ChessPiece> captured)
    {
        List<ChessPiece> white = captured.stream().filter(x -> x.getColor() == Color.WHITE).collect(Collectors.toList());
        List<ChessPiece> black = captured.stream().filter(x -> x.getColor() == Color.BLACK).collect(Collectors.toList());
        System.out.println("Captured pieces: ");
        
        System.out.print("White: ");
        System.out.print(ANSI_WHITE);
        System.out.println(Arrays.toString((white.toArray())));
        System.out.print(ANSI_RESET);

        System.out.print("Black: ");
        System.out.print(ANSI_YELLOW);
        System.out.println(Arrays.toString(black.toArray()));
        System.out.print(ANSI_RESET);
    }
}
