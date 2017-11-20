package br.com.controle;

import java.util.List;

import br.com.DAO.ItemLocacaoDao;
import br.com.modelo.ItemLocacao;

public class ControleItemLocacao {
	
	public void adicionaItemLocacao(int idItem, int idCopia, int idLocacao){
		ItemLocacaoDao dao = new ItemLocacaoDao();
		ItemLocacao itemLocacao = new ItemLocacao();
		itemLocacao.setIdItem(idItem);
		itemLocacao.setIdCopia(idCopia);
		itemLocacao.setIdLocacao(idLocacao);
		dao.adicionaItem(itemLocacao);
	}
	
	public void excluiItemLocacao(int idItem){
		ItemLocacaoDao dao = new ItemLocacaoDao();
		ItemLocacao itemLocacao = new ItemLocacao();
		itemLocacao.setIdItem(idItem);
		dao.excluiItem(itemLocacao);
	}
	
	public void alteraItemLocacao(int idItem, int idCopia, int idLocacao){
		ItemLocacaoDao dao = new ItemLocacaoDao();
		ItemLocacao itemLocacao = new ItemLocacao();
		itemLocacao.setIdItem(idItem);
		itemLocacao.setIdCopia(idCopia);
		itemLocacao.setIdLocacao(idLocacao);
		dao.alteraItem(itemLocacao);
	}
	
	public void ListaItemLocacao(){
		ItemLocacaoDao dao = new ItemLocacaoDao();
		List<ItemLocacao> itens = dao.listaItem();
		for(ItemLocacao itemLocacao: itens){
			System.out.println("IDITEM"+ itemLocacao.getIdItem());
			System.out.println("IDCOPIA"+ itemLocacao.getIdCopia());
			System.out.println("IDLOCACAO"+ itemLocacao.getIdLocacao());	
		}
		
	}

}
