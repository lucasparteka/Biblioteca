package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConectionFactory {

	public static Connection getConexao() {
 
		try {
			System.out.println("abriu conexão");
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
				System.out.println("fechou connection");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void fecharConexao(Connection connection, PreparedStatement stat) {
		try {
			if (stat != null) {
				stat.close();
				System.out.println("fechou statement");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		fecharConexao(connection);
	}
	
	public static void fecharConexao(Connection connection, PreparedStatement stat, ResultSet result) {
		try {
			if (result != null) {
				result.close();
				System.out.println("fechou resultSet");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		fecharConexao(connection, stat);
	}


}
