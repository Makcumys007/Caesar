package ru.caesar;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
      AnchorPane pane = FXMLLoader.load(Main.class.getResource("view/main.fxml"));
        primaryStage.setTitle("Caesar Admin");
          primaryStage.setScene(new Scene(pane));
            primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
