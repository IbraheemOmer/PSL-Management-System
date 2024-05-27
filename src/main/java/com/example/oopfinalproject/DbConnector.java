package com.example.oopfinalproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbConnector {

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/psl_data?useSSL=false";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "Pakistan198!";

    public static Connection getConnection() throws SQLException{
        Connection connection = DriverManager.getConnection(DATABASE_URL,DATABASE_USERNAME,DATABASE_PASSWORD);
        return connection;
    }

    private static final String INSERT_QUERY_PLAYERS = "INSERT INTO Players (name,team,nationality,role,age,player_rank) VALUES (?, ?, ?,?,?,?)";
    private static final String INSERT_QUERY_TITLES = "INSERT INTO Titles(team,title,year) VALUES(?,?,?)";
    private static final String INSERT_QUERY_FIXTURES= "INSERT INTO Fixtures(team1,team2,date,time,venue) VALUES(?,?,?,?,?)";
    private static final String INSERT_QUERY_POINTS = "INSERT INTO Points(team,points) VALUE(?,?)";
    public void insertRecordPlayers(String Name, String Team, String Nationality, String Role, String Age ,String Rank) throws SQLException {

        // load and register JDBC driver for MySQL
        try {
            Class.forName("com.mysql.DbConnector.Driver");
        } catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        // Step 1: Establishing a Connection and
        // try-with-resource statement will auto close the connection.
        try (Connection connection = DriverManager
                .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY_PLAYERS)) {
            preparedStatement.setString(1, Name);
            preparedStatement.setString(2, Team);
            preparedStatement.setString(3, Nationality);
            preparedStatement.setString(4, Role);
            preparedStatement.setString(5, Age);
            preparedStatement.setString(6, Rank);

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // print SQL exception information
            printSQLException(e);
        }
    }

    public void insertRecordTitles(String Team, String Title, String Year) throws SQLException {

        // load and register JDBC driver for MySQL
        try {
            Class.forName("com.mysql.DbConnector.Driver");
        } catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        // Step 1: Establishing a Connection and
        // try-with-resource statement will auto close the connection.
        try (Connection connection = DriverManager
                .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY_TITLES)) {
            preparedStatement.setString(1, Team);
            preparedStatement.setString(2, Title);
            preparedStatement.setString(3, Year);

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // print SQL exception information
            printSQLException(e);
        }
    }

    public void insertRecordFixtures(String Team1, String Team2, String Date, String Time, String Venue) throws SQLException {

        // load and register JDBC driver for MySQL
        try {
            Class.forName("com.mysql.DbConnector.Driver");
        } catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        // Step 1: Establishing a Connection and
        // try-with-resource statement will auto close the connection.
        try (Connection connection = DriverManager
                .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY_FIXTURES)) {
            preparedStatement.setString(1, Team1);
            preparedStatement.setString(2, Team2);
            preparedStatement.setString(3, Date);
            preparedStatement.setString(4, Time);
            preparedStatement.setString(5, Venue);

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // print SQL exception information
            printSQLException(e);
        }
    }

    public void insertRecordPoints(String Team, String Points) throws SQLException {

        // load and register JDBC driver for MySQL
        try {
            Class.forName("com.mysql.DbConnector.Driver");
        } catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        // Step 1: Establishing a Connection and
        // try-with-resource statement will auto close the connection.
        try (Connection connection = DriverManager
                .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY_POINTS)) {
            preparedStatement.setString(1, Team);
            preparedStatement.setString(2, Points);

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // print SQL exception information
            printSQLException(e);
        }
    }

    public static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
