package Controller;

import Model.Livro;
import dao.LivroDAO;

import javax.swing.JOptionPane;

public class AcoesLivro {
	
	private LivroDAO livroDAO;
	
	public AcoesLivro() {
		livroDAO  = new LivroDAO();		
	}

	public void realizarCadastro(long id, String codigoBarras, int estante, int exemplares, int disponiveis,
			String titulo, int isbn, int ano, int volume, int edicao, String editora) {
		
		if (livroDAO.getLivro(id) != null) {
			JOptionPane.showMessageDialog(null, "Esse Id ja existe");
		} else { 
			Livro novoLivro = new Livro();
			novoLivro.setCodigoBarras(codigoBarras);
			novoLivro.setEstante(estante);
			novoLivro.setExemplares(exemplares);
			novoLivro.setDisponiveis(disponiveis);
			novoLivro.setId(id);
			novoLivro.setTitulo(titulo);
			novoLivro.setISBN(isbn);
			novoLivro.setAno(ano);
			novoLivro.setVolume(volume);
			novoLivro.setEdicao(edicao);
			novoLivro.setEditora(editora);
			
			livroDAO.addLivro(novoLivro);
		}

	}

	public Livro pequisar(long id) {
		return livroDAO.getLivro(id);
	}
	

}
