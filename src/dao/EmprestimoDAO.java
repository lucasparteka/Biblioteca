package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Model.Emprestimo;

public class EmprestimoDAO {
	
	private Connection connect = null;
	
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

}
