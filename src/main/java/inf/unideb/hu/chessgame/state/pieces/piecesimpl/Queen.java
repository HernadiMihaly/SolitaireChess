package inf.unideb.hu.chessgame.state.pieces.piecesimpl;

import inf.unideb.hu.chessgame.state.board.Board;
import inf.unideb.hu.chessgame.state.board.boardimpl.Tile;

public class Queen extends ChessPiece {

    @Override
    public boolean isValidMove(Tile stepFrom, Tile stepTo, Board board) {
        int x= stepTo.getX();
        int y= stepTo.getY();

        if(x<4 && x>= 0 && y<4 && y>=0 && isPathClear(stepFrom, x, y, board)
                && (Math.abs(x - stepFrom.getX()) == Math.abs(y - stepFrom.getY())
                || x == stepFrom.getX() || y == stepFrom.getY())
                && !(stepFrom.getX() == x && stepFrom.getY() == y)) {
            if(board.isOccupied(x, y)) {
                return true;
            }
        }
        return false;
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
        } else if (Math.abs(destX - stepFrom.getX()) == Math.abs(destY - stepFrom.getY())) {
            // moving diagonally
            int xDir = destX > stepFrom.getX() ? 1 : -1;
            int yDir = destY > stepFrom.getY() ? 1 : -1;
            for (int i = 1; i < Math.abs(destX - stepFrom.getX()); i++) {
                if (board.getTile(stepFrom.getX() + i * xDir, stepFrom.getY() + i * yDir).getPiece() != null) {
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
        return "Queen";
    }

}