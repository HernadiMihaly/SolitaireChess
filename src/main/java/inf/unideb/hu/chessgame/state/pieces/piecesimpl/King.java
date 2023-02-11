package inf.unideb.hu.chessgame.state.pieces.piecesimpl;

import inf.unideb.hu.chessgame.state.board.Board;
import inf.unideb.hu.chessgame.state.board.boardimpl.Tile;

import java.util.ArrayList;
import java.util.List;

public class King extends ChessPiece {

    public King(Tile tile) {
        super(tile);
    }

    @Override
    public boolean isValidMove(Tile tile, Board board) {
        int x= tile.getX();
        int y= tile.getY();

        if(x<4 && x>= 0 && y<4 && y>=0
                && (Math.abs(x - getTile().getX()) <= 1) && (Math.abs(y - getTile().getY()) <= 1)
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

    @Override
    public String getName() {
        return "King";
    }
}
