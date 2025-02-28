package com.example.demo6;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ExpenseTrackerApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Loads FXML
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        //Create Scene
        Scene scene = new Scene(root, 800, 600);

        // Attach the dark theme CSS
        scene.getStylesheets().add(getClass().getResource("dark-theme.css").toExternalForm());

       //Set up Stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Better Track that Shmony$$");
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
