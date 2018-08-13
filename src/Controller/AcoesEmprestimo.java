package Controller;

import java.sql.Date;

import Model.AbstractInformacional;
import Model.Emprestimo;
import Model.Livro;
import Model.MaterialEspecial;
import Model.Periodico;
import Model.Pessoa;
import dao.EmprestimoDAO;

public class AcoesEmprestimo {

	public void novoEmprestimo(AbstractInformacional materialInformacional, Date dataEmprestimo, Date dataDevolucao, Pessoa usuario, String status) {

		
		Emprestimo emprestimo = new Emprestimo();
		EmprestimoDAO emprestimoDAO = new EmprestimoDAO();
		Long tipoMaterial = null;

		emprestimo.setDataDevolucao(dataDevolucao);
		emprestimo.setDataEmprestimo(dataEmprestimo);
		emprestimo.setInformacional(materialInformacional);
		emprestimo.setPessoa(usuario);
		emprestimo.setStatus(status);
		
		if(materialInformacional instanceof Livro) {
			tipoMaterial = 1L;
		} else if (materialInformacional instanceof Periodico) {
			tipoMaterial = 2L;
		} else if (materialInformacional instanceof MaterialEspecial) {
			tipoMaterial = 3L;
		}

		//System.out.println(materialInformacional.getTitulo() + "  --  " +  materialInformacional.getId());
		emprestimoDAO.salvaremprestimo(emprestimo, tipoMaterial);

	}
	
}
