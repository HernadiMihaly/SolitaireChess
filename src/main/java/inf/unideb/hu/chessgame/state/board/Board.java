package inf.unideb.hu.chessgame.state.board;

import inf.unideb.hu.chessgame.state.board.boardimpl.Tile;
import inf.unideb.hu.chessgame.state.pieces.Piece;

import java.util.Arrays;
import java.util.List;

public interface Board {
    void placePiece(Tile placeTo, Piece piece);
    void removePiece(Tile tile);
    Tile getTile(int x, int y);
    boolean isOccupied(Tile tile);
    Board setBoardFromString(String boardRepresentation);
    int getSize();
    int getNumberOfPieces();
    Board clone();
    Tile[][] getTiles();
}