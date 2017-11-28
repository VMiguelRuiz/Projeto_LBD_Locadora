package br.com.controle;

import java.util.Date;
import java.util.List;

import br.com.DAO.LocacaoDAO;
import br.com.modelo.Locacao;

public class ControleLocacao {

	public void adicionaLocacao(String locacaoData, String locacaoValor, String clienteID) {

		// Date locacao_data = Date.parseDate(locacaoData);

		double locacao_valor = Double.parseDouble(locacaoValor);
		int cliente_id = Integer.parseInt(clienteID);

		LocacaoDAO locacao_dao = new LocacaoDAO();
		Locacao locacao = new Locacao();
		
		// locacao.setDataLocacao(locacaoData);
		locacao.setValorLocacao(locacao_valor);
		locacao.setIdCliente(cliente_id);
		locacao_dao.adicionaLocacao(locacao);
	}

	public void excluiLocacao(String locacao_id) {
		LocacaoDAO locacao_dao = new LocacaoDAO();
		Locacao locacao = new Locacao();
		locacao.setIdLocacao(Integer.parseInt(locacao_id));
		locacao_dao.excluiLocacao(locacao);
	}

	public void alteraLocacao(String locacaoID, String locacaoData, String locacaoValor, String clienteID) {

		int locacao_id = Integer.parseInt(locacaoID);
		// Date locacao_data = Date.parseDate(locacaoData);

		double locacao_valor = Double.parseDouble(locacaoValor);
		int cliente_id = Integer.parseInt(clienteID);

		LocacaoDAO locacao_dao = new LocacaoDAO();
		Locacao locacao = new Locacao();
		locacao.setIdLocacao(locacao_id);
		// locacao.setDataLocacao(locacaoData);
		locacao.setValorLocacao(locacao_valor);
		locacao.setIdCliente(cliente_id);
		locacao_dao.alteraLocacao(locacao);
	}

	public void listaLocacao() {
		LocacaoDAO locacao_dao = new LocacaoDAO();
		List<Locacao> locacoes = locacao_dao.listaLocacao();
		for (Locacao locacao : locacoes) {
			System.out.println("IDLOCACAO" + locacao.getIdLocacao());
			System.out.println("DATA" + locacao.getDataLocacao());
			System.out.println("VALOR" + locacao.getValorLocacao());
			System.out.println("IDCLIENTE" + locacao.getIdCliente());
		}
	}

}
