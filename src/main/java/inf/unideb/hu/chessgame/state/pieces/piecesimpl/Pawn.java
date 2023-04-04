package inf.unideb.hu.chessgame.state.pieces.piecesimpl;

import inf.unideb.hu.chessgame.state.board.Board;
import inf.unideb.hu.chessgame.state.board.boardimpl.Tile;

public class Pawn extends ChessPiece {

    @Override
    protected boolean isValidSpecialMove(Tile stepFrom, Tile stepTo, Board board) {
        return stepTo.getX() == stepFrom.getX()-1
                && (stepTo.getY() == stepFrom.getY()-1 || stepTo.getY() == stepFrom.getY()+1);
    }

    @Override
    public String getName() {
        return "Pawn";
    }

}