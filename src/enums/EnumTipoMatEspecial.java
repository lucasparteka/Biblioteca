package enums;

public enum EnumTipoMatEspecial {

	CD(1, "CD"), DVD(2, "DVD"), FITA(3, "FITA");

	private Integer idTabelaMaterialEscolhido;
	private String tipoMaterialEscolhido;

	EnumTipoMatEspecial(int idTipo, String tipoMat) {
		idTabelaMaterialEscolhido = idTipo;
		tipoMaterialEscolhido = tipoMat;
	}

	public int getIdTabelaMaterialEscolhido() {
		return idTabelaMaterialEscolhido;
	}

	public String getTipoMaterialEscolhido() {
		return tipoMaterialEscolhido;
	}

}
