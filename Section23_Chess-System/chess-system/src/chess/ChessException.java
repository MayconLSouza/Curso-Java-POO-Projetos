package chess;

import boardgame.BoardException;

/**
 * Represents chess-specific exceptions that occur during game operations.
 * <p>
 * This class extends {@link BoardException} to provide specialized exception
 * handling for chess rules and operations. It is thrown when chess-specific
 * violations occur, such as illegal moves, check violations, or invalid
 * game state operations.
 * </p>
 */
public class ChessException extends BoardException{

    /**
     * Constructs a new chess exception with the specified detail message.
     * The message provides specific information about the chess rule violation
     * that occurred.
     * 
     * @param msg the detail message explaining the reason for the exception
     */
    public ChessException(String msg)
    {
        super(msg);
    }
}
