package Controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import Model.Editora;
import dao.EditoraDAO;

/**
 *
 * @author lparteka
 */

public class AcoesEditora {

	private EditoraDAO editoraDAO;

	public AcoesEditora() {
		editoraDAO = new EditoraDAO();
	}

	public void realizarCadastro(String nomeEditora, String nacionalidade, long id) {

		if (editoraDAO.getEditora(id) != null) {
			JOptionPane.showMessageDialog(null, "ID ja cadastrado, tente novamente");
		} else {
			Editora novaEditora = new Editora();
			novaEditora.setNome(nomeEditora);
			novaEditora.setNacionalidade(nacionalidade);
			novaEditora.setId(id);
			editoraDAO.addEditora(novaEditora);

		}

	}

	public ArrayList<Editora> retornaEditoras() {
		ArrayList<Editora> listEditoras = new ArrayList<>();
		listEditoras = editoraDAO.retornaEditoras();
		return listEditoras;
	}

	public Editora pesquisar(long id) {
		return editoraDAO.getEditora(id);
	}

}
