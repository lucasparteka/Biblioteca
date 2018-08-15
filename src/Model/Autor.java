package Model;

public class Autor {
    
    private String nome;
    private String sobreNome;
    private Long id;
    
    public Autor() {
    	this(-1L,"","");
    }
    
    public Autor(Long id, String nome, String sobreNome) {
    	setId(id);
    	setNome(nome);
    	setSobreNome(sobreNome);    	
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

	@Override
	public String toString() {
		return "Autor [nome=" + nome + ", sobreNome=" + sobreNome + ", id=" + id + "]";
	}    

}
