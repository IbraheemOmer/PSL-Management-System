package com.example.oopfinalproject;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class TeamController {
    @FXML private Button btnKarachi;
    @FXML private Button btnPeshawar;
    @FXML private Button btnIslamabad;
    @FXML private Button btnQuetta;
    @FXML private Button btnMultan;
    @FXML private Button btnLahore;

    public void handleButtonClicks(Event mouseEvent) throws IOException {
        if (mouseEvent.getSource()==btnKarachi){
            loadStages("Karachi.fxml");
        }
        else if (mouseEvent.getSource()==btnPeshawar){
            loadStages("Peshawar.fxml");
        }
        else if (mouseEvent.getSource()==btnIslamabad){
            loadStages("Islamabad.fxml");
        }
        else if (mouseEvent.getSource()==btnQuetta){
            loadStages("Quetta.fxml");
        }
        else if (mouseEvent.getSource()==btnMultan){
            loadStages("Multan.fxml");
        }
        else if (mouseEvent.getSource()==btnLahore){
            loadStages("Lahore.fxml");
        }
    }

    private void loadStages(String fxml) throws IOException {
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
