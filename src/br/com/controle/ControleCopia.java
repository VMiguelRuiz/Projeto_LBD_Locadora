package br.com.controle;

import java.util.List;

import br.com.DAO.CopiaDao;
import br.com.modelo.Copia;


public class ControleCopia {
	
	public void adicionaCopia(int idCopia, int idFilme, String locado, int idFormato){
		
		Copia copia = new Copia();
		CopiaDao dao = new CopiaDao();
		copia.setIdFormato(idCopia);
		copia.setIdFilme(idFilme);
		copia.setLocado(locado);
		copia.setIdFormato(idFormato);
		dao.adicionaCopia(copia);
	}
	
	public void excluiCopia(int idCopia){
		Copia copia = new Copia();
		CopiaDao dao = new CopiaDao();
		copia.setIdCopia(idCopia);
		dao.excluiCopia(copia);
	}
	
	public void alteraCopia(int idCopia, int idFilme, String locado, int idFormato){
		
		Copia copia = new Copia();
		CopiaDao dao = new CopiaDao();
		copia.setIdFormato(idCopia);
		copia.setIdFilme(idFilme);
		copia.setLocado(locado);
		copia.setIdFormato(idFormato);
		dao.alteraCopia(copia);
	}
	
	public void listaCopia(){
		
		CopiaDao dao = new CopiaDao();
		List<Copia> copias = dao.listaCopia();
		for (Copia copia : copias) {
			System.out.println("ID: " + copia.getIdCopia());
			System.out.println("IDFILME: " + copia.getIdFilme());
			System.out.println("LOCADO" + copia.getLocado());
			System.out.println("FORMATO"+ copia.getIdFormato());
		}
	}

}
