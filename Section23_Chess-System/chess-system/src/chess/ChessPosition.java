package chess;

import boardgame.Position;

/**
 * Represents a chess position in algebraic notation (e.g., "e4", "a1", "h8").
 * <p>
 * This class provides conversion between algebraic chess notation and internal
 * board positions. It validates that positions are within the valid chess board
 * range (a1 to h8).
 * </p>
 */
public class ChessPosition {

    private char column;
    private int row;
    
    /**
     * Constructs a chess position from algebraic notation.
     * 
     * @param column the file letter (a-h)
     * @param row the rank number (1-8)
     * @throws ChessException if the position is outside the valid range a1-h8
     */
    public ChessPosition(char column, int row) {
        if (column < 'a' || column > 'h' || row < 1 || row > 8)
        {
            throw new ChessException("Invalid position! Valid values are from a1 to h8");
        }
        this.column = column;
        this.row = row;
    }

    /**
     * Gets the file letter of this chess position.
     * 
     * @return the column letter (a-h)
     */
    public char getColumn() {
        return column;
    }

    /**
     * Gets the rank number of this chess position.
     * 
     * @return the row number (1-8)
     */
    public int getRow() {
        return row;
    }
    
    /**
     * Converts this chess position to an internal board position.
     * <p>
     * The conversion follows:
     * - Row: 8 - chess row (chess rows are 1-8 from bottom, board rows are 0-7 from top)
     * - Column: column letter - 'a' (a=0, b=1, ..., h=7)
     * </p>
     * 
     * @return the corresponding internal {@link Position}
     */
    protected Position toPosition() 
    {
        return new Position(8 - row, column - 'a');
    }

    /**
     * Creates a chess position from an internal board position.
     * <p>
     * This is the inverse operation of {@link #toPosition()}.
     * </p>
     * 
     * @param position the internal board position to convert
     * @return the corresponding chess position in algebraic notation
     */
    protected static ChessPosition fromPosition(Position position) {
        return new ChessPosition((char)('a' + position.getColumn()), 8 - position.getRow());
    }

    /**
     * Returns the string representation of this chess position in algebraic notation.
     * 
     * @return the position as a string (e.g., "e4", "a1", "h8")
     */
    @Override
    public String toString() {
        return "" + column + row;
    }

}
