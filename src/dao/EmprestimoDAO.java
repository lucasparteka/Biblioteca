package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.Emprestimo;

public class EmprestimoDAO {

	private static Connection connect = null;
	private Emprestimo emprestimo;
	private LivroDAO livroDAO;
	private PeriodicoDAO periodicoDAO;
	private MatEspecialDAO matEspecialDAO;
	private PessoaDAO pessoaDAO;

	public static final int EXCLUIR_EMPRESTIMO = 1;
	public static final int DEVOLVER_EMPRESTIMO = 2;

	public void salvaremprestimo(Emprestimo emprestimo, long idTabelaMaterialEscolhido) {

		connect = ConnectionFactory.getConexao();
		PreparedStatement stat = null;
		String sql = "insert into emprestimos (id_usuario, dataemprestimo, datadevolucao, status, tipo_material, id_material ) values (?, ?, ?, ?, ?, ?)";
		try {
			stat = connect.prepareStatement(sql);
			stat.setLong(1, emprestimo.getPessoa().getId());
			stat.setDate(2, emprestimo.getDataEmprestimo());
			stat.setDate(3, emprestimo.getDataDevolucao());
			stat.setString(4, emprestimo.getStatus());
			stat.setLong(5, idTabelaMaterialEscolhido);
			stat.setLong(6, emprestimo.getInformacional().getId());
			stat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.fecharConexao(connect, stat);
		}
	}

	public static void alterarEmprestimo(Long id, int operacao) {
		String sql = "";
		switch (operacao) {
		case DEVOLVER_EMPRESTIMO:
			sql = "update emprestimos set status = 'Finalizado' where id = ?";
			break;
		case EXCLUIR_EMPRESTIMO:
			sql = "delete from emprestimos where id = ?";
			break;
		}
		connect = ConnectionFactory.getConexao();
		PreparedStatement stat = null;
		try {
			stat = connect.prepareStatement(sql);
			stat.setLong(1, id);
			stat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.fecharConexao(connect, stat);
		}

	}

	public ArrayList<Emprestimo> retornaEmprestimos(int pageIndex) {
		ArrayList<Emprestimo> listEmprestimos = new ArrayList<>();
		connect = ConnectionFactory.getConexao();
		String sql = "select e.id as id_emp, e.dataemprestimo, e.datadevolucao, e.status, p.id as usuario, l.titulo, l.id as id_mat, t.descricao as tipo"
				+ " from emprestimos e" + " inner join pessoa p on e.id_usuario = p.id"
				+ " inner join livro l on e.id_material = l.id" + " inner join tipomaterial t on e.tipo_material = t.id"
				+ " where e.tipo_material = 1" + " union"
				+ " select e.id as id_emp, e.dataemprestimo, e.datadevolucao, e.status, p.id as usuario, per.titulo, per.id as id_mat, t.descricao as tipo"
				+ " from emprestimos e " + " inner join pessoa p on e.id_usuario = p.id"
				+ " inner join periodicos per on e.id_material = per.id"
				+ " inner join tipomaterial t on e.tipo_material = t.id" + " where e.tipo_material = 2" + "union"
				+ " select e.id as id_emp, e.dataemprestimo, e.datadevolucao, e.status, p.id as usuario, mat.titulo, mat.id as id_mat, t.descricao as tipo"
				+ " from emprestimos e" + " inner join pessoa p on e.id_usuario = p.id"
				+ " inner join materialespecial mat on e.id_material = mat.id"
				+ " inner join tipomaterial t on e.tipo_material = t.id" + " where e.tipo_material = 3"
				+ " order by id_emp limit 3 offset ?";

		PreparedStatement stat = null;
		ResultSet result = null;
		try {
			stat = connect.prepareStatement(sql);

			stat.setInt(1, pageIndex);
			result = stat.executeQuery();
			while (result.next()) {
				emprestimo = new Emprestimo();
				pessoaDAO = new PessoaDAO();
				if (result.getString("tipo").equals("Livro")) {
					livroDAO = new LivroDAO();
					emprestimo.setInformacional(livroDAO.retornaLivro(result.getLong("id_mat")));
				} else if (result.getString("tipo").equals("Periodico")) {
					periodicoDAO = new PeriodicoDAO();
					emprestimo.setInformacional(periodicoDAO.buscarPeriodico(result.getLong("id_mat")));
				} else if (result.getString("tipo").equals("Material Especial")) {
					matEspecialDAO = new MatEspecialDAO();
					emprestimo.setInformacional(matEspecialDAO.buscarMatEspecial(result.getLong("id_mat")));
				}
				emprestimo.setPessoa(pessoaDAO.buscarPessoaPorId(result.getLong("usuario")));
				emprestimo.setDataDevolucao(result.getDate("datadevolucao"));
				emprestimo.setDataEmprestimo(result.getDate("dataemprestimo"));
				emprestimo.setStatus(result.getString("status"));
				emprestimo.setId(result.getLong("id_emp"));
				listEmprestimos.add(emprestimo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.fecharConexao(connect, stat, result);
		}
		return listEmprestimos;
	}

	public int retornaQuantidade() {
		int quantidade = 0;
		connect = ConnectionFactory.getConexao();
		String sql = "select count(*) from emprestimos";
		PreparedStatement stat = null;
		ResultSet result = null;
		try {
			stat = connect.prepareStatement(sql);
			result = stat.executeQuery();
			while (result.next()) {
				quantidade = result.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.fecharConexao(connect, stat, result);
		}
		return quantidade;
	}

}
