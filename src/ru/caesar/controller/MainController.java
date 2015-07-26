package ru.caesar.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ru.caesar.Main;
import ru.caesar.model.ConnectManager;
import ru.caesar.model.Film;
import ru.caesar.model.Seans;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class MainController implements Controller {

    private Main main = new Main();

    private ConnectManager connectManager = ConnectManager.getInstance();
    private ObservableList<Film> films = FXCollections.observableArrayList();
    @FXML
    private TableView filmsTable;
    @FXML
    private TableColumn<Film, Integer> idFilm;
    @FXML
    private TableColumn<Film, String> titleFilm;
    @FXML
    private TableColumn<Film, String> genreFilm;
    @FXML
    private TableColumn<Film, String> yearFilm;
    @FXML
    private TableColumn<Film, String> timeFilm;





    @Override
    public void initialize() {
        initData();
        idFilm.setCellValueFactory(new PropertyValueFactory<Film, Integer>("id"));
        titleFilm.setCellValueFactory(new PropertyValueFactory<Film, String>("title"));
        genreFilm.setCellValueFactory(new PropertyValueFactory<Film, String>("genre"));
        yearFilm.setCellValueFactory(new PropertyValueFactory<Film, String>("year"));
        timeFilm.setCellValueFactory(new PropertyValueFactory<Film, String>("time"));
        filmsTable.setItems(films);
        showDescription(null);
        filmsTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {

                showDescription((Film) newValue);
            }
        });

        selectAllSeanses();





    }

    @Override
    public void initData() {
        List<Film> filmList = null;
        try {
            filmList = connectManager.selectAllFilms();
            for (int i = 0; i < filmList.size(); i++) {
                Film film = filmList.get(i);
                films.add(film);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handlerRemoveFilm(){
        int index = filmsTable.getSelectionModel().getSelectedIndex();
        if (index>=0){

            Film film = (Film) filmsTable.getItems().get(index);
            System.out.println("Delete film..." + film.toString());
            try {
                connectManager.removeFilm(film);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            filmsTable.getItems().remove(index);
        }
    }


    public void showDescription(Film film){
       if (film!=null){
           descriptionLabel.setText(film.getDescription());
           titleLabel.setText(film.getTitle());
           genreLabel.setText(film.getGenre());
           yearLabel.setText(film.getYear());
           timeLabel.setText(film.getTime());
           String url = film.getImg();
           imgView.setImage(new Image(url));
       } else {
           descriptionLabel.setText("");
           titleLabel.setText("");
           genreLabel.setText("");
           yearLabel.setText("");
           timeLabel.setText("");
       }
    }

    @FXML
    private ImageView imgView;
    @FXML
    private Label titleLabel;
    @FXML
    private Label genreLabel;
    @FXML
    private Label yearLabel;
    @FXML
    private Label timeLabel;
    @FXML
    private Label descriptionLabel;

    @FXML
    public void handlerInsertFilm(){
        main.addFilm(null);
    }

    @FXML
    public void handlerUpdateFilm(){
        Film film = (Film) filmsTable.getSelectionModel().getSelectedItem();
        main.addFilm(film);
    }

    @FXML
    public void handlerRefresh(){
        films.clear();
        initialize();
    }

    @FXML
    public void handlerExit(){
        System.exit(0);
    }

    @FXML
    public void handlerAbout(){
        try {
            AnchorPane pane = FXMLLoader.load(Main.class.getResource("view/about.fxml"));
            Stage stage = new Stage();
            stage.setTitle("О программе");
            stage.setScene(new Scene(pane));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ObservableList<Seans> seanses = FXCollections.observableArrayList();
    @FXML
    private TableView<Seans> seansesView;
    @FXML
    private TableColumn<Seans, String> titleFilmS;
    @FXML
    private TableColumn<Seans, String> dateFilmS;
    @FXML
    private TableColumn<Seans, String> timeFilmS;

    @FXML
    private TableView<Seans> seansesView1;
    @FXML
    private TableColumn<Seans, String> titleFilmS1;
    @FXML
    private TableColumn<Seans, String> dateFilmS1;
    @FXML
    private TableColumn<Seans, String> timeFilmS1;

    @FXML
    private TableView<Seans> seansesView2;
    @FXML
    private TableColumn<Seans, String> titleFilmS2;
    @FXML
    private TableColumn<Seans, String> dateFilmS2;
    @FXML
    private TableColumn<Seans, String> timeFilmS2;

    @FXML
    private TableView<Seans> seansesView3;
    @FXML
    private TableColumn<Seans, String> titleFilmS3;
    @FXML
    private TableColumn<Seans, String> dateFilmS3;
    @FXML
    private TableColumn<Seans, String> timeFilmS3;

    @FXML
    private TableView<Seans> seansesView4;
    @FXML
    private TableColumn<Seans, String> titleFilmS4;
    @FXML
    private TableColumn<Seans, String> dateFilmS4;
    @FXML
    private TableColumn<Seans, String> timeFilmS4;

    @FXML
    private TableView<Seans> seansesView5;
    @FXML
    private TableColumn<Seans, String> titleFilmS5;
    @FXML
    private TableColumn<Seans, String> dateFilmS5;
    @FXML
    private TableColumn<Seans, String> timeFilmS5;

    @FXML
    private TableView<Seans> seansesView6;
    @FXML
    private TableColumn<Seans, String> titleFilmS6;
    @FXML
    private TableColumn<Seans, String> dateFilmS6;
    @FXML
    private TableColumn<Seans, String> timeFilmS6;

    @FXML
    private TabPane weekTabPane;
    @FXML
    private Tab mon;
    @FXML
    private Tab tue;
    @FXML
    private Tab wed;
    @FXML
    private Tab thu;
    @FXML
    private Tab fri;
    @FXML
    private Tab sat;
    @FXML
    private Tab sun;

    @FXML
    public void monTabSlect(){
        seanses.clear();
        initDataSeanses("Mon");
        titleFilmS.setCellValueFactory(new PropertyValueFactory<Seans, String>("filmTitle"));
        dateFilmS.setCellValueFactory(new PropertyValueFactory<Seans, String>("date"));
        timeFilmS.setCellValueFactory(new PropertyValueFactory<Seans, String>("time"));
        seansesView.setItems(seanses);
    }

    @FXML
    public void tueTabSlect(){
        seanses.clear();
        initDataSeanses("Tue");
        titleFilmS1.setCellValueFactory(new PropertyValueFactory<Seans, String>("filmTitle"));
        dateFilmS1.setCellValueFactory(new PropertyValueFactory<Seans, String>("date"));
        timeFilmS1.setCellValueFactory(new PropertyValueFactory<Seans, String>("time"));
        seansesView1.setItems(seanses);
    }

    @FXML
    public void wedTabSlect(){
        seanses.clear();
        initDataSeanses("Wed");
        titleFilmS2.setCellValueFactory(new PropertyValueFactory<Seans, String>("filmTitle"));
        dateFilmS2.setCellValueFactory(new PropertyValueFactory<Seans, String>("date"));
        timeFilmS2.setCellValueFactory(new PropertyValueFactory<Seans, String>("time"));
        seansesView2.setItems(seanses);
    }

    @FXML
    public void thuTabSlect(){
        seanses.clear();
        initDataSeanses("Thu");
        titleFilmS3.setCellValueFactory(new PropertyValueFactory<Seans, String>("filmTitle"));
        dateFilmS3.setCellValueFactory(new PropertyValueFactory<Seans, String>("date"));
        timeFilmS3.setCellValueFactory(new PropertyValueFactory<Seans, String>("time"));
        seansesView3.setItems(seanses);
    }

    public void satTabSlect(){
        seanses.clear();
        initDataSeanses("Sat");
        titleFilmS5.setCellValueFactory(new PropertyValueFactory<Seans, String>("filmTitle"));
        dateFilmS5.setCellValueFactory(new PropertyValueFactory<Seans, String>("date"));
        timeFilmS5.setCellValueFactory(new PropertyValueFactory<Seans, String>("time"));
        seansesView5.setItems(seanses);
    }

    public void sunTabSlect(){
        seanses.clear();
        initDataSeanses("Sun");
        titleFilmS6.setCellValueFactory(new PropertyValueFactory<Seans, String>("filmTitle"));
        dateFilmS6.setCellValueFactory(new PropertyValueFactory<Seans, String>("date"));
        timeFilmS6.setCellValueFactory(new PropertyValueFactory<Seans, String>("time"));
        seansesView6.setItems(seanses);
    }

    public void friTabSlect(){
        seanses.clear();
        initDataSeanses("Fri");
        titleFilmS4.setCellValueFactory(new PropertyValueFactory<Seans, String>("filmTitle"));
        dateFilmS4.setCellValueFactory(new PropertyValueFactory<Seans, String>("date"));
        timeFilmS4.setCellValueFactory(new PropertyValueFactory<Seans, String>("time"));
        seansesView4.setItems(seanses);
    }


    public void selectAllSeanses(){

       Tab tab = weekTabPane.getSelectionModel().getSelectedItem();
        if (tab.getText().equalsIgnoreCase("Пн")){
            seanses.clear();
            initDataSeanses("Mon");
            titleFilmS.setCellValueFactory(new PropertyValueFactory<Seans, String>("filmTitle"));
            dateFilmS.setCellValueFactory(new PropertyValueFactory<Seans, String>("date"));
            timeFilmS.setCellValueFactory(new PropertyValueFactory<Seans, String>("time"));
            seansesView.setItems(seanses);
        }
    }

    public void initDataSeanses(String day){

        try {
            List<Seans> seanses = connectManager.selectSeans(day);
            for (int i = 0; i < seanses.size(); i++) {
                Seans seans = seanses.get(i);
                this.seanses.add(seans);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handlerInsertSeans(){
        int index = filmsTable.getSelectionModel().getSelectedIndex();
        if (index>=0){
            Film film = (Film) filmsTable.getItems().get(index);
            main.addSeans(film);
        }

    }

}
