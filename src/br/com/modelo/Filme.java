package br.com.modelo;

public class Filme {
	private int filme_id;
	private String filme_titulo;
	private int genero_id;

	public int getIdFilme() {
		return filme_id;
	}

	public void setIdFilme(int filme_id) {
		this.filme_id = filme_id;
	}

	public String getTituloFilme() {
		return filme_titulo;
	}

	public void setTituloFilme(String filme_titulo) {
		this.filme_titulo = filme_titulo;
	}

	public int getIdGenero() {
		return genero_id;
	}

	public void setIdGenero(int genero_id) {
		this.genero_id = genero_id;
	}

}
