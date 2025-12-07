package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

/**
 * King chess piece implementation.
 * <p>
 * The king can move one square in any direction. This class computes the
 * king's legal moves considering the current board state and whether the
 * destination square is empty or occupied by an opponent. Additionally,
 * it handles the special castling move when conditions are met.
 * </p>
 */
public class King extends ChessPiece {

    private ChessMatch chessMatch;

    /**
     * Creates a king associated with the given board and color.
     * @param board the board where the king is placed
     * @param color the king color (WHITE or BLACK)
     * @param chessMatch the chess match instance for game state checks (castling)
     */
    public King(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
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
     * Tests if a rook at the given position is eligible for castling.
     * A rook is eligible if it exists, hasn't moved, and is the same color as the king.
     * @param position the position of the rook to test
     * @return `true` if the rook can participate in castling; otherwise `false`
     */
    private boolean testRookCastling(Position position)
    {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;
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
     * Includes regular king moves and special castling moves when conditions permit.
     * <p>
     * Castling conditions:
     * - Neither king nor rook has moved before
     * - King is not in check
     * - Squares between king and rook are empty
     * - King does not move through or into check
     * </p>
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

        // Special move: castling
        if(getMoveCount() == 0 && !chessMatch.getCheck())
        {
            // kingside castling (short castling)
            Position posR1 = new Position(position.getRow(), position.getColumn() + 3);
            if(testRookCastling(posR1))
            {
                Position p1 = new Position(position.getRow(), position.getColumn() + 1);
                Position p2 = new Position(position.getRow(), position.getColumn() + 2);
                if(getBoard().piece(p1) == null && getBoard().piece(p2) == null)
                {
                    mat[position.getRow()][position.getColumn() + 2] = true;
                }
            }

            // queenside castling (long castling)
            Position posR2 = new Position(position.getRow(), position.getColumn() - 4);
            if(testRookCastling(posR2))
            {
                Position p1 = new Position(position.getRow(), position.getColumn() - 1);
                Position p2 = new Position(position.getRow(), position.getColumn() - 2);
                Position p3 = new Position(position.getRow(), position.getColumn() - 3);
                if(getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null)
                {
                    mat[position.getRow()][position.getColumn() - 2] = true;
                }
            }
        }

        return mat;
    }

}
