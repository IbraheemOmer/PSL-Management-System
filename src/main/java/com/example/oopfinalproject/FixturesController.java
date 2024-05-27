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

public class FixturesController implements Initializable {
    @FXML
    private TableView<Fixtures> FixturesView;

    @FXML
    private TableColumn<Fixtures,String> Team1Col;

    @FXML
    private TableColumn<Fixtures,String> Team2Col;

    @FXML
    private TableColumn<Fixtures,String> DateCol;

    @FXML
    private TableColumn<Fixtures,String> TimeCol;

    @FXML
    private TableColumn<Fixtures,String> VenueCol;

    private ObservableList<FixturesController.Fixtures> matches = FXCollections.observableArrayList();

    @FXML private TextField addTeam1;

    @FXML private TextField addTeam2;

    @FXML private TextField addDate;

    @FXML private TextField addTime;

    @FXML private TextField addVenue;

    @FXML private Button addBtn;

    @FXML private Button removeBtn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Connection con = null;
        try {
            con = DbConnector.getConnection();
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM Fixtures");

            while (rs.next()){
                matches.add(new Fixtures(rs.getString("Team1"),rs.getString("Team2"),
                        rs.getString("Date"),rs.getString("Time"),rs.getString("Venue")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Team1Col.setCellValueFactory(new PropertyValueFactory<FixturesController.Fixtures,String>("Team1"));
        Team2Col.setCellValueFactory(new PropertyValueFactory<FixturesController.Fixtures,String>("Team2"));
        DateCol.setCellValueFactory(new PropertyValueFactory<FixturesController.Fixtures,String>("Date"));
        TimeCol.setCellValueFactory(new PropertyValueFactory<FixturesController.Fixtures,String>("Time"));
        VenueCol.setCellValueFactory(new PropertyValueFactory<FixturesController.Fixtures,String>("Venue"));
        FixturesView.setItems(matches);
    }

    @FXML public void handleButtonAction(Event e) throws SQLException {
        Window owner = addBtn.getScene().getWindow();
        if(addTeam1.getText().isEmpty()){
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please Enter Team 1 Name");
            return;
        }

        if(addTeam2.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please Enter Team 2 Name");
            return;
        }

        if(addDate.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please Enter The Date");
            return;
        }

        if(addTime.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please Enter The Time");
            return;
        }

        if(addVenue.getText().isEmpty()){
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please Enter The Venue");
            return;
        }

        String Team1 = addTeam1.getText();
        String Team2 = addTeam2.getText();
        String Date = addDate.getText();
        String Time = addTime.getText();
        String Venue = addVenue.getText();

        matches.add(new FixturesController.Fixtures(Team1,Team2,Date,Time,Venue));

        DbConnector dbConnector = new DbConnector();
        dbConnector.insertRecordFixtures(Team1,Team2,Date,Time,Venue);
        addTeam1.clear();
        addTeam2.clear();
        addDate.clear();
        addTime.clear();
        addVenue.clear();
    }

    public void deleteRowFromTable(ActionEvent event){
        FixturesView.getItems().removeAll(FixturesView.getSelectionModel().getSelectedItems());
    }

    public static class Fixtures{
        private SimpleStringProperty Team1,Team2,Date,Time,Venue;

        public String getTeam1() {
            return Team1.get();
        }

        public SimpleStringProperty team1Property() {
            return Team1;
        }

        public void setTeam1(String team1) {
            this.Team1.set(team1);
        }

        public String getTeam2() {
            return Team2.get();
        }

        public SimpleStringProperty team2Property() {
            return Team2;
        }

        public void setTeam2(String team2) {
            this.Team2.set(team2);
        }

        public String getDate() {
            return Date.get();
        }

        public SimpleStringProperty dateProperty() {
            return Date;
        }

        public void setDate(String date) {
            this.Date.set(date);
        }

        public String getTime() {
            return Time.get();
        }

        public SimpleStringProperty timeProperty() {
            return Time;
        }

        public void setTime(String time) {
            this.Time.set(time);
        }

        public String getVenue() {
            return Venue.get();
        }

        public SimpleStringProperty venueProperty() {
            return Venue;
        }

        public void setVenue(String venue) {
            this.Venue.set(venue);
        }

        public Fixtures(String Team1,String Team2,String Date,String Time,String Venue){
            this.Team1 = new SimpleStringProperty(Team1);
            this.Team2 = new SimpleStringProperty(Team2);
            this.Date = new SimpleStringProperty(Date);
            this.Time = new SimpleStringProperty(Time);
            this.Venue = new SimpleStringProperty(Venue);
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
