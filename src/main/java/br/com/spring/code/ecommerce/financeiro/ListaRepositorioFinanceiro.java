package br.com.spring.code.ecommerce.financeiro;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListaRepositorioFinanceiro implements RepositorioFinanceiro {
	
	// Atributo
	List<Financeiro> repositorioDeFinanceiros;
	
	// Construtor
	public ListaRepositorioFinanceiro() {
		repositorioDeFinanceiros = new ArrayList<Financeiro>();
	}
	
	// Métodos
	
	
	public void registrarMovimentacao(Financeiro movimentoFinanceiro) {
		
		repositorioDeFinanceiros.add(movimentoFinanceiro);
		
	}

	public List<Financeiro> listarMovimentosFinanceiros() {
		
		return this.repositorioDeFinanceiros;
	}

	public Financeiro procurarMovimento(Date dataProcurada) {
		
		/**
		 * Percorre a lista e verifica se o atributo `dataDePagamento` 
		 * é igual ao input {@code dataProcurada}.
		 * 
		 * @alert retorna o primeiro valor encontrado.
		 */
		for (Financeiro financeiro : repositorioDeFinanceiros) {
			if (financeiro.getDataDoPagamento().equals(dataProcurada)) {
				return financeiro;
			}
		}
		// Retorna NULO caso não encontre um match.
		return null;
	}
	
	/**
	 * @descrição <p> Percorre a lista do repositório e imprime no console os seus dados.
	 * <p> Usa o {@code System.out.printl()} para imprimir no console.
	 */
	public void exibirTodosMovFinanceiros() {
		for (Financeiro financeiro : repositorioDeFinanceiros) {
			System.out.println(financeiro.toString());
		}
	}

}
