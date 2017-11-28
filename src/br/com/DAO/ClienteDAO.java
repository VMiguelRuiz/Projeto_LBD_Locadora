package br.com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.connectionFactory.ConnectionFactory;
import br.com.modelo.Cliente;

public class ClienteDAO {
	public void adicionarCliente(Cliente cliente) {
		Connection connect = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {

			stmt = connect.prepareCall("{call INSERIRCLIENTE(?,?,?,?)}");
			// stmt.setInt(1, cliente.getIdCliente());
			stmt.setString(1, cliente.getNomeCliente());
			stmt.setLong(2, cliente.getCPFCliente());
			stmt.setString(3, cliente.getEnderecoCliente());
			stmt.setString(4, cliente.getTelefoneCliente());

			stmt.executeUpdate();
			System.out.println("Adicionado");
		} catch (SQLException ex) {

		} finally {
			ConnectionFactory.closeConnection(connect, stmt);

		}

	}

	public void excluiCliente(Cliente cliente) {
		Connection connect = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {

			stmt = connect.prepareCall("{call EXCLUICLIENTE(?)}");
			stmt.setInt(1, cliente.getIdCliente());

			stmt.execute();
			System.out.println("Excluido");
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} finally {
			ConnectionFactory.closeConnection(connect, stmt);
		}
	}

	public void alteraCliente(Cliente cliente) {
		Connection connect = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = connect.prepareCall("{call ALTERARCLIENTE(?,?,?,?,?)}");
			stmt.setInt(1, cliente.getIdCliente());
			stmt.setString(2, cliente.getNomeCliente());
			stmt.setLong(3, cliente.getCPFCliente());
			stmt.setString(4, cliente.getEnderecoCliente());
			stmt.setString(5, cliente.getTelefoneCliente());

			System.out.println("Alterado");
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.closeConnection(connect, stmt);
		}
	}

	public List<Cliente> listaCliente() {
		Connection connect = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = connect.prepareStatement("select * from TB_Cliente");
			List<Cliente> clientes = new ArrayList<Cliente>();
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setIdCliente(rs.getInt("CLIENTE_ID"));
				cliente.setNomeCliente(rs.getString("CLIENTE_NOME"));
				cliente.setCPFCliente(rs.getLong("CLIENTE_CPF"));
				cliente.setEnderecoCliente(rs.getString("CLIENTE_ENDERECO"));
				cliente.setTelefoneCliente(rs.getString("CLIENTE_TELEFONE"));

				clientes.add(cliente);
			}
			stmt.execute();
			rs.close();
			return clientes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.closeConnection(connect, stmt);
		}
	}

	public List<Cliente> listaCliente(String nome) {
		Connection connect = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = connect.prepareStatement("select * from TB_Cliente where CLIENTE_NOME like '%" + nome + "%'");
			List<Cliente> clientes = new ArrayList<Cliente>();
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setIdCliente(rs.getInt("CLIENTE_ID"));
				cliente.setNomeCliente(rs.getString("CLIENTE_NOME"));
				cliente.setCPFCliente(rs.getLong("CLIENTE_CPF"));
				cliente.setEnderecoCliente(rs.getString("CLIENTE_ENDERECO"));
				cliente.setTelefoneCliente(rs.getString("CLIENTE_TELEFONE"));

				clientes.add(cliente);
			}
			stmt.execute();
			rs.close();
			return clientes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.closeConnection(connect, stmt);
		}
	}

}
