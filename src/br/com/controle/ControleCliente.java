package br.com.controle;

import java.util.List;

import br.com.DAO.ClienteDao;
import br.com.modelo.Cliente;

public class ControleCliente {

	public void adicionaCliente(int id, String nome, long cpf, int telefone, String endereco) {
		ClienteDao dao = new ClienteDao();
		Cliente cliente = new Cliente();
		cliente.setIdCliente(id);
		cliente.setNomeCliente(nome);
		cliente.setCpf(cpf);
		cliente.setEnderecoCliente(endereco);
		cliente.setTelefone(telefone);
		dao.adicionarCliente(cliente);
	}
	
	public void excluiCliente(int id) {
		ClienteDao dao = new ClienteDao();
		Cliente cliente = new Cliente();
		cliente.setIdCliente(id);
		dao.excluiCliente(cliente);
	}
	
	public void alteraCliente(int id, String nome, long cpf, int telefone, String endereco) {
		ClienteDao dao = new ClienteDao();
		Cliente cliente = new Cliente();
		cliente.setIdCliente(id);
		cliente.setNomeCliente(nome);
		cliente.setCpf(cpf);
		cliente.setEnderecoCliente(endereco);
		cliente.setTelefone(telefone);
		dao.alteraCliente(cliente);
	}
	
	public void listaCliente(){
		ClienteDao dao = new ClienteDao();
		List<Cliente> clientes = dao.listaCliente();
		for (Cliente cliente : clientes) {
			System.out.println("ID: " + cliente.getIdCliente());
			System.out.println("Nome: " + cliente.getNomeCliente());
			System.out.println("CPF: " + cliente.getCpf());
			System.out.println("Endereco: " + cliente.getEnderecoCliente());
			System.out.println("Telefone: " + cliente.getTelefone());
		}
	}
}
