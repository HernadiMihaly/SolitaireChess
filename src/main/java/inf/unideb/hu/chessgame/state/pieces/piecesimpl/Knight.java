package inf.unideb.hu.chessgame.state.pieces.piecesimpl;

import inf.unideb.hu.chessgame.state.board.Board;
import inf.unideb.hu.chessgame.state.board.boardimpl.Tile;

public class Knight extends ChessPiece {

    @Override
    protected boolean isValidSpecialMove(Tile stepFrom, Tile stepTo, Board board) {
        int x= stepTo.getX();
        int y= stepTo.getY();
        return ((x == stepFrom.getX() + 1 && y == stepFrom.getY() + 2) ||
                (x == stepFrom.getX() + 1 && y == stepFrom.getY() - 2) ||
                (x == stepFrom.getX() - 1 && y == stepFrom.getY() + 2) ||
                (x == stepFrom.getX() - 1 && y == stepFrom.getY() - 2) ||
                (x == stepFrom.getX() + 2 && y == stepFrom.getY() + 1) ||
                (x == stepFrom.getX() + 2 && y == stepFrom.getY() - 1) ||
                (x == stepFrom.getX() - 2 && y == stepFrom.getY() + 1) ||
                (x == stepFrom.getX() - 2 && y == stepFrom.getY() - 1));
    }

    @Override
    public String getName() {
        return "Knight";
    }

}