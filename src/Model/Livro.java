package Model;

public class Livro extends AbstractInformacional {

	private Integer ISBN;
	private Integer ano;
	private Integer volume;
	private Integer edicao;
	private Editora editora;
	private Autor autor;

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Integer getISBN() {
		return ISBN;
	}

	public void setISBN(Integer iSBN) {
		ISBN = iSBN;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Integer getVolume() {
		return volume;
	}

	public void setVolume(Integer volume) {
		this.volume = volume;
	}

	public Integer getEdicao() {
		return edicao;
	}

	public void setEdicao(Integer edicao) {
		this.edicao = edicao;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	@Override
	public String toString() {
		return "Livro{" + "ISBN=" + ISBN + ", ano=" + ano + ", volume=" + volume + ", edicao=" + edicao + ", editora="
				+ editora + '}';
	}

}
