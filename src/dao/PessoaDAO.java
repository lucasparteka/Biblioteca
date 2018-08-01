package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import Model.Pessoa;

public class PessoaDAO {
	
	public void salvarPessoa(Long idPessoa, String nomePessoa, String telefonePessoa, String cpfPessoa) {
		String sql = "INSERT INTO pessoa (id, nome, telefone, cpf) VALUES "
				+ "('" +idPessoa+ "', '" +nomePessoa+ "', '" +telefonePessoa+ "', '" +cpfPessoa+ "')";
		
		Connection conect = ConectionFactory.getConexao();
		try {
			Statement stat = conect.createStatement();
			System.out.println(stat.executeUpdate(sql));
			ConectionFactory.fecharConexao(conect, stat);
		} catch (SQLException e) {
			e.printStackTrace();
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
