package inf.unideb.hu.chessgame.state.pieces.piecesimpl;

import inf.unideb.hu.chessgame.state.board.Board;
import inf.unideb.hu.chessgame.state.board.boardimpl.Tile;

/**
 * Ez az osztály a Király figura kódbeli reprezentációja.
 */
public class King extends ChessPiece {

    /**
     * Kiszámolja, hogy egy mező léphető-e a Király szabályai alapján: az adott mezőről, az adott táblaállapotban.
     * @param stepFrom Ahonnan lépni szeretnénk a figurával.
     * @param stepTo Ahova lépni szeretnénk a figurával.
     * @param board A játéktábla.
     * @return true, ha megfelel a lépési szabályoknak, false, ha nem.
     */
    @Override
    protected boolean isValidSpecialMove(Tile stepFrom, Tile stepTo, Board board) {
        return (Math.abs(stepTo.getX() - stepFrom.getX()) <= 1) && (Math.abs(stepTo.getY() - stepFrom.getY()) <= 1)
                && !(stepFrom.getX() == stepTo.getX() && stepFrom.getY() == stepTo.getY());
    }

    /**
     * Visszaadja a Király hivatalos (angol) nevét.
     * @return A figura neve.
     */
    @Override
    public String getName() {
        return "King";
    }

}
