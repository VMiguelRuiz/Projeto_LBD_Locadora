package br.com.controle;

import java.util.List;

import br.com.DAO.ClienteDao;
import br.com.modelo.Cliente;

public class ControleCliente {

	public void adicionaCliente(int cliente_id, String cliente_nome, long cliente_cpf, int cliente_telefone, String cliente_endereco) {
		ClienteDao dao = new ClienteDao();
		Cliente cliente = new Cliente();
		cliente.setIdCliente(cliente_id);
		cliente.setNomeCliente(cliente_nome);
		cliente.setCPFCliente(cliente_cpf);
		cliente.setEnderecoCliente(cliente_endereco);
		cliente.setTelefoneCliente(cliente_telefone);
		dao.adicionarCliente(cliente);
	}
	
	public void excluiCliente(int cliente_id) {
		ClienteDao dao = new ClienteDao();
		Cliente cliente = new Cliente();
		cliente.setIdCliente(cliente_id);
		dao.excluiCliente(cliente);
	}
	
	public void alteraCliente(int cliente_id, String cliente_nome, long cliente_cpf, int cliente_telefone, String cliente_endereco) {
		ClienteDao dao = new ClienteDao();
		Cliente cliente = new Cliente();
		cliente.setIdCliente(cliente_id);
		cliente.setNomeCliente(cliente_nome);
		cliente.setCPFCliente(cliente_cpf);
		cliente.setEnderecoCliente(cliente_endereco);
		cliente.setTelefoneCliente(cliente_telefone);
		dao.alteraCliente(cliente);
	}
	
	public void listaCliente(){
		ClienteDao dao = new ClienteDao();
		List<Cliente> clientes = dao.listaCliente();
		for (Cliente cliente : clientes) {
			System.out.println("ID: " + cliente.getIdCliente());
			System.out.println("Nome: " + cliente.getNomeCliente());
			System.out.println("CPF: " + cliente.getCPFCliente());
			System.out.println("Endereco: " + cliente.getEnderecoCliente());
			System.out.println("Telefone: " + cliente.getTelefoneCliente());
		}
	}
}
