package br.com.controle;

import java.util.List;

import br.com.DAO.FormatoDAO;
import br.com.modelo.Formato;

public class ControleFormato {

	public void adicionaFormato(String formatoID, String formato_nome) {
		int formato_id = Integer.parseInt(formatoID);
		Formato formato_modelo = new Formato();
		FormatoDAO formato_dao  = new FormatoDAO();
		formato_modelo.setIdFormato(formato_id);
		formato_modelo.setNomeFormato(formato_nome);
		formato_dao.adicionaFormato(formato_modelo);
	}

	public void excluiFormato(String formatoID) {
		Formato formato_modelo = new Formato();
		FormatoDAO formato_dao  = new FormatoDAO();
		formato_modelo.setIdFormato(Integer.parseInt(formatoID));
		formato_dao.excluiFormato(formato_modelo);
	}

	public void alteraFormato(String formatoID, String formato_nome) {
		int formato_id = Integer.parseInt(formatoID);
		Formato formato_modelo = new Formato();
		FormatoDAO formato_dao  = new FormatoDAO();
		formato_modelo.setIdFormato(formato_id);
		formato_modelo.setNomeFormato(formato_nome);
		formato_dao.alteraFormato(formato_modelo);
	}

	public void listaFormato() {

		FormatoDAO formato_dao  = new FormatoDAO();
		List<Formato> formatos = formato_dao.listaFormatos();
		for (Formato formato_modelo : formatos) {
			System.out.println("ID: " + formato_modelo.getIdFormato());
			System.out.println("Formato: " + formato_modelo.getNomeFormato());
		}
	}
	
	public String listaFormato(int formato_id) {
		String nome = "";
		FormatoDAO formato_dao  = new FormatoDAO();
		List<Formato> formatos = formato_dao.listaFormatos(formato_id);
		for (Formato formato_modelo : formatos) {
			//System.out.println("ID: " + formato_modelo.getIdFormato());
			//System.out.println("Formato: " + formato_modelo.getNomeFormato());
			nome = formato_modelo.getNomeFormato();
		}
		return nome;
	}
	
}
