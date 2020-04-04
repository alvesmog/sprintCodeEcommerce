package br.com.spring.code.ecommerce.financeiro;

public class Financeiro {
	private static final double COMISSAO = 0.03;
	private Pagamento formaPagamento;
	private double valorTotal;
	
	public Financeiro(Pagamento formaPagamento, double valorTotal) {
		super();
		this.formaPagamento = formaPagamento;
		this.valorTotal = valorTotal;
	}

	public Pagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(Pagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	public void cobrarComissao() {
		
	}
		
}
