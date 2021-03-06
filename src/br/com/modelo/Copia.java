package br.com.modelo;

public class Copia {
	private String copia_nome;
	private int copia_id;
	private int filme_id;
	private int copia_locada;
	private int formato_id;
	private double copia_valor;

	public String getNomeCopia() {
		return copia_nome;
	}

	public void setNomeCopia(String copia_nome) {
		this.copia_nome = copia_nome;
	}

	public int getIdCopia() {
		return copia_id;
	}

	public void setIdCopia(int copia_id) {
		this.copia_id = copia_id;
	}

	public int getIdFilme() {
		return filme_id;
	}

	public void setIdFilme(int filme_id) {
		this.filme_id = filme_id;
	}

	public int getCopiaLocada() {
		return copia_locada;
	}

	public void setCopiaLocada(int copia_locada) {
		this.copia_locada = copia_locada;
	}

	public int getIdFormato() {
		return formato_id;
	}

	public void setIdFormato(int formato_id) {
		this.formato_id = formato_id;
	}

	public double getValorCopia() {
		return copia_valor;
	}

	public void setValorCopia(double copia_valor) {
		this.copia_valor = copia_valor;
	}

}
