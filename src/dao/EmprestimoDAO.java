package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Autor;
import Model.Emprestimo;
import Model.Livro;
import Model.MaterialEspecial;

public class EmprestimoDAO {

	private Connection connect = null;
	private Emprestimo emprestimo;
	private LivroDAO livroDAO;
	private PeriodicoDAO periodicoDAO;
	private MatEspecialDAO matEspecialDAO;

	public void salvaremprestimo(Emprestimo emprestimo, long tipoMaterial) {

		connect = ConnectionFactory.getConexao();
		PreparedStatement stat = null;
		String sql = "insert into emprestimos (id_usuario, dataemprestimo, datadevolucao, status, tipo_material, id_material ) values (?, ?, ?, ?, ?, ?)";
		try {
			stat = connect.prepareStatement(sql);
			stat.setLong(1, emprestimo.getPessoa().getId());
			stat.setDate(2, emprestimo.getDataEmprestimo());
			stat.setDate(3, emprestimo.getDataDevolucao());
			stat.setString(4, emprestimo.getStatus());
			stat.setLong(5, tipoMaterial);
			stat.setLong(6, emprestimo.getInformacional().getId());
			stat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.fecharConexao(connect, stat);
		}
	}

	public void devolverEmprestimo(Long id) {
		connect = ConnectionFactory.getConexao();
		PreparedStatement stat = null;
		String sql = "update emprestimos set status = 'Finalizado' where id = ?";
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
		String sql = "select e.id, e.dataemprestimo, e.datadevolucao, e.status, p.nome as usuario, l.titulo, t.descricao as tipo"
				+ " from emprestimos e" + " inner join pessoa p on e.id_usuario = p.id"
				+ " inner join livro l on e.id_material = l.id" + " inner join tipomaterial t on e.tipo_material = t.id"
				+ " where e.tipo_material = 1" + " union"
				+ " select e.id, e.dataemprestimo, e.datadevolucao, e.status, p.nome as usuario, per.titulo, t.descricao as tipo"
				+ " from emprestimos e " + " inner join pessoa p on e.id_usuario = p.id"
				+ " inner join periodicos per on e.id_material = per.id"
				+ " inner join tipomaterial t on e.tipo_material = t.id" + " where e.tipo_material = 2" + "union"
				+ " select e.id, e.dataemprestimo, e.datadevolucao, e.status, p.nome as usuario, mat.titulo, t.descricao as tipo"
				+ " from emprestimos e" + " inner join pessoa p on e.id_usuario = p.id"
				+ " inner join materialespecial mat on e.id_material = mat.id"
				+ " inner join tipomaterial t on e.tipo_material = t.id" + " where e.tipo_material = 3"
				+ " order by id limit 5 offset ?";
		PreparedStatement stat = null;
		ResultSet result = null;
		try {
			stat = connect.prepareStatement(sql);
			stat.setInt(1, pageIndex);
			result = stat.executeQuery();
			while (result.next()) {
				emprestimo = new Emprestimo();
				if(result.getString("tipo").equals("Livro")) {
					//Livro livro = new Livro();
					livroDAO = new LivroDAO();
					emprestimo.setInformacional(livroDAO.retornaLivro(result.getLong("id")));
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.fecharConexao(connect, stat, result);
		}
		return listEmprestimos;
	}

}
