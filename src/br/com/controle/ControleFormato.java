package br.com.controle;

import java.util.List;

import br.com.DAO.FormatoDAO;
import br.com.modelo.Formato;

public class ControleFormato {

	public void adicionaFormato( String formato_nome) {

		Formato formato = new Formato();
		FormatoDAO formato_dao  = new FormatoDAO();

		formato.setNomeFormato(formato_nome);
		formato_dao.adicionaFormato(formato);
	}

	public void excluiFormato(String formatoID) {
		Formato formato = new Formato();
		FormatoDAO formato_dao  = new FormatoDAO();
		formato.setIdFormato(Integer.parseInt(formatoID));
		formato_dao.excluiFormato(formato);
	}

	public void alteraFormato(String formatoID, String formato_nome) {
		int formato_id = Integer.parseInt(formatoID);
		Formato formato = new Formato();
		FormatoDAO formato_dao  = new FormatoDAO();
		formato.setIdFormato(formato_id);
		formato.setNomeFormato(formato_nome);
		formato_dao.alteraFormato(formato);
	}

	public void listaFormato() {

		FormatoDAO formato_dao  = new FormatoDAO();
		List<Formato> formatos = formato_dao.listaFormatos();
		for (Formato formato : formatos) {
			System.out.println("ID: " + formato.getIdFormato());
			System.out.println("Formato: " + formato.getNomeFormato());
		}
	}
	
	public String listaFormato(int formato_id) {
		String nome = "";
		FormatoDAO formato_dao  = new FormatoDAO();
		List<Formato> formatos = formato_dao.listaFormatos(formato_id);
		for (Formato formato : formatos) {
			//System.out.println("ID: " + formato.getIdFormato());
			//System.out.println("Formato: " + formato.getNomeFormato());
			nome = formato.getNomeFormato();
		}
		return nome;
	}
	
}
