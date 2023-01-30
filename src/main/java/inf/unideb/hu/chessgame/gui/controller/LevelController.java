package inf.unideb.hu.chessgame.gui.controller;

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

public class LevelController {
    @FXML
    void btnCancelClicked(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    public void btnBeginnerClicked(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/beginner.fxml")));
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    public void btnIntermediateClicked(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/intermediate.fxml")));
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    public void btnAdvancedClicked(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/advanced.fxml")));
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    public void btnExpertClicked(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/expert.fxml")));
        stage.setScene(new Scene(root));
        stage.show();
    }
}
