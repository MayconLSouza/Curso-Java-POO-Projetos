package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

/**
 * Pawn chess piece implementation.
 * <p>
 * The pawn moves forward one square (two on its first move) and captures
 * diagonally. This class computes the pawn's possible moves according to
 * its color and current position on the board.
 * </p>
 */
public class Pawn extends ChessPiece {

    /**
     * Creates a pawn associated with the given board and color.
     * @param board the board where the pawn is placed
     * @param color the pawn color (WHITE or BLACK)
     */
    public Pawn(Board board, Color color) {
        super(board, color);
    }

     /**
     * Returns the pawn symbol used in board printing.
     * @return the string "P"
     */
    @Override
    public String toString() {
        return "P";
    }

    /**
     * Calculates and returns the pawn's possible moves as a boolean matrix.
     * The matrix dimensions match the board; `true` entries indicate allowed
     * target squares for the pawn given the current position and board state.
     * @return boolean matrix [rows][columns] with possible moves for this pawn
     */
    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0, 0);
        
        if(getColor() == Color.WHITE) {
            p.setValues(position.getRow() - 1, position.getColumn());
            if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p))
            {
                mat[p.getRow()][p.getColumn()] = true;
            }

            p.setValues(position.getRow() - 2, p.getColumn());
            Position p2 = new Position(position.getRow() - 1, position.getColumn());
            if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0)
            {
                mat[p.getRow()][p.getColumn()] = true;
            }

            p.setValues(position.getRow() - 1, position.getColumn() - 1);
            if(getBoard().positionExists(p) && isThereOpponentPiece(p))
            {
                mat[p.getRow()][p.getColumn()] = true;
            }

            p.setValues(position.getRow() - 1, position.getColumn() + 1);
            if(getBoard().positionExists(p) && isThereOpponentPiece(p))
            {
                mat[p.getRow()][p.getColumn()] = true;
            }
        }
        else 
        {
            p.setValues(position.getRow() + 1, position.getColumn());
            if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p))
            {
                mat[p.getRow()][p.getColumn()] = true;
            }

            p.setValues(position.getRow() + 2, p.getColumn());
            Position p2 = new Position(position.getRow() + 1, position.getColumn());
            if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0)
            {
                mat[p.getRow()][p.getColumn()] = true;
            }

            p.setValues(position.getRow() + 1, position.getColumn() - 1);
            if(getBoard().positionExists(p) && isThereOpponentPiece(p))
            {
                mat[p.getRow()][p.getColumn()] = true;
            }

            p.setValues(position.getRow() + 1, position.getColumn() + 1);
            if(getBoard().positionExists(p) && isThereOpponentPiece(p))
            {
                mat[p.getRow()][p.getColumn()] = true;
            }
        }

        return mat;
    }
}
