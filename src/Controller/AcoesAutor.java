package Controller;

import java.util.ArrayList;
import Model.Autor;
import dao.AutorDAO;

public class AcoesAutor {

	private AutorDAO autorDAO;
	
	public static final int ALTERAR_CADASTRO = 1;
	public static final int INSERIR_CADASTRO = 2;

	public AcoesAutor() {
		autorDAO = new AutorDAO();
	}

	public void executarOperacao(Autor autor, int operacao) {
		switch(operacao) {
		case ALTERAR_CADASTRO:
			AutorDAO.executarOperacaoAutor(autor, AutorDAO.ALTERAR_CADASTRO);
			break;
		case INSERIR_CADASTRO:
			AutorDAO.executarOperacaoAutor(autor, AutorDAO.INSERIR_CADASTRO);
			break;
		}
	}

	public ArrayList<Autor> retornaAutores(int pageIndex) {
		return autorDAO.retornaAutores(pageIndex * 3);
	}

	public Autor pesquisarAutor(Long id) {
		return autorDAO.buscarAutor(id);
	}
	
	public int retornaQuantidade() {
		return autorDAO.retornaQuantidade();
	}

}
