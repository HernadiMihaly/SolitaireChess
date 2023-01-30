package inf.unideb.hu.chessgame.state.impl;

import inf.unideb.hu.chessgame.state.Board;
import inf.unideb.hu.chessgame.state.Piece;

import java.util.List;

public class SimpleBoard implements Board {
        private Tile[][] tiles;

        public SimpleBoard() {
            tiles = new Tile[4][4];
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    tiles[i][j] = new Tile(i, j);
                }
            }
        }

        @Override
        public Tile getTile(int x, int y) {
            return tiles[x][y];
        }

        @Override
        public void placePiece(Piece piece) {
            int x= piece.getTile().getX();
            int y= piece.getTile().getY();

            if (x >= 0 && x < 4 && y >= 0 && y < 4
                && !isOccupied(x, y))
            tiles[x][y]
                    .setPiece(piece);
        }

        @Override
        public void removePiece(Tile tile) {
            int x= tile.getX();
            int y= tile.getY();

            if (isOccupied(x, y)) {
                tiles[x][y].setPiece(null);
            }
        }

        @Override
        public boolean isOccupied(int x, int y) {
            return tiles[x][y].getPiece() != null;
        }
}