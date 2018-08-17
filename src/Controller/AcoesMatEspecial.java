package Controller;

import java.util.ArrayList;

import Model.MaterialEspecial;
import dao.MatEspecialDAO;

public class AcoesMatEspecial {

	private MatEspecialDAO matEspecialDAO;

	public static final int ALTERAR_CADASTRO = 1;
	public static final int INSERIR_CADASTRO = 2;

	public AcoesMatEspecial() {
		matEspecialDAO = new MatEspecialDAO();
	}

	public void acoesMatEspecialController(MaterialEspecial materialEspecial, int operacao) {
		switch (operacao) {
		case ALTERAR_CADASTRO:
			matEspecialDAO.salvarMaterialEspecial(materialEspecial, MatEspecialDAO.ALTERAR_CADASTRO);
			break;
		case INSERIR_CADASTRO:
			matEspecialDAO.salvarMaterialEspecial(materialEspecial, MatEspecialDAO.INSERIR_CADASTRO);
			break;
		}
	}

	public MaterialEspecial buscarMatEspecial(Long id) {
		return matEspecialDAO.buscarMatEspecial(id);
	}

	public ArrayList<MaterialEspecial> retornaMatEspeciais(int pageIndex) {
		return matEspecialDAO.retornaMatEspeciais(pageIndex * 3);
	}

	public int retornaQuantidade() {
		return matEspecialDAO.retornaQuantidade();
	}

}
