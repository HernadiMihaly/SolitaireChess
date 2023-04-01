package inf.unideb.hu.chessgame.gui.controller;

import inf.unideb.hu.chessgame.state.ai.Backtracking;
import inf.unideb.hu.chessgame.state.ai.HeuristicSearch;
import inf.unideb.hu.chessgame.state.ai.Search;
import inf.unideb.hu.chessgame.state.board.Board;
import inf.unideb.hu.chessgame.state.board.boardimpl.Tile;
import inf.unideb.hu.chessgame.state.pieces.Piece;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class BacktrackingController extends BaseController{
    private static Board baseBoard;
    private static Search search;
    private static List<Board> solutions;

    private GameController gameController = new GameController();
    private Button[][] buttons;
    @FXML
    public GridPane gridPane;
    @FXML
    public Text winText;

    public void startGame(Board board, javafx.scene.input.MouseEvent event) throws IOException {
        this.baseBoard = board;
        if (ChessGameDataManager.getInstance().getLevel().equals("expert")){
            this.search = new HeuristicSearch(baseBoard);
        } else {
            this.search = new Backtracking(baseBoard);
        }
        this.solutions = search.solve();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/backtracking.fxml")));
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void btnBackClicked(ActionEvent event) throws IOException {
        gameController.btnBackClicked(event);
    }

    @FXML
    public void initialize() {
        buttons = new Button[baseBoard.getSize()][baseBoard.getSize()];

        Timeline timeline = new Timeline();
        int delay = 1500;

        for (int i = 0; i < solutions.size(); i++) {
            final int index = i;
            KeyFrame keyFrame = new KeyFrame(Duration.millis(delay * i), event -> {
                refreshBoard(solutions.get(index));
                if (index == solutions.size()-1){
                    displayWinStatus();
                }
            });
            timeline.getKeyFrames().add(keyFrame);
        }
        timeline.play();
    }

    public void refreshBoard(Board board) {
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                representTileWithButton(i, j, board);
            }
        }
    }

    private void representTileWithButton(int i, int j, Board board) {
        Button button = new Button();
        button.setPrefSize(60, 60);
        gameController.placeTile(new Tile(i, j), button);
        placePiece(new Tile(i, j), button, board);
        gridPane.add(button, j, i);
        buttons[i][j] = button;
    }

    private void placePiece(Tile tile, Button button, Board board){
        Piece piece = board.getTile(tile.getX(), tile.getY()).getPiece();
        if (piece != null) {
            setPiece(new Tile(tile.getX(), tile.getY()), piece, button);
        }
    }

    private void setPiece(Tile tile, Piece piece, Button button){
        if ((tile.getX() + tile.getY()) % 2 == 0) {
            gameController.setLightPiece(piece, button);
        } else {
            gameController.setDarkPiece(piece, button);
        }
    }

    private void displayWinStatus(){
        winText.setText("Problem solved!");
        winText.setFill(Color.DARKBLUE);
        winText.setFont(Font.font("Impact", FontWeight.BOLD, 35));
    }
}