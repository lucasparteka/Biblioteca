package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConectionFactory {

	public static Connection getConexao() {

		try {
			System.out.println("sucesso!");
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/biblioteca", "postgres", "cad@1");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void fecharConexao(Connection connection) {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void fecharConexao(Connection connection, Statement stat) {
		fecharConexao(connection);
		try {
			if (stat != null) {
				stat.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
