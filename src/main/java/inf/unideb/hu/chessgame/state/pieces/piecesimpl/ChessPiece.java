package inf.unideb.hu.chessgame.state.pieces.piecesimpl;

import inf.unideb.hu.chessgame.state.board.Board;
import inf.unideb.hu.chessgame.state.board.boardimpl.Tile;
import inf.unideb.hu.chessgame.state.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

/**
 * Egy általános sakkfigura viselkedését fogalmazza meg.
 */
public abstract class ChessPiece implements Piece {

    /**
     * A figura, a tábla egyik mezőjéről a másikra való mozgatásáért felelős metódus.
     * @param stepFrom Ahonnan mozgatni szeretnénk a figurát.
     * @param stepTo Ahova mozgatni szeretnénk a figurát.
     * @param board A játéktábla.
     */
    @Override
    public void move(Tile stepFrom, Tile stepTo, Board board) {
        if (isValidMove(stepFrom, stepTo, board)){
            board.removePiece(stepFrom);
            board.removePiece(stepTo);
            board.placePiece(stepTo,this);
        }
    }

    /**
     * Visszaadja egy adott figura lehetséges lépéseinek listáját egy adott mezőről, az adott táblaállapotban.
     * @param stepFrom Az adott mező.
     * @param board Az adott táblaállapot.
     * @return A lehetséges mezők/lépések listája.
     */
    @Override
    public List<Tile> getPossibleMoves(Tile stepFrom, Board board) {
        List<Tile> possibleTiles = new ArrayList<>();

        for (int i=0; i<board.getSize(); i++){
            for (int j=0; j<board.getSize(); j++){
                if (isValidMove(stepFrom, board.getTile(i, j), board)){
                    possibleTiles.add(board.getTile(i, j));
                }
            }
        }

        return possibleTiles;
    }

    /**
     * Visszaadja, hogy egy adott mező léphető-e a figura által.
     * A játék szabályai alapján figyelembe veszi a tábla méretét + hogy foglalt-e a célmező.
     * @param stepFrom Ahonnan lépni szeretnénk a figurával.
     * @param stepTo Ahova lépni szeretnénk a figurával.
     * @param board A játéktábla.
     * @return true, ha léphető, false, ha nem
     */
    @Override
    public boolean isValidMove(Tile stepFrom, Tile stepTo, Board board) {
        if(stepTo.getX()< board.getSize() && stepTo.getX()>= 0 && stepTo.getY()< board.getSize() && stepTo.getY()>=0  && isValidSpecialMove(stepFrom, stepTo, board)) {
            if (board.isOccupied(stepTo)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Kiszámolja, hogy a figura specialitása alapján léphető-e egy mező számára. (Pl.: Huszár esetén L alakú lépés)
     * Ezt kell felülírniuk a speciális figuráknak a saját mozgásformájuk alapján.
     * @param stepFrom Ahonnan lépni szeretnénk a figurával.
     * @param stepTo Ahova lépni szeretnénk a figurával.
     * @param board A játéktábla.
     * @return true, ha léphető a szabályok alapján, false, ha nem.
     */
    protected abstract boolean isValidSpecialMove(Tile stepFrom, Tile stepTo, Board board);

    /**
     * Visszaadja Stringként a speciális figura nevét.
     * Felül kell írni az alosztályokban a saját nevük alapján.
     * @return A figura neve.
     */
    @Override
    public abstract String getName();

    /**
     * Két figura összehasonlítására alkalmas metódus.
     * @param obj
     * @return true, ha ugyanaz, false, ha nem.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof ChessPiece)) {
            return false;
        }

        ChessPiece other = (ChessPiece) obj;

        return this.getName().equals(other.getName());
    }
}