package Controller;

import java.util.ArrayList;
import Model.Periodico;
import dao.PeriodicoDAO;

public class AcoesPeriodico {

	private PeriodicoDAO periodicoDAO;

	public static final int ALTERAR_CADASTRO = 1;
	public static final int INSERIR_CADASTRO = 2;
	
	public AcoesPeriodico() {
		periodicoDAO = new PeriodicoDAO();
	}

	public void acoesPeriodicoController(Periodico periodico, int operacao) {

		switch (operacao) {
		case ALTERAR_CADASTRO:
			periodicoDAO.salvarPeriodico(periodico, PeriodicoDAO.ALTERAR_CADASTRO);
			break;
		case INSERIR_CADASTRO:
			periodicoDAO.salvarPeriodico(periodico, PeriodicoDAO.INSERIR_CADASTRO);
			break;
			
		}
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
