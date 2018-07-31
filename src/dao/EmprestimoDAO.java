package dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import Model.Emprestimo;
import Model.Livro;
import Model.MaterialEspecial;
import Model.Periodico;
import Pojo.TabelaEmprestimoPojo;

public class EmprestimoDAO {
	
	private static Map<Long, Emprestimo> mapEmprestimo = new HashMap<Long, Emprestimo>();
	
	public Emprestimo getEmprestimo(Long id) {
		return mapEmprestimo.get(id);
	}
	
	public void addEmprestimo (Emprestimo emprestimo) {
		EmprestimoDAO.mapEmprestimo.put(emprestimo.getId(), emprestimo);
		diminuirDisponiveis(emprestimo);
	}
	
	public void diminuirDisponiveis(Emprestimo emprestimo) {
		
		if (emprestimo.getInformacional() instanceof Livro) {
			Livro livro  = (Livro) emprestimo.getInformacional(); 
			LivroDAO livroDao = new LivroDAO();
			livroDao.reduzirDisponiveis(livro.getId());
			
		} else if(emprestimo.getInformacional() instanceof Periodico) {
			Periodico periodico = (Periodico) emprestimo.getInformacional();
			PeriodicoDAO periodicoDAO = new PeriodicoDAO();
			periodicoDAO.reduzirDisponiveis(periodico.getId());
			
		} else if(emprestimo.getInformacional() instanceof MaterialEspecial) {
			MaterialEspecial materialEspecial = (MaterialEspecial) emprestimo.getInformacional();
			MatEspecialDAO matEspecialDAO = new MatEspecialDAO();
			matEspecialDAO.reduzirDisponiveis(materialEspecial.getId());
		}
		
	}
	
	public ArrayList<Emprestimo> retornaEmprestimos() {
		Collection<Emprestimo> values = mapEmprestimo.values();
		return new ArrayList<> (values);
	}
	
	public ArrayList<TabelaEmprestimoPojo> retornaEmprestimosTabela() {
		
		ArrayList<TabelaEmprestimoPojo> listEmprestimosTabela = new ArrayList<>();

		
		for (Emprestimo emprestimo : mapEmprestimo.values()) {
			
			String tipoMaterial = "";
			
			if (emprestimo.getInformacional() instanceof Livro) {
				tipoMaterial = "Livro";
			} else if (emprestimo.getInformacional() instanceof Periodico) {
				tipoMaterial = "Periodico";
			} else if (emprestimo.getInformacional() instanceof MaterialEspecial) {
				tipoMaterial = "Mat. Especial";
			}
			
			TabelaEmprestimoPojo tabelaEmprestimoPojo = new TabelaEmprestimoPojo();

			tabelaEmprestimoPojo.setTitulo(emprestimo.getInformacional().getTitulo());
			tabelaEmprestimoPojo.setDataDevolucao(emprestimo.getDataDevolucao());
			tabelaEmprestimoPojo.setDataEmprestimo(emprestimo.getDataEmprestimo());
			tabelaEmprestimoPojo.setId(emprestimo.getId());
			tabelaEmprestimoPojo.setTipoMaterial(tipoMaterial);
			tabelaEmprestimoPojo.setUsuario(emprestimo.getPessoa().getNome());

			listEmprestimosTabela.add(tabelaEmprestimoPojo);

		}

		return listEmprestimosTabela;

	}

	public void registarDevolucao(Long id) {
		DevolucoesDAO devolucoesDAO = new DevolucoesDAO();
		devolucoesDAO.addDevolucao(mapEmprestimo.get(id));
		mapEmprestimo.remove(id);
		
	}
	
	public void cancelarEmprestimo(Long id) {
		Emprestimo emprestimo = mapEmprestimo.get(id);
		DevolucoesDAO devolucoesDAO = new DevolucoesDAO();
		devolucoesDAO.aumentarDisponivel(emprestimo);
		mapEmprestimo.remove(id);
	}

}
