package br.com.controle;

import java.util.Date;
import java.util.List;

import br.com.DAO.LocacaoDao;
import br.com.modelo.Locacao;

public class ControleLocacao {
	
	public void adicionaLocacao(int idLocacao,  Date data, double valor, int idCliente){
		LocacaoDao dao = new LocacaoDao();
		Locacao locacao = new Locacao();
		locacao.setIdLocacao(idLocacao);
		//locacao.setDataLocacao(data);
		locacao.setValorLocacao(valor);
		locacao.setIdCliente(idCliente);	
	}
	
	public void excluiLocacao(int idLocacao){
		LocacaoDao dao = new LocacaoDao();
		Locacao locacao = new Locacao();
		locacao.setIdLocacao(idLocacao);
		dao.excluiLocacao(locacao);
	}
	
	public void alteraLocacao(int idLocacao, Date data, double valor, int idCliente){
		LocacaoDao dao = new LocacaoDao();
		Locacao locacao = new Locacao();
		locacao.setIdLocacao(idLocacao);
		//locacao.setDataLocacao(dataLocacao);
		locacao.setValorLocacao(valor);
		locacao.setIdCliente(idCliente);
		dao.alteraLocacao(locacao);
	}
	
	public void listaLocacao(){
		LocacaoDao dao = new LocacaoDao();
		List<Locacao> locacoes = dao.listaLocacao();
		for(Locacao locacao: locacoes){
			System.out.println("IDLOCACAO"+ locacao.getIdLocacao());
			System.out.println("DATA"+ locacao.getDataLocacao());
			System.out.println("VALOR"+ locacao.getValorLocacao());
			System.out.println("IDCLIENTE"+ locacao.getIdCliente());
		}
	}

}
