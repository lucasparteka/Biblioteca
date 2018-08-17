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
	public static final int ALTERAR_CADASTRO = 1;
	public static final int INSERIR_CADASTRO = 2;
 
	public AcoesEditora() {
		editoraDAO = new EditoraDAO();
	}

	public void acoesEditoraController(Editora editora, int operacao) {

		switch(operacao) {
		case ALTERAR_CADASTRO:
			editoraDAO.acoesTabelaEditora(editora, ALTERAR_CADASTRO);
			break;
		case INSERIR_CADASTRO:
			editoraDAO.acoesTabelaEditora(editora, EditoraDAO.INSERIR_CADASTRO);
			break;
		}
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
