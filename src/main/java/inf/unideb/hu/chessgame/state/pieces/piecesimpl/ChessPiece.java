package inf.unideb.hu.chessgame.state.pieces.piecesimpl;

import inf.unideb.hu.chessgame.state.board.Board;
import inf.unideb.hu.chessgame.state.board.boardimpl.Tile;
import inf.unideb.hu.chessgame.state.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public abstract class ChessPiece implements Piece {

    @Override
    public void move(Tile stepFrom, Tile stepTo, Board board) {
        if (isValidMove(stepFrom, stepTo, board)){
            board.removePiece(stepFrom);
            board.removePiece(stepTo);
            board.placePiece(stepTo,this);
        }
        else {
            System.out.println("not valid move");
        }
    }

    @Override
    public List<Tile> getPossibleMoves(Tile stepFrom, Board board) {
        List<Tile> possibleTiles = new ArrayList<>();

        for (int i=0; i<4; i++){
            for (int j=0; j<4; j++){
                if (isValidMove(stepFrom, board.getTile(i, j), board)){
                    possibleTiles.add(board.getTile(i, j));
                }
            }
        }

        return possibleTiles;
    }

    @Override
    public abstract boolean isValidMove(Tile stepFrom, Tile stepTo, Board board);

    @Override
    public abstract String getName();

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof ChessPiece)) {
            return false;
        }

        ChessPiece other = (ChessPiece) obj;

        return this.getName().equals(other.getName());
    }

}
