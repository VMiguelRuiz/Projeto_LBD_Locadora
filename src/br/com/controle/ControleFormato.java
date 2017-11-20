package br.com.controle;

import java.util.List;

import br.com.DAO.FormatoDao;
import br.com.modelo.Formato;

public class ControleFormato {

	public void adicionaFormato(int idFormato, String nome) {
		Formato formato = new Formato();
		FormatoDao dao = new FormatoDao();
		formato.setIdFormato(idFormato);
		formato.setNomeFormato(nome);
		dao.adicionaFormato(formato);
	}

	public void excluiFormato(int idFormato) {
		Formato formato = new Formato();
		FormatoDao dao = new FormatoDao();
		formato.setIdFormato(idFormato);
		dao.excluiFormato(formato);
	}

	public void alteraFormato(int idFormato, String nome) {
		Formato formato = new Formato();
		FormatoDao dao = new FormatoDao();
		formato.setIdFormato(idFormato);
		formato.setNomeFormato(nome);
		dao.alteraFormato(formato);
	}
	
	public void listaFormato(){

		FormatoDao dao = new FormatoDao();
		List<Formato> formatos = dao.listaFormatos();
		for (Formato formato : formatos) {
			System.out.println("ID: " + formato.getIdFormato());
			System.out.println("Formato: " + formato.getNomeFormato());
		}
	}
}
