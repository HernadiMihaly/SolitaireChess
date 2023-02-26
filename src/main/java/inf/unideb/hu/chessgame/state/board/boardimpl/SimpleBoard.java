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
        public void placePiece(Tile placeTo, Piece piece) {
            int x= placeTo.getX();
            int y= placeTo.getY();

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
                                piece = new Knight();
                                tiles[i][j].setPiece(piece);
                                break;
                            case "Rook":
                                piece = new Rook();
                                tiles[i][j].setPiece(piece);
                                break;
                            case "Bishop":
                                piece = new Bishop();
                                tiles[i][j].setPiece(piece);
                                break;
                            case "Pawn":
                                piece = new Pawn();
                                tiles[i][j].setPiece(piece);
                                break;
                            case "Queen":
                                piece = new Queen();
                                tiles[i][j].setPiece(piece);
                                break;
                            case "King":
                                piece = new King();
                                tiles[i][j].setPiece(piece);
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
    public int getNumberOfPieces() {
        int count = 0;
        for (int x = 0; x < getSize(); x++) {
            for (int y = 0; y < getSize(); y++) {
                if (isOccupied(x, y)) {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public int getSize() {
        return tiles.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("   ");
        for (int i = 0; i < getSize(); i++) {
            sb.append("+---");
        }
        sb.append("+\n");

        for (int i = 0; i < getSize(); i++) {
            sb.append(" " + (getSize() - i) + " ");
            for (int j = 0; j < getSize(); j++) {
                sb.append("| ");
                if (tiles[i][j].getPiece() == null) {
                    sb.append("  ");
                } else {
                    Piece piece = tiles[i][j].getPiece();
                    sb.append(piece.getName().substring(0, 2));
                }
                sb.append(" ");
            }
            sb.append("| " + (getSize() - i) + "\n");
            sb.append("   ");
            for (int j = 0; j < getSize(); j++) {
                sb.append("+---");
            }
            sb.append("+\n");
        }

        sb.append("   ");
        for (int i = 0; i < getSize(); i++) {
            sb.append(" " + (char)('a' + i) + "  ");
        }
        sb.append("\n");

        return sb.toString();
    }

    @Override
    public SimpleBoard clone() {
        SimpleBoard clonedBoard = new SimpleBoard();
        for (int i = 0; i < getSize(); i++) {
            for (int j = 0; j < getSize(); j++) {
                Tile originalTile = tiles[i][j];
                Tile clonedTile = new Tile(originalTile.getX(), originalTile.getY());
                clonedTile.setTriedTiles(originalTile.getTriedTiles());
                if (originalTile.getPiece() != null) {
                    Piece originalPiece = originalTile.getPiece();
                    Piece clonedPiece = null;
                    if (originalPiece instanceof Knight) {
                        clonedPiece = new Knight();
                    } else if (originalPiece instanceof Rook) {
                        clonedPiece = new Rook();
                    } else if (originalPiece instanceof Bishop) {
                        clonedPiece = new Bishop();
                    } else if (originalPiece instanceof Pawn) {
                        clonedPiece = new Pawn();
                    } else if (originalPiece instanceof Queen) {
                        clonedPiece = new Queen();
                    } else if (originalPiece instanceof King) {
                        clonedPiece = new King();
                    }
                    clonedTile.setPiece(clonedPiece);
                }
                clonedBoard.tiles[i][j] = clonedTile;
            }
        }

        return clonedBoard;
    }

    @Override
    public Tile[][] getTiles() {
        return tiles;
    }
}