package br.com.controle;

import java.util.List;

import br.com.DAO.CopiaDAO;
import br.com.DAO.FilmeDAO;
import br.com.DAO.FormatoDAO;
import br.com.modelo.Copia;

public class ControleCopia {

	public void adicionaCopia(String filmeID, String copiaLocada, String formatoID, String copiaValor) {

		int filme_id = Integer.parseInt(filmeID);
		int copia_locada = Integer.parseInt(copiaLocada);
		int formato_id = Integer.parseInt(formatoID);
		double copia_valor = Double.parseDouble(copiaValor);
		
		Copia copia = new Copia();
		CopiaDAO copia_dao = new CopiaDAO();

		copia.setCopiaLocada(copia_locada);
		copia.setIdFilme(filme_id);
		copia.setIdFormato(formato_id);
		copia.setValorCopia(copia_valor);
		copia_dao.adicionaCopia(copia);
	}

	public void excluiCopia(String copia_id) {
		Copia copia = new Copia();
		CopiaDAO copia_dao = new CopiaDAO();
		copia.setIdCopia(Integer.parseInt(copia_id));
		copia_dao.excluiCopia(copia);
	}

	public void alteraCopia(String copiaID, String filmeID, String copiaLocada, String formatoID, String copiaValor) {

		int copia_id = Integer.parseInt(copiaID);
		int filme_id = Integer.parseInt(filmeID);
		int copia_locada = Integer.parseInt(copiaLocada);
		int formato_id = Integer.parseInt(formatoID);
		double copia_valor = Double.parseDouble(copiaValor);
		
		Copia copia = new Copia();
		CopiaDAO copia_dao = new CopiaDAO();

		copia.setIdCopia(copia_id);
		copia.setIdFilme(filme_id);
		copia.setCopiaLocada(copia_locada);
		copia.setIdFormato(formato_id);
		copia.setValorCopia(copia_valor);
		copia_dao.alteraCopia(copia);
	}

	public void listaCopia() {

		CopiaDAO copia_dao = new CopiaDAO();
		ControleFilme filme = new ControleFilme();
		ControleFormato formato = new ControleFormato();
		List<Copia> copias = copia_dao.listaCopia();
		for (Copia copia : copias) {
			System.out.println("ID: " + copia.getIdCopia());
			System.out.println("FILME: " + filme.listaFilme(copia.getIdFilme()));
			System.out.println("FORMATO: " + formato.listaFormato(copia.getIdFormato()));
			// System.out.println("LOCADO" + copia.getCopiaLocada());
			System.out.println("Valor " + copia.getValorCopia());
		}
	}
}
