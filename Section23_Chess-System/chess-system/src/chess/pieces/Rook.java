package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

/**
 * Rook chess piece implementation.
 * <p>
 * The rook moves any number of squares along rank or file until it is
 * blocked by another piece. This class computes all legal rook moves
 * considering the current board state.
 * </p>
 */
public class Rook extends ChessPiece{

    /**
     * Creates a rook associated with the given board and color.
     * @param board the board where the rook is placed
     * @param color the rook color (WHITE or BLACK)
     */
    public Rook(Board board, Color color) {
        super(board, color);
    }

    /**
     * Returns the rook symbol used in board printing.
     * @return the string "R"
     */
    @Override
    public String toString() {
        return "R";
    }

    /**
     * Calculates and returns the rook's possible moves as a boolean matrix.
     * The matrix dimensions match the board; `true` entries indicate allowed
     * target squares for the rook given the current position and board state.
     * @return boolean matrix [rows][columns] with possible moves for this rook
     */
    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0, 0);
        
        //above
        p.setValues(position.getRow() - 1, position.getColumn());
        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p))
        {
            mat[p.getRow()][p.getColumn()] = true;
            p.setRow(p.getRow() - 1);
        }
        if(getBoard().positionExists(p) && isThereOpponentPiece(p))
        {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // left
        p.setValues(position.getRow(), position.getColumn() - 1);
        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p))
        {
            mat[p.getRow()][p.getColumn()] = true;
            p.setColumn(p.getColumn() - 1);
        }
        if(getBoard().positionExists(p) && isThereOpponentPiece(p))
        {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // right
        p.setValues(position.getRow(), position.getColumn() + 1);
        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p))
        {
            mat[p.getRow()][p.getColumn()] = true;
            p.setColumn(p.getColumn() + 1);
        }
        if(getBoard().positionExists(p) && isThereOpponentPiece(p))
        {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // below
        p.setValues(position.getRow() + 1, position.getColumn());
        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p))
        {
            mat[p.getRow()][p.getColumn()] = true;
            p.setRow(p.getRow() + 1);
        }
        if(getBoard().positionExists(p) && isThereOpponentPiece(p))
        {
            mat[p.getRow()][p.getColumn()] = true;
        }

        return mat;
    }

}
