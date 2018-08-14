package Controller;

import java.util.ArrayList;
import Model.Livro;
import dao.AutorDAO;
import dao.EditoraDAO;
import dao.LivroDAO;

public class AcoesLivro {
	
	private LivroDAO livroDAO;
	private EditoraDAO editoraDAO;
	private AutorDAO autorDAO;
	
	public AcoesLivro() {
		livroDAO  = new LivroDAO();		
	}

	public void realizarCadastro(String codigoBarras, int estante, int exemplares, int disponiveis,
			String titulo, int isbn, int ano, int volume, int edicao, Long idEditora, Long idAutor) {
		
			Livro novoLivro = new Livro();
			editoraDAO = new EditoraDAO();
			autorDAO = new AutorDAO();
			
			novoLivro.setCodigoBarras(codigoBarras);
			novoLivro.setEstante(estante);
			novoLivro.setExemplares(exemplares);
			novoLivro.setDisponiveis(disponiveis);
			novoLivro.setTitulo(titulo);
			novoLivro.setISBN(isbn);
			novoLivro.setAno(ano);
			novoLivro.setVolume(volume);
			novoLivro.setEdicao(edicao);
			novoLivro.setEditora(editoraDAO.buscarEditora(idEditora));
			novoLivro.setAutor(autorDAO.buscarAutor(idAutor));
			
			livroDAO.salvarLivro(novoLivro);
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
