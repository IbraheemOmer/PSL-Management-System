package com.example.oopfinalproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class WindowApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(WindowApplication.class.getResource("Window.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 500);
        Image image = new Image("file:src\\main\\resources\\Images\\Icon.png");
        stage.getIcons().add(image);
        stage.setTitle("PSL Management System");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}