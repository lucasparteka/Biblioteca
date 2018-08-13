package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.Periodico;

public class PeriodicoDAO {

	private Connection connect;
	private Periodico periodico;

	public void salvarPeriodico(Periodico periodico) {

		connect = ConnectionFactory.getConexao();
		String sql = "insert into periodicos (titulo, codbarras, estante, exemplares, disponiveis, issn, volume, ano) values (?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement stat = null;

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

	public Periodico buscarPeriodico(String titulo) {
		connect = ConnectionFactory.getConexao();
		String sql = "select * from periodicos where titulo = ?";
		PreparedStatement stat = null;
		ResultSet result = null;

		try {
			stat = connect.prepareStatement(sql);
			stat.setString(1, titulo);
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
	
	public ArrayList<Periodico> buscarPeriodicos(){
		connect = ConnectionFactory.getConexao();
		String sql = "select * from periodicos";
		ArrayList<Periodico> listPeriodico = new ArrayList<>();
		PreparedStatement stat = null;
		ResultSet result = null;
		
		try {
			stat = connect.prepareStatement(sql);
			result = stat.executeQuery();
			while(result.next()) {
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
}
