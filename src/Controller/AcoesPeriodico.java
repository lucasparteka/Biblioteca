package Controller;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import Model.Periodico;
import dao.PeriodicoDAO;

public class AcoesPeriodico {
	
	private PeriodicoDAO periodicoDAO;
	
	

	public AcoesPeriodico() {
		periodicoDAO = new PeriodicoDAO();
	}

	public static Map<Long, Periodico> mapPeriodico = new HashMap<Long, Periodico>();
	
	

	public void realizarCadastro(long id, String codigoBarras, int estante, int exemplares, int disponiveis,
			String titulo, int issn, int ano, int volume) {

		if (mapPeriodico.get(id) != null) {
			JOptionPane.showMessageDialog(null, "ID ja cadastrado, tente novamente");
		} else {
			
			Periodico periodico = new Periodico();
			periodico.setAno(ano);
			periodico.setCodigoBarras(codigoBarras);
			periodico.setDisponiveis(disponiveis);
			periodico.setEstante(estante);
			periodico.setExemplares(exemplares);
			periodico.setId(id);
			periodico.setIssn(issn);
			periodico.setTitulo(titulo);
			periodico.setVolume(volume);
			
			periodicoDAO.addPeriodico(periodico);
		}

	}
	
	public Periodico pesquisarPeriodicoPorId(Long id) {
		return periodicoDAO.getMapPeriodico(id);
	}
	

}
