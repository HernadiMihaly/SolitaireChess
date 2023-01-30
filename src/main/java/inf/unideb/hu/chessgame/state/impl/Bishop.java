package inf.unideb.hu.chessgame.state.impl;

import inf.unideb.hu.chessgame.state.Board;
import inf.unideb.hu.chessgame.state.Piece;

public class Bishop implements Piece {
    private Tile tile;

    public Bishop(Tile tile) {
        this.tile = tile;
    }

    public Bishop(){}

    @Override
    public boolean isValidMove(Tile tile, Board board) {
        int x= tile.getX();
        int y= tile.getY();

        if(x<4 && x>= 0 && y<4 && y>=0  && isPathClear(x, y, board)
                && Math.abs(x - this.getTile().getX()) == Math.abs(y - this.getTile().getY())) {
            if (board.isOccupied(x, y)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getName() {
        return "Bishop";
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

    public boolean isPathClear(int x, int y, Board board) {
            // moving diagonally
            int xdir = x > this.tile.getX() ? 1 : -1;
            int ydir = y > this.tile.getY() ? 1 : -1;
            for (int i = 1; i < Math.abs(x - this.tile.getX()); i++) {
                if (board.getTile(this.tile.getX() + i * xdir, this.tile.getY() + i * ydir).getPiece() != null) {

                    return false;
                }
            }
        return true;
    }
}
