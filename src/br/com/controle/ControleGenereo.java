package br.com.controle;

import java.util.List;

import br.com.DAO.GeneroDao;
import br.com.modelo.Genero;

public class ControleGenereo {
	
	public void adicionaGenereo(int idGenero, String nomeGenero){
		GeneroDao dao = new GeneroDao();
		Genero genero = new Genero();
		genero.setIdGenero(idGenero);
		genero.setNomeGenero(nomeGenero);
		dao.adicionaGenero(genero);
	}
	
	
	public void excluiGenero(int idGenero){
		GeneroDao dao = new GeneroDao();
		Genero genero = new Genero();
		genero.setIdGenero(idGenero);
		dao.excluiGenero(genero);
	}
	
	public void alteraGenero(int idGenero, String nomeGenero){
		GeneroDao dao = new GeneroDao();
		Genero genero = new Genero();
		genero.setIdGenero(idGenero);
		genero.setNomeGenero(nomeGenero);
		dao.alteraGenero(genero);
	}
	
	public void listaGenero(){
		GeneroDao dao = new GeneroDao();
		List<Genero> generos = dao.listaGenero();
		for(Genero genero: generos){
			System.out.println("IDGENERO"+ genero.getIdGenero());
			System.out.println("NOME GENERO"+ genero.getNomeGenero());
		}
	}
	
	

}
