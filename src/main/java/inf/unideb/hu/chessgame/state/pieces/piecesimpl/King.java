package inf.unideb.hu.chessgame.state.pieces.piecesimpl;

import inf.unideb.hu.chessgame.state.board.Board;
import inf.unideb.hu.chessgame.state.board.boardimpl.Tile;

public class King extends ChessPiece {

    @Override
    protected boolean isValidSpecialMove(Tile stepFrom, Tile stepTo, Board board) {
        return (Math.abs(stepTo.getX() - stepFrom.getX()) <= 1) && (Math.abs(stepTo.getY() - stepFrom.getY()) <= 1)
                && !(stepFrom.getX() == stepTo.getX() && stepFrom.getY() == stepTo.getY());
    }

    @Override
    public String getName() {
        return "King";
    }

}
