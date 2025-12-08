package boardgame;

/**
 * Abstract base class representing a piece on a game board.
 * <p>
 * This class provides the foundation for all game pieces, defining common
 * functionality such as position tracking and movement validation.
 * Concrete subclasses must implement piece-specific movement logic.
 * </p>
 */
public abstract class Piece {

    protected Position position;
    private Board board;
    
    /**
     * Constructs a piece associated with the given board.
     * The piece's initial position is set to `null` and should be
     * assigned when placed on the board.
     * 
     * @param board the board where this piece belongs
     */
    public Piece(Board board) {
        this.board = board;
    }

    /**
     * Gets the board associated with this piece.
     * This method is protected to allow access by subclasses.
     * 
     * @return the board containing this piece
     */
    protected Board getBoard() {
        return board;
    }

    /**
     * Calculates and returns all possible moves for this piece.
     * <p>
     * This abstract method must be implemented by concrete subclasses
     * to define the specific movement patterns for each piece type.
     * The returned matrix should have `true` values for positions
     * where the piece can legally move.
     * </p>
     * 
     * @return a boolean matrix [rows][columns] indicating possible moves
     */
    public abstract boolean[][] possibleMoves();
    
    /**
     * Checks whether this piece can move to the specified position.
     * <p>
     * This method delegates to the {@link #possibleMoves()} matrix
     * to determine if the target position is a legal move.
     * </p>
     * 
     * @param position the target position to check
     * @return `true` if the piece can move to the position; otherwise `false`
     */
    public boolean possibleMove(Position position)
    {
        return possibleMoves()[position.getRow()][position.getColumn()];
    }
    
    /**
     * Determines if there is at least one possible move for this piece.
     * <p>
     * This method scans the possible moves matrix to check if the piece
     * has any legal moves available in the current board state.
     * </p>
     * 
     * @return `true` if the piece has at least one legal move; otherwise `false`
     */
    public boolean isThereAnyPossibleMove()
    {
        boolean[][] mat = possibleMoves();
        for(int i = 0; i < mat.length; i++)
        {
            for(int j = 0; j < mat.length; j++)
            {
                if (mat[i][j])
                {
                    return true;
                }
            }
        }
        return false;
    }
}
