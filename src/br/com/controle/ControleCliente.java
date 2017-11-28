package br.com.controle;

import java.util.List;

import br.com.DAO.ClienteDAO;
import br.com.modelo.Cliente;

public class ControleCliente {

	public void adicionaCliente(String clienteID, String cliente_nome, String clienteCPF, String clienteTelefone, String cliente_endereco) {

		int cliente_id = Integer.parseInt(clienteID);
		long cliente_cpf = Long.parseLong(clienteCPF);
		int cliente_telefone = Integer.parseInt(clienteTelefone);

		ClienteDAO cliente_dao = new ClienteDAO();
		Cliente cliente = new Cliente();
		cliente.setIdCliente(cliente_id);
		cliente.setNomeCliente(cliente_nome);
		cliente.setCPFCliente(cliente_cpf);
		cliente.setEnderecoCliente(cliente_endereco);
		cliente.setTelefoneCliente(cliente_telefone);
		cliente_dao.adicionarCliente(cliente );

	}

	public void excluiCliente(String cliente_id) {
		ClienteDAO cliente_dao = new ClienteDAO();
		Cliente cliente = new Cliente();
		cliente.setIdCliente(Integer.parseInt(cliente_id));
		cliente_dao.excluiCliente(cliente );
	}

	public void alteraCliente(String clienteID, String cliente_nome, String clienteCPF, String clienteTelefone, String cliente_endereco) {
		int cliente_id = Integer.parseInt(clienteID);
		long cliente_cpf = Long.parseLong(clienteCPF);
		int cliente_telefone = Integer.parseInt(clienteTelefone);

		ClienteDAO cliente_dao = new ClienteDAO();
		Cliente cliente = new Cliente();
		cliente.setIdCliente(cliente_id);

		cliente.setNomeCliente(cliente_nome);
		cliente.setCPFCliente(cliente_cpf);
		cliente.setEnderecoCliente(cliente_endereco);
		cliente.setTelefoneCliente(cliente_telefone);
		cliente_dao.alteraCliente(cliente );
	}

	public void listaCliente() {
		ClienteDAO cliente_dao = new ClienteDAO();
		List<Cliente> clientes = cliente_dao.listaCliente();
		for (Cliente cliente : clientes) {
			System.out.println("ID: " + cliente.getIdCliente());
			System.out.println("Nome: " + cliente.getNomeCliente());
			System.out.println("CPF: " + cliente.getCPFCliente());
			System.out.println("Endereco: " + cliente.getEnderecoCliente());
			System.out.println("Telefone: " + cliente.getTelefoneCliente());
		}
	}

}
