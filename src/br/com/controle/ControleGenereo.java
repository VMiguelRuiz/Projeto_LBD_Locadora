package br.com.controle;

import java.util.List;

import br.com.DAO.GeneroDAO;
import br.com.modelo.Genero;

public class ControleGenereo {

	public void adicionaGenereo(String generoID, String genero_nome) {

		int genero_id = Integer.parseInt(generoID);
		GeneroDAO genero_dao = new GeneroDAO();
		Genero genero = new Genero();
		genero.setIdGenero(genero_id);
		genero.setNomeGenero(genero_nome);
		genero_dao.adicionaGenero(genero);
	}

	public void excluiGenero(String generoID) {
		int genero_id = Integer.parseInt(generoID);
		GeneroDAO genero_dao = new GeneroDAO();
		Genero genero = new Genero();
		genero.setIdGenero(genero_id);
		genero_dao.excluiGenero(genero);
	}

	public void alteraGenero(String generoID, String genero_nome) {
		int genero_id = Integer.parseInt(generoID);
		GeneroDAO genero_dao = new GeneroDAO();
		Genero genero = new Genero();
		genero.setIdGenero(genero_id);
		genero.setNomeGenero(genero_nome);
		genero_dao.alteraGenero(genero);
	}

	public void listaGenero() {
		GeneroDAO genero_dao = new GeneroDAO();
		List<Genero> generos = genero_dao.listaGenero();
		for (Genero genero : generos) {
			System.out.println("IDGENERO" + genero.getIdGenero());
			System.out.println("NOME GENERO" + genero.getNomeGenero());
		}
	}

}
