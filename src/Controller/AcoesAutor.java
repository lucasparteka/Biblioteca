package Controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import Model.Autor;
import dao.AutorDAO;

public class AcoesAutor {

	private AutorDAO autorDAO;
	
	public AcoesAutor() {
		autorDAO = new AutorDAO();
	}

	public void realizarCadastro(String nome, String sobrenome, long id) {

		if (autorDAO.getAutor(id) != null) {
			JOptionPane.showMessageDialog(null, "ID ja cadastrado, tente novamente");
		} else {
			Autor novoAutor = new Autor();
			novoAutor.setNome(nome);
			novoAutor.setSobreNome(sobrenome);
			novoAutor.setId(id);

			autorDAO.addAutor(novoAutor);
		}

	}
	
	public ArrayList<Autor> retornaAutores(){
		ArrayList<Autor> listAutores = new ArrayList<>();
		
		listAutores = autorDAO.retornaAutores();
		
		return listAutores;
	}
	
	public Autor pesquisar(Long id) {
		return autorDAO.getAutor(id);
	}

}
