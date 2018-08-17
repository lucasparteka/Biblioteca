package Controller;

import java.util.ArrayList;
import Model.Livro;
import dao.LivroDAO;

public class AcoesLivro {

	private LivroDAO livroDAO;
	
	public static final int ALTERAR_CADASTRO = 1;
	public static final int INSERIR_CADASTRO = 2;

	public AcoesLivro() {
		livroDAO = new LivroDAO();
	}

	public void realizarCadastro(Livro livro, int operacao) {
		
			switch (operacao) {
			case ALTERAR_CADASTRO:
				livroDAO.acoesTabelaLivro(livro, LivroDAO.ALTERAR_CADASTRO);
				break;
			case INSERIR_CADASTRO:
				livroDAO.acoesTabelaLivro(livro, LivroDAO.INSERIR_CADASTRO);
				break;
			}
		}

	public Livro pequisar(Long id) {
		return livroDAO.retornaLivro(id);
	}

	public ArrayList<Livro> retornaLivros(int pageIndex) {
		return livroDAO.retornaLivros(pageIndex * 3);
	}

	public int retornaQuantidade() {
		return livroDAO.retornaQuantidade();
	}

}
