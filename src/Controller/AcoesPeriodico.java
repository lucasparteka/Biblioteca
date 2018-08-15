package Controller;

import java.util.ArrayList;
import Model.Periodico;
import dao.PeriodicoDAO;

public class AcoesPeriodico {

	private PeriodicoDAO periodicoDAO;

	public AcoesPeriodico() {
		periodicoDAO = new PeriodicoDAO();
	}

	public void realizarCadastro(String codigoBarras, int estante, int exemplares, int disponiveis, String titulo,
			int issn, int ano, int volume) {

		Periodico periodico = new Periodico();
		periodico.setAno(ano);
		periodico.setCodigoBarras(codigoBarras);
		periodico.setDisponiveis(disponiveis);
		periodico.setEstante(estante);
		periodico.setExemplares(exemplares);
		periodico.setIssn(issn);
		periodico.setTitulo(titulo);
		periodico.setVolume(volume);

		periodicoDAO.salvarPeriodico(periodico);
	}

	public Periodico pesquisarPeriodico(Long id) {
		return periodicoDAO.buscarPeriodico(id);
	}

	public ArrayList<Periodico> retornaPeriodicos(int pageIndex) {
		return periodicoDAO.buscarPeriodicos(pageIndex * 3);
	}
	
	public int retornaQuantidade() {
		return periodicoDAO.retornaQuantidade();
	}

}
