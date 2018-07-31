package Controller;

import Model.AbstractInformacional;
import Model.Emprestimo;
import Model.Pessoa;
import dao.EmprestimoDAO;

public class AcoesEmprestimo {

	public void novoEmprestimo(AbstractInformacional tipoMaterial, Long id, String dataEmprestimo, String dataDevolucao,
			Pessoa pessoa) {

		Emprestimo emprestimo = new Emprestimo();
		EmprestimoDAO gravarEmprestimo = new EmprestimoDAO();

		emprestimo.setDataDevolucao(dataDevolucao);
		emprestimo.setDataEmprestimo(dataEmprestimo);
		emprestimo.setId(id);
		emprestimo.setInformacional(tipoMaterial);
		emprestimo.setPessoa(pessoa);

		gravarEmprestimo.addEmprestimo(emprestimo);

	}
	
	public void registrarDevolucao(Long id) {
		EmprestimoDAO emprestimoDAO = new EmprestimoDAO();
		emprestimoDAO.registarDevolucao(id);
		
	}

	public void cancelaremprestimo(Long id) {
		EmprestimoDAO emprestimoDAO = new EmprestimoDAO();
		emprestimoDAO.cancelarEmprestimo(id);
	}
}
