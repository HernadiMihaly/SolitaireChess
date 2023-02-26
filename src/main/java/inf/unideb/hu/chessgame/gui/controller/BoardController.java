package inf.unideb.hu.chessgame.gui.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import inf.unideb.hu.chessgame.state.board.Board;
import inf.unideb.hu.chessgame.state.board.boardimpl.SimpleBoard;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Optional;

public class BoardController extends BaseController {
    GameController gameController = new GameController();
    BacktrackingController backtrackingController = new BacktrackingController();

    @FXML
    void btnBackClicked(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/levels.fxml")));
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    public void onBoardSelected(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("config/boards.json");

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(inputStream);

        String level = ChessGameDataManager.getInstance().getLevel();
        JsonNode levelNode = rootNode.path(level);

        String id = mouseEvent.getSource().toString().split("=")[1].replace("]", "");
        String boardRepresentation = levelNode.path(id).asText();

        Board board = new SimpleBoard().setBoardFromString(boardRepresentation);
        ChessGameDataManager.getInstance().setGameBoard(board);

        showPopUpMenu(board, mouseEvent);
    }

    private void showPopUpMenu(Board board, javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Select an Option");
        alert.setHeaderText(null);
        alert.setContentText("What do you want to do?");

        ButtonType solveItButton = new ButtonType("I want to solve it!");
        ButtonType aiSolveItButton = new ButtonType("I want AI to solve it!");
        ButtonType cancelButton = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(solveItButton, aiSolveItButton, cancelButton);

        Node cancelButtonNode = alert.getDialogPane().lookupButton(cancelButton);
        cancelButtonNode.setVisible(false);
        cancelButtonNode.setManaged(false);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent()) {
            if (result.get() == solveItButton) {
                gameController.startGame(board, mouseEvent);
            } else if (result.get() == aiSolveItButton) {
                backtrackingController.startGame(board, mouseEvent);
            }
        }

    }

}