package ru.caesar;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import ru.caesar.controller.FilmController;
import ru.caesar.model.Film;

import java.io.IOException;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
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
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
