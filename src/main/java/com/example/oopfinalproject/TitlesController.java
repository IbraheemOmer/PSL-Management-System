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

public class TitlesController implements Initializable {
    @FXML
    private TableView<Titles> tableView;

    @FXML
    public TableColumn<Titles, String> TeamCol;

    @FXML
    private TableColumn<Titles, String> TitleCol;

    @FXML
    private TableColumn<Titles, String> YearCol;

    private ObservableList<Titles> trophies = FXCollections.observableArrayList();

    @FXML private TextField addTeam;
    @FXML private TextField addTitle;
    @FXML private TextField addYear;

    @FXML private Button addBtn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){

        Connection con = null;
        try {
            con = DbConnector.getConnection();
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM Titles");
            while (rs.next()){
                trophies.add(new TitlesController.Titles(rs.getString("Team"),rs.getString("Title"),
                        rs.getString("Year")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        TeamCol.setCellValueFactory(new PropertyValueFactory<TitlesController.Titles,String>("Team"));
        TitleCol.setCellValueFactory(new PropertyValueFactory<TitlesController.Titles,String>("Title"));
        YearCol.setCellValueFactory(new PropertyValueFactory<TitlesController.Titles,String>("Year"));
        tableView.setItems(trophies);

    }

    @FXML public void handleButtonOnAction(Event event) throws SQLException {
        Window owner = addBtn.getScene().getWindow();
        if(addTeam.getText().isEmpty()){
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please Enter Team");
            return;
        }

        if(addTitle.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please Enter Title");
            return;
        }

        if(addYear.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please Enter Year");
            return;
        }

        String Team=addTeam.getText();
        String Titles=addTitle.getText();
        String Year=addYear.getText();
        trophies.add(new Titles(Team,Titles,Year));

        DbConnector dbConnector = new DbConnector();
        dbConnector.insertRecordTitles(Team,Titles,Year);
        addTeam.clear();
        addTitle.clear();
        addYear.clear();
    }

    public void deleteRowsFromTable(ActionEvent event){
        tableView.getItems().removeAll(tableView.getSelectionModel().getSelectedItems());
    }

    public static class Titles{
        private SimpleStringProperty Team,Title,Year;

        public String getTeam() {
            return Team.get();
        }

        public SimpleStringProperty teamProperty() {
            return Team;
        }

        public void setTeam(String team) {
            this.Team.set(team);
        }

        public String getTitle() {
            return Title.get();
        }

        public SimpleStringProperty titleProperty() {
            return Title;
        }

        public void setTitle(String title) {
            this.Title.set(title);
        }

        public String getYear() {
            return Year.get();
        }

        public SimpleStringProperty yearProperty() {
            return Year;
        }

        public void setYear(String year) {
            this.Year.set(year);
        }

        public Titles(String Team,String Title,String Year){
            this.Team = new SimpleStringProperty(Team);
            this.Title = new SimpleStringProperty(Title);
            this.Year = new SimpleStringProperty(Year);
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
