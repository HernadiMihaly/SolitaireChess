package inf.unideb.hu.chessgame.state.pieces.piecesimpl;

import inf.unideb.hu.chessgame.state.board.Board;
import inf.unideb.hu.chessgame.state.board.boardimpl.Tile;

public class Rook extends ChessPiece {
    @Override
    protected boolean isValidSpecialMove(Tile stepFrom, Tile stepTo, Board board) {
        return isPathClear(stepFrom, stepTo.getX(), stepTo.getY(), board)
                && (stepTo.getX() == stepFrom.getX() || stepTo.getY() == stepFrom.getY())
                && !(stepFrom.getX() == stepTo.getX() && stepFrom.getY() == stepTo.getY());
    }

    public boolean isPathClear(Tile stepFrom, int destX, int destY, Board board) {
        int minX = Math.min(destX, stepFrom.getX());
        int maxX = Math.max(destX, stepFrom.getX());
        int minY = Math.min(destY, stepFrom.getY());
        int maxY = Math.max(destY, stepFrom.getY());

        if (destX == stepFrom.getX()) {
            // moving vertically
            for (int i = minY + 1; i < maxY; i++) {
                if (board.getTile(destX, i).getPiece() != null) {
                    return false;
                }
            }
        } else if (destY == stepFrom.getY()) {
            // moving horizontally
            for (int i = minX + 1; i < maxX; i++) {
                if (board.getTile(i, destY).getPiece() != null) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    @Override
    public String getName() {
        return "Rook";
    }

}