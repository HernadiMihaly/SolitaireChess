package inf.unideb.hu.chessgame.state.impl;

import inf.unideb.hu.chessgame.state.Piece;

public class Tile {
    private int x;
    private int y;
    private Piece piece;

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}