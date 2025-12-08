package boardgame;

/**
 * Represents a game board with a grid of positions for placing pieces.
 * <p>
 * This class manages a two-dimensional board with rows and columns,
 * providing methods to place, retrieve, and remove pieces from positions.
 * It validates all board operations to ensure positions are within bounds
 * and prevents illegal operations.
 * </p>
 */
public class Board {

    private int rows;
    private int columns;
    private Piece[][] pieces;
   
    /**
     * Constructs a board with the specified dimensions.
     * 
     * @param rows the number of rows (must be at least 1)
     * @param columns the number of columns (must be at least 1)
     * @throws BoardException if rows or columns is less than 1
     */
    public Board(int rows, int columns) {
        if (rows < 1 || columns < 1) {
            throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    /**
     * Gets the number of rows on this board.
     * 
     * @return the number of rows
     */
    public int getRows() {
        return rows;
    }

    /**
     * Gets the number of columns on this board.
     * 
     * @return the number of columns
     */
    public int getColumns() {
        return columns;
    }

    /**
     * Gets the piece at the specified row and column.
     * 
     * @param row the row index (0-based)
     * @param column the column index (0-based)
     * @return the piece at the specified position, or `null` if empty
     * @throws BoardException if the position is outside the board bounds
     */
    public Piece piece(int row, int column) {
        if(!positionExists(row, column)) {
            throw new BoardException("Position not on the board");
        }
        return pieces[row][column];
    }

    /**
     * Gets the piece at the specified position.
     * 
     * @param position the position to query
     * @return the piece at the specified position, or `null` if empty
     * @throws BoardException if the position is outside the board bounds
     */
    public Piece piece(Position position) {
        if(!positionExists(position)) {
            throw new BoardException("Position not on the board");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    /**
     * Places a piece at the specified position on the board.
     * 
     * @param piece the piece to place
     * @param position the target position
     * @throws BoardException if the position is already occupied or outside bounds
     */
    public void placePiece(Piece piece, Position position) {
        if(thereIsAPiece(position)) {
            throw new BoardException("There is already a piece on position " + position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    /**
     * Removes the piece from the specified position.
     * 
     * @param position the position from which to remove the piece
     * @return the removed piece, or `null` if the position was empty
     * @throws BoardException if the position is outside the board bounds
     */
    public Piece removePiece(Position position)
    {
        if(!positionExists(position)) 
        {
            throw new BoardException("Position not on the board");
        }
        if(piece(position) == null)
        {
            return null;
        }
        Piece aux = piece(position);
        aux.position = null;
        pieces[position.getRow()][position.getColumn()] = null;
        return aux;
    }

    /**
     * Checks if the specified row and column coordinates exist on the board.
     * This is a private helper method used internally for validation.
     * 
     * @param row the row index to check
     * @param column the column index to check
     * @return `true` if the position is within board bounds; otherwise `false`
     */
    private boolean positionExists(int row, int column) {
        return row >= 0 && row < rows && column >=0 && column < columns;
    }

    /**
     * Checks if the specified position exists on the board.
     * 
     * @param position the position to check
     * @return `true` if the position is within board bounds; otherwise `false`
     */
    public boolean positionExists(Position position) {
        return positionExists(position.getRow(), position.getColumn());
    }

    /**
     * Checks if there is a piece at the specified position.
     * 
     * @param position the position to check
     * @return `true` if a piece exists at the position; otherwise `false`
     * @throws BoardException if the position is outside the board bounds
     */
    public boolean thereIsAPiece(Position position) {
        if(!positionExists(position)) {
            throw new BoardException("Position not on the board");
        }
        return piece(position) != null;
    }
}
