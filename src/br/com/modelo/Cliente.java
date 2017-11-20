package br.com.modelo;

public class Cliente {
	private int cliente_id;
	private String cliente_nome;
	private long cliente_cpf;
	private int cliente_telefone;
	private String cliente_endereco;

	public int getIdCliente() {
		return cliente_id;
	}

	public void setIdCliente(int cliente_id) {
		this.cliente_id = cliente_id;
	}

	public String getNomeCliente() {
		return cliente_nome;
	}

	public void setNomeCliente(String cliente_nome) {
		this.cliente_nome = cliente_nome;
	}

	public long getCPFCliente() {
		return cliente_cpf;
	}

	public void setCPFCliente(long cliente_cpf) {
		this.cliente_cpf = cliente_cpf;
	}

	public int getTelefoneCliente() {
		return cliente_telefone;
	}

	public void setTelefoneCliente(int cliente_telefone) {
		this.cliente_telefone = cliente_telefone;
	}

	public String getEnderecoCliente() {
		return cliente_endereco;
	}

	public void setEnderecoCliente(String cliente_endereco) {
		this.cliente_endereco = cliente_endereco;
	}

}