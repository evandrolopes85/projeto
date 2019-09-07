package dev.evandro.projeto.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private Connection connection;
	
	public Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost/projeto", "evandro", "evandro");
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
}
