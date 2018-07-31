package dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import Model.Livro;

public class LivroDAO {
	
	private static Map<Long, Livro> mapLivro = new HashMap<Long, Livro>();
	
	public Livro getLivro(long id) {
		return mapLivro.get(id);
	} 

	public void addLivro(Livro livro) {
		LivroDAO.mapLivro.put(livro.getId(), livro);
	}
	
	public ArrayList<Livro> retornaLivros() {
		Collection<Livro> value = mapLivro.values();
		return new ArrayList<>(value);
	}
	
	public void reduzirDisponiveis(Long id) {
		mapLivro.get(id).setDisponiveis(mapLivro.get(id).getDisponiveis() -1);
	}
	
	public void aumentarDisponiveis(Long id) {
		mapLivro.get(id).setDisponiveis(mapLivro.get(id).getDisponiveis() +1);
	}

}
