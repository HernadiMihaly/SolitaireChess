package inf.unideb.hu.chessgame.state.ai;

import inf.unideb.hu.chessgame.state.board.Board;
import inf.unideb.hu.chessgame.state.board.boardimpl.Tile;

import java.util.*;

public class HeuristicSearch extends Search {

    public HeuristicSearch(Board board) {
        super(board);
    }

    public void findPieceThatCanMove() {
        PriorityQueue<Tile> movablePieces = new PriorityQueue<>(
                Comparator.comparingInt(o -> -evaluation(o)));

        // Find all movable pieces and add them to the priority queue
        addAllMovablePieces(movablePieces);

        // Move the piece that can attack the most number of pieces
        movePieceWithBiggestValue(movablePieces);

        // If no movable pieces are found and game is not won, backtrack
        if (!isWon()) {
            backTrack();
        }
    }

    private void addAllMovablePieces(PriorityQueue<Tile> movablePieces) {
        for (int x = 0; x < board.getSize(); x++) {
            for (int y = 0; y < board.getSize(); y++) {
                if (isWon()) return;

                Tile currentTile = board.getTile(x, y);
                if (!board.isOccupied(x, y)
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
            //if (isWon()) return;

            this.tile = tile;
            possibleMoves = tile.getPiece().getPossibleMoves(tile, board);

            removeTriedTilesFromPossibleSteps();

            // Move the piece that can attack the most number of pieces
            processMovement();

            if (isWon()) return;
        }
    }

    private int evaluation(Tile tile) {
        // Evaluate how many places a piece can move to in the current state
        return tile.getPiece().getPossibleMoves(tile, board).size();
    }
}
