package br.com.spring.code.ecommerce.financeiro;

import java.sql.Date;
import java.util.List;

import br.com.spring.code.ecommerce.anuncio.Anuncio;
import br.com.spring.code.ecommerce.venda.TipoDeEnvio;

public class Financeiro {

	private static final double TAXA_DE_COMISSAO = 0.03;
	private Integer id;
	private Pagamento formaPagamento;
	private double valorTotal;
	private double valorComissao;
	private double valorFrete;
	private Date dataDoPagamento;

	// Construtor

	public Financeiro(
			Integer id,
			Pagamento formaPagamento, 
			Date data) {
		
		this.id = id;
		this.formaPagamento = formaPagamento;
		this.dataDoPagamento = data;
	}

	public Financeiro() {
		// Construtor VAZIO
	}

	// GETTERS e SETTERS

	public Integer getId() {
		return id;
	}

	public Pagamento getFormaPagamento() {
		return formaPagamento;
	}

	public double getValorComissao() {
		return valorComissao;
	}

	public void setFormaPagamento(Pagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public double getValorTotal() {
		return valorTotal;
	}
	
	public double getValorFrete() {
		return valorFrete;
	}
	
	public Date getDataDoPagamento() {
		return dataDoPagamento;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	private void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	private void setValorComissao(double valorComissao) {
		this.valorComissao = valorComissao;
	}

	private void setValorFrete(double valorFrete) {
		this.valorFrete = valorFrete;
	}

	// MÉTODOS

	/**
	 * Calcular o valor total de todos os itens de uma lista de anuncios.
	 * @param List<Anuncio> -> Anucio.getValor()
	 */
	public void calcularValor(List<Anuncio> listaDeAnuncios) {

		double somaDeValores = 0;
		// Percorrer a lista de anuncios em busca do atributo `valor` de cada Anuncio:
		for (int i = 0; i < listaDeAnuncios.size(); i++) {
			somaDeValores += listaDeAnuncios.get(i).getValor();
		}

		// Ao final da lista, seta a atributo `ValorTotal` como soma dos valores.
		this.setValorTotal(somaDeValores);
		this.calcularComissao(somaDeValores);
	}

	/**
	 * Calcular o valor da comissão de acordo com o quantia de entrada;
	 */
	private void calcularComissao(double valor) {

		this.setValorComissao(valor * TAXA_DE_COMISSAO);
	}

	/**
	 * Calcular o valor total do frete a partir de uma lista de anuncios e o tipo de envio escolhido.
	 * @param listaDeAnuncios
	 * @param tipoDeEnvio
	 */
	public void calcularValorDoFrete(
			List<Anuncio> listaDeAnuncios, 
			TipoDeEnvio tipoDeEnvio) {

		double valorDoEnvio = 0;
		int quantidade = listaDeAnuncios.size();

		if (quantidade > 1) {	// Para quantidades de anuncios > 1

			for (int i = 0; i < listaDeAnuncios.size(); i++) {

				switch (tipoDeEnvio) {
				case PAC:
					valorDoEnvio = 10 + (5 * quantidade);
					break;

				case SEDEX:
					valorDoEnvio = 15.0 + (6 * quantidade);;
					break;

				case SEDEX_10:
					valorDoEnvio = 20.0 + (7 * quantidade);;
					break;
				}
			}
			
		} else {	// Para venda de apenas anuncio.

			// Simplificado: valor fixo a depender do tipo de envio
			switch (tipoDeEnvio) {
			case PAC:
				valorDoEnvio = 10.0;
				break;

			case SEDEX:
				valorDoEnvio = 15.0;
				break;

			case SEDEX_10:
				valorDoEnvio = 20.0;
				break;
			}
		}

		// Guarda o valor do envio no atributo `valorFrete`:
		this.setValorFrete(valorDoEnvio);
	}
	
	/**
	 * {@code toString()} customizado para objeto `Financeiro`
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Financeiro [ id = ");
		builder.append(id);
		builder.append(", formaPagamento = ");
		builder.append(formaPagamento);
		builder.append(", valorTotal = ");
		builder.append(valorTotal);
		builder.append(", valorComissao = ");
		builder.append(valorComissao);
		builder.append(", valorFrete = ");
		builder.append(valorFrete);
		builder.append(", dataDoPagamento = ");
		builder.append(dataDoPagamento);
		builder.append(" ]");
		return builder.toString();
	}
	
	

}
