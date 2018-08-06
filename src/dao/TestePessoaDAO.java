package dao;


import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import Controller.AcoesPessoa;
import Model.Pessoa;
 
class TestePessoaDAO {
	
	AcoesPessoa acoesPessoa = new AcoesPessoa();

	
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
		
		Pessoa pessoa = new Pessoa();
		pessoa = acoesPessoa.buscarPessoa("4567");
		if(pessoa != null) {
			System.out.println(pessoa.getNome());
		} else {
			System.out.println("CPF não encontrado");
		}
		
	}

}
