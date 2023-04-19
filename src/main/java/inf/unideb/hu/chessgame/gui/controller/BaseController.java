package inf.unideb.hu.chessgame.gui.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;

public abstract class BaseController {
    protected BaseController() {
    }

    @FXML
    public void btnExitClicked() {
        Platform.exit();
    }
}
