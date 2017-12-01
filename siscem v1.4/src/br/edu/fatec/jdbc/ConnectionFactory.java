package br.edu.fatec.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	/*	
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "system";
	private static final String PASS = "gabriela";
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	*/
	
	private static final String URL = "jdbc:mysql://sql3.freemysqlhosting.net/sql3147220";
	private static final String USER = "sql3147220";
	private static final String PASS = "QGLaCYxbKw";
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	
	public Connection getConnection() {

		try {
			try {
				Class.forName(DRIVER);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return DriverManager.getConnection(URL,USER,PASS);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}
