package ru.caesar.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ru.caesar.model.ConnectManager;
import ru.caesar.model.Film;

import java.sql.SQLException;

public class FilmController implements Controller {
    private ConnectManager connectManager = ConnectManager.getInstance();
    @FXML
    private TextField titleField;
    @FXML
    private TextField genreField;
    @FXML
    private TextField yearField;
    @FXML
    private TextField timeField;
    @FXML
    private TextField imgField;
    @FXML
    private TextArea descriptionArea;
    @FXML
    private Button okBtn;
    @FXML
    private Button cancelBtn;




    @Override
    public void initialize() {

    }

    @Override
    public void initData() {

    }

    public void setData(){
        Film film = new Film(titleField.getText(), descriptionArea.getText(), genreField.getText(), imgField.getText(), timeField.getText(), yearField.getText());
        try {
            connectManager.insertFilm(film);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handlerBtnOk(){
        setData();
        Stage stage = (Stage) okBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void handlerBtnCancel(){
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }

}
