package inf.unideb.hu.chessgame.state.pieces.piecesimpl;

import inf.unideb.hu.chessgame.state.board.Board;
import inf.unideb.hu.chessgame.state.board.boardimpl.Tile;

public class Bishop extends ChessPiece {

    @Override
    protected boolean isValidSpecialMove(Tile stepFrom, Tile stepTo, Board board) {
        return isPathClear(stepFrom, stepTo.getX(), stepTo.getY(), board)
                && Math.abs(stepTo.getX() - stepFrom.getX()) == Math.abs(stepTo.getY() - stepFrom.getY())
                && !(stepFrom.getX() == stepTo.getX() && stepFrom.getY() == stepTo.getY());
    }

    public boolean isPathClear(Tile stepFrom, int x, int y, Board board) {
        int xDir = x > stepFrom.getX() ? 1 : -1;
        int yDir = y > stepFrom.getY() ? 1 : -1;

        if (Math.abs(x - stepFrom.getX()) == Math.abs(y - stepFrom.getY())) {
            // moving diagonally
            for (int i = 1; i < Math.abs(x - stepFrom.getX()); i++) {
                if (board.getTile(stepFrom.getX() + i * xDir, stepFrom.getY() + i * yDir).getPiece() != null) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String getName() {
        return "Bishop";
    }

}