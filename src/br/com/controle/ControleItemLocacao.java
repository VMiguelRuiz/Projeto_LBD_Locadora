package br.com.controle;

import java.util.List;

import br.com.DAO.ItemLocacaoDao;
import br.com.modelo.ItemLocacao;

public class ControleItemLocacao {

	public void adicionaItemLocacao(int item_id, int copia_id, int locacao_id) {
		ItemLocacaoDao dao = new ItemLocacaoDao();
		ItemLocacao itemLocacao = new ItemLocacao();
		itemLocacao.setIdItem(item_id);
		itemLocacao.setIdCopia(copia_id);
		itemLocacao.setIdLocacao(locacao_id);
		dao.adicionaItem(itemLocacao);
	}

	public void excluiItemLocacao(int item_id) {
		ItemLocacaoDao dao = new ItemLocacaoDao();
		ItemLocacao itemLocacao = new ItemLocacao();
		itemLocacao.setIdItem(item_id);
		dao.excluiItem(itemLocacao);
	}

	public void alteraItemLocacao(int item_id, int copia_id, int locacao_id) {
		ItemLocacaoDao dao = new ItemLocacaoDao();
		ItemLocacao itemLocacao = new ItemLocacao();
		itemLocacao.setIdItem(item_id);
		itemLocacao.setIdCopia(copia_id);
		itemLocacao.setIdLocacao(locacao_id);
		dao.alteraItem(itemLocacao);
	}

	public void ListaItemLocacao() {
		ItemLocacaoDao dao = new ItemLocacaoDao();
		List<ItemLocacao> itens = dao.listaItem();
		for (ItemLocacao itemLocacao : itens) {
			System.out.println("IDITEM" + itemLocacao.getIdItem());
			System.out.println("IDCOPIA" + itemLocacao.getIdCopia());
			System.out.println("IDLOCACAO" + itemLocacao.getIdLocacao());
		}

	}

}
