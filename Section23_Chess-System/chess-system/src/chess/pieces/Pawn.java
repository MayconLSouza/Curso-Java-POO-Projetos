package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

/**
 * Pawn chess piece implementation.
 * <p>
 * The pawn moves forward one square (two on its first move) and captures
 * diagonally. This class computes the pawn's possible moves according to
 * its color and current position on the board. Additionally, it handles
 * the special en passant capture when conditions are met.
 * </p>
 */
public class Pawn extends ChessPiece {

    private ChessMatch chessMatch;

    /**
     * Creates a pawn associated with the given board and color.
     * @param board the board where the pawn is placed
     * @param color the pawn color (WHITE or BLACK)
     * @param chessMatch the chess match instance for en passant state checks
     */
    public Pawn(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
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
     * <p>
     * Includes:
     * - Standard pawn moves (forward one or two squares)
     * - Diagonal captures
     * - En passant capture when applicable
     * </p>
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

            p.setValues(position.getRow() - 2, position.getColumn());
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

            // Special move: en passant
            if(position.getRow() == 3)
            {
                Position left = new Position(position.getRow(), position.getColumn() - 1);
                if(getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVulnerable())
                {
                    mat[left.getRow() - 1][left.getColumn()] = true;
                }

                Position right = new Position(position.getRow(), position.getColumn() + 1);
                if(getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMatch.getEnPassantVulnerable())
                {
                    mat[right.getRow() - 1][right.getColumn()] = true;
                }
            }
        }
        else 
        {
            p.setValues(position.getRow() + 1, position.getColumn());
            if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p))
            {
                mat[p.getRow()][p.getColumn()] = true;
            }

            p.setValues(position.getRow() + 2, position.getColumn());
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

            // Special move: en passant
            if(position.getRow() == 4)
            {
                Position left = new Position(position.getRow(), position.getColumn() - 1);
                if(getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVulnerable())
                {
                    mat[left.getRow() + 1][left.getColumn()] = true;
                }

                Position right = new Position(position.getRow(), position.getColumn() + 1);
                if(getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMatch.getEnPassantVulnerable())
                {
                    mat[right.getRow() + 1][right.getColumn()] = true;
                }
            }
        }

        return mat;
    }
}
