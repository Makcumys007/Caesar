package ru.caesar;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ru.caesar.controller.FilmController;
import ru.caesar.controller.SeansController;
import ru.caesar.model.Cinima;
import ru.caesar.model.Film;
import ru.caesar.model.Seans;

import java.io.IOException;

public class Main extends Application {
    private Stage mainStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.mainStage = primaryStage;
        this.mainStage.getIcons().add(new Image(Main.class.getResourceAsStream("resources/img/icon.png")));
      AnchorPane pane = FXMLLoader.load(Main.class.getResource("view/main.fxml"));
        primaryStage.setTitle("Caesar Admin");
          primaryStage.setScene(new Scene(pane));
            primaryStage.show();
    }

    public void addFilm(Film film){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/insert.fxml"));
            AnchorPane pane = loader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Добавить/Изменить фильм");
            stage.setScene(new Scene(pane));
            if (film==null){
                stage.show();
            } else {
                FilmController controller = loader.getController();
                controller.setIsAddOrUpdate(false);
                controller.setData(film, true);
                stage.show();
            }
        } catch (IOException e) {
            e.printStackTrace();this.mainStage.getIcons().add(new Image("file:resources/img/icon.png"));
        }
    }

    public void addSeans(Cinima cinima){
        try {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/seans.fxml"));
            AnchorPane pane = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Добавить/Изменить сеанс");
            stage.setScene(new Scene(pane));

                if (cinima instanceof Film){
                    Film film = (Film) cinima;
                    SeansController controller = loader.getController();
                    controller.setDataFilm(film);
                    stage.show();
                } else if (cinima instanceof Seans){
                    Seans seans = (Seans) cinima;
                    SeansController controller = loader.getController();
                    controller.setDataSeans(seans);
                    stage.show();
                }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}
