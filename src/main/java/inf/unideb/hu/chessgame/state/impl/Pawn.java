package inf.unideb.hu.chessgame.state.impl;

import inf.unideb.hu.chessgame.state.Board;
import inf.unideb.hu.chessgame.state.Piece;

import java.util.ArrayList;
import java.util.List;

public class Pawn implements Piece {
    private Tile tile;

    public Pawn(Tile tile) {
        this.tile = tile;
    }

    @Override
    public boolean isValidMove(Tile tile, Board board) {
        int x= tile.getX();
        int y= tile.getY();

        if(x<4 && x>= 0 && y<4 && y>=0
                && x == this.getTile().getX()-1
                && (y == this.getTile().getY()-1 || y == this.getTile().getY()+1)) {
            if (board.isOccupied(x, y)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getName() {
        return "Pawn";
    }

    @Override
    public void setTile(Tile tile) {
        this.tile = tile;
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
}
