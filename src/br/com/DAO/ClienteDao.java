package br.com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.connectionFactory.ConnectionFactory;
import br.com.modelo.Cliente;

public class ClienteDao {
	public void adicionarCliente(Cliente cliente) {
		Connection connect = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			
			stmt = connect.prepareCall("{call}");
			stmt.setInt(1, cliente.getIdCliente());
			stmt.setLong(2, cliente.getCpf());
			stmt.setString(3, cliente.getNomeCliente());
			stmt.setString(4, cliente.getEnderecoCliente());
			stmt.setInt(5, cliente.getTelefone());

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
			
			stmt = connect.prepareCall("{call}");
			stmt.setInt(1, cliente.getIdCliente());
			stmt.setLong(2, cliente.getCpf());
			stmt.setString(3, cliente.getNomeCliente());
			stmt.setString(4, cliente.getEnderecoCliente());
			stmt.setInt(5, cliente.getTelefone());

			stmt.execute();
			System.out.println("Excluido");
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} finally {
			ConnectionFactory.closeConnection(connect, stmt);
		}
	}
	
	public void alteraCliente(Cliente cliente){
		Connection connect = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try{
			stmt = connect.prepareCall("{call}");
			stmt.setInt(1, cliente.getIdCliente());
			stmt.setLong(2, cliente.getCpf());
			stmt.setString(3, cliente.getNomeCliente());
			stmt.setString(4, cliente.getEnderecoCliente());
			stmt.setInt(5, cliente.getTelefone());
			
			System.out.println("Alterado");
			 stmt.execute();
		} catch (SQLException e) {
			 throw new RuntimeException(e);
		} finally {
			ConnectionFactory.closeConnection(connect, stmt);
		}
	}
	public List<Cliente> listaCliente(){
		Connection connect = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try{
			stmt = connect.prepareStatement("select * from TB_Cliente");
			List<Cliente> clientes = new ArrayList<Cliente>();
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Cliente cliente = new Cliente();
				cliente.setIdCliente(rs.getInt("IDCLIENTE"));
				cliente.setCpf(rs.getLong("CPF"));
				cliente.setNomeCliente(rs.getString("NOMECLIENTE"));
				cliente.setEnderecoCliente(rs.getString("endereco"));
				cliente.setTelefone(rs.getInt("telefone"));
				
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
