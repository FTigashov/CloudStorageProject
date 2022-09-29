package com.example.cloudstorageproject.server;
import java.sql.*;

public class DBHandler {
    private static Connection connection;
    private static Statement statement;

    public static void openConnection() {
        try {
            connection  = DriverManager.getConnection("jdbc:sqlite:users.db");
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeConnection() {
        try {
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean checkLoginExists(String login) {
        String query = "SELECT login FROM users";
        try {
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                if (rs.getString("login").equals(login)) {
                    return true;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public static boolean checkCorrectPassword(String login, String password){
        String dbQuery = "SELECT password FROM users WHERE login='" + login + "'";
        try {
            ResultSet resultSet = statement.executeQuery(dbQuery);
            String passwordDB = resultSet.getString("password");
            if (passwordDB.equals(password)){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean registerNewUser(String login, String password) {
        String dbQuery = "INSERT INTO users(login,password) VALUES ('" + login + "','" + password + "')";
        try {
            int rows = statement.executeUpdate(dbQuery);
            if (rows > 0) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
