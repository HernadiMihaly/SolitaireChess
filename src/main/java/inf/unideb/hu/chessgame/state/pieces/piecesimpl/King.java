package inf.unideb.hu.chessgame.state.pieces.piecesimpl;

import inf.unideb.hu.chessgame.state.board.Board;
import inf.unideb.hu.chessgame.state.board.boardimpl.Tile;

public class King extends ChessPiece {

    @Override
    public boolean isValidMove(Tile stepFrom, Tile stepTo, Board board) {
        int x= stepTo.getX();
        int y= stepTo.getY();

        if(x<4 && x>= 0 && y<4 && y>=0
                && (Math.abs(x - stepFrom.getX()) <= 1) && (Math.abs(y - stepFrom.getY()) <= 1)
                && !(stepFrom.getX() == x && stepFrom.getY() == y)) {
            if (board.isOccupied(x, y)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getName() {
        return "King";
    }

}
