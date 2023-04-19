package inf.unideb.hu.chessgame.state.pieces.piecesimpl;

import inf.unideb.hu.chessgame.state.board.Board;
import inf.unideb.hu.chessgame.state.board.boardimpl.Tile;

/**
 * Ez az osztály a Huszár/Ló figura kódbeli reprezentációja.
 */
public class Knight extends ChessPiece {

    /**
     * Kiszámolja, hogy egy mező léphető-e a Huszár szabályai alapján: az adott mezőről, az adott táblaállapotban.
     * @param stepFrom Ahonnan lépni szeretnénk a figurával.
     * @param stepTo Ahova lépni szeretnénk a figurával.
     * @param board A játéktábla.
     * @return true, ha megfelel a lépési szabályoknak, false, ha nem.
     */
    @Override
    protected boolean isValidSpecialMove(Tile stepFrom, Tile stepTo, Board board) {
        int x= stepTo.getX();
        int y= stepTo.getY();
        return ((x == stepFrom.getX() + 1 && y == stepFrom.getY() + 2) ||
                (x == stepFrom.getX() + 1 && y == stepFrom.getY() - 2) ||
                (x == stepFrom.getX() - 1 && y == stepFrom.getY() + 2) ||
                (x == stepFrom.getX() - 1 && y == stepFrom.getY() - 2) ||
                (x == stepFrom.getX() + 2 && y == stepFrom.getY() + 1) ||
                (x == stepFrom.getX() + 2 && y == stepFrom.getY() - 1) ||
                (x == stepFrom.getX() - 2 && y == stepFrom.getY() + 1) ||
                (x == stepFrom.getX() - 2 && y == stepFrom.getY() - 1));
    }

    /**
     * Visszaadja a Huszár hivatalos (angol) nevét.
     * @return A figura neve.
     */
    @Override
    public String getName() {
        return "Knight";
    }

}