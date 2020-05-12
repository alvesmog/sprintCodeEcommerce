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
 * Definição: classe que representa as VENDAS do sistema de e-commerce.
 * 
 * @params: Pessoa, List<Anuncios>, Pagamento, Envio;
 *
 */
public class Venda {	
	
	// Atributos
	
	private Integer id;
	private Pessoa pessoa;
	private List<Anuncio> anuncio;
	private TipoDeEnvio envio;
	private boolean vendaConfirmada;
	private Financeiro financeiro;
	
	// Construtor
	
	public Venda(Integer id, 
			Pessoa pessoa, 
			List<Anuncio> anuncio, 
			TipoDeEnvio envio,
			Financeiro financeiro) {
		
		this.id = id;
		this.pessoa = pessoa;
		this.anuncio = anuncio;
		this.envio = envio;
		this.financeiro = financeiro;
	}
	
	public Venda() {
		// Construtor VAZIO
	}
	
	
	/*
	 * GETTERS e SETTERS
	 */
	
	public Integer getId() {
		return id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public List<Anuncio> getAnuncio() {
		return anuncio;
	}

	public Pagamento getTipoDePagamento() {
		return financeiro.getFormaPagamento();
	}

	public TipoDeEnvio getEnvio() {
		return envio;
	}
	
	public Financeiro getFinanceiro() {
		return financeiro;
	}

	public boolean isVendaConfirmada() {
		return vendaConfirmada;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public void setAnuncio(List<Anuncio> anuncio) {
		this.anuncio = anuncio;
	}

	public void setTipoDePagamento(Pagamento tipoDePagamento) {
		this.financeiro.setFormaPagamento(tipoDePagamento);
	}

	public void setEnvio(TipoDeEnvio envio) {
		this.envio = envio;
	}

	public void setFinanceiro(Financeiro financeiro) {
		this.financeiro = financeiro;
	}
	
	private void setVendaConfirmada(boolean vendaConfirmada) {
		this.vendaConfirmada = vendaConfirmada;
	}
	
	// MÉTODOS
	
	/**
	 * Retorna o ID do objeto da class 'Financeiro' correspondente.
	 * @return Integer: ID do Financeiro correspondente.
	 */
	public Integer getFinanceiroID() {
		return financeiro.getId();
	}
	
	/**
	 * Transfere a pontuacao gerada, para as pessoas envolvidas: comprador e vendedor(es) dos anúncios vinculados a venda.
	 * @param confirmacaoVenda
	 * @param beneficio
	 * @param comprador
	 * @param listaDeAnuncios
	 */
	private void transferirBeneficios(
			boolean confirmacaoVenda,
			Double beneficio,
			Pessoa comprador, 
			List<Anuncio> listaDeAnuncios) {
		
		Integer operador = confirmacaoVenda ? 1 : -1;
		
		comprador.setConfiabilidade(
				comprador.getConfiabilidade() + operador * beneficio
				);
		
		for (Anuncio anuncio : listaDeAnuncios) {
			anuncio.getPessoa().setConfiabilidade(
					anuncio.getPessoa().getConfiabilidade() + operador * beneficio
					);
		}
	}
	
	/**
	 * Usado para executar a confirmação final da venda;
	 * @param confirmacao (boolean)
	 */
	public void confirmarVenda(boolean confirmacao) {
		
		if (confirmacao) {
			setVendaConfirmada(true);
		} else {
			setVendaConfirmada(false);
		}
		
		this.transferirBeneficios(
				confirmacao, 
				this.getFinanceiro().getBeneficio(), 
				this.getPessoa(), 
				this.getAnuncio()
				);
	}

	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		builder.append("Venda [ id = ");
		builder.append(id);
		builder.append(",\n pessoa = ");
		builder.append(pessoa);
		builder.append(",\n anuncio = ");
		builder.append(anuncio);
		builder.append(",\n envio = ");
		builder.append(envio);
		builder.append(",\n vendaConfirmada = ");
		builder.append(vendaConfirmada);
		builder.append(",\n Finaceiro ID = ");
		builder.append(getFinanceiroID());
		builder.append(" ]");
		return builder.toString();
	}
	
	
	
}
