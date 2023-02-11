package inf.unideb.hu.chessgame.state.pieces.piecesimpl;

import inf.unideb.hu.chessgame.state.board.Board;
import inf.unideb.hu.chessgame.state.board.boardimpl.Tile;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends ChessPiece {

    public Bishop(Tile tile) {
        super(tile);
    }

    @Override
    public boolean isValidMove(Tile tile, Board board) {
        int x= tile.getX();
        int y= tile.getY();

        if(x< board.getSize() && x>= 0 && y< board.getSize() && y>=0  && isPathClear(x, y, board)
                && Math.abs(x - getTile().getX()) == Math.abs(y - getTile().getY())
                && !(getTile().getX() == x && getTile().getY() == y)) {
            if (board.isOccupied(x, y)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Tile> getPossibleMoves(Board board) {
        List<Tile> possibleTiles = new ArrayList<>();

        for (int i=0; i< board.getSize(); i++){
            for (int j=0; j< board.getSize(); j++){
                if (isValidMove(board.getTile(i, j), board)){
                    possibleTiles.add(board.getTile(i, j));
                }
            }
        }

        return possibleTiles;
    }

    public boolean isPathClear(int x, int y, Board board) {
        int xDir = x > getTile().getX() ? 1 : -1;
        int yDir = y > getTile().getY() ? 1 : -1;

        if (Math.abs(x - getTile().getX()) == Math.abs(y - getTile().getY())) {
            // moving diagonally
            for (int i = 1; i < Math.abs(x - getTile().getX()); i++) {
                if (board.getTile(getTile().getX() + i * xDir, getTile().getY() + i * yDir).getPiece() != null) {
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
