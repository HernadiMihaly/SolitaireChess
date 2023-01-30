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

        for (int i = 0; i < 4; i++) {
            System.out.println();
            for (int j = 0; j < 4; j++) {
                if (board.getTile(i, j).getPiece() != null)
                    System.out.print(board.getTile(i, j).getPiece().getName() + " ");
                else {
                    System.out.print("(" + i + "," + j + ")" + " ");
                }
            }
        }
        System.out.println();

        switch (mouseEvent.getSource().toString()) {
            case "Pane[id=1]": {
                Rook rook1 = new Rook(new Tile(0, 0));
                Pawn pawn1 = new Pawn(new Tile(1, 1));
                Knight knight = new Knight(new Tile(1, 2));
                Bishop bishop1 = new Bishop(new Tile(1, 3));
                Pawn pawn2 = new Pawn(new Tile(2, 2));
                Bishop bishop2= new Bishop(new Tile(3, 0));
                Rook rook2 = new Rook(new Tile(2, 3));

                board.placePiece(rook1);
                board.placePiece(pawn1);
                board.placePiece(knight);
                board.placePiece(bishop1);
                board.placePiece(pawn2);
                board.placePiece(rook2);
                board.placePiece(bishop2);

                break;
            }
            case "Pane[id=2]": {
                Bishop bishop1 = new Bishop(new Tile(0, 2));
                Bishop bishop2 = new Bishop(new Tile(1, 1));
                King king = new King(new Tile(1, 2));
                Knight knight1 = new Knight(new Tile(2, 0));
                Knight knight2 = new Knight(new Tile(2, 1));
                Pawn pawn2 = new Pawn(new Tile(3, 0));
                Pawn pawn1 = new Pawn(new Tile(2, 3));

                board.placePiece(bishop1);
                board.placePiece(bishop2);
                board.placePiece(king);
                board.placePiece(knight1);
                board.placePiece(knight2);
                board.placePiece(pawn1);
                board.placePiece(pawn2);

                break;
            }

            case "Pane[id=3]": {
                Rook rook1 = new Rook(new Tile(0, 3));
                Rook rook2 = new Rook(new Tile(1, 1));
                Pawn pawn1 = new Pawn(new Tile(1, 2));
                Bishop bishop1 = new Bishop(new Tile(2, 0));
                Knight knight = new Knight(new Tile(2, 3));
                Pawn pawn2 = new Pawn(new Tile(3, 1));
                Bishop bishop2 = new Bishop(new Tile(3, 2));

                board.placePiece(rook1);
                board.placePiece(rook2);
                board.placePiece(pawn1);
                board.placePiece(bishop1);
                board.placePiece(knight);
                board.placePiece(pawn2);
                board.placePiece(bishop2);

                break;
            }
            case "Pane[id=4]":{
                Rook rook1 = new Rook(new Tile(0, 2));
                Rook rook2 = new Rook(new Tile(1, 0));
                Pawn pawn = new Pawn(new Tile(1, 1));
                Bishop bishop1 = new Bishop(new Tile(2, 0));
                King king = new King(new Tile(2, 1));
                Bishop bishop2 = new Bishop(new Tile(3, 2));


                board.placePiece(rook1);
                board.placePiece(rook2);
                board.placePiece(pawn);
                board.placePiece(bishop1);
                board.placePiece(king);
                board.placePiece(bishop2);

                break;
            }

            case "Pane[id=5]":{
                Rook rook1 = new Rook(new Tile(0, 2));
                Knight knight1 = new Knight(new Tile(1, 0));
                Pawn pawn1 = new Pawn(new Tile(1, 3));
                Pawn pawn2 = new Pawn(new Tile(2, 2));
                Rook rook2 = new Rook(new Tile(3, 1));
                Knight knight2 = new Knight(new Tile(3, 0));

                board.placePiece(rook1);
                board.placePiece(knight1);
                board.placePiece(pawn1);
                board.placePiece(pawn2);
                board.placePiece(rook2);
                board.placePiece(knight2);

                break;
            }

            case "Pane[id=6]":{
                Knight knight1 = new Knight(new Tile(0, 1));
                Bishop bishop1 = new Bishop(new Tile(1, 1));
                Pawn pawn1 = new Pawn(new Tile(1, 2));
                Bishop bishop2 = new Bishop(new Tile(1, 3));
                Pawn pawn2 = new Pawn(new Tile(2, 0));
                Knight knight2 = new Knight(new Tile(2, 2));

                board.placePiece(knight1);
                board.placePiece(bishop1);
                board.placePiece(pawn1);
                board.placePiece(bishop2);
                board.placePiece(pawn2);
                board.placePiece(knight2);

                break;
            }

            case "Pane[id=7]":{
                Knight knight1 = new Knight(new Tile(0, 2));
                Bishop bishop1 = new Bishop(new Tile(1, 1));
                Pawn pawn1 = new Pawn(new Tile(2, 0));
                Bishop bishop2 = new Bishop(new Tile(2, 1));
                Knight knight2 = new Knight(new Tile(2, 2));
                Pawn pawn2 = new Pawn(new Tile(3, 0));

                board.placePiece(knight1);
                board.placePiece(bishop1);
                board.placePiece(pawn1);
                board.placePiece(bishop2);
                board.placePiece(knight2);
                board.placePiece(pawn2);

                break;
            }

            case "Pane[id=8]":{
                Rook rook1 = new Rook(new Tile(0, 1));
                Pawn pawn = new Pawn(new Tile(1, 2));
                Bishop bishop = new Bishop(new Tile(2, 2));
                Knight knight1 = new Knight(new Tile(3, 0));
                Rook rook2 = new Rook(new Tile(3, 1));
                Knight knight2 = new Knight(new Tile(3, 3));

                board.placePiece(rook1);
                board.placePiece(pawn);
                board.placePiece(bishop);
                board.placePiece(knight1);
                board.placePiece(rook2);
                board.placePiece(knight2);

                break;
            }

            case "Pane[id=9]":{
                Rook rook = new Rook(new Tile(0, 0));
                Queen queen = new Queen(new Tile(1, 0));
                Bishop bishop = new Bishop(new Tile(1, 3));
                Pawn pawn1 = new Pawn(new Tile(2, 1));
                Pawn pawn2 = new Pawn(new Tile(3, 2));
                Knight knight = new Knight(new Tile(3, 1));

                board.placePiece(rook);
                board.placePiece(queen);
                board.placePiece(bishop);
                board.placePiece(pawn1);
                board.placePiece(knight);
                board.placePiece(pawn2);

                break;
            }

            case "Pane[id=10]":{
                Bishop bishop1 = new Bishop(new Tile(0, 3));
                Bishop bishop2 = new Bishop(new Tile(1, 0));
                Queen queen = new Queen(new Tile(1, 2));
                Knight knight1 = new Knight(new Tile(2, 0));
                Pawn pawn = new Pawn(new Tile(3, 1));
                Knight knight2 = new Knight(new Tile(3, 2));

                board.placePiece(bishop1);
                board.placePiece(bishop2);
                board.placePiece(queen);
                board.placePiece(knight1);
                board.placePiece(pawn);
                board.placePiece(knight2);

                break;
            }
        }
        gameController.startGame(board, mouseEvent);
    }
}
