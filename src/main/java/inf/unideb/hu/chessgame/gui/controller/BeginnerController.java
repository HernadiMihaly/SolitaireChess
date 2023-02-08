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

public class BeginnerController {
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
                String boardRepresentation = "[ x, Bishop, x, x\n" +
                                            " x, x, Queen, x\n" +
                                            " x, x, x, Bishop\n" +
                                            " Rook, x, x, x\n" +
                                            "]";
                board.setBoardFromString(boardRepresentation);

                break;
            }
            case "Pane[id=2]": {
                String boardRepresentation = " x, x, Knight, x\n" +
                                            " Bishop, x, x, x\n" +
                                            " x, Pawn, x, x\n" +
                                            " x, x, Rook, x\n";
                board.setBoardFromString(boardRepresentation);

                break;
            }

            case "Pane[id=3]": {
                String boardRepresentation = " Queen, x, Rook, x\n" +
                        " x, x, x, x\n" +
                        " x, Knight, x, x\n" +
                        " Pawn, x, x, x\n";
                board.setBoardFromString(boardRepresentation);

                break;
            }
            case "Pane[id=4]":{
                String boardRepresentation = " x, Knight, x, x\n" +
                        " x, x, x, Queen\n" +
                        " x, x, Knight, x\n" +
                        " Pawn, x, x, x\n";
                board.setBoardFromString(boardRepresentation);

                break;
            }

            case "Pane[id=5]":{
                String boardRepresentation = " x, Bishop, x, x\n" +
                                            " x, Queen, x, x\n" +
                                            " Pawn, x, King, x\n" +
                                            " x, x, x, x\n";
                board.setBoardFromString(boardRepresentation);

                break;
            }

            case "Pane[id=6]":{
                String boardRepresentation = " x, x, x, x\n" +
                                            " Rook, x, x, Knight\n" +
                                            " x, Bishop, Knight, x\n" +
                                            " Rook, x, x, x\n";
                board.setBoardFromString(boardRepresentation);

                break;
            }

            case "Pane[id=7]":{
                String boardRepresentation =
                                            " x, x, x, Bishop\n" +
                                            " x, x, Pawn, x\n" +
                                            " x, x, x, Pawn\n" +
                                            " Rook, Knight, x, x\n";
                board.setBoardFromString(boardRepresentation);

                break;
            }

            case "Pane[id=8]":{
                String boardRepresentation =
                                            " x, Bishop, x, x\n" +
                                            " x, Queen, Bishop, Knight\n" +
                                            " x, x, x, x\n" +
                                            " Knight, x, x, x\n";
                board.setBoardFromString(boardRepresentation);

                break;
            }

            case "Pane[id=9]":{
                String boardRepresentation =
                                " x, Rook, x, Knight\n" +
                                " x, Knight, x, x\n" +
                                " Pawn, x, Rook, x\n" +
                                " x, x, x, x\n";
                board.setBoardFromString(boardRepresentation);

                break;
            }

            case "Pane[id=10]":{
                String boardRepresentation =
                                " x, x, Bishop, x\n" +
                                " x, Queen, x, Rook\n" +
                                " x, Knight, x, x\n" +
                                " Knight, x, x, x\n";
                board.setBoardFromString(boardRepresentation);

                break;

            }
        }
        gameController.startGame(board, mouseEvent);
    }
}