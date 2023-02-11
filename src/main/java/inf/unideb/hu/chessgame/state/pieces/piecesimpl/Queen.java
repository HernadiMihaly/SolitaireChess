package inf.unideb.hu.chessgame.state.pieces.piecesimpl;

import inf.unideb.hu.chessgame.state.board.Board;
import inf.unideb.hu.chessgame.state.board.boardimpl.Tile;

import java.util.ArrayList;
import java.util.List;

public class Queen extends ChessPiece {
    public Queen(Tile tile) {
        super(tile);
    }

    @Override
    public boolean isValidMove(Tile tile, Board board) {
        int x= tile.getX();
        int y= tile.getY();

        if(x<4 && x>= 0 && y<4 && y>=0 && isPathClear(x, y, board)
                && (Math.abs(x - getTile().getX()) == Math.abs(y - getTile().getY())
                || x == getTile().getX() || y == getTile().getY())
                && !(this.getTile().getX() == x && getTile().getY() == y)) {
            if(board.isOccupied(x, y)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Tile> getPossibleMoves(Board board) {
        List<Tile> possibleTiles = new ArrayList<>();

        for (int i=0; i<4; i++){
            for (int j=0; j<4; j++){
                if (isValidMove(board.getTile(i, j), board)){
                    possibleTiles.add(board.getTile(i, j));
                }
            }
        }

        return possibleTiles;
    }

    public boolean isPathClear(int destX, int destY, Board board) {
        int min = Math.min(destY, getTile().getY());
        int max = Math.max(destY, getTile().getY());
        if (destX == getTile().getX()) {
            // moving horizontally
            for (int i = min + 1; i < max; i++) {
                if (board.getTile(destX, i).getPiece() != null) {
                    return false;
                }
            }
        } else if (destY == getTile().getY()) {
            // moving vertically
            for (int i = min + 1; i < max; i++) {
                if (board.getTile(i, destY).getPiece() != null) {
                    return false;
                }
            }
        } else if (Math.abs(destX - getTile().getX()) == Math.abs(destY - getTile().getY())) {
            // moving diagonally
            int xDir = destX > getTile().getX() ? 1 : -1;
            int yDir = destY > getTile().getY() ? 1 : -1;
            for (int i = 1; i < Math.abs(destX - getTile().getX()); i++) {
                if (board.getTile(getTile().getX() + i * xDir, getTile().getY() + i * yDir).getPiece() != null) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String getName() {
        return "Queen";
    }
}