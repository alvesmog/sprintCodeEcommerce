package br.com.spring.code.ecommerce.vendas;

import java.util.List;

import br.com.spring.code.ecommerce.anuncio.Anuncio;
import br.com.spring.code.ecommerce.financeiro.Financeiro;
import br.com.spring.code.ecommerce.financeiro.Pagamento;
import br.com.spring.code.ecommerce.gestaopessoas.Pessoa;

public class Vendas {	
	private Pessoa pessoa;
	private List<Anuncio> anuncio;
	private Pagamento pagamento;
	private Financeiro financeiro;
	private String tipoEnvio;
	private boolean confirmarVenda;
	
	
}
