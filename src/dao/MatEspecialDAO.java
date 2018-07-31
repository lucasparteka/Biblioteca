package dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import Model.MaterialEspecial;

public class MatEspecialDAO {
	
	private static Map<Long, MaterialEspecial> mapMatEspecial = new HashMap<Long, MaterialEspecial>();

	public MaterialEspecial getMapMatEspecial(Long id) {
		return mapMatEspecial.get(id);
	}

	public void addMatEspecial(MaterialEspecial matEspecial) {
		MatEspecialDAO.mapMatEspecial.put(matEspecial.getId(), matEspecial);
	}
	
	public ArrayList<MaterialEspecial> retornaMatEspecial() {
		Collection<MaterialEspecial> values = mapMatEspecial.values();
		return new ArrayList<>(values);
	}
	
	public void reduzirDisponiveis(Long id) {
		mapMatEspecial.get(id).setDisponiveis(mapMatEspecial.get(id).getDisponiveis() -1);
	}
	
	public void aumentarDisponiveis(Long id) {
		mapMatEspecial.get(id).setDisponiveis(mapMatEspecial.get(id).getDisponiveis() +1);
	}

}
