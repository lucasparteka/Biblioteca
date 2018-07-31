package Model;

public abstract class AbstractInformacional {
    
    private long id;
    private String titulo;
    private String codigoBarras;
    private int estante;
    private int exemplares;
    private int disponiveis;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public int getEstante() {
        return estante;
    }

    public void setEstante(int estante) {
        this.estante = estante;
    }

    public int getExemplares() {
        return exemplares;
    }

    public void setExemplares(int exemplares) {
        this.exemplares = exemplares;
    }

    public int getDisponiveis() {
        return disponiveis;
    }

    public void setDisponiveis(int disponiveis) {
        this.disponiveis = disponiveis;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    
}
