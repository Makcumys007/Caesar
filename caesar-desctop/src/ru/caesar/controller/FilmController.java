package ru.caesar.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.controlsfx.dialog.Dialogs;
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
    private boolean isAddOrUpdate;
    private int idFilm;


    @Override
    public void initialize() {
    }

    @Override
    public void initData() {
        if (isValidator()) {
            Film film = new Film(titleField.getText(), descriptionArea.getText(), genreField.getText(), imgField.getText(), timeField.getText(), yearField.getText());
            try {
                connectManager.insertFilm(film);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println("Insert...");
        } 
    }

    public void upData(){
        if (isValidator()) {
            Film film = new Film(idFilm, titleField.getText(), descriptionArea.getText(), genreField.getText(), imgField.getText(), timeField.getText(), yearField.getText());
            try {
                connectManager.updateFilm(film);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println("Update...");
        }
    }

    public void setData(Film film, boolean isAddOrUpdate){
        this.idFilm = film.getId();
        this.isAddOrUpdate = isAddOrUpdate;
        titleField.setText(film.getTitle());
        genreField.setText(film.getGenre());
        yearField.setText(film.getYear());
        timeField.setText(film.getTime());
        imgField.setText(film.getImg());
        descriptionArea.setText(film.getDescription());

    }

    @FXML
    public void handlerBtnOk(){
        if (!isAddOrUpdate) {

            initData();
        } else {

            upData();
        }
        Stage stage = (Stage) okBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void handlerBtnCancel(){
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }

    public boolean isValidator(){
        if (titleField.getText().length() == 0 ||
                genreField.getText().length() == 0 ||
                yearField.getText().length() == 0 ||
                timeField.getText().length() == 0 ||
                imgField.getText().length() == 0 ||
                descriptionArea.getText().length() == 0){
            Dialogs.create().title("Внимание").masthead("Не коректные данные").message("Заполните все поля").showError();
            return false;
        } else {
            return true;
        }
    }

    public void setIsAddOrUpdate(boolean isAddOrUpdate) {
        this.isAddOrUpdate = isAddOrUpdate;
    }
}
