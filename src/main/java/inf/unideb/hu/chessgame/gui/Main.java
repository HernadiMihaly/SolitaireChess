package inf.unideb.hu.chessgame.gui;

import javafx.application.Application;

public class Main {
    /*
    Az alkalmazás indításáért felelős metódus. Futtatás előtt a heap-et bővíteni kell, mivel sok a lépés az expert szinten, így StackOverflowError lesz.
    */
    public static void main(String[] args){
        Application.launch(SolitaireChessApplication.class, args);
    }
}
