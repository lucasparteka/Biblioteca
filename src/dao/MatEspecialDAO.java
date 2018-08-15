package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.MaterialEspecial;

public class MatEspecialDAO {

	private static Connection connect;
	private MaterialEspecial materialEspecial;

	public static final int INCREMENTAR = 1;
	public static final int DECREMENTAR = 2;

	public void salvarMaterialEspecial(MaterialEspecial matEspecial) {

		connect = ConnectionFactory.getConexao();
		PreparedStatement stat = null;
		String sql = "insert into materialespecial (titulo, codbarras, estante, exemplares, disponiveis, tipo, descricao) values (?, ?, ?, ?, ?, ?, ?)";

		try {
			stat = connect.prepareStatement(sql);
			stat.setString(1, matEspecial.getTitulo());
			stat.setString(2, matEspecial.getCodigoBarras());
			stat.setInt(3, matEspecial.getEstante());
			stat.setInt(4, matEspecial.getExemplares());
			stat.setInt(5, matEspecial.getDisponiveis());
			stat.setInt(6, matEspecial.getIdTipo());
			stat.setString(7, matEspecial.getDescricao());
			stat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.fecharConexao(connect, stat);
		}
	}

	public MaterialEspecial buscarMatEspecial(Long id) {
		connect = ConnectionFactory.getConexao();
		PreparedStatement stat = null;
		ResultSet result = null;
		String sql = "select m.id, m.codbarras, m.descricao, m.disponiveis, m.estante, m.titulo, m.exemplares, t.tipo"
				+ " from materialespecial m" + " inner join tipomaterialesp t on t.id = m.tipo" + " where m.id = ?";
		try {
			stat = connect.prepareStatement(sql);
			stat.setLong(1, id);
			result = stat.executeQuery();
			while (result.next()) {
				materialEspecial = new MaterialEspecial();
				materialEspecial.setCodigoBarras(result.getString("codbarras"));
				materialEspecial.setDescricao(result.getString("descricao"));
				materialEspecial.setDisponiveis(result.getInt("disponiveis"));
				materialEspecial.setEstante(result.getInt("estante"));
				materialEspecial.setExemplares(result.getInt("exemplares"));
				materialEspecial.setTipo(result.getString("tipo"));
				materialEspecial.setTitulo(result.getString("titulo"));
				materialEspecial.setId(result.getLong("id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.fecharConexao(connect, stat, result);
		}
		return materialEspecial;
	}

	public ArrayList<MaterialEspecial> retornaMatEspeciais(int pageIndex) {
		ArrayList<MaterialEspecial> listMatEspecial = new ArrayList<>();
		connect = ConnectionFactory.getConexao();
		PreparedStatement stat = null;
		ResultSet result = null;
		String sql = "select m.id, m.codbarras, m.descricao, m.disponiveis, m.estante, m.titulo, m.exemplares, t.tipo"
				+ " FROM materialespecial m" + " inner join tipomaterialesp t on t.id = m.tipo"
				+ " where m.tipo = 1 or m.tipo = 2 or m.tipo = 3  order by id limit 3 offset ?";
		try {
			stat = connect.prepareStatement(sql);
			stat.setInt(1, pageIndex);
			result = stat.executeQuery();
			while (result.next()) {
				materialEspecial = new MaterialEspecial();
				materialEspecial.setCodigoBarras(result.getString("codbarras"));
				materialEspecial.setDescricao(result.getString("descricao"));
				materialEspecial.setDisponiveis(result.getInt("disponiveis"));
				materialEspecial.setEstante(result.getInt("estante"));
				materialEspecial.setExemplares(result.getInt("exemplares"));
				materialEspecial.setTipo(result.getString("tipo"));
				materialEspecial.setTitulo(result.getString("titulo"));
				materialEspecial.setId(result.getLong("id"));

				listMatEspecial.add(materialEspecial);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.fecharConexao(connect, stat, result);
		}
		return listMatEspecial;
	}

	public int retornaQuantidade() {
		int quantidade = 0;
		connect = ConnectionFactory.getConexao();
		String sql = "select count(*) from materialespecial";
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

	public static void alterarQuantidade(Long id, int operacao) {
		String sql = "";
		switch (operacao) {
		case INCREMENTAR:
			sql = "UPDATE materialespecial set disponiveis = disponiveis + 1 where id = ? ";
			break;
		case DECREMENTAR:
			sql = "UPDATE materialespecial set disponiveis = disponiveis - 1 where id = ? ";
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

}
