package Model;

import java.sql.Date;

public class Emprestimo {
	
	private AbstractInformacional informacional;
	private Long id;
	private Date dataEmprestimo;
	private Date dataDevolucao;
	private Pessoa pessoa;
	private String status;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

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

	public AbstractInformacional getInformacional() {
		return informacional;
	}

	public void setInformacional(AbstractInformacional informacional) {
		this.informacional = informacional;
	}

	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public Date getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}


}
