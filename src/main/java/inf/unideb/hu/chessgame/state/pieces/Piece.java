package inf.unideb.hu.chessgame.state.pieces;

import inf.unideb.hu.chessgame.state.board.Board;
import inf.unideb.hu.chessgame.state.board.boardimpl.Tile;

import java.util.List;

public interface Piece {
    boolean isValidMove(Tile tile, Board board);
    String getName();
    void move(Tile tile, Board board);
    Tile getTile();
    void setTile(Tile tile);
    List<Tile> getPossibleMoves(Board board);
}
