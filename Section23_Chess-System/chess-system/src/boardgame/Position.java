package boardgame;

/**
 * Represents a position on a game board with row and column coordinates.
 * <p>
 * This class is used to represent positions in a two-dimensional board.
 * It provides methods to get, set, and update row and column values,
 * and is fundamental for board game implementations.
 * </p>
 */
public class Position {

    private int row;
    private int column;
    
    /**
     * Constructs a position with the specified row and column.
     * 
     * @param row the row index (0-based)
     * @param column the column index (0-based)
     */
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * Gets the row index of this position.
     * 
     * @return the row index
     */
    public int getRow() {
        return row;
    }

    /**
     * Sets the row index of this position.
     * 
     * @param row the new row index
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * Gets the column index of this position.
     * 
     * @return the column index
     */
    public int getColumn() {
        return column;
    }

    /**
     * Sets the column index of this position.
     * 
     * @param column the new column index
     */
    public void setColumn(int column) {
        this.column = column;
    }

    /**
     * Sets both the row and column values of this position simultaneously.
     * <p>
     * This method provides a convenient way to update both coordinates
     * in a single operation.
     * </p>
     * 
     * @param row the new row index
     * @param column the new column index
     */
    public void setValues(int row, int column)
    {
        this.row = row;
        this.column = column;
    }

    /**
     * Returns a string representation of this position.
     * <p>
     * The format is "row, column" (e.g., "3, 5").
     * </p>
     * 
     * @return the position as a string
     */
    @Override
    public String toString() {
        return row + ", " + column;
    }

    

}
