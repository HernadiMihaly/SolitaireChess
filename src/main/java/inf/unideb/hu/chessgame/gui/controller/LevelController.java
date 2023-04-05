package inf.unideb.hu.chessgame.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class LevelController extends BaseController{

    @FXML
    public void onLevelSelected(ActionEvent event) throws IOException{
        String level = getLevelFromEventString(event.getSource().toString()).toLowerCase();
        Singleton.getInstance().setLevel(level);
        String fileName = String.format("/fxml/%s.fxml", level);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fileName)));
        stage.setScene(new Scene(root));
        stage.show();

    }

    private static String getLevelFromEventString(String input) {
        int startIndex = input.indexOf("'") + 1;
        int endIndex = input.lastIndexOf("'");
        return input.substring(startIndex, endIndex);
    }
}