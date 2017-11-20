package br.com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.connectionFactory.ConnectionFactory;
import br.com.modelo.ItemLocacao;

public class ItemLocacaoDao {
	public void adicionaItem(ItemLocacao item) {
		Connection connect = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {

			stmt = connect.prepareCall("{call}");
			stmt.setInt(1, item.getIdItem());
			stmt.setInt(2, item.getIdCopia());
			stmt.setInt(3, item.getIdLocacao());

			stmt.execute();
			System.out.println("Adicionado");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.closeConnection(connect, stmt);
		}
	}

	public void excluiItem(ItemLocacao item) {
		Connection connect = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = connect.prepareCall("{call}");
			stmt.setInt(1, item.getIdItem());
			stmt.setInt(2, item.getIdCopia());
			stmt.setInt(3, item.getIdLocacao());

			stmt.execute();

			System.out.println("Excluido");
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} finally {
			ConnectionFactory.closeConnection(connect, stmt);
		}
	}

	public void alteraItem(ItemLocacao item) {
		Connection connect = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = connect.prepareCall("{call}");
			stmt.setInt(1, item.getIdItem());
			stmt.setInt(2, item.getIdCopia());
			stmt.setInt(3, item.getIdLocacao());

			stmt.execute();
			System.out.println("Alterado");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.closeConnection(connect, stmt);
		}
	}

	public List<ItemLocacao> listaItem() {
		Connection connect = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = connect.prepareStatement("select * from TB_ITEMLOCACAO");
			List<ItemLocacao> itens = new ArrayList<ItemLocacao>();
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ItemLocacao item = new ItemLocacao();
				item.setIdItem(rs.getInt("IDITEM"));
				item.setIdCopia(rs.getInt("IDCOPIA"));
				item.setIdLocacao(rs.getInt("IDLOCACAO"));

				itens.add(item);
			}
			stmt.execute();
			rs.close();
			return itens;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.closeConnection(connect, stmt);
		}
	}
}