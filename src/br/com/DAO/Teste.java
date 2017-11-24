package br.com.DAO;

import java.util.List;

import br.com.controle.ControleCopia;
import br.com.controle.ControleFilme;
import br.com.controle.ControleFormato;
import br.com.modelo.Copia;
import br.com.modelo.Filme;
import br.com.modelo.Formato;
import br.com.modelo.Genero;

public class Teste {
	public static void main(String[] args) {
	
		GeneroDao genDao = new GeneroDao();
		Genero genero = new Genero();

		
		FilmeDao filmeDao = new FilmeDao();
		Filme filme = new Filme();
		ControleFilme ctrFilme = new ControleFilme();
		
		FormatoDao forDao = new FormatoDao();
		Formato formato = new Formato();
		ControleFormato ctrFormato = new ControleFormato();
		
		CopiaDao copDao = new CopiaDao();
		ControleCopia ctrCopia = new ControleCopia();
		//ctrCopia.listaCopia();
		
		//ctrFilme.listaFilme();
		
		//ctrFormato.listaFormato(1);
		//ctrFilme.listaFilme();
		ctrCopia.listaCopia();
	}
}
