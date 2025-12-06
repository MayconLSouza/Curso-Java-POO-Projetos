package chess;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {

    private int turn;
    private Color currentPlayer;
    private Board board;
    private List<Piece> piecesOnTheBoard;
    private List<Piece> capturedPieces;
    private boolean check;
    private boolean checkMate;

    public ChessMatch() {
        board = new Board(8, 8);
        turn = 1;
        currentPlayer = Color.WHITE;
        piecesOnTheBoard = new ArrayList<>();
        capturedPieces = new ArrayList<>();
        initialSetup();
    }
    
    public ChessPiece[][] getPieces() {
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
        for(int i = 0; i < board.getRows(); i++) {
            for(int j=0; j < board.getColumns(); j++) {
                mat[i][j] = (ChessPiece) board.piece(i, j);
            }
        }
        return mat;
    }

    public Color getCurrentPlayer() {
        return currentPlayer;
    }

    public int getTurn() {
        return turn;
    }

    public boolean getCheck()
    {
        return check;
    }

    public boolean getCheckMate()
    {
        return checkMate;
    }

    public boolean[][] possibleMoves (ChessPosition sourcePosition)
    {
        Position position = sourcePosition.toPosition();
        ValidateSourcePosition(position);
        return board.piece(position).possibleMoves();
    }

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

    private Piece makeMove(Position source, Position target) 
    {
        Piece p = board.removePiece(source);
        Piece capturedPiece = board.removePiece(target);
        board.placePiece(p, target);

        if(capturedPiece != null)
        {
            piecesOnTheBoard.remove(capturedPiece);
            capturedPieces.add(capturedPiece);
        }
        return capturedPiece;
    }

    private void undoMove(Position source, Position target, Piece capturedPiece)
    {
        Piece p = board.removePiece(target);
        board.placePiece(p, source);

        if(capturedPiece != null)
        {
            board.placePiece(capturedPiece, target);
            capturedPieces.remove(capturedPiece);
            piecesOnTheBoard.add(capturedPiece);
        }
    }

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

    private void ValidateTargetPosition(Position source, Position target) {
        if(!board.piece(source).possibleMove(target))
        {
            throw new ChessException("The chosen piece cannot move to target position.");
        }
    }

    private void nextTurn() {
        turn++;
        currentPlayer = (currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;
    }

    private void placeNewPiece(char column, int row, ChessPiece piece)
    {
        board.placePiece(piece, new ChessPosition(column, row).toPosition());
        piecesOnTheBoard.add(piece);
    }

    private Color opponent(Color color)
    {
        return (color == Color.WHITE) ? Color.BLACK : Color.WHITE;
    }

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

    private void initialSetup() {
        placeNewPiece('h', 7, new Rook(board, Color.WHITE));
        placeNewPiece('d', 1, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new King(board, Color.WHITE));

        placeNewPiece('b', 8, new Rook(board, Color.BLACK));
        placeNewPiece('a', 8, new King(board, Color.BLACK));
    }

}
