package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

/**
 * Bishop chess piece implementation.
 * <p>
 * The bishop moves any number of squares diagonally until it is
 * blocked by another piece. This class computes all legal bishop moves
 * considering the current board state.
 * </p>
 */
public class Bishop extends ChessPiece{

    /**
     * Creates a bishop associated with the given board and color.
     * @param board the boarda where the bishop is placed.
     * @param color the bishop color (WHITE or BLACK)
     */
    public Bishop(Board board, Color color) {
        super(board, color);
    }

    /**
     * Returns the bishop symbol used in board printing.
     * @return the string "B"
     */
    @Override
    public String toString() {
        return "B";
    }

    /**
     * Calculates and returns the bishop's possible moves as a boolean matrix.
     * The matrix dimensions match the board; `true` entries indicate allowed
     * target squares for the bishop given the current position and board state.
     * @return boolean matrix [rows][columns] with possible moves for this bishop
     */
    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0, 0);
        
        // nw
        p.setValues(position.getRow() - 1, position.getColumn() - 1);
        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p))
        {
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() - 1, p.getColumn() - 1);
        }
        if(getBoard().positionExists(p) && isThereOpponentPiece(p))
        {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // ne
        p.setValues(position.getRow() - 1, position.getColumn() + 1);
        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p))
        {
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() - 1, p.getColumn() + 1);
        }
        if(getBoard().positionExists(p) && isThereOpponentPiece(p))
        {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // se
        p.setValues(position.getRow() + 1, position.getColumn() + 1);
        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p))
        {
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() + 1, p.getColumn() + 1);
        }
        if(getBoard().positionExists(p) && isThereOpponentPiece(p))
        {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // sw
        p.setValues(position.getRow() + 1, position.getColumn() - 1);
        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p))
        {
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() + 1, p.getColumn() - 1);
        }
        if(getBoard().positionExists(p) && isThereOpponentPiece(p))
        {
            mat[p.getRow()][p.getColumn()] = true;
        }

        return mat;
    }
}
