package dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import Model.Periodico;

public class PeriodicoDAO {

	private static Map<Long, Periodico> mapPeriodico = new HashMap<Long, Periodico>();

	public Periodico getMapPeriodico(long id) {
		return mapPeriodico.get(id);
	}

	public void addPeriodico(Periodico periodico) {
		PeriodicoDAO.mapPeriodico.put(periodico.getId(), periodico);
	}

	public ArrayList<Periodico> retornaPeriodicos(){
		Collection<Periodico> values = mapPeriodico.values();
		return new ArrayList<>(values);
		                         
	}
	
	public void reduzirDisponiveis(Long id) {
		mapPeriodico.get(id).setDisponiveis(mapPeriodico.get(id).getDisponiveis() - 1);
	}
	
	public void aumentarDisponiveis(Long id) {
		mapPeriodico.get(id).setDisponiveis(mapPeriodico.get(id).getDisponiveis() + 1);
	}
}
