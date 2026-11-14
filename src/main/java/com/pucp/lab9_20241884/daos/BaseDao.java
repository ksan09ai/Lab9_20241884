package com.pucp.lab9_20241884.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public abstract class BaseDao {

    private static final String URL = "jdbc:mysql://localhost:3306/lab9_biblioteca";
    private static final String USER = "root";
    private static final String PASS = "mierda1A.";

    protected Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("No se encontró el driver de MySQL", e);
        }
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
