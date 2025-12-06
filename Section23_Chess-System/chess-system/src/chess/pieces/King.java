package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

/**
 * King chess piece implementation.
 * <p>
 * The king can move one square in any direction. This class computes the
 * king's legal moves considering the current board state and whether the
 * destination square is empty or occupied by an opponent.
 * </p>
 */
public class King extends ChessPiece{

    /**
     * Creates a king associated with the given board and color.
     * @param board the board where the king is placed
     * @param color the king color (WHITE or BLACK)
     */
    public King(Board board, Color color) {
        super(board, color);
    }

    /**
     * Returns the king symbol used in board printing.
     * @return the string "K"
     */
    @Override
    public String toString() {
        return "K";
    }

    /**
     * Checks whether the king can move to the given position. A move is
     * allowed if the destination square is empty or contains an opponent piece.
     * @param position target position to check
     * @return `true` if the king can move to the position; otherwise `false`
     */
    private boolean canMove(Position position)
    {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

    /**
     * Calculates and returns the king's possible moves as a boolean matrix.
     * The matrix dimensions match the board; `true` entries indicate allowed
     * target squares for the king given the current position and board state.
     * @return boolean matrix [rows][columns] with possible moves for this king
     */
    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0, 0);

        // above
        p.setValues(position.getRow() - 1, position.getColumn());
        if(getBoard().positionExists(p) && canMove(p))
        {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // left
        p.setValues(position.getRow(), position.getColumn() - 1);
        if(getBoard().positionExists(p) && canMove(p))
        {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // below
        p.setValues(position.getRow() + 1, position.getColumn());
        if(getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // right
        p.setValues(position.getRow(), position.getColumn() + 1);
        if(getBoard().positionExists(p) && canMove(p))
        {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // nw
        p.setValues(position.getRow() - 1, position.getColumn() - 1);
        if(getBoard().positionExists(p) && canMove(p))
        {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // ne
        p.setValues(position.getRow() - 1, position.getColumn() + 1);
        if(getBoard().positionExists(p) && canMove(p))
        {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // sw
        p.setValues(position.getRow() + 1, position.getColumn() - 1);
        if(getBoard().positionExists(p) && canMove(p))
        {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // se
        p.setValues(position.getRow() + 1, position.getColumn() + 1);
        if(getBoard().positionExists(p) && canMove(p))
        {
            mat[p.getRow()][p.getColumn()] = true;
        }

        return mat;
    }

}
