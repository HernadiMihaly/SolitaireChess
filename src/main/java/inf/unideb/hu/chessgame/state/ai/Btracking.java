package inf.unideb.hu.chessgame.state.ai;

import inf.unideb.hu.chessgame.state.board.Board;
import inf.unideb.hu.chessgame.state.board.boardimpl.Tile;

public class Btracking extends Search {

    public Btracking(Board board) {
        //kezdőállapot átadása
        super(board);
    }

    public void findPieceThatCanMove() {
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

}