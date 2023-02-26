package inf.unideb.hu.chessgame.state.board.boardimpl;

import inf.unideb.hu.chessgame.state.pieces.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Tile {
    private int x;
    private int y;
    private Piece piece;
    private List<Tile> triedTiles = new ArrayList<>();

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

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Tile)) {
            return false;
        }

        Tile other = (Tile) obj;

        return this.x == other.x &&
                this.y == other.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, piece, triedTiles);
    }


    public List<Tile> getTriedTiles() {
        return triedTiles;
    }

    public void setTriedTiles(List<Tile> triedTiles) {
       this.triedTiles = new ArrayList<>(triedTiles);
    }

    public void addTileToTriedTiles(Tile tile){
        this.triedTiles.add(tile);
    }

}