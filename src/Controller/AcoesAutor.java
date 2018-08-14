package Controller;

import java.util.ArrayList;
import Model.Autor;
import dao.AutorDAO;

public class AcoesAutor {

	private AutorDAO autorDAO;

	public AcoesAutor() {
		autorDAO = new AutorDAO();
	}

	public void realizarCadastro(String nome, String sobrenome) {

		Autor novoAutor = new Autor();
		novoAutor.setNome(nome);
		novoAutor.setSobreNome(sobrenome);

		autorDAO.cadastrarAutor(novoAutor);

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
