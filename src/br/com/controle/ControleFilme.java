package br.com.controle;

import java.util.List;

import br.com.DAO.FilmeDao;
import br.com.DAO.FormatoDao;
import br.com.modelo.Filme;


public class ControleFilme {

	public void adicionaFormato(int filme_id, String filme_titulo, int genero_id) {
		Filme filme = new Filme();
		FilmeDao dao = new FilmeDao();
		
		filme.setIdFilme(filme_id);
		filme.setIdGenero(genero_id);
		filme.setTituloFilme(filme_titulo);
		dao.adicionaFilme(filme);
	}

	public void excluiFormato(int formato_id) {
		Filme filme = new Filme();
		FilmeDao dao = new FilmeDao();
		filme.setIdFilme(formato_id);
		dao.excluiFilme(filme);
	}

	public void alteraFormato(int filme_id, String filme_titulo) {
		Filme filme = new Filme();
		FilmeDao dao = new FilmeDao();
		filme.setIdFilme(filme_id);
		filme.setTituloFilme(filme_titulo);
		dao.alteraFilme(filme);
	}

	public void listaFilme() {
		ControleFormato formato = new ControleFormato();
		FilmeDao dao = new FilmeDao();
		List<Filme> filmes = dao.listaFilme();
		for (Filme filme : filmes) {
			System.out.println("ID: " + filme.getIdFilme());
			System.out.println("Titulo: " + filme.getTituloFilme());
			System.out.println("Formato: " + formato.listaFormato(filme.getIdFilme()));
		}
	}
	
	public String listaFilme(int filme_id) {
		String titulo = "";
		ControleFormato formato = new ControleFormato();
		FilmeDao dao = new FilmeDao();
		List<Filme> filmes = dao.listaFilme();
		for (Filme filme : filmes) {
			titulo = filme.getTituloFilme();
		}
		return titulo;
	}
}
