package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.Autor;

public class AutorDAO {

	private Connection connect = null;
	private Autor autor;
	private ArrayList<Autor> listAutor;
	
	public ArrayList<Autor> getListAutor() {
		return listAutor;
	}

	public void setListAutor(ArrayList<Autor> listAutor) {
		this.listAutor = listAutor;
	}

	public AutorDAO() {
		Autor autor1 = new Autor();
		autor1.setNome("Lucas");
		autor1.setSobreNome("Leal");
		Autor autor2 = new Autor();
		autor2.setNome("Andre");
		autor2.setSobreNome("Leal");
		Autor autor3 = new Autor();
		autor3.setNome("Bruna");
		autor3.setSobreNome("Leal");
		Autor autor4 = new Autor();
		autor4.setNome("Marcia");
		autor4.setSobreNome("Leal");
		Autor autor5 = new Autor();
		autor5.setNome("Juca");
		autor5.setSobreNome("Leal");
		Autor autor6 = new Autor();
		autor6.setNome("Antonio");
		autor6.setSobreNome("Leal");
		Autor autor7 = new Autor();
		autor7.setNome("Pedro");
		autor7.setSobreNome("Leal");
		Autor autor8 = new Autor();
		autor8.setNome("José");
		autor8.setSobreNome("Leal");
		Autor autor9 = new Autor();
		autor9.setNome("Catia");
		autor9.setSobreNome("Leal");
		
		listAutor = new ArrayList<>();
		listAutor.add(autor1);
		listAutor.add(autor2);
		listAutor.add(autor3);
		listAutor.add(autor4);
		listAutor.add(autor5);
		listAutor.add(autor6);
		listAutor.add(autor7);
		listAutor.add(autor8);

		
	}

	public void cadastrarAutor(Autor autor) {

		connect = ConnectionFactory.getConexao();
		PreparedStatement stat = null;
		String sql = "insert into autor (nome, sobrenome) values (?, ?)";

		try {
			stat = connect.prepareStatement(sql);
			stat.setString(1, autor.getNome());
			stat.setString(2, autor.getSobreNome());
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

	public ArrayList<Autor> buscarAutores() {

		connect = ConnectionFactory.getConexao();
		ArrayList<Autor> listAutor = new ArrayList<>();
		String sql = "select * from autor";
		PreparedStatement stat = null;
		ResultSet result = null;

		try {
			stat = connect.prepareStatement(sql);
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
	
	public ArrayList<Autor> autoresPaginacao(){
		//ArrayList<Autor> tresAutores = new ArrayList<>();
		
		return listAutor;
	}

}
