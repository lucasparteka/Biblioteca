package dao;

import Model.Pessoa;

public class Conect {

	public static void main(String[] args) {
		
		Pessoa pessoa = new Pessoa();
		pessoa.setId(10);
		pessoa.setNome("Lucas");
		pessoa.setTelefone("999");
		pessoa.setCpf("111111");
		
		PessoaDAO dao  = new PessoaDAO();
		dao.salvarPessoa(pessoa.getId(), pessoa.getNome(), pessoa.getTelefone(), pessoa.getCpf());
		
//		String sql = "INSERT INTO pessoa (id, nome, telefone, cpf) VALUES "
//				+ "('" +pessoa.getId()+ "', '" +pessoa.getNome()+ "', '" +pessoa.getTelefone()+ "', '" +pessoa.getCpf()+ "')";
//		System.out.println(sql);
	}

}
