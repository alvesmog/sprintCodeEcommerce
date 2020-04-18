package br.com.spring.code.ecommerce.gestaopessoas;

public class PessoaJuridica extends TipoPessoa {
	
	private String cnpj;
	
	public PessoaJuridica(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCpf(String cnpj) {
		this.cnpj = cnpj;
	}	

}
