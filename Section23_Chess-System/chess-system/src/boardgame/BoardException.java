package boardgame;

/**
 * Represents runtime exceptions specific to board game operations.
 * <p>
 * This class extends {@link RuntimeException} to provide specialized
 * exception handling for board-related errors. It is thrown when
 * invalid board operations are attempted, such as accessing invalid
 * positions or performing illegal board manipulations.
 * </p>
 */
public class BoardException extends RuntimeException{

    /**
     * Constructs a new board exception with the specified detail message.
     * The message provides specific information about the board operation
     * violation that occurred.
     * 
     * @param msg the detail message explaining the reason for the exception
     */
    public BoardException(String msg) {
        super(msg);
    }

}
