package br.com.controle;

import java.util.Date;
import java.util.List;

import br.com.DAO.LocacaoDao;
import br.com.modelo.Locacao;

public class ControleLocacao {

	public void adicionaLocacao(int locacao_id, Date locacao_data, double locacao_valor, int cliente_id) {
		LocacaoDao dao = new LocacaoDao();
		Locacao locacao = new Locacao();
		locacao.setIdLocacao(locacao_id);
		// locacao.setDataLocacao(data);
		locacao.setValorLocacao(locacao_valor);
		locacao.setIdCliente(cliente_id);
		dao.adicionaLocacao(locacao);
	}

	public void excluiLocacao(int locacao_id) {
		LocacaoDao dao = new LocacaoDao();
		Locacao locacao = new Locacao();
		locacao.setIdLocacao(locacao_id);
		dao.excluiLocacao(locacao);
	}

	public void alteraLocacao(int locacao_id, Date locacao_data, double locacao_valor, int cliente_id) {
		LocacaoDao dao = new LocacaoDao();
		Locacao locacao = new Locacao();
		locacao.setIdLocacao(locacao_id);
		// locacao.setDataLocacao(dataLocacao);
		locacao.setValorLocacao(locacao_valor);
		locacao.setIdCliente(cliente_id);
		dao.alteraLocacao(locacao);
	}

	public void listaLocacao() {
		LocacaoDao dao = new LocacaoDao();
		List<Locacao> locacoes = dao.listaLocacao();
		for (Locacao locacao : locacoes) {
			System.out.println("IDLOCACAO" + locacao.getIdLocacao());
			System.out.println("DATA" + locacao.getDataLocacao());
			System.out.println("VALOR" + locacao.getValorLocacao());
			System.out.println("IDCLIENTE" + locacao.getIdCliente());
		}
	}

}
