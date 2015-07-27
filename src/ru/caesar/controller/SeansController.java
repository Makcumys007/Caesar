package ru.caesar.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import ru.caesar.model.ConnectManager;
import ru.caesar.model.Film;
import ru.caesar.model.Seans;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class SeansController implements Controller {
    private ConnectManager connectManager = ConnectManager.getInstance();
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
    private Label filmIdLabel;
    @FXML
    private Label filmTitleLabel;
    @FXML
    private ChoiceBox<String> hhChoice;
    @FXML
    private ChoiceBox<String> mmChoice;
    @FXML
    private ChoiceBox dateChoice;



    private boolean isAddFromTable;
    private Film film;
    private boolean isUpdateTable;
    private Seans seans;


    @Override
    public void initialize() {
        initData();
    }

    @Override
    public void initData() {
        for (int i = 1; i <= 24; i++) {
            hhChoice.getItems().add(String.valueOf(i));
        }
        mmChoice.getItems().add("00");
        mmChoice.getItems().add("05");
        int n = 5;
        int m = 0;
        for (int i = 2; i < 12; i++) {
            m = n * i;
            mmChoice.getItems().add(String.valueOf(m));
            m = 0;
        }


    }
    public void insertSeans(){
        String str = (String) dateChoice.getSelectionModel().getSelectedItem();
        String time = hhChoice.getSelectionModel().getSelectedItem() + ":" + mmChoice.getSelectionModel().getSelectedItem();
        Seans seans = new Seans(film.getId(), film.getTitle(), str, time);
        try {
            connectManager.insertSeans(seans);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateSeans(){
        String str = (String) dateChoice.getSelectionModel().getSelectedItem();
        String time = hhChoice.getSelectionModel().getSelectedItem() + ":" + mmChoice.getSelectionModel().getSelectedItem();
        Seans seans2 = new Seans(seans.getId(), seans.getFilmId(), seans.getFilmTitle(), str, time);
        try {
            connectManager.updateSeanse(seans2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void handlerOkBtn(){
        System.out.println(isAddFromTable);
        if (isAddFromTable){
            insertSeans();
        }
        System.out.println(isUpdateTable);
        if (isUpdateTable){

            updateSeans();
        }
        Stage stage = (Stage) okBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void handlerCancelBtn(){
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }



    public void setDataFilm(Film film) {
        this.isAddFromTable = true;
        this.film = film;
        filmIdLabel.setText(String.valueOf(film.getId()));
        filmTitleLabel.setText(film.getTitle());
    }

    public void setDataSeans(Seans seans) {
        this.seans = seans;
        this.isUpdateTable = true;
        filmIdLabel.setText(String.valueOf(seans.getFilmId()));
        filmTitleLabel.setText(seans.getFilmTitle());
    }

    @FXML
    public void monIsSelected(){
        dateChoice.getItems().clear();
        Calendar calendar = new GregorianCalendar();
        if (new SimpleDateFormat("E").format(calendar.getTime()).equalsIgnoreCase("Пн") || new SimpleDateFormat("E").format(calendar.getTime()).equalsIgnoreCase("Mon")){
            dateChoice.getItems().add(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));
        }
        for (int i = 0; i < 15; i++) {
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            if (new SimpleDateFormat("E").format(calendar.getTime()).equalsIgnoreCase("Пн") || new SimpleDateFormat("E").format(calendar.getTime()).equalsIgnoreCase("Mon")){
                dateChoice.getItems().add(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));
            }
        }
    }

    @FXML
    public void tueIsSelected(){
        dateChoice.getItems().clear();
        Calendar calendar = new GregorianCalendar();
        if (new SimpleDateFormat("E").format(calendar.getTime()).equalsIgnoreCase("Вт") || new SimpleDateFormat("E").format(calendar.getTime()).equalsIgnoreCase("Tue")){
            dateChoice.getItems().add(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));
        }
        for (int i = 0; i < 15; i++) {
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            if (new SimpleDateFormat("E").format(calendar.getTime()).equalsIgnoreCase("Вт") || new SimpleDateFormat("E").format(calendar.getTime()).equalsIgnoreCase("Tue")){
                dateChoice.getItems().add(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));
            }
        }
    }

    @FXML
    public void wedIsSelected(){
        dateChoice.getItems().clear();
        Calendar calendar = new GregorianCalendar();
        if (new SimpleDateFormat("E").format(calendar.getTime()).equalsIgnoreCase("Ср") ||
                new SimpleDateFormat("E").format(calendar.getTime()).equalsIgnoreCase("Wed")){
            dateChoice.getItems().add(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));
        }
        for (int i = 0; i < 15; i++) {
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            if (new SimpleDateFormat("E").format(calendar.getTime()).equalsIgnoreCase("Ср") ||
                    new SimpleDateFormat("E").format(calendar.getTime()).equalsIgnoreCase("Wed")){
                dateChoice.getItems().add(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));
            }
        }
    }

    @FXML
    public void thuIsSelected(){
        dateChoice.getItems().clear();
        Calendar calendar = new GregorianCalendar();
        if (new SimpleDateFormat("E").format(calendar.getTime()).equalsIgnoreCase("Чт") ||
                new SimpleDateFormat("E").format(calendar.getTime()).equalsIgnoreCase("Thu")){
            dateChoice.getItems().add(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));
        }
        for (int i = 0; i < 15; i++) {
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            if (new SimpleDateFormat("E").format(calendar.getTime()).equalsIgnoreCase("Чт") ||
                    new SimpleDateFormat("E").format(calendar.getTime()).equalsIgnoreCase("Thu")){
                dateChoice.getItems().add(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));
            }
        }
    }

    @FXML
    public void friIsSelected(){
        dateChoice.getItems().clear();
        Calendar calendar = new GregorianCalendar();
        if (new SimpleDateFormat("E").format(calendar.getTime()).equalsIgnoreCase("Пт") ||
                new SimpleDateFormat("E").format(calendar.getTime()).equalsIgnoreCase("Fri")){
            dateChoice.getItems().add(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));
        }
        for (int i = 0; i < 15; i++) {
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            if (new SimpleDateFormat("E").format(calendar.getTime()).equalsIgnoreCase("Пт") ||
                    new SimpleDateFormat("E").format(calendar.getTime()).equalsIgnoreCase("Fri")){
                dateChoice.getItems().add(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));
            }
        }
    }

    @FXML
    public void satIsSelected(){
        dateChoice.getItems().clear();
        Calendar calendar = new GregorianCalendar();
        if (new SimpleDateFormat("E").format(calendar.getTime()).equalsIgnoreCase("Сб") ||
                new SimpleDateFormat("E").format(calendar.getTime()).equalsIgnoreCase("Sat")){
            dateChoice.getItems().add(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));
        }
        for (int i = 0; i < 15; i++) {
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            if (new SimpleDateFormat("E").format(calendar.getTime()).equalsIgnoreCase("Сб") ||
                    new SimpleDateFormat("E").format(calendar.getTime()).equalsIgnoreCase("Sat")){
                dateChoice.getItems().add(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));
            }
        }
    }

    @FXML
    public void sunIsSelected(){
        dateChoice.getItems().clear();
        Calendar calendar = new GregorianCalendar();
        if (new SimpleDateFormat("E").format(calendar.getTime()).equalsIgnoreCase("Вс") ||
                new SimpleDateFormat("E").format(calendar.getTime()).equalsIgnoreCase("Sun")){
            dateChoice.getItems().add(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));
        }
        for (int i = 0; i < 15; i++) {
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            if (new SimpleDateFormat("E").format(calendar.getTime()).equalsIgnoreCase("Вс") ||
                    new SimpleDateFormat("E").format(calendar.getTime()).equalsIgnoreCase("Sun")){
                dateChoice.getItems().add(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));
            }
        }
    }



}
