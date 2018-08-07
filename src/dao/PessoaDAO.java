package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

	public void buscarPessoa() {

		String sql = "SELECT e.id, p.nome, dataemprestimo, datadevolucao, status, tm.descricao, l.titulo"
				+ " from public.emprestimos e" + " inner join livro l on l.id = e.id_material"
				+ " inner join tipomaterial tm on tm.id = e.tipo_material" + " inner join pessoa p on p.id = e.id_usuario"
				+ " where e.tipo_material = 1" + " union"
				+ " SELECT e.id, p.nome, dataemprestimo, datadevolucao, status, tm.descricao, l.titulo"
				+ " from public.emprestimos e" + " inner join periodicos l on l.id = e.id_material"
				+ " inner join tipomaterial tm on tm.id = e.tipo_material" + " inner join pessoa p on p.id = e.id_usuario"
				+ " where e.tipo_material = 2" + " union"
				+ " SELECT e.id, p.nome, dataemprestimo, datadevolucao, status, tm.descricao, l.titulo"
				+ " from public.emprestimos e" + " inner join materialespecial l on l.id = e.id_material"
				+ " inner join tipomaterial tm on tm.id = e.tipo_material" + " inner join pessoa p on p.id = e.id_usuario"
				+ " where e.tipo_material = 3";

		// Pessoa pessoa;
		PreparedStatement stat = null;
		ResultSet result = null;
		// ArrayList<Pessoa> listPessoa = new ArrayList<>();

		try {
			stat = connect.prepareStatement(sql);
			result = stat.executeQuery();

			while (result.next()) {
				System.out.println(result.getInt("id") + result.getString("nome") +
				 result.getString("descricao")
				 + result.getString("titulo"));
				// System.out.println(result.getInt());
				// pessoa = new Pessoa();
				// pessoa.setId(result.getLong("id"));
				// pessoa.setNome(result.getString("nome"));
				// pessoa.setCpf(result.getString("cpf"));
				// pessoa.setTelefone(result.getString("telefone"));
				// listPessoa.add(pessoa);

			}
		} catch (SQLException e) {
			System.out.println("Erro");
		} finally {
			ConectionFactory.fecharConexao(connect, stat, result);
		}

	}
}
