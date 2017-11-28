package br.com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.connectionFactory.ConnectionFactory;
import br.com.modelo.ItemLocacao;

public class ItemLocacaoDAO {
	public void adicionaItem(ItemLocacao item) {
		Connection connect = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {

			stmt = connect.prepareCall("{call INSERIRITEM(?,?,?)}");
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
			stmt = connect.prepareCall("{call EXCLUIITEM(?)}");
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
			stmt = connect.prepareCall("{call ALTERARITEM(?,?,?)}");
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
				item.setIdItem(rs.getInt("ITEM_ID"));
				item.setIdCopia(rs.getInt("COPIA_ID"));
				item.setIdLocacao(rs.getInt("LOCACAO_ID"));

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
