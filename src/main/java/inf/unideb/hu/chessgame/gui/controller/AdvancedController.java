package inf.unideb.hu.chessgame.gui.controller;

import inf.unideb.hu.chessgame.state.Board;
import inf.unideb.hu.chessgame.state.impl.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class AdvancedController {
    GameController gameController = new GameController();

    @FXML
    public void btnExitClicked() {
        Platform.exit();
    }

    @FXML
    void btnBackClicked(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/levels.fxml")));
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    public void onBoardSelected(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        Board board = new SimpleBoard();

        switch (mouseEvent.getSource().toString()) {
            case "Pane[id=1]": {
                String boardRepresentation =
                                " Rook, x, x, x\n" +
                                " x, Pawn, Knight, Bishop\n" +
                                " x, x, Pawn, Rook\n" +
                                " Bishop, x, x, x\n";
                board.setBoardFromString(boardRepresentation);

                break;
            }
            case "Pane[id=2]": {
                String boardRepresentation =
                                " x, x, Bishop, x\n" +
                                " x, Bishop, King, x\n" +
                                " Knight, Knight, x, Pawn\n" +
                                " Pawn, x, x, x\n";
                board.setBoardFromString(boardRepresentation);

                break;
            }

            case "Pane[id=3]": {
                String boardRepresentation =
                                " x, x, x, Rook\n" +
                                " x, Rook, Pawn, x\n" +
                                " Bishop, x, x, Knight\n" +
                                " x, Pawn, Bishop, x\n";
                board.setBoardFromString(boardRepresentation);

                break;
            }
            case "Pane[id=4]":{
                String boardRepresentation =
                                " x, x, Rook, Bishop\n" +
                                " x, x, x, Pawn\n" +
                                " Bishop, Knight, x, x\n" +
                                " Pawn, x, Rook, x\n";
                board.setBoardFromString(boardRepresentation);

                break;
            }

            case "Pane[id=5]":{
                String boardRepresentation =
                                " x, x, x, Bishop\n" +
                                " x, x, x, Rook\n" +
                                " Rook, Knight, Knight, x\n" +
                                " Pawn, Pawn, x, x\n";
                board.setBoardFromString(boardRepresentation);

                break;
            }

            case "Pane[id=6]":{
                String boardRepresentation =
                                " x, x, Knight, Bishop\n" +
                                " x, Knight, x, Pawn\n" +
                                " Pawn, Rook, x, x\n" +
                                " Bishop, x, x, x\n";
                board.setBoardFromString(boardRepresentation);

                break;
            }

            case "Pane[id=7]":{
                String boardRepresentation =
                                " x, Knight, Knight, x\n" +
                                " Pawn, x, Rook, Pawn\n" +
                                " x, x, x, Bishop\n" +
                                " Bishop, x, x, x\n";
                board.setBoardFromString(boardRepresentation);

                break;
            }

            case "Pane[id=8]":{
                String boardRepresentation =
                                " x, x, Bishop, Rook\n" +
                                " x, x, Pawn, Knight\n" +
                                " Bishop, Pawn, x, x\n" +
                                " Rook, x, x, x\n";
                board.setBoardFromString(boardRepresentation);

                break;
            }

            case "Pane[id=9]":{
                String boardRepresentation =
                                " x, x, Rook, x\n" +
                                " Rook, x, x, Pawn\n" +
                                " x, Bishop, King, x\n" +
                                " Pawn, x, x, Bishop\n";
                board.setBoardFromString(boardRepresentation);

                break;
            }

            case "Pane[id=10]":{
                String boardRepresentation =
                                " x, x, Bishop, Knight\n" +
                                " x, Rook, Bishop, Pawn\n" +
                                " Knight, x, x, x\n" +
                                " x, Pawn, x, x\n";
                board.setBoardFromString(boardRepresentation);

                break;
            }
        }
        gameController.startGame(board, mouseEvent);
    }
}
