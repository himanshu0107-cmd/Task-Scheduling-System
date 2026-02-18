package com.promanage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL =
            "jdbc:postgresql://localhost:5432/promanage";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Jyoti";

    public static Connection getConnection() {

        Connection con = null;

        try {
            
            Class.forName("org.postgresql.Driver");

           
            con = DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Database Connected Successfully!");

        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection Failed!");
            e.printStackTrace();
        }

        return con;
    }
}

