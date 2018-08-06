package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Pessoa;

public class PessoaDAO {

	private Connection connect = null;

	public PessoaDAO() {
		connect = ConectionFactory.getConexao();

	}

	public void salvarPessoa(Pessoa pessoa) {

		String sql = "INSERT INTO pessoa (id, nome, telefone, cpf) VALUES (?, ?, ?, ?)";
		PreparedStatement stat = null;
		try {
			stat = connect.prepareStatement(sql);
			stat.setLong(1, pessoa.getId());
			stat.setString(2, pessoa.getNome());
			stat.setString(3, pessoa.getTelefone());
			stat.setString(4, pessoa.getCpf());
			stat.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			ConectionFactory.fecharConexao(connect, stat);
		}

	}

	public Pessoa buscarPessoa(String cpf) {

		String sql = "SELECT * FROM emprestimos where id = 1";
		Pessoa pessoa = null;
		PreparedStatement stat = null;
		ResultSet result = null;
		

		try {
			stat = connect.prepareStatement(sql);
			//stat.setString(1, cpf);
			result = stat.executeQuery();

			if (result.next() == false) {
				return null;
			} else {
				System.out.println(result.getString("tipo_material"));
//				pessoa = new Pessoa();
//				pessoa.setId(result.getLong("id"));
//				pessoa.setNome(result.getString("nome"));
//				pessoa.setCpf(result.getString("cpf"));
//				pessoa.setTelefone(result.getString("telefone"));
			}
		} catch (SQLException e) {
			System.out.println("Erro");
		} finally {
			ConectionFactory.fecharConexao(connect, stat, result);
		}

		return pessoa;
	}
}
