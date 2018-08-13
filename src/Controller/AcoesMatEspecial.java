package Controller;


import java.util.ArrayList;

import Model.MaterialEspecial;
import dao.MatEspecialDAO;

public class AcoesMatEspecial {
	
	private MatEspecialDAO matEspecialDAO;
	
	public AcoesMatEspecial() {
		matEspecialDAO = new MatEspecialDAO();
	}

	public void realizarCadastro(String codigoBarras, int estante, int exemplares, int disponiveis,
			String titulo, String descricao, int idTipoMaterial) {

			MaterialEspecial matEspecial = new MaterialEspecial();
			matEspecial.setCodigoBarras(codigoBarras);
			matEspecial.setDescricao(descricao);
			matEspecial.setDisponiveis(disponiveis);
			matEspecial.setEstante(estante);
			matEspecial.setExemplares(exemplares);
			matEspecial.setIdTipo(idTipoMaterial);
			matEspecial.setTitulo(titulo);
			
			matEspecialDAO.salvarMaterialEspecial(matEspecial);
		}
	
	public MaterialEspecial buscarMatEspecial(Long id) {
		return matEspecialDAO.buscarMatEspecial(id);
	}
	
	public ArrayList<MaterialEspecial> buscarTodosMatespecial(){
		return matEspecialDAO .buscarTodosMatEspecial();
	}

}
