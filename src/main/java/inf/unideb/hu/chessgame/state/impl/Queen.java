package inf.unideb.hu.chessgame.state.impl;

import inf.unideb.hu.chessgame.state.Board;
import inf.unideb.hu.chessgame.state.Piece;

public class Queen implements Piece {
    private Tile tile;

    public Queen(Tile tile) {
        this.tile = tile;
    }

    public Queen() {
    }

    @Override
    public boolean isValidMove(Tile tile, Board board) {
        int x= tile.getX();
        int y= tile.getY();

        if(x<4 && x>= 0 && y<4 && y>=0 && isPathClear(x, y, board)
                && (Math.abs(x - this.tile.getX()) == Math.abs(y - this.tile.getY())
                || x == this.tile.getX() || y == this.tile.getY())) {
            if(board.isOccupied(x, y)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getName() {
        return "Queen";
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

    @Override
    public void setTile(Tile tile) {
        this.tile = tile;
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
        } else if (Math.abs(destX - this.tile.getX()) == Math.abs(destY - this.tile.getY())) {
            // moving diagonally
            int xdir = destX > this.tile.getX() ? 1 : -1;
            int ydir = destY > this.tile.getY() ? 1 : -1;
            for (int i = 1; i < Math.abs(destX - this.tile.getX()); i++) {
                if (board.getTile(this.tile.getX() + i * xdir, this.tile.getY() + i * ydir).getPiece() != null) {
                    return false;
                }
            }
        }
        return true;
    }
}
