package br.com.DAO;

import br.com.controle.ControleFormato;

public class Teste {
	public static void main(String[] args) {
		ControleFormato formato = new ControleFormato();
		//formato.adicionaFormato(1, "Romance");
		//formato.excluiFormato(1);
		//formato.alteraFormato(1, "Comedia Romantica");
		formato.listaFormato();
	}
}
