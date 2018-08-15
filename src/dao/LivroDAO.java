package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Autor;
import Model.Editora;
import Model.Livro;

public class LivroDAO {

	private static Connection connect;
	private Livro livro;
	private Editora editora;
	private Autor autor;

	public static final int INCREMENTAR = 1;
	public static final int DECREMENTAR = 2;

	public void salvarLivro(Livro livro) {

		connect = ConnectionFactory.getConexao();
		PreparedStatement stat = null;
		String sql = "insert into livro (titulo, codbarras, estante, exemplares, disponiveis, isbn, ano, volume, edicao, editora, autor)"
				+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			stat = connect.prepareStatement(sql);
			stat.setString(1, livro.getTitulo());
			stat.setString(2, livro.getCodigoBarras());
			stat.setInt(3, livro.getEstante());
			stat.setInt(4, livro.getExemplares());
			stat.setInt(5, livro.getDisponiveis());
			stat.setInt(6, livro.getISBN());
			stat.setInt(7, livro.getAno());
			stat.setInt(8, livro.getVolume());
			stat.setInt(9, livro.getEdicao());
			stat.setLong(10, livro.getEditora().getId());
			stat.setLong(11, livro.getAutor().getId());
			stat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.fecharConexao(connect, stat);
		}
	}

	public Livro retornaLivro(Long id) {
		connect = ConnectionFactory.getConexao();
		PreparedStatement stat = null;
		ResultSet result = null;
		String sql = "select l.ano, l.codbarras, l.disponiveis, l.edicao, l.estante, l.exemplares, l.id as id_livro, l.isbn, l.titulo, l.volume,"
				+ " e.id as id_editora, e.nacionalidade, e.nome as nome_editora, a.id as id_autor, a.nome as nome_autor, a.sobrenome as sobrenome_autor"
				+ " from livro l" + " inner join editora e on e.id = l.editora"
				+ " inner join autor a on a.id = l.autor" + " where l.id = ?";

		try {
			stat = connect.prepareStatement(sql);
			stat.setLong(1, id);
			result = stat.executeQuery();
			while (result.next()) {
				livro = new Livro();
				autor = new Autor();
				editora = new Editora();
				autor.setId(result.getLong("id_autor"));
				autor.setNome(result.getString("nome_autor"));
				autor.setSobreNome(result.getString("sobrenome_autor"));
				editora.setId(result.getLong("id_editora"));
				editora.setNacionalidade(result.getString("nacionalidade"));
				editora.setNome(result.getString("nome_editora"));
				livro.setAno(result.getInt("ano"));
				livro.setCodigoBarras(result.getString("codbarras"));
				livro.setDisponiveis(result.getInt("disponiveis"));
				livro.setEdicao(result.getInt("edicao"));
				livro.setEstante(result.getInt("estante"));
				livro.setExemplares(result.getInt("exemplares"));
				livro.setId(result.getLong("id_livro"));
				livro.setISBN(result.getInt("isbn"));
				livro.setTitulo(result.getString("titulo"));
				livro.setVolume(result.getInt("volume"));
				livro.setAutor(autor);
				livro.setEditora(editora);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.fecharConexao(connect, stat, result);
		}
		return livro;
	}

	public ArrayList<Livro> retornaLivros(int pageIndex) {

		ArrayList<Livro> listLivro = new ArrayList<>();
		connect = ConnectionFactory.getConexao();
		PreparedStatement stat = null;
		ResultSet result = null;
		String sql = "select l.ano, l.codbarras, l.disponiveis, l.edicao, l.estante, l.exemplares, l.id as id_livro, l.isbn, l.titulo, l.volume,"
				+ " e.id as id_editora, e.nacionalidade, e.nome as nome_editora, a.id as id_autor, a.nome as nome_autor, a.sobrenome as sobrenome_autor"
				+ " from livro l" + " inner join editora e on e.id = l.editora"
				+ " inner join autor a on a.id = l.autor order by id_livro limit 3 offset ?";

		try {
			stat = connect.prepareStatement(sql);
			stat.setInt(1, pageIndex);
			result = stat.executeQuery();
			while (result.next()) {
				livro = new Livro();
				autor = new Autor();
				editora = new Editora();
				autor.setId(result.getLong("id_autor"));
				autor.setNome(result.getString("nome_autor"));
				autor.setSobreNome(result.getString("sobrenome_autor"));
				editora.setId(result.getLong("id_editora"));
				editora.setNacionalidade(result.getString("nacionalidade"));
				editora.setNome(result.getString("nome_editora"));
				livro.setAno(result.getInt("ano"));
				livro.setCodigoBarras(result.getString("codbarras"));
				livro.setDisponiveis(result.getInt("disponiveis"));
				livro.setEdicao(result.getInt("edicao"));
				livro.setEstante(result.getInt("estante"));
				livro.setExemplares(result.getInt("exemplares"));
				livro.setId(result.getLong("id_livro"));
				livro.setISBN(result.getInt("isbn"));
				livro.setTitulo(result.getString("titulo"));
				livro.setAutor(autor);
				livro.setEditora(editora);

				listLivro.add(livro);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.fecharConexao(connect, stat, result);
		}
		return listLivro;
	}

	public int retornaQuantidade() {
		int quantidade = 0;
		connect = ConnectionFactory.getConexao();
		String sql = "select count(*) from livro";
		PreparedStatement stat = null;
		ResultSet result = null;
		try {
			stat = connect.prepareStatement(sql);
			result = stat.executeQuery();
			while (result.next()) {
				quantidade = result.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.fecharConexao(connect, stat, result);
		}
		return quantidade;
	}

	public static void alterarQuantidade(Long id, int operacao) {
		String sql = "";
		switch (operacao) {
		case INCREMENTAR:
			sql = "UPDATE livro set disponiveis = disponiveis + 1 where id = ? ";
			break;
		case DECREMENTAR:
			sql = "UPDATE livro set disponiveis = disponiveis - 1 where id = ? ";
			break;
		}
		connect = ConnectionFactory.getConexao();
		PreparedStatement stat = null;
		try {
			stat = connect.prepareStatement(sql);
			stat.setLong(1, id);
			stat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.fecharConexao(connect, stat);
		}
	}
}
