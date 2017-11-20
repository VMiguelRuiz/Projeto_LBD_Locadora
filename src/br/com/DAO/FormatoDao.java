package br.com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.connectionFactory.ConnectionFactory;
import br.com.modelo.Formato;

public class FormatoDao {

	public void adicionaFormato(Formato formato) {
		Connection connect = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			// stmt = connect.prepareStatement("INSERT INTO TIPO (idtipo, nome)
			// values (?, ?)");
			stmt = connect.prepareCall("{call InserirFormato(?,?)}");
			stmt.setInt(1, formato.getIdFormato());
			stmt.setString(2, formato.getNomeFormato());

			stmt.execute();
			System.out.println("Adicionado");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.closeConnection(connect, stmt);
		}
	}

	public void excluiFormato(Formato formato) {
		Connection connect = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = connect.prepareCall("{call ExcluirFormato(?)}");
			stmt.setInt(1, formato.getIdFormato());
			stmt.execute();
			System.out.println("Excluido");
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} finally {
			ConnectionFactory.closeConnection(connect, stmt);
		}
	}

	public void alteraFormato(Formato formato) {
		Connection connect = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = connect.prepareCall("{call AlterarFormato(?, ?)}");
			stmt.setInt(1, formato.getIdFormato());
			stmt.setString(2, formato.getNomeFormato());
			stmt.execute();
			System.out.println("Alterado");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.closeConnection(connect, stmt);
		}
	}

	public List<Formato> listaFormatos() {
		Connection connect = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = connect.prepareStatement("select * from FORMATO");
			List<Formato> formatos = new ArrayList<Formato>();
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Formato formato = new Formato();
				formato.setIdFormato(rs.getInt("IDFORMATO"));
				formato.setNomeFormato(rs.getString("NOMEFORMATO"));

				formatos.add(formato);
			}
			stmt.execute();
			rs.close();
			return formatos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.closeConnection(connect, stmt);
		}
	}
}
