package com.example.oopfinalproject;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Window;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PointsController implements Initializable {
    @FXML
    private TableView<Points> PointsView;

    @FXML
    private TableColumn<Points,String> TeamCol;

    @FXML
    private TableColumn<Points,String> PointsCol;

    private ObservableList<PointsController.Points> scores = FXCollections.observableArrayList();

    @FXML private TextField addTeam;

    @FXML private TextField addPoints;

    @FXML private Button addBtn;

    @FXML private Button removeBtn;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        Connection con = null;
        try {
            con = DbConnector.getConnection();
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM Points");

            while (rs.next()){
                scores.add(new PointsController.Points(rs.getString("Team"),rs.getString("Points")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        TeamCol.setCellValueFactory(new PropertyValueFactory<PointsController.Points,String>("Team"));
        PointsCol.setCellValueFactory(new PropertyValueFactory<PointsController.Points,String>("Points"));
        PointsView.setItems(scores);
    }

    @FXML public void handleButtonAction(Event e) throws SQLException {
        Window owner = addBtn.getScene().getWindow();
        if(addTeam.getText().isEmpty()){
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please Enter Team Name");
            return;
        }

        if(addPoints.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please Enter The Points");
            return;
        }

        String Team = addTeam.getText();
        String Points = addPoints.getText();

        scores.add(new PointsController.Points(Team,Points));

        DbConnector dbConnector = new DbConnector();
        dbConnector.insertRecordPoints(Team,Points);
        addTeam.clear();
        addPoints.clear();
    }

    public void deleteRowFromTable(ActionEvent event){
        PointsView.getItems().removeAll(PointsView.getSelectionModel().getSelectedItems());
    }

    public static class Points{
        private SimpleStringProperty Team,Points;

        public String getTeam() {
            return Team.get();
        }

        public SimpleStringProperty teamProperty() {
            return Team;
        }

        public void setTeam(String team) {
            this.Team.set(team);
        }

        public String getPoints() {
            return Points.get();
        }

        public SimpleStringProperty pointsProperty() {
            return Points;
        }

        public void setPoints(String points) {
            this.Points.set(points);
        }

        public Points(String Team, String Points){
            this.Team = new SimpleStringProperty(Team);
            this.Points = new SimpleStringProperty(Points);
        }
    }

    private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
}
