package inf.unideb.hu.chessgame.state;

import inf.unideb.hu.chessgame.state.impl.SimpleBoard;
import inf.unideb.hu.chessgame.state.impl.Tile;

public interface Piece {
    boolean isValidMove(Tile tile, Board board);
    String getName();
    void move(Tile tile, Board board);
    Tile getTile();
    public void setTile(Tile tile);
}
