package br.com.spring.code.ecommerce.financeiro;

public class Pagamento {
	private int Id;
	private String formaPagamento;
	
	public Pagamento(int id, String formaPagamento) {
		super();
		Id = id;
		this.formaPagamento = formaPagamento;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	
	
}
