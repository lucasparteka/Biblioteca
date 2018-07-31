package dao;

import java.util.HashMap;
import java.util.Map;

import Model.Pessoa;

public class PessoaDAO {
	
	private static Map<String, Pessoa> mapPessoa = new HashMap<String, Pessoa>();

	public Pessoa getPessoa(String cpf) {
		return mapPessoa.get(cpf);
	}

	public void addPessoa(Pessoa pessoa) {
		PessoaDAO.mapPessoa.put(pessoa.getCpf(), pessoa);
	}
	
}
