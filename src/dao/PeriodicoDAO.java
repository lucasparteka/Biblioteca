package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.Periodico;

public class PeriodicoDAO {

	private static Connection connect;
	private Periodico periodico;

	public static final int INCREMENTAR = 1;
	public static final int DECREMENTAR = 2;
	public static final int ALTERAR_CADASTRO = 1;
	public static final int INSERIR_CADASTRO = 2;

	public void salvarPeriodico(Periodico periodico, int operacao) {

		connect = ConnectionFactory.getConexao();
		String sql = "";
		PreparedStatement stat = null;
		switch (operacao) {
		case ALTERAR_CADASTRO:
			sql = "update periodicos set titulo = ?, codbarras = ?, estante = ?, exemplares = ?, disponiveis = ?, issn = ?, volume = ?, ano = ? where id = " + periodico.getId();
			break;
		case INSERIR_CADASTRO:
			sql = "insert into periodicos (titulo, codbarras, estante, exemplares, disponiveis, issn, volume, ano) values (?, ?, ?, ?, ?, ?, ?, ?)";
			break;
		}

		try {
			stat = connect.prepareStatement(sql);
			stat.setString(1, periodico.getTitulo());
			stat.setString(2, periodico.getCodigoBarras());
			stat.setInt(3, periodico.getEstante());
			stat.setInt(4, periodico.getExemplares());
			stat.setInt(5, periodico.getDisponiveis());
			stat.setInt(6, periodico.getIssn());
			stat.setInt(7, periodico.getVolume());
			stat.setInt(8, periodico.getAno());
			stat.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.fecharConexao(connect, stat);
		}

	}

	public Periodico buscarPeriodico(Long id) {
		connect = ConnectionFactory.getConexao();
		String sql = "select * from periodicos where id = ?";
		PreparedStatement stat = null;
		ResultSet result = null;

		try {
			stat = connect.prepareStatement(sql);
			stat.setLong(1, id);
			result = stat.executeQuery();
			while (result.next()) {
				periodico = new Periodico();
				periodico.setId(result.getLong("id"));
				periodico.setAno(result.getInt("ano"));
				periodico.setCodigoBarras(result.getString("codbarras"));
				periodico.setDisponiveis(result.getInt("disponiveis"));
				periodico.setEstante(result.getInt("estante"));
				periodico.setExemplares(result.getInt("exemplares"));
				periodico.setIssn(result.getInt("issn"));
				periodico.setTitulo(result.getString("titulo"));
				periodico.setVolume(result.getInt("volume"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.fecharConexao(connect, stat, result);
		}

		return periodico;
	}

	public ArrayList<Periodico> buscarPeriodicos(int pageIndex) {
		connect = ConnectionFactory.getConexao();
		String sql = "select * from periodicos order by id limit 3 offset ?";
		ArrayList<Periodico> listPeriodico = new ArrayList<>();
		PreparedStatement stat = null;
		ResultSet result = null;

		try {
			stat = connect.prepareStatement(sql);
			stat.setInt(1, pageIndex);
			result = stat.executeQuery();
			while (result.next()) {
				periodico = new Periodico();
				periodico.setId(result.getLong("id"));
				periodico.setAno(result.getInt("ano"));
				periodico.setCodigoBarras(result.getString("codbarras"));
				periodico.setDisponiveis(result.getInt("disponiveis"));
				periodico.setEstante(result.getInt("estante"));
				periodico.setExemplares(result.getInt("exemplares"));
				periodico.setIssn(result.getInt("issn"));
				periodico.setTitulo(result.getString("titulo"));
				periodico.setVolume(result.getInt("volume"));

				listPeriodico.add(periodico);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.fecharConexao(connect, stat, result);
		}

		return listPeriodico;
	}

	public int retornaQuantidade() {
		int quantidade = 0;
		connect = ConnectionFactory.getConexao();
		String sql = "select count(*) from periodicos";
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
			sql = "UPDATE periodicos set disponiveis = disponiveis + 1 where id = ? ";
			break;

		case DECREMENTAR:
			sql = "UPDATE periodicos set disponiveis = disponiveis - 1 where id = ? ";
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
