package inf.unideb.hu.chessgame.state.pieces;

import inf.unideb.hu.chessgame.state.board.Board;
import inf.unideb.hu.chessgame.state.board.boardimpl.Tile;

import java.util.List;

public interface Piece {
    boolean isValidMove(Tile stepFrom, Tile stepTo, Board board);
    String getName();
    void move(Tile stepFrom, Tile stepTo, Board board);
    List<Tile> getPossibleMoves(Tile stepFrom, Board board);
    boolean equals(Object obj);
}
