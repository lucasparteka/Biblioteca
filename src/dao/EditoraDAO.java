package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Model.Editora;

public class EditoraDAO {
	
	private static Map<Long, Editora> mapEditora = new HashMap<>();

	public Editora getEditora(Long id) {
		return mapEditora.get(id);
	}

	public void addEditora(Editora editora) {
		mapEditora.put(editora.getId(), editora);
	}
	
	public ArrayList<Editora> retornaEditoras(){
		ArrayList<Editora> listEditora = new ArrayList<>();
	
		for(Editora editora : mapEditora.values()) {
			listEditora.add(editora);
		}
		
		return listEditora;
	}

}
