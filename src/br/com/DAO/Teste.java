package br.com.DAO;

import java.util.List;

import br.com.controle.ControleCliente;
import br.com.controle.ControleCopia;
import br.com.controle.ControleFilme;
import br.com.controle.ControleFormato;
import br.com.controle.ControleGenero;
import br.com.modelo.Cliente;
import br.com.modelo.Copia;



public class Teste {
	public static void main(String[] args) {
	
	
		ControleGenero gen = new ControleGenero();


		ControleFilme filme = new ControleFilme();

		ControleFormato formato = new ControleFormato();
		//formato.adicionaFormato("DVD");
		
		ControleCopia copia = new ControleCopia();
		copia.alteraCopia("1", "1", "0", "1", "3.00");
		copia.listaCopia();

	}
}
