package Controller;

import Model.Pessoa;
import dao.PessoaDAO;
 
public class AcoesPessoa {
	
	private PessoaDAO pessoaDAO;
	
	public AcoesPessoa() {
		
		pessoaDAO = new PessoaDAO();
	}

	public void realizarCadastro(String nome, String sobrenome, String celular, String cpf) {
		
			Pessoa pessoa = new Pessoa();
			pessoa.setCpf(cpf);
			pessoa.setNome(nome + " " + sobrenome);
			pessoa.setTelefone(celular);
			
			pessoaDAO.salvarPessoa(pessoa);
			
	}
	
	public Pessoa buscarPessoa(String cpf){
		return pessoaDAO.buscarPessoa(cpf);
	} 
	
	public boolean verificarCadastro(String cpf) {
		if(pessoaDAO.buscarPessoa(cpf) == null) {
			return false;
		} else {
			return true;
		}
		
	}
	
}
