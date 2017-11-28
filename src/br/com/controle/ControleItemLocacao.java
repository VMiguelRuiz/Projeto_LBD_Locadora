package br.com.controle;

import java.util.List;

import br.com.DAO.ItemLocacaoDAO;
import br.com.modelo.ItemLocacao;

public class ControleItemLocacao {

	public void adicionaItemLocacao(String itemID, String copiaID, String locacaoID) {
		int item_id = Integer.parseInt(itemID);
		int copia_id = Integer.parseInt(copiaID);
		int locacao_id = Integer.parseInt(locacaoID);
		
		ItemLocacaoDAO item_dao = new ItemLocacaoDAO();
		ItemLocacao item = new ItemLocacao();
		item.setIdItem(item_id);
		item.setIdCopia(copia_id);
		item.setIdLocacao(locacao_id);
		item_dao.adicionaItem(item);
	}

	public void excluiItemLocacao(String item_id) {
		ItemLocacaoDAO item_dao = new ItemLocacaoDAO();
		ItemLocacao item = new ItemLocacao();
		item.setIdItem(Integer.parseInt(item_id));
		item_dao.excluiItem(item);
	}

	public void alteraItemLocacao(String itemID, String copiaID, String locacaoID) {
		
		int item_id = Integer.parseInt(itemID);
		int copia_id = Integer.parseInt(copiaID);
		int locacao_id = Integer.parseInt(locacaoID);
		
		ItemLocacaoDAO item_dao = new ItemLocacaoDAO();
		ItemLocacao item = new ItemLocacao();
		item.setIdItem(item_id);
		item.setIdCopia(copia_id);
		item.setIdLocacao(locacao_id);
		item_dao.alteraItem(item);
	}

	public void ListaItemLocacao() {
		ItemLocacaoDAO item_dao = new ItemLocacaoDAO();
		List<ItemLocacao> itens = item_dao.listaItem();
		for (ItemLocacao item : itens) {
			System.out.println("IDITEM" + item.getIdItem());
			System.out.println("IDCOPIA" + item.getIdCopia());
			System.out.println("IDLOCACAO" + item.getIdLocacao());
		}

	}

}
