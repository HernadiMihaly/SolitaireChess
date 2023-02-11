package inf.unideb.hu.chessgame.state.board.boardimpl;

import inf.unideb.hu.chessgame.state.board.Board;
import inf.unideb.hu.chessgame.state.pieces.Piece;
import inf.unideb.hu.chessgame.state.pieces.piecesimpl.*;

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

            if (x >= 0 && x < getSize() && y >= 0 && y < getSize()
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

        @Override
        public Board setBoardFromString(String boardRepresentation) {
            String[] rows = boardRepresentation.split("\n");
            for (int i = 0; i < getSize(); i++) {
                String[] columns = rows[i].split(",");
                for (int j = 0; j < getSize(); j++) {
                    String pieceName = columns[j].trim();
                    if (!pieceName.equals("(" + i + "," + j + ")")) {
                        Piece piece = null;
                        switch (pieceName) {
                            case "Knight":
                                piece = new Knight(tiles[i][j]);
                                break;
                            case "Rook":
                                piece = new Rook(tiles[i][j]);
                                break;
                            case "Bishop":
                                piece = new Bishop(tiles[i][j]);
                                break;
                            case "Pawn":
                                piece = new Pawn(tiles[i][j]);
                                break;
                            case "Queen":
                                piece = new Queen(tiles[i][j]);
                                break;
                            case "King":
                                piece = new King(tiles[i][j]);
                                break;
                            default:
                                break;
                        }
                        if (piece != null) {
                            tiles[i][j].setPiece(piece);
                        }
                    }
                }
            }
            return this;
        }

    @Override
    public int getSize() {
        return tiles.length;
    }
}