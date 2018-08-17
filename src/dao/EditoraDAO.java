package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Editora;

public class EditoraDAO {
	
	private Connection connect = null;
	private Editora editora;
	
	public static final int ALTERAR_CADASTRO = 1;
	public static final int INSERIR_CADASTRO = 2;
	
	public void acoesTabelaEditora(Editora editora, int operacao) {
		PreparedStatement stat = null;
		connect = ConnectionFactory.getConexao();
		String sql = "";
		switch(operacao) {
		case ALTERAR_CADASTRO:
			sql = "update editora set nome = ?, nacionalidade = ? where id = " + editora.getId();
			break;
		case INSERIR_CADASTRO:
			sql = "insert into public.editora (nome, nacionalidade) values (?, ?)";
			break;
		}
		try {
			stat = connect.prepareStatement(sql);
			stat.setString(1, editora.getNome());
			stat.setString(2, editora.getNacionalidade());
			stat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.fecharConexao(connect, stat);
		}
	}
	
	public Editora buscarEditora(Long idEditora) {
		connect = ConnectionFactory.getConexao();
		String sql = "select * from editora where id = ?";
		PreparedStatement stat = null;
		ResultSet result = null;
		
		try {
			stat = connect.prepareStatement(sql);
			stat.setLong(1, idEditora);
			result = stat.executeQuery();
			while(result.next()) {
				editora = new Editora();
				editora.setId(result.getLong("id"));
				editora.setNome(result.getString("nome"));
				editora.setNacionalidade(result.getString("nacionalidade"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.fecharConexao(connect, stat, result);
		}
		return editora;
	}
	
	public ArrayList<Editora> buscarEditoras(int indexPage) {
		
		ArrayList<Editora> listEditora = new ArrayList<>();
		connect = ConnectionFactory.getConexao();
		String sql = "select * from editora order by id limit 3 offset ?";
		PreparedStatement stat = null;
		ResultSet result = null;
		
		try {
			stat = connect.prepareStatement(sql);
			stat.setInt(1, indexPage);
			result = stat.executeQuery();
			while(result.next()) {
				editora = new Editora();
				editora.setId(result.getLong("id"));
				editora.setNome(result.getString("nome"));
				editora.setNacionalidade(result.getString("nacionalidade"));
				listEditora.add(editora);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.fecharConexao(connect, stat, result);
		}
		return listEditora;
	}
	
	public int retornaQuantidade(){
		int quantidade = 0;
		connect = ConnectionFactory.getConexao();
		String sql = "select count(*) from editora";
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
