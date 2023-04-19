package inf.unideb.hu.chessgame.state.pieces.piecesimpl;

import inf.unideb.hu.chessgame.state.board.Board;
import inf.unideb.hu.chessgame.state.board.boardimpl.Tile;

/**
 * Ez az osztály a Futó figura kódbeli reprezentációja.
 */
public class Bishop extends ChessPiece {

    /**
     * Kiszámolja, hogy egy mező léphető-e a Futó szabályai alapján: az adott mezőről, az adott táblaállapotban.
     * @param stepFrom Ahonnan lépni szeretnénk a figurával.
     * @param stepTo Ahova lépni szeretnénk a figurával.
     * @param board A játéktábla.
     * @return true, ha megfelel a lépési szabályoknak, false, ha nem.
     */
    @Override
    protected boolean isValidSpecialMove(Tile stepFrom, Tile stepTo, Board board) {
        return isPathClear(stepFrom, stepTo.getX(), stepTo.getY(), board)
                && Math.abs(stepTo.getX() - stepFrom.getX()) == Math.abs(stepTo.getY() - stepFrom.getY())
                && !(stepFrom.getX() == stepTo.getX() && stepFrom.getY() == stepTo.getY());
    }

    /**
     * Megvizsgálja, hogy tiszta-e a célmezőig vezető út a Futó számára egy adott lépésnél.
     * @param stepFrom Ahonnan lépni szeretnénk a figurával.
     * @param x Ahova lépni szeretnénk a figurával (x koordináta).
     * @param y Ahova lépni szeretnénk a figurával (y koordináta).
     * @param board A játéktábla.
     * @return true, ha tiszta az út, false, ha valami az útjában áll.
     */
    public boolean isPathClear(Tile stepFrom, int x, int y, Board board) {
        int xDir = x > stepFrom.getX() ? 1 : -1;
        int yDir = y > stepFrom.getY() ? 1 : -1;

        if (Math.abs(x - stepFrom.getX()) == Math.abs(y - stepFrom.getY())) {
            for (int i = 1; i < Math.abs(x - stepFrom.getX()); i++) {
                if (board.getTile(stepFrom.getX() + i * xDir, stepFrom.getY() + i * yDir).getPiece() != null) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Visszaadja a Futó hivatalos (angol) nevét.
     * @return A figura neve.
     */
    @Override
    public String getName() {
        return "Bishop";
    }

}