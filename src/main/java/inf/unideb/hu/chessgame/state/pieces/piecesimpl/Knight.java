package inf.unideb.hu.chessgame.state.pieces.piecesimpl;

import inf.unideb.hu.chessgame.state.board.Board;
import inf.unideb.hu.chessgame.state.board.boardimpl.Tile;

public class Knight extends ChessPiece {

    @Override
    public boolean isValidMove(Tile stepFrom, Tile stepTo, Board board) {
        int x= stepTo.getX();
        int y= stepTo.getY();

        if (x<4 && x>= 0 && y<4 && y>=0 &&
                ((x == stepFrom.getX() + 1 && y == stepFrom.getY() + 2) ||
                (x == stepFrom.getX() + 1 && y == stepFrom.getY() - 2) ||
                (x == stepFrom.getX() - 1 && y == stepFrom.getY() + 2) ||
                (x == stepFrom.getX() - 1 && y == stepFrom.getY() - 2) ||
                (x == stepFrom.getX() + 2 && y == stepFrom.getY() + 1) ||
                (x == stepFrom.getX() + 2 && y == stepFrom.getY() - 1) ||
                (x == stepFrom.getX() - 2 && y == stepFrom.getY() + 1) ||
                (x == stepFrom.getX() - 2 && y == stepFrom.getY() - 1))) {
            if (board.isOccupied(x, y)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getName() {
        return "Knight";
    }

}