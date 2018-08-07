package Controller;

import Model.Pessoa;
import dao.PessoaDAO;
 
public class AcoesPessoa {
	
	private PessoaDAO pessoaDAO;
	
	public AcoesPessoa() {
		
		pessoaDAO = new PessoaDAO();
	}

	public void realizarCadastro(long id, String nome, String celular, String cpf) {
		
			Pessoa pessoa = new Pessoa();
			pessoa.setCpf(cpf);
			pessoa.setId(id);
			pessoa.setNome(nome);
			pessoa.setTelefone(celular);
			
			pessoaDAO.salvarPessoa(pessoa);
	}
	
	public Pessoa buscarPessoa(){
		return null;
	} 
	
}
