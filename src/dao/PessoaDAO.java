package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Pessoa;

public class PessoaDAO {

	private Connection connect = null;
	private Pessoa pessoa;

	public static final int ALTERAR_CADASTRO = 1;
	public static final int INSERIR_CADASTRO = 2;

	public void acoesTabelaPessoa(Pessoa usuario, int operacao) {

		connect = ConnectionFactory.getConexao();
		String sql = "";
		PreparedStatement stat = null;
		switch (operacao) {
		case ALTERAR_CADASTRO:
			sql = "update pessoa set nome = ?, telefone = ? where cpf = ?";
			break;
		case INSERIR_CADASTRO:
			sql = "INSERT INTO public.pessoa (nome, telefone, cpf) VALUES (?, ?, ?)";
			break;
		}
		try {
			stat = connect.prepareStatement(sql);
			stat.setString(1, usuario.getNome());
			stat.setString(2, usuario.getTelefone());
			stat.setString(3, usuario.getCpf());
			stat.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			ConnectionFactory.fecharConexao(connect, stat);
		}

	}

	public Pessoa buscarPessoa(String cpf) {

		connect = ConnectionFactory.getConexao();
		String sql = "select * from pessoa where cpf  = ?";
		pessoa = null;
		PreparedStatement stat = null;
		ResultSet result = null;

		try {
			stat = connect.prepareStatement(sql);
			stat.setString(1, cpf);
			result = stat.executeQuery();
			while (result.next()) {
				pessoa = new Pessoa();
				pessoa.setId(result.getLong("id"));
				pessoa.setNome(result.getString("nome"));
				pessoa.setCpf(result.getString("cpf"));
				pessoa.setTelefone(result.getString("telefone"));

			}

		} catch (SQLException e) {
			System.out.println("Erro");
		} finally {
			ConnectionFactory.fecharConexao(connect, stat, result);
		}
		return pessoa;
	}

	public Pessoa buscarPessoaPorId(Long id) {

		connect = ConnectionFactory.getConexao();
		String sql = "select * from pessoa where id  = ?";
		pessoa = null;
		PreparedStatement stat = null;
		ResultSet result = null;

		try {
			stat = connect.prepareStatement(sql);
			stat.setLong(1, id);
			result = stat.executeQuery();
			while (result.next()) {
				pessoa = new Pessoa();
				pessoa.setId(result.getLong("id"));
				pessoa.setNome(result.getString("nome"));
				pessoa.setCpf(result.getString("cpf"));
				pessoa.setTelefone(result.getString("telefone"));

			}

		} catch (SQLException e) {
			System.out.println("Erro");
		} finally {
			ConnectionFactory.fecharConexao(connect, stat, result);
		}
		return pessoa;
	}
}
