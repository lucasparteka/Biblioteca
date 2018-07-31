package Controller;


import javax.swing.JOptionPane;

import Model.MaterialEspecial;
import dao.MatEspecialDAO;

public class AcoesMatEspecial {
	
	private MatEspecialDAO matEspecialDAO;
	
	public AcoesMatEspecial() {
		matEspecialDAO = new MatEspecialDAO();
	}

	public void realizarCadastro(long id, String codigoBarras, int estante, int exemplares, int disponiveis,
			String titulo, String descricao, String tipo) {

		if(matEspecialDAO.getMapMatEspecial(id) != null) {
			JOptionPane.showMessageDialog(null, "ID ja cadastrado, tente novamente");
		} else {
			MaterialEspecial matEspecial = new MaterialEspecial();
			matEspecial.setCodigoBarras(codigoBarras);
			matEspecial.setDescricao(descricao);
			matEspecial.setDisponiveis(disponiveis);
			matEspecial.setEstante(estante);
			matEspecial.setExemplares(exemplares);
			matEspecial.setId(id);
			matEspecial.setTipo(tipo);
			matEspecial.setTitulo(titulo);
			
			matEspecialDAO.addMatEspecial(matEspecial);
		}
		
	}
	
	public MaterialEspecial pesquisar(long id) {
		return matEspecialDAO.getMapMatEspecial(id);
	}

}
