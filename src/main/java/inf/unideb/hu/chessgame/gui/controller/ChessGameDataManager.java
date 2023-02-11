package inf.unideb.hu.chessgame.gui.controller;

import inf.unideb.hu.chessgame.state.board.Board;
import inf.unideb.hu.chessgame.state.board.boardimpl.SimpleBoard;

public class ChessGameDataManager {
    private static ChessGameDataManager instance;
    private Board gameBoard = new SimpleBoard();
    private String level = "";

    private ChessGameDataManager() {}

    public static ChessGameDataManager getInstance() {
        if (instance == null) {
            instance = new ChessGameDataManager();
        }
        return instance;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Board getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(Board gameBoard) {
        this.gameBoard = gameBoard;
    }
}
