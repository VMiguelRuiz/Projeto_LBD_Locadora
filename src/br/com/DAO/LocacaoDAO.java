package br.com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.connectionFactory.ConnectionFactory;
import br.com.modelo.Locacao;

public class LocacaoDAO {
	public void adicionaLocacao(Locacao locacao) {
		Connection connect = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = connect.prepareCall("{call INSERIRLOCACAO(?,?,?)}");
			
			//stmt.setInt(1, locacao.getIdLocacao());
			stmt.setDate(2, locacao.getDataLocacao());
			stmt.setDouble(3, locacao.getValorLocacao());
			stmt.setInt(4, locacao.getIdCliente());
			
			stmt.execute();
			System.out.println("Adicionado");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.closeConnection(connect, stmt);
		}
	}

	public void excluiLocacao(Locacao locacao) {
		Connection connect = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = connect.prepareCall("{call EXCLUILOCACAO(?)}");

			stmt.setInt(1, locacao.getIdLocacao());

			stmt.execute();
			System.out.println("Excluido");
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} finally {
			ConnectionFactory.closeConnection(connect, stmt);
		}
	}

	public void alteraLocacao(Locacao locacao) {
		Connection connect = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = connect.prepareCall("{call ALTERARLOCACAO(?,?,?,?)}");
			stmt.setInt(1, locacao.getIdLocacao());
			stmt.setDate(2, locacao.getDataLocacao());
			stmt.setDouble(3, locacao.getValorLocacao());
			stmt.setInt(4, locacao.getIdCliente());

			stmt.execute();
			System.out.println("Alterado");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.closeConnection(connect, stmt);
		}
	}

	public List<Locacao> listaLocacao() {
		Connection connect = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = connect.prepareStatement("select * from TB_LOCACAO");
			List<Locacao> locacoes = new ArrayList<Locacao>();
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Locacao locacao = new Locacao();
				locacao.setIdLocacao(rs.getInt("LOCACAO_ID"));
				locacao.setDataLocacao(rs.getDate("LOCACAO_DATA"));
				locacao.setValorLocacao(rs.getDouble("LOCACAO_VALOR"));
				locacao.setIdCliente(rs.getInt("CLIENTE_ID"));

				locacoes.add(locacao);
			}
			stmt.execute();
			rs.close();
			return locacoes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.closeConnection(connect, stmt);
		}
	}
}
