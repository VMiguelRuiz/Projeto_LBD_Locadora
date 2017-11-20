package br.com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.connectionFactory.ConnectionFactory;
import br.com.modelo.Genero;

public class GeneroDao {
	public void adicionaGenero(Genero genero) {
		Connection connect = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = connect.prepareCall("{call INSERIRGENERO(?,?)}");
			stmt.setInt(1, genero.getIdGenero());
			stmt.setString(2, genero.getNomeGenero());

			stmt.execute();
			System.out.println("Adicionado");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.closeConnection(connect, stmt);
		}
	}

	public void excluiGenero(Genero genero) {
		Connection connect = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = connect.prepareCall("{call EXCLUIGENERO(?)}");
			stmt.setInt(1, genero.getIdGenero());
			stmt.setString(2, genero.getNomeGenero());

			stmt.execute();
			System.out.println("Excluido");

		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} finally {
			ConnectionFactory.closeConnection(connect, stmt);
		}
	}

	public void alteraGenero(Genero genero) {
		Connection connect = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = connect.prepareCall("{call ALTERARGENERO(?,?)}");
			stmt.setInt(1, genero.getIdGenero());
			stmt.setString(2, genero.getNomeGenero());

			stmt.execute();
			System.out.println("Alterado");

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.closeConnection(connect, stmt);
		}
	}

	public List<Genero> listaGenero() {
		Connection connect = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = connect.prepareStatement("select * from TB_GENERO");
			List<Genero> generos = new ArrayList<Genero>();
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Genero genero = new Genero();
				genero.setIdGenero(rs.getInt("GENERO_ID"));
				genero.setNomeGenero(rs.getString("GENERO_NOME"));

				generos.add(genero);
			}
			stmt.execute();
			rs.close();
			return generos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.closeConnection(connect, stmt);
		}
	}
}
