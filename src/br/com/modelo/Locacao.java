package br.com.modelo;

import java.sql.Date;

public class Locacao {
	private int idLocacao;
	private Date dataLocacao;
	private double valorLocacao;
	private int cliente_id;

	public int getIdLocacao() {
		return idLocacao;
	}

	public void setIdLocacao(int locacao_id) {
		this.idLocacao = locacao_id;
	}

	public Date getDataLocacao() {
		return dataLocacao;
	}

	public void setDataLocacao(Date locacao_data) {
		this.dataLocacao = locacao_data;
	}

	public double getValorLocacao() {
		return valorLocacao;
	}

	public void setValorLocacao(double locacao_valor) {
		this.valorLocacao = locacao_valor;
	}

	public int getIdCliente() {
		return cliente_id;
	}

	public void setIdCliente(int cliente_id) {
		this.cliente_id = cliente_id;
	}

}
