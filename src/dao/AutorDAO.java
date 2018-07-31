package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Model.Autor;

public class AutorDAO {
	
	private static Map<Long, Autor> listAutor = new HashMap<Long, Autor>();

	public Autor getAutor(Long id) {
		return listAutor.get(id);
	}

	public void addAutor(Autor novoAutor) {
		listAutor.put(novoAutor.getId(), novoAutor) ;
	}
	
	public ArrayList<Autor> retornaAutores(){
		ArrayList<Autor> autores = new ArrayList<>();
		
		for(Autor autor : listAutor.values()) {
			autores.add(autor);
		}
		
		return autores;
	}
	

}
