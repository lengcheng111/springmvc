package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author truonglv
 */
public class Connector {

    private static Connection connection;

    // connect to data base
    public static Connection connect() throws SQLException, ClassNotFoundException {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5433/test", "postgres", "123456");
            return connection;
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
            throw e;
        }
    }

    public static Connection connectMysql() throws SQLException, ClassNotFoundException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/j4student", "root", "admin123456");
            return connection;
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
            throw e;
        }
    }

    // close connection
    public static void closeConnection() throws SQLException {
        if (connection != null) {
            Connector.connection.close();
        }
    }

    public static void closeStatement(java.sql.Statement stm) throws SQLException {
        if (stm != null) {
            stm.close();
        }
    }

    public static void closePreparedStatement(java.sql.PreparedStatement preparedStatement) throws SQLException {
        if (preparedStatement != null) {
            preparedStatement.close();
        }

    }
}
