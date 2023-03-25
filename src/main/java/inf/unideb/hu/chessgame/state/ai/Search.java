package inf.unideb.hu.chessgame.state.ai;

import inf.unideb.hu.chessgame.state.board.Board;
import inf.unideb.hu.chessgame.state.board.boardimpl.Tile;

import java.util.*;

public abstract class Search {
    protected Tile tile;
    protected Board board;
    protected final Stack<Board> boardStates = new Stack<>();
    protected List<Tile> possibleMoves = new ArrayList<>();
    protected int counter = 0;

    protected Search(Board board) {
        this.board = board;
    }

    public int getCounter() {
        return counter;
    }

    public List<Board> solve() {
        counter++;
        if (boardStates.isEmpty()) {
            addBoardState();
        }
        findPieceThatCanMove();
        return boardStates;
    }

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

    protected void removeTriedTilesFromPossibleSteps() {
        List<Tile> triedTilesList = boardStates.lastElement().getTile(tile.getX(), tile.getY()).getTriedTiles();

        if (!triedTilesList.isEmpty()) {
            possibleMoves.removeAll(triedTilesList);
        }
    }

    protected boolean isWon() {
        return (board.getNumberOfPieces() == 1);
    }

    protected void addBoardState() {
        clearTriedTiles();
        Board board1 = board.clone();
        boolean isBoardInStack = false;

        if (!boardStates.isEmpty()) {
            for (Board boardState : boardStates) {
                if (boardState.toString().equals(board1.toString())) {
                    isBoardInStack = true;
                    break;
                }
            }
            if (!isBoardInStack) {
                boardStates.push(board1);
            }
        } else {
            boardStates.push(board1);
        }

    }

    protected void backTrack() {
        boardStates.pop();
        board = boardStates.lastElement().clone();
        solve();
    }

    protected void clearTriedTiles() {
        Arrays.stream(board.getTiles())
                .flatMap(Arrays::stream)
                .filter(tile -> !tile.getTriedTiles().isEmpty())
                .forEach(tile -> tile.getTriedTiles().clear());
    }

    protected abstract void findPieceThatCanMove();

}
