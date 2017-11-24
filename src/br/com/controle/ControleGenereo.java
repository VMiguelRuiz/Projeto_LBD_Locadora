package br.com.controle;

import java.util.List;

import br.com.DAO.GeneroDao;
import br.com.modelo.Genero;

public class ControleGenereo {

	public void adicionaGenereo(int genero_id, String genero_nome) {
		GeneroDao dao = new GeneroDao();
		Genero genero = new Genero();
		genero.setIdGenero(genero_id);
		genero.setNomeGenero(genero_nome);
		dao.adicionaGenero(genero);
	}

	public void excluiGenero(int genero_id) {
		GeneroDao dao = new GeneroDao();
		Genero genero = new Genero();
		genero.setIdGenero(genero_id);
		dao.excluiGenero(genero);
	}

	public void alteraGenero(int genero_id, String genero_nome) {
		GeneroDao dao = new GeneroDao();
		Genero genero = new Genero();
		genero.setIdGenero(genero_id);
		genero.setNomeGenero(genero_nome);
		dao.alteraGenero(genero);
	}

	public void listaGenero() {
		GeneroDao dao = new GeneroDao();
		List<Genero> generos = dao.listaGenero();
		for (Genero genero : generos) {
			System.out.println("IDGENERO" + genero.getIdGenero());
			System.out.println("NOME GENERO" + genero.getNomeGenero());
		}
	}

}
