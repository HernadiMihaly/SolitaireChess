package inf.unideb.hu.chessgame.state.board;

import inf.unideb.hu.chessgame.state.board.boardimpl.Tile;
import inf.unideb.hu.chessgame.state.pieces.Piece;

public interface Board {
    void placePiece(Piece piece);
    void removePiece(Tile tile);
    Tile getTile(int x, int y);
    boolean isOccupied(int x, int y);
    Board setBoardFromString(String boardRepresentation);
    int getSize();
}