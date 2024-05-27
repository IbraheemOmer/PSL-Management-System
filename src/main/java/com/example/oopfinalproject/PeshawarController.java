package com.example.oopfinalproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PeshawarController implements Initializable {
    @FXML
    private TableView<TitlesController.Titles> TitlesView;

    @FXML
    private TableColumn<TitlesController.Titles, String> TeamCol1;

    @FXML
    private TableColumn<TitlesController.Titles, String> TitleCol;

    @FXML
    private TableColumn<TitlesController.Titles, String> YearCol;

    @FXML
    private TableView <PlayersController.Players> PlayerView;

    @FXML
    private TableColumn<PlayersController.Players, String > NameCol;

    @FXML
    private TableColumn<PlayersController.Players, String > TeamCol2;

    @FXML
    private TableColumn<PlayersController.Players, String > NationalityCol;

    @FXML
    private TableColumn<PlayersController.Players, String > RolesCol;

    @FXML
    private TableColumn<PlayersController.Players, String > AgeCol;

    @FXML
    private TableColumn<PlayersController.Players, String > RankCol;

    private ObservableList<PlayersController.Players> people = FXCollections.observableArrayList();

    private ObservableList<TitlesController.Titles> trophies = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Connection con = null;
        try {
            con = DbConnector.getConnection();
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM Titles Where Team = 'Peshawar Zalmi'");
            while (rs.next()) {
                trophies.add(new TitlesController.Titles(rs.getString("Team"), rs.getString("Title"),
                        rs.getString("Year")));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            con = DbConnector.getConnection();
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM Players Where Team = 'Peshawar Zalmi'");
            while (rs.next()) {
                people.add(new PlayersController.Players(rs.getString("Name"),rs.getString("Team"),
                        rs.getString("Nationality"),rs.getString("Role"),rs.getString("Age"),
                        rs.getString("Player_Rank")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        TeamCol1.setCellValueFactory(new PropertyValueFactory<TitlesController.Titles, String>("Team"));
        TitleCol.setCellValueFactory(new PropertyValueFactory<TitlesController.Titles, String>("Title"));
        YearCol.setCellValueFactory(new PropertyValueFactory<TitlesController.Titles, String>("Year"));
        TitlesView.setItems(trophies);

        NameCol.setCellValueFactory(new PropertyValueFactory<PlayersController.Players,String>("Name"));
        TeamCol2.setCellValueFactory(new PropertyValueFactory<PlayersController.Players,String>("Team"));
        NationalityCol.setCellValueFactory(new PropertyValueFactory<PlayersController.Players,String>("Nationality"));
        RolesCol.setCellValueFactory(new PropertyValueFactory<PlayersController.Players,String>("Roles"));
        AgeCol.setCellValueFactory(new PropertyValueFactory<PlayersController.Players,String>("Age"));
        RankCol.setCellValueFactory(new PropertyValueFactory<PlayersController.Players,String>("Rank"));
        PlayerView.setItems(people);
    }
}
