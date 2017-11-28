package br.com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.connectionFactory.ConnectionFactory;
import br.com.modelo.Copia;

public class CopiaDAO {
	public void adicionaCopia(Copia copia) {
		Connection connect = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = connect.prepareCall("{call INSERIRCOPIA(?,?,?,?,?)}");
			stmt.setInt(1, copia.getIdCopia());
			stmt.setInt(2, copia.getIdFilme());
			stmt.setInt(3, copia.getCopiaLocada());
			stmt.setInt(4, copia.getIdFormato());
			stmt.setDouble(5, copia.getValorCopia());
			stmt.execute();
			System.out.println("Adicionado");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.closeConnection(connect, stmt);
		}
	}

	public void excluiCopia(Copia copia) {
		Connection connect = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = connect.prepareCall("{call EXCLUICOPIA(?)}");
			stmt.setInt(1, copia.getIdCopia());
			stmt.setInt(2, copia.getIdFilme());
			stmt.setInt(3, copia.getCopiaLocada());
			stmt.setInt(4, copia.getIdFormato());

			stmt.execute();
			System.out.println("Excluido");
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} finally {
			ConnectionFactory.closeConnection(connect, stmt);
		}
	}

	public void alteraCopia(Copia copia) {
		Connection connect = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = connect.prepareCall("{call ALTERARCOPIA(?,?,?,?,?)}");
			stmt.setInt(1, copia.getIdCopia());
			stmt.setInt(2, copia.getIdFilme());
			stmt.setInt(3, copia.getCopiaLocada());
			stmt.setInt(4, copia.getIdFormato());
			stmt.setDouble(5, copia.getValorCopia());
			stmt.execute();
			System.out.println("Alterado");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.closeConnection(connect, stmt);
		}
	}

	public List<Copia> listaCopia() {
		Connection connect = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = connect.prepareStatement("select * from TB_COPIA");
			List<Copia> copias = new ArrayList<Copia>();
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Copia copia = new Copia();
				copia.setIdCopia(rs.getInt("COPIA_ID"));
				copia.setIdFilme(rs.getInt("FILME_ID"));
				copia.setCopiaLocada(rs.getInt("COPIA_LOCADA"));
				copia.setIdFormato(rs.getInt("FORMATO_ID"));
				copia.setValorCopia(rs.getInt("COPIA_VALOR"));
				copias.add(copia);
			}
			stmt.execute();
			rs.close();
			return copias;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.closeConnection(connect, stmt);
		}
	}
}
