package inf.unideb.hu.chessgame.state.ai;

import inf.unideb.hu.chessgame.state.board.Board;
import inf.unideb.hu.chessgame.state.board.boardimpl.Tile;

import java.util.*;

/**
 * A visszalépéses keresések absztrakt ősosztálya.
 */
public abstract class Search {
    protected Tile tile;
    protected Board board;
    protected final Stack<Board> boardStates = new Stack<>();
    protected List<Tile> possibleMoves = new ArrayList<>();
    public int counter = 0;

    /**
     * A keresés konstruktora, ezen keresztül kaphatja meg az adott algoritmus a kezdőállapot táblát.
     * @param board A kezdőállapot
     */
    protected Search(Board board) {
        this.board = board;
    }

    /**
     * Ez a metódus végzi a megoldás keresését.
     * @return A megoldásig vezető táblák listáját (a célállapotig vezető ágat a keresési fában).
     */
    public List<Board> solve() {
        counter++;
        if (boardStates.isEmpty()) {
            addBoardState();
        }
        findPieceThatCanMove();
        return boardStates;
    }

    /**
     * Ez a metódus végzi az adott figura mozgatását.
     * Hozzáadja a csomópontok Stackjéhez a kialakult állapotot.
     */
    protected void processMovement() {
        for (Tile destTile : possibleMoves) {
            tile.getPiece().move(tile, destTile, board);
            boardStates.lastElement().getTile(tile.getX(), tile.getY())
                    .addTileToTriedTiles(destTile);
            addBoardState();
            solve();
            break;
        }
    }

    /**
     * Eltávolítja az adott figura összes olyan lépési lehetőségét, amelyet az adott állapotban már kipróbált.
     */
    protected void removeTriedTilesFromPossibleSteps() {
        List<Tile> triedTilesList = boardStates.lastElement().getTile(tile.getX(), tile.getY()).getTriedTiles();

        if (!triedTilesList.isEmpty()) {
            possibleMoves.removeAll(triedTilesList);
        }
    }

    /**
     * Megvizsgálja, hogy nyertes állapotban vagyunk-e.
     * @return true, ha igen, false, ha nem.
     */
    protected boolean isWon() {
        return (board.getNumberOfPieces() == 1);
    }

    /**
     * Hozzáadja az adott, kialakult táblaállapotot a Stack-hez (verem).
     */
    protected void addBoardState() {
        clearTriedTiles();
        Board board1 = board.clone();
        boardStates.push(board1);
    }

    /**
     * Ez a metódus végzi a visszalépést. Eltávolítja a verem legfelső elemét, majd beállítja az előző állapotot a jelenleginek.
     */
    protected void backTrack() {
        boardStates.pop();
        board = boardStates.lastElement().clone();
        solve();
    }

    /**
     * Eltávolítja az összes korábban feljegyzett próbálkozást egy adott táblaállapotból.
     */
    protected void clearTriedTiles() {
        Arrays.stream(board.getTiles())
                .flatMap(Arrays::stream)
                .filter(tile -> !tile.getTriedTiles().isEmpty())
                .forEach(tile -> tile.getTriedTiles().clear());
    }

    /**
     * Ez a metódus határozza meg, hogy melyik figurával történjen az adott állapotban a lépés.
     * Ezt írják felül a speciális osztályok.
     */
    protected abstract void findPieceThatCanMove();

}