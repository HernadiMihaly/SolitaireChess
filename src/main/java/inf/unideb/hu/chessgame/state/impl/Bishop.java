package inf.unideb.hu.chessgame.state.impl;

import inf.unideb.hu.chessgame.state.Board;
import inf.unideb.hu.chessgame.state.Piece;

import java.util.ArrayList;
import java.util.List;

public class Bishop implements Piece {
    private Tile tile;

    public Bishop(Tile tile) {
        this.tile = tile;
    }

    @Override
    public boolean isValidMove(Tile tile, Board board) {
        int x= tile.getX();
        int y= tile.getY();

        if(x< board.getSize() && x>= 0 && y< board.getSize() && y>=0  && isPathClear(x, y, board)
                && Math.abs(x - this.getTile().getX()) == Math.abs(y - this.getTile().getY())
                && !(this.getTile().getX() == x && this.tile.getY() == y)) {
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
        int xDir = x > this.tile.getX() ? 1 : -1;
        int yDir = y > this.tile.getY() ? 1 : -1;

        if (Math.abs(x - this.tile.getX()) == Math.abs(y - this.tile.getY())) {
            // moving diagonally
            for (int i = 1; i < Math.abs(x - this.tile.getX()); i++) {
                if (board.getTile(this.tile.getX() + i * xDir, this.tile.getY() + i * yDir).getPiece() != null) {
                    return false;
                }
            }
        }
        return true;
    }

}
