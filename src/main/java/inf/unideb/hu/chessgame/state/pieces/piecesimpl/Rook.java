package inf.unideb.hu.chessgame.state.pieces.piecesimpl;

import inf.unideb.hu.chessgame.state.board.Board;
import inf.unideb.hu.chessgame.state.board.boardimpl.Tile;

import java.util.ArrayList;
import java.util.List;

public class Rook extends ChessPiece {
    public Rook(Tile tile) {
        super(tile);
    }

    @Override
    public boolean isValidMove(Tile tile, Board board) {
        int x= tile.getX();
        int y= tile.getY();

        if(x<4 && x>= 0 && y<4 && y>=0
                && isPathClear(x, y, board)
                && (x == super.getTile().getX() || y == getTile().getY())
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
