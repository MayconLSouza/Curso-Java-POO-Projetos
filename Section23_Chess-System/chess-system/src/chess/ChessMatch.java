package chess;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.Bishop;
import chess.pieces.King;
import chess.pieces.Knight;
import chess.pieces.Pawn;
import chess.pieces.Rook;

/**
 * Represents a chess match, managing the board, pieces, turns and game
 * state such as check and checkmate. Provides operations to query the
 * board, validate and perform moves, and initialize the starting setup.
 */
public class ChessMatch {

    private int turn;
    private Color currentPlayer;
    private Board board;
    private List<Piece> piecesOnTheBoard;
    private List<Piece> capturedPieces;
    private boolean check;
    private boolean checkMate;

    /**
     * Initializes a new chess match with an 8x8 board, starting turn and
     * default player (white). Also prepares the lists that track pieces
     * on the board and captured pieces, and sets up the initial piece layout.
     */
    public ChessMatch() {
        board = new Board(8, 8);
        turn = 1;
        currentPlayer = Color.WHITE;
        piecesOnTheBoard = new ArrayList<>();
        capturedPieces = new ArrayList<>();
        initialSetup();
    }
    
    /**
     * Returns the current board pieces as a 2D array of `ChessPiece`.
     * Empty squares are represented by `null` entries.
     * @return a matrix [rows][columns] containing the chess pieces
     */
    public ChessPiece[][] getPieces() {
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
        for(int i = 0; i < board.getRows(); i++) {
            for(int j=0; j < board.getColumns(); j++) {
                mat[i][j] = (ChessPiece) board.piece(i, j);
            }
        }
        return mat;
    }

    /**
     * Returns the color of the player whose turn it is.
     * @return current player color
     */
    public Color getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * Returns the current turn number. The first turn is 1.
     * @return current turn
     */
    public int getTurn() {
        return turn;
    }

    /**
     * Indicates whether the current player is in check.
     * @return `true` if the current player is in check; otherwise `false`
     */
    public boolean getCheck()
    {
        return check;
    }

    /**
     * Indicates whether the match has reached checkmate.
     * @return `true` if checkmate has occurred; otherwise `false`
     */
    public boolean getCheckMate()
    {
        return checkMate;
    }

    /**
     * Returns a boolean matrix with the possible moves for the piece
     * located at `sourcePosition`.
     * @param sourcePosition the piece position in chess notation (column, row)
     * @return a matrix [rows][columns] where `true` indicates an allowed move
     * @throws ChessException if the source position is invalid, there is no
     * piece, or the piece does not belong to the current player
     */
    public boolean[][] possibleMoves (ChessPosition sourcePosition)
    {
        Position position = sourcePosition.toPosition();
        ValidateSourcePosition(position);
        return board.piece(position).possibleMoves();
    }

