package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Model.Emprestimo;
import Model.Livro;
import Model.MaterialEspecial;
import Model.Periodico;
import Pojo.TabelaEmprestimoPojo;

public class DevolucoesDAO {

//	private static Map<Long, Emprestimo> listDevolucoes = new HashMap<Long, Emprestimo>();
//
//	public static Emprestimo getListDevolucoes(Long id) {
//		return listDevolucoes.get(id);
//	}
//
//	public void addDevolucao(Emprestimo novaDevolucao) {
//		DevolucoesDAO.listDevolucoes.put(novaDevolucao.getId(), novaDevolucao);
//		aumentarDisponivel(novaDevolucao);
//	}
//	
//	public void aumentarDisponivel(Emprestimo novaDevolucao) {
//		
//		if (novaDevolucao.getInformacional() instanceof Livro) {
//			Livro livro  = (Livro) novaDevolucao.getInformacional();
//			LivroDAO livroDao = new LivroDAO();
//			livroDao.aumentarDisponiveis(livro.getId());
//			
//		} else if(novaDevolucao.getInformacional() instanceof Periodico) {
//			Periodico periodico = (Periodico) novaDevolucao.getInformacional();
//			PeriodicoDAO periodicoDAO = new PeriodicoDAO();
//			periodicoDAO.aumentarDisponiveis(periodico.getId());
//			
//		} else if(novaDevolucao.getInformacional() instanceof MaterialEspecial) {
//			MaterialEspecial materialEspecial = (MaterialEspecial) novaDevolucao.getInformacional();
//			MatEspecialDAO matEspecialDAO = new MatEspecialDAO();
//			matEspecialDAO.aumentarDisponiveis(materialEspecial.getId());
//		}
//	}
//	
//	public ArrayList<TabelaEmprestimoPojo> retornaDevolucoes(){
//		
//		ArrayList<TabelaEmprestimoPojo> listaDevolucoes = new ArrayList<>();
//		
//		for(Emprestimo emprestimo : listDevolucoes.values()) {
//			
//			String tipoMaterial = "";
//			
//			if (emprestimo.getInformacional() instanceof Livro) {
//				tipoMaterial = "Livro";
//			} else if (emprestimo.getInformacional() instanceof Periodico) {
//				tipoMaterial = "Periodico";
//			} else if (emprestimo.getInformacional() instanceof MaterialEspecial) {
//				tipoMaterial = "Mat. Especial";
//			}
//			
//			TabelaEmprestimoPojo tabelaEmprestimoPojo = new TabelaEmprestimoPojo();
//			
//			tabelaEmprestimoPojo.setDataDevolucao(emprestimo.getDataDevolucao());
//			tabelaEmprestimoPojo.setDataEmprestimo(emprestimo.getDataEmprestimo());
//			tabelaEmprestimoPojo.setId(emprestimo.getId());
//			tabelaEmprestimoPojo.setTipoMaterial(tipoMaterial);
//			tabelaEmprestimoPojo.setTitulo(emprestimo.getInformacional().getTitulo());
//			tabelaEmprestimoPojo.setUsuario(emprestimo.getPessoa().getNome());
//			
//			listaDevolucoes.add(tabelaEmprestimoPojo);
//			
//		}
//		
//		return listaDevolucoes;
//	}
//	
}
