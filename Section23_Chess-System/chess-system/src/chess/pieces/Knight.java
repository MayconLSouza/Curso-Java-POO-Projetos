package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

/**
 * Knight chess piece implementation.
 * <p>
 * The knight moves in an L-shape pattern: two squares in one direction
 * (rank or file) and then one square perpendicular to that. The knight
 * is the only piece that can "jump" over other pieces. This class computes
 * all legal knight moves considering the current board state.
 * </p>
 */
public class Knight extends ChessPiece{

    /**
     * Creates a knight associated with the given board and color.
     * @param board the board where the knight is placed
     * @param color the knight color (WHITE or BLACK)
     */
    public Knight(Board board, Color color) {
        super(board, color);
    }

    /**
     * Returns the knight symbol used in board printing.
     * @return the string "N"
     */
    @Override
    public String toString() {
        return "N";
    }

    /**
     * Checks whether the knight can move to the given position. A move is
     * allowed if the destination square is empty or contains an opponent piece.
     * @param position target position to check
     * @return `true` if the knight can move to the position; otherwise `false`
     */
    private boolean canMove(Position position)
    {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

    /**
     * Calculates and returns the knight's possible moves as a boolean matrix.
     * The matrix dimensions match the board; `true` entries indicate allowed
     * target squares for the knight given the current position and board state.
     * The knight has up to 8 possible moves in an L-shape pattern.
     * @return boolean matrix [rows][columns] with possible moves for this knight
     */
    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0, 0);

        // One up, two left (10:30 position)
        p.setValues(position.getRow() - 1, position.getColumn() - 2);
        if(getBoard().positionExists(p) && canMove(p))
        {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // Two up, one left (11:30 position)
        p.setValues(position.getRow() - 2, position.getColumn() - 1);
        if(getBoard().positionExists(p) && canMove(p))
        {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // Two up, one right (12:30 position)
        p.setValues(position.getRow() - 2, position.getColumn() + 1);
        if(getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // One up, two right (1:30 position)
        p.setValues(position.getRow() - 1, position.getColumn() + 2);
        if(getBoard().positionExists(p) && canMove(p))
        {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // One down, two right (4:30 position)
        p.setValues(position.getRow() + 1, position.getColumn() + 2);
        if(getBoard().positionExists(p) && canMove(p))
        {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // Two down, one right (5:30 position)
        p.setValues(position.getRow() + 2, position.getColumn() + 1);
        if(getBoard().positionExists(p) && canMove(p))
        {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // Two down, one left (6:30 position)
        p.setValues(position.getRow() + 2, position.getColumn() - 1);
        if(getBoard().positionExists(p) && canMove(p))
        {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // One down, two left (7:30 position)
        p.setValues(position.getRow() + 1, position.getColumn() - 2);
        if(getBoard().positionExists(p) && canMove(p))
        {
            mat[p.getRow()][p.getColumn()] = true;
        }

        return mat;
    }

}
