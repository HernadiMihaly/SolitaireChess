package inf.unideb.hu.chessgame.gui.controller;

import inf.unideb.hu.chessgame.state.board.Board;
import inf.unideb.hu.chessgame.state.pieces.Piece;
import inf.unideb.hu.chessgame.state.board.boardimpl.Tile;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class GameController extends BaseController {
    private static Board board;
    private Button[][] buttons;
    private Piece selectedPiece;
    private List<Tile> possibleMoves;
    String level = ChessGameDataManager.getInstance().getLevel();

    @FXML
    GridPane gridPane;
    @FXML
    Text winText;

    @FXML
    public void initialize() {
        buttons = new Button[board.getSize()][board.getSize()];
        refreshBoard();
    }

    public void startGame(Board board, javafx.scene.input.MouseEvent event) throws IOException {
        this.board = board;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/game.fxml")));
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void btnBackClicked(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        String fileName = String.format("/fxml/%s.fxml", level);
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fileName)));
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void refreshBoard(){
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                representTileWithButton(i, j);
            }
        }
    }

    public boolean isWon(){
        return board.getNumberOfPieces() == 1;
    }

    private void representTileWithButton(int i, int j){
        Button button = new Button();
        button.setPrefSize(60, 60);
        placeTile(new Tile(i, j), button);
        placePiece(new Tile(i, j), button);
        gridPane.add(button, j, i);
        buttons[i][j] = button;
    }

    public void placeTile(Tile tile, Button button){
        if ((tile.getX() + tile.getY()) % 2 == 0) {
            changeBackground("images/LightTile.png", button);
        } else {
            changeBackground("images/DarkTile.png", button);
        }
    }

    private void placePiece(Tile tile, Button button){
        Piece piece = board.getTile(tile.getX(), tile.getY()).getPiece();
        if (piece != null) {
            setPiece(new Tile(tile.getX(), tile.getY()), piece, button);
        }
    }

    private void setPiece(Tile tile, Piece piece, Button button){
        if ((tile.getX() + tile.getY()) % 2 == 0) {
            setLightPiece(piece, button);
        } else {
            setDarkPiece(piece, button);
        }

        button.setOnAction(e -> buttonClicked(tile.getX(), tile.getY()));
    }

    public void setLightPiece(Piece piece, Button button){
        switch(piece.getName()) {
            case "King":
                changeBackground("images/LightKing.png", button);
                break;
            case "Queen":
                changeBackground("images/LightQueen.png", button);
                break;
            case "Bishop":
                changeBackground("images/LightBishop.png", button);
                break;
            case "Rook":
                changeBackground("images/LightRook.png", button);
                break;
            case "Pawn":
                changeBackground("images/LightPawn.png", button);
                break;
            case "Knight":
                changeBackground("images/LightKnight.png", button);
                break;
        }
    }

    public void setDarkPiece(Piece piece, Button button){
        switch(piece.getName()) {
            case "King":
                changeBackground("images/DarkKing.png", button);
                break;
            case "Queen":
                changeBackground("images/DarkQueen.png", button);
                break;
            case "Bishop":
                changeBackground("images/DarkBishop.png", button);
                break;
            case "Rook":
                changeBackground("images/DarkRook.png", button);
                break;
            case "Pawn":
                changeBackground("images/DarkPawn.png", button);
                break;
            case "Knight":
                changeBackground("images/DarkKnight.png", button);
                break;
        }
    }

    public void changeBackground(String path, Button button){
        BackgroundImage backgroundImage = new BackgroundImage(new Image(path),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);

        button.setBackground(new Background(backgroundImage));
    }

    private void buttonClicked(int x, int y){
        if (selectedPiece == null) {
            selectPiece(x, y);
        } else {
            movePiece(x, y);
        }
    }

    private void selectPiece(int x, int y) {
        Piece piece = board.getTile(x, y).getPiece();

        if (piece == null) {
            return;
        }

        selectedPiece = piece;

        possibleMoves = selectedPiece.getPossibleMoves(board.getTile(x, y), board);

        if (!possibleMoves.isEmpty()) {
            for (Tile tile : possibleMoves) {
                Button button = buttons[tile.getX()][tile.getY()];
                button.setStyle("-fx-border-color: darkred; -fx-border-width: 2");
            }
        } else {
            selectedPiece = null;
            return;
        }
    }

    private void movePiece(int x, int y){
        Tile selectedTile = new Tile(x, y);
        selectedPiece.move(getCurrentTile(), selectedTile, board);
        refreshBoard();
        selectedPiece = null;
        possibleMoves = null;
        displayWinStatus();
    }

    private Tile getCurrentTile(){
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                if (board.getTile(i, j).getPiece() == selectedPiece){
                    return new Tile(i, j);
                }
            }
        }
        return null;
    }

    private void displayWinStatus(){
        if (isWon()) {
            winText.setText("You Win!");
            winText.setFill(Color.DARKBLUE);
            winText.setFont(Font.font("Impact", FontWeight.BOLD, 40));
        }
    }
}