package br.com.DAO;

import java.util.List;

import br.com.controle.ControleFormato;
import br.com.modelo.Filme;

public class Teste {
	public static void main(String[] args) {
		//ControleFormato formato = new ControleFormato();
		//formato.adicionaFormato(1, "DVD");
		//formato.excluiFormato(1);
		//formato.alteraFormato(1, "BLUERAY");
		//formato.listaFormato();
	
		Filme filme = new Filme();
//		filme.setIdFilme(1);
//		filme.setIdGenero(1);
		filme.setTituloFilme("Harry");
		
		FilmeDao dao = new FilmeDao();
//		dao.adicionaFilme(filme);
		
		List<Filme> filmes = dao.pesquisaFilme("Har");
		for (Filme filme2 : filmes) {
			System.out.println("Nome: " + filme2.getTituloFilme());
		}

	}
}
