package dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import Controller.AcoesPessoa;
import Model.MaterialEspecial;
import Model.Pessoa;
 
class TestePessoaDAO {
	
	AcoesPessoa acoesPessoa = new AcoesPessoa();
	PessoaDAO pessoaDAO;
	Pessoa pessoa;
	
	@Test
	public void inserirPessoa() {
//		MatEspecialDAO matEspecialDAO = new MatEspecialDAO();
//		ArrayList<MaterialEspecial> listMat = new ArrayList<>();
//		listMat = matEspecialDAO.buscarTodosMatEspecial();
//		for (MaterialEspecial  mat : listMat) {
//			System.out.println(mat.getTitulo() + " " + mat.getTipo());
//		}
		int nLinhas = 9;
		int nLinhasPorPagina = 3;
		int nPaginas = ( nLinhas + (nLinhasPorPagina - 1) ) / nLinhasPorPagina;
		System.out.println(nPaginas);
	}
	
	@Ignore
	public void buscarPessoas() {
		//pessoaDAO = new PessoaDAO();
		//pessoa = new Pessoa();
		//pessoa = ;
		if(acoesPessoa.verificarCadastro("876876") == false) {
			System.out.println("cadastrou usuario");
		} else {
			
			System.out.println("usuario ja cadastrado");
		}
		
		
	}
	
	@Ignore
	public void buscarPessoa() {

		String sql = "SELECT e.id, p.nome, dataemprestimo, datadevolucao, status, tm.descricao, l.titulo"
				+ " from public.emprestimos e" + " inner join livro l on l.id = e.id_material"
				+ " inner join tipomaterial tm on tm.id = e.tipo_material" + " inner join pessoa p on p.id = e.id_usuario"
				+ " where e.tipo_material = 1" + " union"
				+ " SELECT e.id, p.nome, dataemprestimo, datadevolucao, status, tm.descricao, l.titulo"
				+ " from public.emprestimos e" + " inner join periodicos l on l.id = e.id_material"
				+ " inner join tipomaterial tm on tm.id = e.tipo_material" + " inner join pessoa p on p.id = e.id_usuario"
				+ " where e.tipo_material = 2" + " union"
				+ " SELECT e.id, p.nome, dataemprestimo, datadevolucao, status, tm.descricao, l.titulo"
				+ " from public.emprestimos e" + " inner join materialespecial l on l.id = e.id_material"
				+ " inner join tipomaterial tm on tm.id = e.tipo_material" + " inner join pessoa p on p.id = e.id_usuario"
				+ " where e.tipo_material = 3";

		// Pessoa pessoa;
		PreparedStatement stat = null;
		ResultSet result = null;
		// ArrayList<Pessoa> listPessoa = new ArrayList<>();

		try {
			//stat = connect.prepareStatement(sql);
			result = stat.executeQuery();

			while (result.next()) {
				System.out.println(result.getInt("id") + result.getString("nome") +
				 result.getString("descricao")
				 + result.getString("titulo"));
				// System.out.println(result.getInt());
				// pessoa = new Pessoa();
				// pessoa.setId(result.getLong("id"));
				// pessoa.setNome(result.getString("nome"));
				// pessoa.setCpf(result.getString("cpf"));
				// pessoa.setTelefone(result.getString("telefone"));
				// listPessoa.add(pessoa);

			}
		} catch (SQLException e) {
			System.out.println("Erro");
		} finally {
			//ConectionFactory.fecharConexao(connect, stat, result);
		}

	}

}
