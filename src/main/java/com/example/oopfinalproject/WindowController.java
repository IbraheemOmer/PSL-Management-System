package com.example.oopfinalproject;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class WindowController {
    @FXML
    private Button btnPlayers;

    @FXML
    private Button btnTeams;

    @FXML
    private Button btnTitles;

    @FXML
    private Button btnSponsors;

    @FXML
    private Button btnFixtures;

    @FXML
    private Button btnPoints;

    public void handleButtonClicks(Event mouseEvent) throws IOException {
        if (mouseEvent.getSource()==btnPlayers){
            loadStages("Players.fxml");
        }
        else if (mouseEvent.getSource()==btnTeams){
            loadStages("Teams.fxml");
        }
        else if (mouseEvent.getSource()==btnTitles){
            loadStages("Titles.fxml");
        }
        else if (mouseEvent.getSource()==btnSponsors){
            loadStages("Sponsors.fxml");
        }
        else if (mouseEvent.getSource()==btnFixtures){
            loadStages("Fixtures.fxml");
        }
        else if (mouseEvent.getSource()==btnPoints){
            loadStages("Points.fxml");
        }
    }

    public void loadStages(String fxml) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxml));
        Stage stage = new Stage();
        Image image = new Image("file:src\\main\\resources\\Images\\Icon.png");
        stage.getIcons().add(image);
        stage.setTitle("PSL Management System");
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.show();
    }
}