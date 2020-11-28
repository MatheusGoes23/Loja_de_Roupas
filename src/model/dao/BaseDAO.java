package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class BaseDAO<VO> {
	private static Connection conn = null;
	final static String url = "jdbc:postgresql://localhost:5432/TesteProva";
	final static String usuario = "postgres";
	final static String senha = "abc321";

	public static Connection getConnection() {
		if (conn == null) {
			try {
				conn = DriverManager.getConnection(url, usuario, senha);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return conn;
		} else {
			return conn;
		}
	}

	public static void closeConnection() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
