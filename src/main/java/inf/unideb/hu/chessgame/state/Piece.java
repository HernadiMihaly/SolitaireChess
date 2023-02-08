package inf.unideb.hu.chessgame.state;

import inf.unideb.hu.chessgame.state.impl.Tile;

import java.util.List;

public interface Piece {
    boolean isValidMove(Tile tile, Board board);
    String getName();
    void move(Tile tile, Board board);
    Tile getTile();
    void setTile(Tile tile);
    List<Tile> getPossibleMoves(Board board);
}
