package inf.unideb.hu.chessgame.state.impl;

import inf.unideb.hu.chessgame.state.Board;
import inf.unideb.hu.chessgame.state.Piece;

public class Knight implements Piece {
    private Tile tile;

    public Knight(Tile tile) {
        this.tile = tile;
    }

    public Knight() {
    }

    @Override
    public boolean isValidMove(Tile tile, Board board) {
        int x= tile.getX();
        int y= tile.getY();

        if (x<4 && x>= 0 && y<4 && y>=0 &&
                ((x == this.tile.getX() + 1 && y == this.tile.getY() + 2) ||
                (x == this.tile.getX() + 1 && y == this.tile.getY() - 2) ||
                (x == this.tile.getX() - 1 && y == this.tile.getY() + 2) ||
                (x == this.tile.getX() - 1 && y == this.tile.getY() - 2) ||
                (x == this.tile.getX() + 2 && y == this.tile.getY() + 1) ||
                (x == this.tile.getX() + 2 && y == this.tile.getY() - 1) ||
                (x == this.tile.getX() - 2 && y == this.tile.getY() + 1) ||
                (x == this.tile.getX() - 2 && y == this.tile.getY() - 1))) {
            if (board.isOccupied(x, y)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getName() {
        return "Knight";
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

}