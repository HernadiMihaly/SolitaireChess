package inf.unideb.hu.chessgame.gui;

import inf.unideb.hu.chessgame.state.ai.Btracking;
import inf.unideb.hu.chessgame.state.board.Board;
import inf.unideb.hu.chessgame.state.board.boardimpl.SimpleBoard;
import javafx.application.Application;
import org.tinylog.Logger;

import java.util.*;

/**
 * A program indításáért felelős fő/main osztály.
 */
public class Main {
    public static void main(String[] args){

        Logger.debug("Application starts..");
        Application.launch(SolitaireChessApplication.class, args);
        Logger.debug("Application closed!");

    }
}
