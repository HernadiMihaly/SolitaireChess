package inf.unideb.hu.chessgame.state;

import inf.unideb.hu.chessgame.state.impl.Tile;

public interface Board {
    void placePiece(Piece piece);
    void removePiece(Tile tile);
    Tile getTile(int x, int y);
    boolean isOccupied(int x, int y);
    Board setBoardFromString(String boardRepresentation);
    int getSize();
}