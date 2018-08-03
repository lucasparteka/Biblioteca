package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import Model.Pessoa;

public class PessoaDAO {

	private Connection conect = null;

	public PessoaDAO() {
		conect = ConectionFactory.getConexao();
		
	}

	public void salvarPessoa(Pessoa pessoa) {

		String sql = "INSERT INTO pessoa (id, nome, telefone, cpf) VALUES (?, ?, ?, ?)";
		PreparedStatement stat = null;
		try {
			stat = conect.prepareStatement(sql);
			stat.setLong(1, pessoa.getId());
			stat.setString(2, pessoa.getNome());
			stat.setString(3, pessoa.getTelefone());
			stat.setString(4, pessoa.getCpf());
			stat.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			ConectionFactory.fecharConexao(conect, stat);
		}

	}

	private static Map<String, Pessoa> mapPessoa = new HashMap<String, Pessoa>();

	public Pessoa getPessoa(String cpf) {
		return mapPessoa.get(cpf);
	}

	public void addPessoa(Pessoa pessoa) {
		PessoaDAO.mapPessoa.put(pessoa.getCpf(), pessoa);
	}

}
