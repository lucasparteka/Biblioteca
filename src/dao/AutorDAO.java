package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.Autor;

public class AutorDAO {

	private static Connection connect = null;
	private Autor autor;
	private ArrayList<Autor> listAutor; 
	
	public static final int ALTERAR_CADASTRO = 1;
	public static final int INSERIR_CADASTRO = 2;
	
	public ArrayList<Autor> getListAutor() {
		return listAutor;
	}

	public void setListAutor(ArrayList<Autor> listAutor) {
		this.listAutor = listAutor;
	}

	public static void executarOperacaoAutor(Autor autor, int operacao) {

		connect = ConnectionFactory.getConexao();
		String sql = "";
		PreparedStatement stat = null;
		switch(operacao) {
		case ALTERAR_CADASTRO:
			sql = "update autor set nome = ?, sobrenome = ? where id = " + autor.getId();
			break;
		case INSERIR_CADASTRO:
			sql = "insert into autor (nome, sobrenome) values (?, ?)";
			break;
		}
		try {
			stat = connect.prepareStatement(sql);
			stat.setString(1, autor.getNome());
			stat.setString(2, autor.getSobreNome());
			//stat.setLong(3, autor.getId());
			stat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.fecharConexao(connect, stat);
		}

	}
	
	public Autor buscarAutor(Long idAutor) {

		connect = ConnectionFactory.getConexao();
		String sql = "select * from autor where id = ?";
		PreparedStatement stat = null;
		ResultSet result = null;

		try {
			stat = connect.prepareStatement(sql);
			stat.setLong(1, idAutor);
			result = stat.executeQuery();
			while (result.next()) {
				autor = new Autor();
				autor.setId(result.getLong("id"));
				autor.setNome(result.getString("nome"));
				autor.setSobreNome(result.getString("sobrenome"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.fecharConexao(connect, stat, result);
		}

		return autor;
	}

	public ArrayList<Autor> retornaAutores(int offset) {

		connect = ConnectionFactory.getConexao();
		ArrayList<Autor> listAutor = new ArrayList<>();
		String sql = "select * from autor order by id limit 3 offset ?";
		PreparedStatement stat = null;
		ResultSet result = null;

		try {
			stat = connect.prepareStatement(sql);
			stat.setInt(1, offset);
			result = stat.executeQuery();
			while (result.next()) {
				autor = new Autor();
				autor.setId(result.getLong("id"));
				autor.setNome(result.getString("nome"));
				autor.setSobreNome(result.getString("sobrenome"));
				listAutor.add(autor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.fecharConexao(connect, stat, result);
		}

		return listAutor;
	}
	
	public int retornaQuantidade(){
		int quantidade = 0;
		connect = ConnectionFactory.getConexao();
		String sql = "select count(*) from autor";
		PreparedStatement stat = null;
		ResultSet result = null;
		try {
			stat = connect.prepareStatement(sql);
			result = stat.executeQuery();
			while(result.next()) {
				quantidade = result.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.fecharConexao(connect, stat, result);
		}

		return quantidade;
	}

}
