package br.com.controle;

import java.util.List;

import br.com.DAO.FilmeDAO;
import br.com.DAO.FormatoDAO;
import br.com.DAO.GeneroDAO;
import br.com.modelo.Filme;

public class ControleFilme {

	public void adicionaFilme(String filme_titulo, String generoID) {

		int genero_id = Integer.parseInt(generoID);

		Filme filme = new Filme();
		FilmeDAO filme_dao = new FilmeDAO();

		filme.setIdGenero(genero_id);
		filme.setTituloFilme(filme_titulo);
		filme_dao.adicionaFilme(filme);
	}

	public void excluiFilme(String formato_id) {
		Filme filme = new Filme();
		FilmeDAO filme_dao = new FilmeDAO();
		filme.setIdFilme(Integer.parseInt(formato_id));
		filme_dao.excluiFilme(filme);
	}

	public void alteraFilme(String filmeID, String filme_titulo, String generoID) {
		int filme_id = Integer.parseInt(filmeID);
		int genero_id = Integer.parseInt(generoID);

		Filme filme = new Filme();
		FilmeDAO filme_dao = new FilmeDAO();

		filme.setIdFilme(filme_id);
		filme.setIdGenero(genero_id);
		filme.setTituloFilme(filme_titulo);
		filme_dao.alteraFilme(filme);
	}

	public void listaFilme() {
		ControleFormato formato = new ControleFormato();
		FilmeDAO filme_dao = new FilmeDAO();
		List<Filme> filmes = filme_dao.listaFilme();
		for (Filme filme : filmes) {
			System.out.println("ID: " + filme.getIdFilme());
			System.out.println("Titulo: " + filme.getTituloFilme());
			System.out.println("Formato: " + formato.listaFormato(filme.getIdFilme()));
		}
	}

	public String listaFilme(int filme_id) {
		String titulo = "";
		ControleFormato formato = new ControleFormato();
		FilmeDAO dao = new FilmeDAO();
		List<Filme> filmes = dao.listaFilme();
		for (Filme filme : filmes) {
			titulo = filme.getTituloFilme();
		}
		return titulo;
	}
	
	public void listaFilme(String nome) {
		String titulo = "";
		ControleFormato formato = new ControleFormato();
		FilmeDAO dao = new FilmeDAO();
		ControleGenero genero = new ControleGenero();
		List<Filme> filmes = dao.listaFilme(nome);
		for (Filme filme : filmes) {
			System.out.println(filme.getIdFilme());
			System.out.println(filme.getTituloFilme());
			System.out.println(genero.listaGenero(filme.getIdFilme()));
		}
	}
}
