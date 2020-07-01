package com.connection;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

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
	@Autowired
	private DataSource dataSource;

	// connect to data base
	public Connection connect() throws SQLException, ClassNotFoundException {
		try {
			connection = this.dataSource.getConnection();
			return connection;
		} catch (final SQLException e) {
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
