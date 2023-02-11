package inf.unideb.hu.chessgame.state.pieces.piecesimpl;

import inf.unideb.hu.chessgame.state.board.Board;
import inf.unideb.hu.chessgame.state.board.boardimpl.Tile;
import inf.unideb.hu.chessgame.state.pieces.Piece;

import java.util.List;

public abstract class ChessPiece implements Piece {
    private Tile tile;

    protected ChessPiece(Tile tile) {
        this.tile = tile;
    }

    @Override
    public Tile getTile() {
        return tile;
    }

    @Override
    public void setTile(Tile tile) {
        this.tile = tile;
    }

    @Override
    public void move(Tile tile, Board board) {
        if (isValidMove(tile, board)){
            board.removePiece(this.tile);
            board.removePiece(tile);
            this.tile = tile;
            board.placePiece(this);
        }
        else {System.out.println("not valid move");}
    }

    @Override
    public abstract List<Tile> getPossibleMoves(Board board);

    @Override
    public abstract boolean isValidMove(Tile tile, Board board);

    @Override
    public abstract String getName();

}
