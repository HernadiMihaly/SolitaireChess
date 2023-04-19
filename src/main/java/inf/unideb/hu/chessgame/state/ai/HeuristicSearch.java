package inf.unideb.hu.chessgame.state.ai;

import inf.unideb.hu.chessgame.state.board.Board;
import inf.unideb.hu.chessgame.state.board.boardimpl.Tile;

import java.util.*;

/**
 * Ez az osztály a visszalépéses keresést egy heurisztika alkalmazásával valósítja meg.
 * Mindig a legtöbb lépési lehetőséggel rendelkező figurát választja mozgatásra.
 */
public class HeuristicSearch extends Search {

    public HeuristicSearch(Board board) {
        super(board);
    }

    /**
     * Megkeresi az összes figurát amelyik lépni tud az adott állapotban, majd lép a legnagyobb lépési lehetőséggel rendelkezővel.
     * Ha nincs ilyen, akkor visszalép az előző állapotba.
     */
    public void findPieceThatCanMove() {
        PriorityQueue<Tile> movablePieces = new PriorityQueue<>(
                Comparator.comparingInt(o -> -evaluation(o)));

        addAllMovablePieces(movablePieces);

        movePieceWithBiggestValue(movablePieces);

        if (!isWon()) {
            backTrack();
        }
    }

    private void addAllMovablePieces(PriorityQueue<Tile> movablePieces) {
        for (int x = 0; x < board.getSize(); x++) {
            for (int y = 0; y < board.getSize(); y++) {
                if (isWon()) return;

                Tile currentTile = board.getTile(x, y);
                if (!board.isOccupied(currentTile)
                        || currentTile.getPiece().getPossibleMoves(currentTile, board).isEmpty()
                        || currentTile.getPiece().getPossibleMoves(currentTile, board).size() ==
                        boardStates.lastElement().getTile(x, y).getTriedTiles().size()) {
                    continue;
                }

                movablePieces.add(currentTile);
            }
        }
    }

    private void movePieceWithBiggestValue(PriorityQueue<Tile> movablePieces){
        for (Tile tile : movablePieces) {
            this.tile = tile;
            possibleMoves = tile.getPiece().getPossibleMoves(tile, board);

            removeTriedTilesFromPossibleSteps();

            processMovement();

            if (isWon()) return;
        }
    }

    private int evaluation(Tile tile) {
        return tile.getPiece().getPossibleMoves(tile, board).size();
    }
}