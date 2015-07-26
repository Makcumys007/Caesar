package ru.caesar.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ru.caesar.Main;
import ru.caesar.model.ConnectManager;
import ru.caesar.model.Film;


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

    @FXML
    private Tab mon;

    @FXML
    public void handlerInsertSeans(){
        int index = filmsTable.getSelectionModel().getSelectedIndex();
        if (index>=0){
            Film film = (Film) filmsTable.getItems().get(index);
            main.addSeans(film);
        } else {
            main.addSeans(null);
        }

    }

}
