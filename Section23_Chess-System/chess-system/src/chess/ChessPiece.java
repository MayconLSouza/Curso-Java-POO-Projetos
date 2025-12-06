package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

/**
 * Base class for all chess pieces. Extends the generic `Piece` from
 * the boardgame package and adds chess-specific data such as color and
 * move count utilities.
 */
public abstract class ChessPiece extends Piece{

    private Color color;
    private int moveCount;

    /**
     * Creates a chess piece associated with a board and a color.
     * @param board the board where the piece will be placed
     * @param color the piece color (WHITE or BLACK)
     */
    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    /**
     * Returns the color of this chess piece.
     * @return the piece color
     */
    public Color getColor() {
        return color;
    }

    /**
     * Returns how many moves this piece has performed.
     * @return move count
     */
    public int getMoveCount()
    {
        return moveCount;
    }

    /**
     * Increments the move count for this piece (used after a successful move).
     */
    public void increaseMoveCount()
    {
        moveCount++;
    }

    /**
     * Decrements the move count for this piece (used when undoing a move).
     */
    public void decreaseMoveCount()
    {
        moveCount--;
    }

    /**
     * Converts the internal board `Position` to a `ChessPosition`.
     * @return the chess position corresponding to the current piece position
     */
    public ChessPosition getChessPosition()
    {
        return ChessPosition.fromPosition(position);
    }

    /**
     * Checks whether there is an opponent piece at the given board position.
     * @param position the target board position (internal indices)
     * @return `true` if there is an opponent piece at the position; otherwise `false`
     */
    protected boolean isThereOpponentPiece(Position position)
    {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p != null && p.getColor() != color;
    }

}
