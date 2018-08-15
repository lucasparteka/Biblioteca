package Controller;

import java.sql.Date;
import java.util.ArrayList;

import Model.AbstractInformacional;
import Model.Emprestimo;
import Model.Livro;
import Model.MaterialEspecial;
import Model.Periodico;
import Model.Pessoa;
import dao.EmprestimoDAO;
import dao.LivroDAO;
import dao.MatEspecialDAO;
import dao.PeriodicoDAO;

public class AcoesEmprestimo {

	private EmprestimoDAO emprestimoDAO;
	private LivroDAO livroDAO;
	private PeriodicoDAO periodicoDAO;
	private MatEspecialDAO matEspecialDAO;

	public static final int EXCLUIR_EMPRESTIMO = 1;
	public static final int DEVOLVER_EMPRESTIMO = 2;

	public AcoesEmprestimo() {
		emprestimoDAO = new EmprestimoDAO();
	}

	public void novoEmprestimo(AbstractInformacional materialInformacional, Date dataEmprestimo, Date dataDevolucao,
			Pessoa usuario, String status) {
		Emprestimo emprestimo = new Emprestimo();
		Long tipoMaterial = null;
		emprestimo.setDataDevolucao(dataDevolucao);
		emprestimo.setDataEmprestimo(dataEmprestimo);
		emprestimo.setInformacional(materialInformacional);
		emprestimo.setPessoa(usuario);
		emprestimo.setStatus(status);

		if (materialInformacional instanceof Livro) {
			tipoMaterial = 1L;
			LivroDAO.alterarQuantidade(emprestimo.getInformacional().getId(), LivroDAO.DECREMENTAR);
		} else if (materialInformacional instanceof Periodico) {
			tipoMaterial = 2L;
			PeriodicoDAO.alterarQuantidade(emprestimo.getInformacional().getId(), PeriodicoDAO.DECREMENTAR);
		} else if (materialInformacional instanceof MaterialEspecial) {
			tipoMaterial = 3L;
			MatEspecialDAO.alterarQuantidade(emprestimo.getInformacional().getId(), MatEspecialDAO.DECREMENTAR);
		}
		emprestimoDAO.salvaremprestimo(emprestimo, tipoMaterial);

	}

	public ArrayList<Emprestimo> retornaEmprestimos(int pageIndex) {
		return emprestimoDAO.retornaEmprestimos(pageIndex * 3);
	}

	public int retornaQuantidade() {
		return emprestimoDAO.retornaQuantidade();
	}

	public static void alterarStatusEmprestimo(Emprestimo emprestimo, int operacao) {

		switch (operacao) {
		case DEVOLVER_EMPRESTIMO:
			EmprestimoDAO.alterarEmprestimo(emprestimo.getId(), EmprestimoDAO.DEVOLVER_EMPRESTIMO);
			if (emprestimo.getInformacional() instanceof Livro) {
				LivroDAO.alterarQuantidade(emprestimo.getInformacional().getId(), LivroDAO.INCREMENTAR);
			} else if (emprestimo.getInformacional() instanceof Periodico) {
				PeriodicoDAO.alterarQuantidade(emprestimo.getInformacional().getId(), PeriodicoDAO.INCREMENTAR);
			} else if (emprestimo.getInformacional() instanceof MaterialEspecial) {
				MatEspecialDAO.alterarQuantidade(emprestimo.getInformacional().getId(), MatEspecialDAO.INCREMENTAR);
			}
			break;
		case EXCLUIR_EMPRESTIMO:
			EmprestimoDAO.alterarEmprestimo(emprestimo.getId(), EmprestimoDAO.EXCLUIR_EMPRESTIMO);
			if (emprestimo.getInformacional() instanceof Livro) {
				LivroDAO.alterarQuantidade(emprestimo.getInformacional().getId(), LivroDAO.INCREMENTAR);
			} else if (emprestimo.getInformacional() instanceof Periodico) {
				PeriodicoDAO.alterarQuantidade(emprestimo.getInformacional().getId(), PeriodicoDAO.INCREMENTAR);
			} else if (emprestimo.getInformacional() instanceof MaterialEspecial) {
				MatEspecialDAO.alterarQuantidade(emprestimo.getInformacional().getId(), MatEspecialDAO.INCREMENTAR);
			}
			break;
		}

	}
}
