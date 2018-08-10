package Model;

public class Editora {
    
    private String nome;
    private String nacionalidade;
    private long id;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

	@Override
	public String toString() {
		return "Editora [nome=" + nome + ", nacionalidade=" + nacionalidade + ", id=" + id + "]";
	}
    

}
