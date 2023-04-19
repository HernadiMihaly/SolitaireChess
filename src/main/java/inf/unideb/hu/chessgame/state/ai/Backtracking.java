package inf.unideb.hu.chessgame.state.ai;

import inf.unideb.hu.chessgame.state.board.Board;
import inf.unideb.hu.chessgame.state.board.boardimpl.Tile;

/**
 * Ez az osztály a visszalépéses keresés megvalósítására szolgál.
 */
public class Backtracking extends Search {

    public Backtracking(Board board) {
        super(board);
    }

    /**
     * Megkeresi a legelső figurát amely lépni tud, majd lép vele. Ha nincs ilyen, akkor visszalép.
     */
    public void findPieceThatCanMove() {
        for (int x = 0; x < board.getSize(); x++) {
            for (int y = 0; y < board.getSize(); y++) {
                if (isWon()) return;

                if (!board.isOccupied(board.getTile(x, y))
                        || board.getTile(x, y).getPiece().getPossibleMoves(new Tile(x, y), board).isEmpty()
                        || board.getTile(x, y).getPiece()
                        .getPossibleMoves(new Tile(x, y), board).size() == boardStates.lastElement().getTile(x, y).getTriedTiles().size())
                {
                    continue;
                }

                tile = board.getTile(x, y);
                possibleMoves = tile.getPiece().getPossibleMoves(tile, board);

                removeTriedTilesFromPossibleSteps();

                processMovement();
            }
        }

        if (!isWon()) {
            backTrack();
        }
    }
}