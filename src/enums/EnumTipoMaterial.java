package enums;

public enum EnumTipoMaterial {

	LIVRO(1L, "Livro"), PERIODICO(2L, "Periodico"), MATERIAL_ESPECIAL(3L, "Mat. Especial");

	private Long idTabelaMaterialEscolhido;
	private String tipoMaterialEscolhido;

	EnumTipoMaterial(Long idTipo, String tipoMat) {
		idTabelaMaterialEscolhido = idTipo;
		tipoMaterialEscolhido = tipoMat;
	}

	public Long getIdTabelaMaterialEscolhido() {
		return idTabelaMaterialEscolhido;
	}

	public String getTipoMaterialEscolhido() {
		return tipoMaterialEscolhido;
	}
	
}
