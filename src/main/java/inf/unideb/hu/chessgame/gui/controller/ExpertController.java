package inf.unideb.hu.chessgame.gui.controller;

import inf.unideb.hu.chessgame.state.Board;
import inf.unideb.hu.chessgame.state.impl.SimpleBoard;
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

public class ExpertController {
    GameController gameController = new GameController();

    @FXML
    public void btnExitClicked(ActionEvent actionEvent) {
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
                                " x, Knight, Knight, x\n" +
                                " x, Rook, Rook, x\n" +
                                " Pawn, x, x, Bishop\n" +
                                " Pawn, x, x, Bishop\n";
                board.setBoardFromString(boardRepresentation);

                break;
            }
            case "Pane[id=2]": {
                String boardRepresentation =
                                " x, x, Pawn, x\n" +
                                " x, Rook, Rook, x\n" +
                                " Knight, Knight, x, x\n" +
                                " Bishop, Pawn, x, Bishop\n";
                board.setBoardFromString(boardRepresentation);

                break;
            }

            case "Pane[id=3]": {
                String boardRepresentation =
                                " x, x, x, Rook\n" +
                                " Rook, Bishop, Pawn, x\n" +
                                " King, x, x, x\n" +
                                " Knight, Pawn, Bishop, x\n";
                board.setBoardFromString(boardRepresentation);

                break;
            }
            case "Pane[id=4]":{
                String boardRepresentation =
                                " x, Bishop, Knight, Knight\n" +
                                " x, Bishop, Pawn, Pawn\n" +
                                " x, Rook, x, x\n" +
                                " Rook, x, x, x\n";
                board.setBoardFromString(boardRepresentation);

                break;
            }

            case "Pane[id=5]":{
                String boardRepresentation =
                                " x, Pawn, Knight, x\n" +
                                " x, Pawn, Knight, x\n" +
                                " Bishop, x, x, Bishop\n" +
                                " Rook, x, x, Rook\n";
                board.setBoardFromString(boardRepresentation);

                break;
            }

            case "Pane[id=6]":{
                String boardRepresentation =
                                " x, Knight, Bishop, Knight\n" +
                                " x, Bishop, Pawn, Rook\n" +
                                " x, x, x, Pawn\n" +
                                " Rook, x, x, x\n";
                board.setBoardFromString(boardRepresentation);

                break;
            }

            case "Pane[id=7]":{
                String boardRepresentation =
                                " x, x, x, Rook\n" +
                                " Bishop, x, Pawn, x\n" +
                                " Bishop, Rook, Knight, x\n" +
                                " x, Knight, Pawn, x\n";
                board.setBoardFromString(boardRepresentation);

                break;
            }

            case "Pane[id=8]":{
                String boardRepresentation =
                                " x, x, Knight, Bishop\n" +
                                " x, Bishop, Pawn, Knight\n" +
                                " x, Rook, Pawn, x\n" +
                                " Rook, x, x, x\n";
                board.setBoardFromString(boardRepresentation);

                break;
            }

            case "Pane[id=9]":{
                String boardRepresentation =
                                " x, Rook, Pawn, x\n" +
                                " Bishop, Rook, x, Pawn\n" +
                                " Knight, Bishop, x, x\n" +
                                " Knight, x, x, x\n";
                board.setBoardFromString(boardRepresentation);

                break;
            }

            case "Pane[id=10]":{
                String boardRepresentation =
                                " x, Knight, Bishop, x\n" +
                                " x, x, Bishop, Pawn\n" +
                                " Rook, Rook, x, Pawn\n" +
                                " Knight, x, x, x\n";
                board.setBoardFromString(boardRepresentation);

                break;
            }
        }
        gameController.startGame(board, mouseEvent);
    }
}
