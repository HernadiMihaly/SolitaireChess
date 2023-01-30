package inf.unideb.hu.chessgame.state.impl;

import inf.unideb.hu.chessgame.state.Board;
import inf.unideb.hu.chessgame.state.Piece;

public class Rook implements Piece {
    public Rook(Tile tile) {
        this.tile = tile;
    }

    public Rook() {
    }

    private Tile tile;


    @Override
    public boolean isValidMove(Tile tile, Board board) {
        int x= tile.getX();
        int y= tile.getY();

        if(x<4 && x>= 0 && y<4 && y>=0
                && isPathClear(x, y, board)
                && (x == this.tile.getX() || y == this.tile.getY())) {
            if (board.isOccupied(x, y)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getName() {
        return "Rook";
    }

    @Override
    public void setTile(Tile tile) {
        this.tile = tile;
    }

    @Override
    public void move(Tile tile, Board board) {
        if (isValidMove(tile, board)){
            board.removePiece(this.tile);
            board.removePiece(tile);
            this.tile = tile;
            board.placePiece(this);
        }
        else {System.out.println("not valid move");}
    }

    @Override
    public Tile getTile() {
        return tile;
    }

    public boolean isPathClear(int destX, int destY, Board board) {
        if (destX == this.tile.getX()) {
            // moving horizontally
            int min = Math.min(destY, this.tile.getY());
            int max = Math.max(destY, this.tile.getY());
            for (int i = min + 1; i < max; i++) {
                if (board.getTile(destX, i).getPiece() != null) {
                    return false;
                }
            }
        } else if (destY == this.tile.getY()) {
            // moving vertically
            int min = Math.min(destX, this.tile.getX());
            int max = Math.max(destX, this.tile.getX());
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
}
