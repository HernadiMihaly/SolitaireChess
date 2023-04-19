package inf.unideb.hu.chessgame.state.pieces.piecesimpl;

import inf.unideb.hu.chessgame.state.board.Board;
import inf.unideb.hu.chessgame.state.board.boardimpl.Tile;

/**
 * Ez az osztály a Vezér/Királynő figura kódbeli reprezentációja.
 */
public class Queen extends ChessPiece {

    /**
     * Kiszámolja, hogy egy mező léphető-e a Vezér (Királynő) szabályai alapján: az adott mezőről, az adott táblaállapotban.
     * @param stepFrom Ahonnan lépni szeretnénk a figurával.
     * @param stepTo Ahova lépni szeretnénk a figurával.
     * @param board A játéktábla.
     * @return true, ha megfelel a lépési szabályoknak, false, ha nem.
     */
    @Override
    protected boolean isValidSpecialMove(Tile stepFrom, Tile stepTo, Board board) {
        return isPathClear(stepFrom, stepTo.getX(), stepTo.getY(), board)
                && (Math.abs(stepTo.getX() - stepFrom.getX()) == Math.abs(stepTo.getY() - stepFrom.getY())
                || stepTo.getX() == stepFrom.getX() || stepTo.getY() == stepFrom.getY())
                && !(stepFrom.getX() == stepTo.getX() && stepFrom.getY() == stepTo.getY());
    }

    /**
     * Megvizsgálja, hogy tiszta-e a célmezőig vezető út a Királynő számára egy adott lépésnél.
     * @param stepFrom Ahonnan lépni szeretnénk a figurával.
     * @param destX Ahova lépni szeretnénk a figurával (x koordináta).
     * @param destY Ahova lépni szeretnénk a figurával (y koordináta).
     * @param board A játéktábla.
     * @return true, ha tiszta az út, false, ha valami az útjában áll.
     */
    public boolean isPathClear(Tile stepFrom, int destX, int destY, Board board) {
        int minX = Math.min(destX, stepFrom.getX());
        int maxX = Math.max(destX, stepFrom.getX());
        int minY = Math.min(destY, stepFrom.getY());
        int maxY = Math.max(destY, stepFrom.getY());

        if (destX == stepFrom.getX()) {
            // vertikális mozgás
            for (int i = minY + 1; i < maxY; i++) {
                if (board.getTile(destX, i).getPiece() != null) {
                    return false;
                }
            }
        } else if (destY == stepFrom.getY()) {
            // horizontális mozgás
            for (int i = minX + 1; i < maxX; i++) {
                if (board.getTile(i, destY).getPiece() != null) {
                    return false;
                }
            }
        } else if (Math.abs(destX - stepFrom.getX()) == Math.abs(destY - stepFrom.getY())) {
            // átlós mozgás
            int xDir = destX > stepFrom.getX() ? 1 : -1;
            int yDir = destY > stepFrom.getY() ? 1 : -1;
            for (int i = 1; i < Math.abs(destX - stepFrom.getX()); i++) {
                if (board.getTile(stepFrom.getX() + i * xDir, stepFrom.getY() + i * yDir).getPiece() != null) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    /**
     * Visszaadja a Királynő hivatalos (angol) nevét.
     * @return A figura neve.
     */
    @Override
    public String getName() {
        return "Queen";
    }

}