package inf.unideb.hu.chessgame.gui.controller;

import inf.unideb.hu.chessgame.state.Board;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class GameController {
    private static Board board;

    @FXML
    public void initialize() {
        for (int i = 0; i < 4; i++) {
            System.out.println();
            for (int j = 0; j < 4; j++) {
                if (this.board.getTile(i, j).getPiece() != null)
                    System.out.print(this.board.getTile(i, j).getPiece().getName() + " ");
                else {
                    System.out.print("(" + i + "," + j + ")" + " ");
                }
            }
        }
        System.out.println();
    }

    public void startGame(Board board, javafx.scene.input.MouseEvent event) throws IOException {
        this.board = board;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/game.fxml")));
        stage.setScene(new Scene(root));
        stage.show();
    }

}