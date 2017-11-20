package br.com.modelo;

public class ItemLocacao {
	private int item_id;
	private int copia_id;
	private int locacao_id;

	public int getIdItem() {
		return item_id;
	}

	public void setIdItem(int item_id) {
		this.item_id = item_id;
	}

	public int getIdCopia() {
		return copia_id;
	}

	public void setIdCopia(int copia_id) {
		this.copia_id = copia_id;
	}

	public int getIdLocacao() {
		return locacao_id;
	}

	public void setIdLocacao(int locacao_id) {
		this.locacao_id = locacao_id;
	}

}
