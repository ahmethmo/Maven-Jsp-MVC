package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {
    public static Connection Getconnection(){
        Connection con=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/FilmTakip", "root","root");
        } catch (Exception e) {
        }
        return con;
    }
}
