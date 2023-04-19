package inf.unideb.hu.chessgame.state.pieces.piecesimpl;

import inf.unideb.hu.chessgame.state.board.Board;
import inf.unideb.hu.chessgame.state.board.boardimpl.Tile;

/**
 * Ez az osztály a Gyalog/Paraszt figura kódbeli reprezentációja.
 */
public class Pawn extends ChessPiece {

    /**
     * Kiszámolja, hogy egy mező léphető-e a Gyalog szabályai alapján: az adott mezőről, az adott táblaállapotban.
     * @param stepFrom Ahonnan lépni szeretnénk a figurával.
     * @param stepTo Ahova lépni szeretnénk a figurával.
     * @param board A játéktábla.
     * @return true, ha megfelel a lépési szabályoknak, false, ha nem.
     */
    @Override
    protected boolean isValidSpecialMove(Tile stepFrom, Tile stepTo, Board board) {
        return stepTo.getX() == stepFrom.getX()-1
                && (stepTo.getY() == stepFrom.getY()-1 || stepTo.getY() == stepFrom.getY()+1);
    }

    /**
     * Visszaadja a Gyalog hivatalos (angol) nevét.
     * @return A figura neve.
     */
    @Override
    public String getName() {
        return "Pawn";
    }

}