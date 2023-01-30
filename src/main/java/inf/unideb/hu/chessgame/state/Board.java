package inf.unideb.hu.chessgame.state;

import inf.unideb.hu.chessgame.state.impl.Tile;

import java.util.List;

public interface Board {
    void placePiece(Piece piece);
    void removePiece(Tile tile);
    Tile getTile(int x, int y);
    boolean isOccupied(int x, int y);
}