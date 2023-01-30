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
                Bishop bishop = new Bishop(new Tile(0, 1));
                Queen queen = new Queen(new Tile(1, 2));
                Bishop bishop2= new Bishop(new Tile(2, 3));
                Rook rook = new Rook(new Tile(3, 0));

                board.placePiece(bishop);
                board.placePiece(queen);
                board.placePiece(bishop2);
                board.placePiece(rook);

                break;
            }
            case "Pane[id=2]": {
                Knight knight = new Knight(new Tile(0, 2));
                Bishop bishop = new Bishop(new Tile(1, 0));
                Pawn pawn = new Pawn(new Tile(2, 1));
                Rook rook = new Rook(new Tile(3, 2));

                board.placePiece(knight);
                board.placePiece(bishop);
                board.placePiece(pawn);
                board.placePiece(rook);

                break;
            }

            case "Pane[id=3]": {
                Queen queen = new Queen(new Tile(0, 0));
                Rook rook = new Rook(new Tile(0, 2));
                Knight knight = new Knight(new Tile(2, 1));
                Pawn pawn = new Pawn(new Tile(3, 0));

                board.placePiece(queen);
                board.placePiece(rook);
                board.placePiece(knight);
                board.placePiece(pawn);

                break;
            }
            case "Pane[id=4]":{
                Knight knight1 = new Knight(new Tile(0, 1));
                Queen queen = new Queen(new Tile(1, 3));
                Pawn pawn = new Pawn(new Tile(3, 0));
                Knight knight2 = new Knight(new Tile(2, 2));

                board.placePiece(knight1);
                board.placePiece(queen);
                board.placePiece(knight2);
                board.placePiece(pawn);

                break;
            }

            case "Pane[id=5]":{
                Bishop bishop = new Bishop(new Tile(0, 1));
                Queen queen = new Queen(new Tile(1, 1));
                Pawn pawn = new Pawn(new Tile(2, 0));
                King king = new King(new Tile(2, 2));

                board.placePiece(bishop);
                board.placePiece(queen);
                board.placePiece(pawn);
                board.placePiece(king);

                break;
            }

            case "Pane[id=6]":{
                Rook rook1 = new Rook(new Tile(1, 0));
                Knight knight1 = new Knight(new Tile(1, 3));
                Bishop bishop = new Bishop(new Tile(2, 1));
                Knight knight2 = new Knight(new Tile(2, 2));
                Rook rook2 = new Rook(new Tile(3, 0));

                board.placePiece(rook1);
                board.placePiece(knight1);
                board.placePiece(bishop);
                board.placePiece(knight2);
                board.placePiece(rook2);

                break;
            }

            case "Pane[id=7]":{
                Bishop bishop = new Bishop(new Tile(0, 3));
                Pawn pawn1 = new Pawn(new Tile(1, 2));
                Pawn pawn2 = new Pawn(new Tile(2, 3));
                Rook rook = new Rook(new Tile(3, 0));
                Knight knight = new Knight(new Tile(3, 1));

                board.placePiece(bishop);
                board.placePiece(pawn1);
                board.placePiece(pawn2);
                board.placePiece(rook);
                board.placePiece(knight);

                break;
            }

            case "Pane[id=8]":{
                Bishop bishop1 = new Bishop(new Tile(0, 1));
                Queen queen = new Queen(new Tile(1, 1));
                Bishop bishop2 = new Bishop(new Tile(1, 2));
                Knight knight1 = new Knight(new Tile(1, 3));
                Knight knight2 = new Knight(new Tile(3, 0));

                board.placePiece(bishop1);
                board.placePiece(queen);
                board.placePiece(bishop2);
                board.placePiece(knight1);
                board.placePiece(knight2);

                break;
            }

            case "Pane[id=9]":{
                Rook rook1 = new Rook(new Tile(0, 1));
                Knight knight1 = new Knight(new Tile(0, 3));
                Knight knight2 = new Knight(new Tile(1, 1));
                Pawn pawn = new Pawn(new Tile(2, 0));
                Rook rook2 = new Rook(new Tile(2, 2));

                board.placePiece(rook1);
                board.placePiece(knight1);
                board.placePiece(knight2);
                board.placePiece(pawn);
                board.placePiece(rook2);

                break;
            }

            case "Pane[id=10]":{
                Bishop bishop = new Bishop(new Tile(0, 2));
                Queen queen = new Queen(new Tile(1, 1));
                Rook rook = new Rook(new Tile(1, 3));
                Knight knight2 = new Knight(new Tile(3, 0));
                Knight knight1 = new Knight(new Tile(2, 1));

                board.placePiece(bishop);
                board.placePiece(queen);
                board.placePiece(rook);
                board.placePiece(knight1);
                board.placePiece(knight2);

                break;
            }
        }
        gameController.startGame(board, mouseEvent);
    }
}