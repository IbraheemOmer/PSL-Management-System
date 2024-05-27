package com.example.oopfinalproject;

import javafx.beans.Observable;
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
import java.sql.Statement;
import java.util.ResourceBundle;

public class PlayersController implements Initializable {
    @FXML
    private TableView <Players> tableView;

    @FXML
    private TableColumn<Players, String > NameCol;

    @FXML
    private TableColumn<Players, String > TeamCol;

    @FXML
    private TableColumn<Players, String > NationalityCol;

    @FXML
    private TableColumn<Players, String > RolesCol;

    @FXML
    private TableColumn<Players, String > AgeCol;

    @FXML
    private TableColumn<Players, String > RankCol;

    private ObservableList<Players> people = FXCollections.observableArrayList();

    @FXML private TextField addName;

    @FXML private TextField addTeam;

    @FXML private TextField addNationality;

    @FXML private TextField addRole;

    @FXML private TextField addAge;

    @FXML private TextField addRank;

    @FXML private Button addBtn;

    @FXML private Button removeBtn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Connection con = null;
        try {
            con = DbConnector.getConnection();
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM Players");

            while (rs.next()){
                people.add(new Players(rs.getString("Name"),rs.getString("Team"),
                        rs.getString("Nationality"),rs.getString("Role"),rs.getString("Age"),
                        rs.getString("Player_Rank")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        NameCol.setCellValueFactory(new PropertyValueFactory<Players,String>("Name"));
        TeamCol.setCellValueFactory(new PropertyValueFactory<Players,String>("Team"));
        NationalityCol.setCellValueFactory(new PropertyValueFactory<Players,String>("Nationality"));
        RolesCol.setCellValueFactory(new PropertyValueFactory<Players,String>("Roles"));
        AgeCol.setCellValueFactory(new PropertyValueFactory<Players,String>("Age"));
        RankCol.setCellValueFactory(new PropertyValueFactory<Players,String>("Rank"));
        tableView.setItems(people);
    }

    @FXML public void handleButtonAction(Event e) throws SQLException {
        Window owner = addBtn.getScene().getWindow();
        if(addName.getText().isEmpty()){
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please Enter Players Name");
            return;
        }

        if(addTeam.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please Enter Players Team");
            return;
        }

        if(addNationality.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please Enter Players Nationality");
            return;
        }

        if(addRole.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please Enter Players Role");
            return;
        }

        if(addAge.getText().isEmpty()){
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please Enter Players Age");
            return;
        }

        if(addRank.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please Enter Players Rank");
            return;
        }

        String fullName = addName.getText();
        String Team = addTeam.getText();
        String Nationality = addNationality.getText();
        String Age = addAge.getText();
        String Role = addRole.getText();
        String Rank = addRank.getText();

        people.add(new Players(fullName,Team,Nationality,Role,Age,Rank));

        DbConnector dbConnector = new DbConnector();
        dbConnector.insertRecordPlayers(fullName,Team,Nationality,Role,Age,Rank);
        addName.clear();
        addTeam.clear();
        addNationality.clear();
        addRole.clear();
        addAge.clear();
        addRank.clear();
    }

    public void deleteRowFromTable(ActionEvent event){
        tableView.getItems().removeAll(tableView.getSelectionModel().getSelectedItems());
    }

    public static class Players {
        private SimpleStringProperty Name,Team,Nationality,Roles,Age,Rank;

        public String getName() {
            return Name.get();
        }

        public SimpleStringProperty nameProperty() {
            return Name;
        }

        public void setName(String name) {
            this.Name.set(name);
        }

        public String getTeam() {
            return Team.get();
        }

        public SimpleStringProperty teamProperty() {
            return Team;
        }

        public void setTeam(String team) {
            this.Team.set(team);
        }

        public String getNationality() {
            return Nationality.get();
        }

        public SimpleStringProperty nationalityProperty() {
            return Nationality;
        }

        public void setNationality(String nationality) {
            this.Nationality.set(nationality);
        }

        public String getRoles() {
            return Roles.get();
        }

        public SimpleStringProperty rolesProperty() {
            return Roles;
        }

        public void setRoles(String roles) {
            this.Roles.set(roles);
        }

        public String getAge() {
            return Age.get();
        }

        public SimpleStringProperty ageProperty() {
            return Age;
        }

        public void setAge(String age) {
            this.Age.set(age);
        }

        public String getRank() {
            return Rank.get();
        }

        public SimpleStringProperty rankProperty() {
            return Rank;
        }

        public void setRank(String rank) {
            this.Rank.set(rank);
        }

        public Players(String Name, String Team, String Nationality,String Roles,String Age, String Rank){
            this.Name = new SimpleStringProperty(Name);
            this.Team = new SimpleStringProperty(Team);
            this.Nationality = new SimpleStringProperty(Nationality);
            this.Roles = new SimpleStringProperty(Roles);
            this.Age = new SimpleStringProperty(Age);
            this.Rank = new SimpleStringProperty(Rank);
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
