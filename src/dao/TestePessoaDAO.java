package dao;


import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import Controller.AcoesPessoa;
import Model.Pessoa;
 
class TestePessoaDAO {
	
	AcoesPessoa acoesPessoa = new AcoesPessoa();
	PessoaDAO pessoaDAO;
	Pessoa pessoa;
	
	@Ignore
	public void inserirPessoa() {
		acoesPessoa = new AcoesPessoa();
		Pessoa pessoa = new Pessoa();
		pessoa.setCpf("098098098");
		pessoa.setId(345L);
		pessoa.setNome("Juca");
		pessoa.setTelefone("09809");
		
		acoesPessoa.realizarCadastro(pessoa.getId(), pessoa.getNome(), pessoa.getTelefone(), pessoa.getCpf());
	}
	
	@Test
	public void buscarPessoas() {
		pessoaDAO = new PessoaDAO();
//		//pessoa = new Pessoa();
//		acoesPessoa.buscarPessoa();
		pessoaDAO.buscarPessoa();
		
	}

}
