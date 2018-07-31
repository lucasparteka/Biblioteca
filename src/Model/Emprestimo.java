package Model;

public class Emprestimo {
	
	private AbstractInformacional informacional;
	private Long id;
	private String dataEmprestimo;
	private String dataDevolucao;
	private Pessoa pessoa;

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(String dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public String getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(String dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public AbstractInformacional getInformacional() {
		return informacional;
	}

	public void setInformacional(AbstractInformacional informacional) {
		this.informacional = informacional;
	}
	
	

}
