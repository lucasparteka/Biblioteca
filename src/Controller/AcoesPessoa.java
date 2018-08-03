package Controller;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import Model.Pessoa;
import dao.PessoaDAO;

public class AcoesPessoa {
	
	private PessoaDAO pessoaDAO;
	
	public AcoesPessoa() {
		
		pessoaDAO = new PessoaDAO();
	}

	public static Map<Long, Pessoa> mapPessoa = new HashMap<Long, Pessoa>();

	
	public void realizarCadastro(long id, String nome, String celular, String cpf) {
		
		if(pessoaDAO.getPessoa(cpf) != null) {
			JOptionPane.showMessageDialog(null, "CPF ja cadastrado, tente novamente");
		} else {
			Pessoa pessoa = new Pessoa();
			pessoa.setCpf(cpf);
			pessoa.setId(id);
			pessoa.setNome(nome);
			pessoa.setTelefone(celular);
			
			pessoaDAO.salvarPessoa(pessoa);
		}
		
	}
	
	public Pessoa pesquisar(String cpf) {
		return pessoaDAO.getPessoa(cpf);
	}
	


}
