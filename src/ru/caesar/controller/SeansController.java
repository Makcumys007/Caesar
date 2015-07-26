package ru.caesar.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import ru.caesar.model.Film;

public class SeansController implements Controller {

    @FXML
    private ToggleGroup weekGroup = new ToggleGroup();
    @FXML
    private RadioButton mon;
    @FXML
    private RadioButton tue;
    @FXML
    private RadioButton wen;
    @FXML
    private RadioButton thu;
    @FXML
    private RadioButton fri;
    @FXML
    private RadioButton sat;
    @FXML
    private RadioButton sun;


    @FXML
    private Button okBtn;
    @FXML
    private Button cancelBtn;
    @FXML
    private TextField filmIdField;


    private boolean isAddFromTable;
    private int idFilm;

    @Override
    public void initialize() {

    }

    @Override
    public void initData() {

    }

    @FXML
    public void handlerCancelBtn(){
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }

    public void setIsAddFromTable(boolean isAddFromTable) {
    }

    public void setDataFilm(Film film) {
        this.idFilm = film.getId();
        filmIdField.setText(String.valueOf(idFilm));
    }
}
