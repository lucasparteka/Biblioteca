package Controller;

import java.util.ArrayList;
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

	public void realizarCadastro(String nomeEditora, String nacionalidade) {

			Editora novaEditora = new Editora();
			novaEditora.setNome(nomeEditora);
			novaEditora.setNacionalidade(nacionalidade);
			editoraDAO.salvarEditora(novaEditora);

		
	}

	public ArrayList<Editora> retornaEditoras(int indexPage) {
		return editoraDAO.buscarEditoras(indexPage * 3);
	}

	public Editora pesquisar(Long id) {
		return editoraDAO.buscarEditora(id);
	}

	public int retornaQuantidade() {
		return editoraDAO.retornaQuantidade();
	}
}
