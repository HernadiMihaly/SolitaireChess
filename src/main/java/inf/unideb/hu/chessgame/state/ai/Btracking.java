package inf.unideb.hu.chessgame.state.ai;

import inf.unideb.hu.chessgame.state.board.Board;
import inf.unideb.hu.chessgame.state.board.boardimpl.Tile;

import java.util.*;

public class Btracking {
    private Tile tile;
    private List<Tile> possibleMoves;
    private Board board;
    private final Stack<Board> boardStates = new Stack<>();

    public Btracking(Board board) {
        //kezdőállapot átadása
        this.board = board;
    }

    public List<Board> solve() {
        if (boardStates.isEmpty()) {
                addBoardState();
        }
        findPieceThatCanMove();
        return boardStates;
    }

    private boolean isWon() {
        return (board.getNumberOfPieces() == 1);
    }

    private void findPieceThatCanMove() {
        for (int x = 0; x < board.getSize(); x++) {
            for (int y = 0; y < board.getSize(); y++) {
                if (isWon()) return;
                //keressük az első Piece-t ami tud lépni
                if (!board.isOccupied(x, y)
                        || board.getTile(x, y).getPiece().getPossibleMoves(new Tile(x, y), board).isEmpty()
                        || board.getTile(x, y).getPiece()
                        .getPossibleMoves(new Tile(x, y), board).size() == boardStates.lastElement().getTile(x, y).getTriedTiles().size())
                {
                    continue;
                }

                tile = board.getTile(x, y);
                possibleMoves = tile.getPiece().getPossibleMoves(tile, board);

                removeTriedTilesFromPossibleSteps();

                //lépünk
                processMovement();
            }
        }
        //ha nincs olyan Piece ami tud lépni és nem nyertünk még akkor visszalépünk
        if (!isWon()) {
            backTrack();
        }
    }

    private void processMovement(){
        for (Tile destTile : possibleMoves) {
            tile.getPiece().move(tile, destTile, board);
            boardStates.lastElement().getTile(tile.getX(), tile.getY())
                    .addTileToTriedTiles(destTile);
            addBoardState();
            solve();
            break;
        }
    }

    private void removeTriedTilesFromPossibleSteps(){
        List<Tile> triedTilesList = boardStates.lastElement().getTile(tile.getX(), tile.getY()).getTriedTiles();

        if (!triedTilesList.isEmpty()) {
            possibleMoves.removeAll(triedTilesList);
        }
    }

    public void addBoardState() {
        clearTriedTiles();
        Board board1 = board.clone();
        boolean isBoardInStack = false;

        if (!boardStates.isEmpty()){
            for (Board boardState : boardStates) {
                if (boardState.toString().equals(board1.toString())) {
                    isBoardInStack = true;
                    break;
                }
            }
            if (!isBoardInStack) {
                boardStates.push(board1);
            }
        } else{
            boardStates.push(board1);
        }

    }

    private void backTrack(){
        boardStates.pop();
        board = boardStates.lastElement().clone();
        solve();
    }

    private void clearTriedTiles() {
        Arrays.stream(board.getTiles())
                .flatMap(Arrays::stream)
                .filter(tile -> !tile.getTriedTiles().isEmpty())
                .forEach(tile -> tile.getTriedTiles().clear());
    }

}