package br.com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.connectionFactory.ConnectionFactory;
import br.com.modelo.Filme;

public class FilmeDao {
	public void adicionaFilme(Filme filme) {
		Connection connect = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			
			stmt = connect.prepareCall("{call}");
			stmt.setInt(1, filme.getIdFilme());
			stmt.setString(2, filme.getTituloFilme());
			stmt.setInt(3,filme.getIdGenero());

			 stmt.execute();
			 
			System.out.println("Adicionado");
		} catch (SQLException e) {
			 throw new RuntimeException(e);
		} finally {
			ConnectionFactory.closeConnection(connect, stmt);
		}
	}

	public void excluiFilme(Filme filme) {
		Connection connect = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try{
			stmt = connect.prepareCall("{call}");
			stmt.setInt(1, filme.getIdFilme());
			stmt.setString(2, filme.getTituloFilme());
			stmt.setInt(3,filme.getIdGenero());
			
			stmt.execute();
			System.out.println("Excluido");
		} catch (SQLException ex) {
			 throw new RuntimeException(ex);
		} finally {
			ConnectionFactory.closeConnection(connect, stmt);
		}
	}
	
	public void alteraFilme(Filme filme){
		Connection connect = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try{
			stmt = connect.prepareCall("{call }");
			stmt.setInt(1, filme.getIdFilme());
			stmt.setString(2, filme.getTituloFilme());
			stmt.setInt(3,filme.getIdGenero());		 
			
			stmt.execute();
			 System.out.println("Alterado");
		} catch (SQLException e) {
			 throw new RuntimeException(e);
		} finally {
			ConnectionFactory.closeConnection(connect, stmt);
		}
	}
	
	public List<Filme> listaFilme(){
		Connection connect = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try{
			stmt = connect.prepareStatement("select * from FILME");
			List<Filme> filmes = new ArrayList<Filme>();
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Filme filme = new Filme();
				filme.setIdFilme(rs.getInt("IDFILME"));
				filme.setTituloFilme(rs.getString("TITULO"));
				filme.setIdGenero(rs.getInt("IDGENERO"));
				
				filmes.add(filme);
			}
			stmt.execute();
			rs.close();
			return filmes;
		} catch (SQLException e) {
			 throw new RuntimeException(e);
		} finally {
			ConnectionFactory.closeConnection(connect, stmt);
		}
	}
}

