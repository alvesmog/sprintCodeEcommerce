package br.com.spring.code.ecommerce.venda;

import java.util.List;

import br.com.spring.code.ecommerce.anuncio.Anuncio;
import br.com.spring.code.ecommerce.financeiro.Financeiro;
import br.com.spring.code.ecommerce.financeiro.Pagamento;
import br.com.spring.code.ecommerce.gestaopessoas.Pessoa;

/**
 * 
 * @author thiagojacinto, carloshenrique e wilson
 * 
 * Definição: classe que representa os pagamentos do sistema de e-commerce.
 *
 */
public class Venda {	
	
	private Pessoa pessoa;
	private List<Anuncio> anuncio;
	private Pagamento pagamento;
	private Financeiro financeiro;
	private String TIPO_DE_ENVIO;
	private boolean confirmarVenda;
	
	
}
