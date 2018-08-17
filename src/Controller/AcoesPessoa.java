package Controller;

import Model.Pessoa;
import dao.PessoaDAO;

public class AcoesPessoa {

	private PessoaDAO pessoaDAO;

	public static final int ALTERAR_CADASTRO = 1;
	public static final int INSERIR_CADASTRO = 2;

	public AcoesPessoa() {
		pessoaDAO = new PessoaDAO();
	}

	public void acoesPessoaController(Pessoa pessoa, int operacao) {
		switch(operacao) {
		case ALTERAR_CADASTRO:
			pessoaDAO.acoesTabelaPessoa(pessoa, PessoaDAO.ALTERAR_CADASTRO);
			break;
		case INSERIR_CADASTRO:
			pessoaDAO.acoesTabelaPessoa(pessoa, PessoaDAO.INSERIR_CADASTRO);
			break;
		}
	}

	public Pessoa buscarPessoa(String cpf) {
		return pessoaDAO.buscarPessoa(cpf);
	}

	public boolean verificarCadastro(String cpf) {
		if (pessoaDAO.buscarPessoa(cpf) == null) {
			return false;
		} else {
			return true;
		}

	}

}