     /**
     * Performs a chess move from `sourcePosition` to `targetPosition`.
     * Validates source and target, executes the move and updates the
     * game state (check, checkmate and turn).
     * @param sourcePosition source position in chess notation
     * @param targetPosition target position in chess notation
     * @return the captured piece, if any; otherwise returns `null`
     * @throws ChessException if the move leaves the player in check or
     * if source/target validations fail
     */
    public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition)
    {
        Position source = sourcePosition.toPosition();
        Position target = targetPosition.toPosition();
        ValidateSourcePosition(source);
        ValidateTargetPosition(source, target);
        Piece capturedPiece = makeMove(source, target);

        if(testCheck(currentPlayer))
        {
            undoMove(source, target, capturedPiece);
            throw new ChessException("You cannot put yourself in check");
        }

        check = testCheck(opponent(currentPlayer));

        if(testCheckMate(opponent(currentPlayer)))
        {
            checkMate = true;
        }
        else 
        {
            nextTurn();
        }

        return (ChessPiece) capturedPiece;
    }

     /**
     * Executes the physical movement of a piece on the board: removes the piece
     * from `source`, increments its move count, removes any captured piece at
     * `target` and places the piece at `target`.
     * It also updates the `piecesOnTheBoard` and `capturedPieces` lists.
     * @param source source position (internal indices)
     * @param target target position (internal indices)
     * @return the captured piece (or `null` if there was no capture)
     */
    private Piece makeMove(Position source, Position target) 
    {
        ChessPiece p = (ChessPiece) board.removePiece(source);
        p.increaseMoveCount();
        Piece capturedPiece = board.removePiece(target);
        board.placePiece(p, target);

        if(capturedPiece != null)
        {
            piecesOnTheBoard.remove(capturedPiece);
            capturedPieces.add(capturedPiece);
        }
        return capturedPiece;
    }

     /**
     * Undoes a previously executed move: moves the piece from `target`
     * back to `source`, decreases its move count and restores the captured
     * piece (if any) in the board structures.
     * @param source original position of the piece (internal indices)
     * @param target position where the piece was after the move
     * @param capturedPiece piece that was captured by the original move
     */
    private void undoMove(Position source, Position target, Piece capturedPiece)
    {
        ChessPiece p = (ChessPiece) board.removePiece(target);
        p.decreaseMoveCount();
        board.placePiece(p, source);

        if(capturedPiece != null)
        {
            board.placePiece(capturedPiece, target);
            capturedPieces.remove(capturedPiece);
            piecesOnTheBoard.add(capturedPiece);
        }
    }


    /**
     * Validates if the source position contains a piece that can be moved
     * by the current player. Throws `ChessException` when there is no piece,
     * the piece does not belong to the player, or there are no possible moves.
     * @param position source position (internal indices)
     * @throws ChessException in case of invalid validation
     */
    private void ValidateSourcePosition(Position position) 
    {
        if(!board.thereIsAPiece(position)) 
        {
            throw new ChessException("There is no piece on source position");
        }
        if(currentPlayer != ((ChessPiece) board.piece(position)).getColor())
        {
            throw new ChessException("The chosen piece is not yours");
        }
        if(!board.piece(position).isThereAnyPossibleMove())
        {
            throw new ChessException("There is no possible moves for the chosen pieces.");
        }
    }

     /**
     * Validates if the piece at `source` can move to `target`.
     * @param source source position (internal indices)
     * @param target target position (internal indices)
     * @throws ChessException if the move is not allowed
     */
    private void ValidateTargetPosition(Position source, Position target) {
        if(!board.piece(source).possibleMove(target))
        {
            throw new ChessException("The chosen piece cannot move to target position.");
        }
    }

     /**
     * Advances the turn number and switches the current player between
     * white and black.
     */
    private void nextTurn() {
        turn++;
        currentPlayer = (currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;
    }

     /**
     * Places a new piece on the board using chess notation (column, row)
     * and registers the piece in the `piecesOnTheBoard` list.
     * @param column column in chess notation ('a'..'h')
     * @param row row in chess notation (1..8)
     * @param piece chess piece to be placed
     */
    private void placeNewPiece(char column, int row, ChessPiece piece)
    {
        board.placePiece(piece, new ChessPosition(column, row).toPosition());
        piecesOnTheBoard.add(piece);
    }

     /**
     * Returns the opposite color of the provided one.
     * @param color current color
     * @return the opponent color (WHITE -> BLACK, BLACK -> WHITE)
     */
    private Color opponent(Color color)
    {
        return (color == Color.WHITE) ? Color.BLACK : Color.WHITE;
    }

     /**
     * Searches for and returns the king of the specified color among the
     * pieces on the board.
     * @param color color of the king to search for
     * @return the `ChessPiece` that represents the king of the given color
     * @throws IllegalStateException if there is no king of that color
     */
    private ChessPiece king(Color color)
    {
        List<Piece> list = piecesOnTheBoard.stream().filter(x -> ((ChessPiece)x).getColor() == color).collect(Collectors.toList());
        for(Piece p : list)
        {
            if(p instanceof King) 
            {
                return (ChessPiece) p;
            }
        }
        throw new IllegalStateException("There is no " + color + " king on the board.");
    }

     /**
     * Checks whether the king of the given color is in check. It obtains
     * the king's position and tests if any opposing piece has a possible
     * move that reaches that position.
     * @param color color of the king to check
     * @return `true` if the king is in check; otherwise `false`
     */
    private boolean testCheck(Color color)
    {
        Position kingPosition = king(color).getChessPosition().toPosition();
        List<Piece> opponentPieces = piecesOnTheBoard.stream().filter(x -> ((ChessPiece)x).getColor() == opponent(color)).collect(Collectors.toList());
        
        for(Piece p : opponentPieces)
        {
            boolean[][] mat = p.possibleMoves();
            if(mat[kingPosition.getRow()][kingPosition.getColumn()])
            {
                return true;
            }
        }

        return false;
    }

    /**
     * Checks whether the given color is in checkmate. It first confirms
     * the color is in check and, if so, simulates all possible moves of the
     * pieces of that color to see if any move removes the check condition.
     * Returns `true` if no valid move exists to escape check.
     * @param color color to be checked
     * @return `true` if it is checkmate; otherwise `false`
     */
    private boolean testCheckMate(Color color)
    {
        if(!testCheck(color))
        {
            return false;
        }

        List<Piece> list = piecesOnTheBoard.stream().filter(x -> ((ChessPiece)x).getColor() == color).collect(Collectors.toList());

        for(Piece p : list)
        {
            boolean[][] mat = p.possibleMoves();
            for(int i = 0; i < board.getRows(); i++)
            {
                for(int j = 0; j < board.getColumns(); j++)
                {
                    if(mat[i][j])
                    {
                        Position source = ((ChessPiece)p).getChessPosition().toPosition();
                        Position target = new Position(i, j);
                        Piece capturedPiece = makeMove(source, target);
                        boolean testCheck = testCheck(color);
                        undoMove(source, target, capturedPiece);

                        if(!testCheck)
                        {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    /**
     * Initial board setup for the match: places initial pieces 
     * and registers these pieces in `piecesOnTheBoard`.
     */
    private void initialSetup() {
        placeNewPiece('a', 1, new Rook(board, Color.WHITE));
        placeNewPiece('b', 1, new Knight(board, Color.WHITE));
        placeNewPiece('c', 1, new Bishop(board, Color.WHITE));
        placeNewPiece('e', 1, new King(board, Color.WHITE));
        placeNewPiece('f', 1, new Bishop(board, Color.WHITE));
        placeNewPiece('g', 1, new Knight(board, Color.WHITE));
        placeNewPiece('h', 1, new Rook(board, Color.WHITE));
        placeNewPiece('a', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('b', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('c', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('d', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('e', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('f', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('g', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('h', 2, new Pawn(board, Color.WHITE));

        placeNewPiece('a', 8, new Rook(board, Color.BLACK));
        placeNewPiece('b', 8, new Knight(board, Color.BLACK));
        placeNewPiece('c', 8, new Bishop(board, Color.BLACK));
        placeNewPiece('e', 8, new King(board, Color.BLACK));
        placeNewPiece('f', 8, new Bishop(board, Color.BLACK));
        placeNewPiece('g', 8, new Knight(board, Color.BLACK));
        placeNewPiece('h', 8, new Rook(board, Color.BLACK));
        placeNewPiece('a', 7, new Pawn(board, Color.BLACK));
        placeNewPiece('b', 7, new Pawn(board, Color.BLACK));
        placeNewPiece('c', 7, new Pawn(board, Color.BLACK));
        placeNewPiece('d', 7, new Pawn(board, Color.BLACK));
        placeNewPiece('e', 7, new Pawn(board, Color.BLACK));
        placeNewPiece('f', 7, new Pawn(board, Color.BLACK));
        placeNewPiece('g', 7, new Pawn(board, Color.BLACK));
        placeNewPiece('h', 7, new Pawn(board, Color.BLACK));
    }

}
