package inf.unideb.hu.chessgame.state.board.boardimpl;

import inf.unideb.hu.chessgame.state.pieces.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Ez az osztály a SolitaireChess játéktábláinak egy mezőjét reprezentálja.
 */
public class Tile {
    private int x;
    private int y;
    private Piece piece;
    private List<Tile> triedTiles = new ArrayList<>();

    /**
     * Konstruktor, amelyen keresztül megadható a mező x és y koordinátája.
     * @param x koordináta.
     * @param y koordináta.
     */
    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Visszaadja a mező x koordinátáját.
     * @return x koordináta.
     */
    public int getX() {
        return x;
    }

    /**
     * Visszaadja a mező y koordinátáját.
     * @return y koordináta.
     */
    public int getY() {
        return y;
    }

    /**
     * Visszaadja a mezőn álló figurát.
     * @return A mezőn álló figura (Piece).
     */
    public Piece getPiece() {
        return piece;
    }

    /**
     * Ezzel a metódussal állítható a mezőre egy figura. Beállítja a piece tulajdonságát.
     * @param piece A figura.
     */
    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    /**
     * Két mező összehasonlítására alkalmas metódus.
     * @param obj
     * @return igaz, ha ugyanaz, hamis, ha nem.
     */
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

    /**
     * Visszaadja a mezőről már próbált lépések (másik mezők) listáját.
     * @return A próbált lépések listája.
     */
    public List<Tile> getTriedTiles() {
        return triedTiles;
    }

    /**
     * A mezőről már próbált lépések/mezők listáját fogadja, amit feljegyez.
     * @param triedTiles A próbált mezők listája.
     */
    public void setTriedTiles(List<Tile> triedTiles) {
       this.triedTiles = new ArrayList<>(triedTiles);
    }

    /**
     * Hozzáad egy darab próbált mezőt a próbált mezők listájához.
     * @param tile A próbált mező.
     */
    public void addTileToTriedTiles(Tile tile){
        this.triedTiles.add(tile);
    }
}