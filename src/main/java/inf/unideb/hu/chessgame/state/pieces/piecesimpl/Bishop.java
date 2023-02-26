package inf.unideb.hu.chessgame.state.pieces.piecesimpl;

import inf.unideb.hu.chessgame.state.board.Board;
import inf.unideb.hu.chessgame.state.board.boardimpl.Tile;

public class Bishop extends ChessPiece {

    @Override
    public boolean isValidMove(Tile stepFrom, Tile stepTo, Board board) {
        int x= stepTo.getX();
        int y= stepTo.getY();

        if(x< board.getSize() && x>= 0 && y< board.getSize() && y>=0  && isPathClear(stepFrom, x, y, board)
                && Math.abs(x - stepFrom.getX()) == Math.abs(y - stepFrom.getY())
                && !(stepFrom.getX() == x && stepFrom.getY() == y)) {
            if (board.isOccupied(x, y)) {
                return true;
            }
        }
        return false;
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