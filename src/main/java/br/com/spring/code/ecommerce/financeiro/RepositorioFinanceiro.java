package br.com.spring.code.ecommerce.financeiro;

import java.util.Date;
import java.util.List;

public interface RepositorioFinanceiro {
	
	// MÉTODOS
	
	/**
	 * @descrição Registrar um novo movimento financeiro com os dados 
	 * e cálculos a partir de uma venda.
	 * @param movimentoFinanceiro
	 */
	void registrarMovimentacao(Financeiro movimentoFinanceiro);
	
	/**
	 * @descrição retorna uma lista de objetos do tipo `Financeiro`.
	 * 
	 * @return List<Financeiro>
	 */
	List<Financeiro> listarMovimentosFinanceiros();
	
	/**
	 * @descrição A partir de uma Data, procurar no repositório uma
	 * movimentação finanaceira realizada na data de entrada.
	 * 
	 * @param data
	 * @return
	 */
	Financeiro procurarMovimento(Date data);
	
}
