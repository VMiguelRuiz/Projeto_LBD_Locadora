package br.com.controle;

import java.util.List;

import br.com.DAO.CopiaDao;
import br.com.DAO.FilmeDao;
import br.com.DAO.FormatoDao;
import br.com.modelo.Copia;

public class ControleCopia {

	public void adicionaCopia(int copia_id, int filme_id, String copia_locada, int formato_id) {

		Copia copia = new Copia();
		CopiaDao dao = new CopiaDao();
		copia.setIdFormato(copia_id);
		copia.setIdFilme(filme_id);
		copia.setCopiaLocada(copia_locada);
		copia.setIdFormato(formato_id);
		dao.adicionaCopia(copia);
	}

	public void excluiCopia(int copia_id) {
		Copia copia = new Copia();
		CopiaDao dao = new CopiaDao();
		copia.setIdCopia(copia_id);
		dao.excluiCopia(copia);
	}

	public void alteraCopia(int copia_id, int filme_id, String copia_locada, int formato_id) {
		Copia copia = new Copia();
		CopiaDao dao = new CopiaDao();
		copia.setIdFormato(copia_id);
		copia.setIdFilme(filme_id);
		copia.setCopiaLocada(copia_locada);
		copia.setIdFormato(formato_id);
		dao.alteraCopia(copia);
	}

	public void listaCopia() {

		CopiaDao dao = new CopiaDao();
		ControleFilme filme = new ControleFilme ();
		ControleFormato formato = new ControleFormato();
		List<Copia> copias = dao.listaCopia();
		for (Copia copia : copias) {
			System.out.println("ID: " + copia.getIdCopia());
			System.out.println("FILME: " + filme.listaFilme(copia.getIdFilme()));
			System.out.println("FORMATO: " + formato.listaFormato(copia.getIdFormato()));
			//System.out.println("LOCADO" + copia.getCopiaLocada());
			System.out.println("Valor " + copia.getValorCopia());
		}
	}
}
