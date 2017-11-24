package br.com.controle;

import java.util.List;

import br.com.DAO.FormatoDao;
import br.com.modelo.Formato;

public class ControleFormato {

	public void adicionaFormato(int formato_id, String formato_nome) {
		Formato formato = new Formato();
		FormatoDao dao = new FormatoDao();
		formato.setIdFormato(formato_id);
		formato.setNomeFormato(formato_nome);
		dao.adicionaFormato(formato);
	}

	public void excluiFormato(int formato_id) {
		Formato formato = new Formato();
		FormatoDao dao = new FormatoDao();
		formato.setIdFormato(formato_id);
		dao.excluiFormato(formato);
	}

	public void alteraFormato(int formato_id, String formato_nome) {
		Formato formato = new Formato();
		FormatoDao dao = new FormatoDao();
		formato.setIdFormato(formato_id);
		formato.setNomeFormato(formato_nome);
		dao.alteraFormato(formato);
	}

	public void listaFormato() {

		FormatoDao dao = new FormatoDao();
		List<Formato> formatos = dao.listaFormatos();
		for (Formato formato : formatos) {
			System.out.println("ID: " + formato.getIdFormato());
			System.out.println("Formato: " + formato.getNomeFormato());
		}
	}
	
	public String listaFormato(int formato_id) {
		String nome = "";
		FormatoDao dao = new FormatoDao();
		List<Formato> formatos = dao.listaFormatos(formato_id);
		for (Formato formato : formatos) {
			//System.out.println("ID: " + formato.getIdFormato());
			//System.out.println("Formato: " + formato.getNomeFormato());
			nome = formato.getNomeFormato();
		}
		return nome;
	}
	
}
