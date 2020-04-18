package br.com.spring.code.ecommerce.gestaopessoas;

public class PessoaJuridica extends TipoPessoa {
	
	private String cnpj;
	
	// [fix] source: https://github.com/alvesmog/sprintCodeEcommerce/commit/4aa4cde652ed03a8c2f3b81b59eed7154715f05e
	public PessoaJuridica(String cnpj) {
 		this.cnpj = cnpj;
 	}

	public String getCnpj() {
		return cnpj;
	}
	
	// [fix] nome do método estava "setCpf()"
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}	
	
	// [fix] source: https://github.com/alvesmog/sprintCodeEcommerce/commit/4aa4cde652ed03a8c2f3b81b59eed7154715f05e
	@Override
 	public String toString() {
 		return "PessoaJuridica [CNPJ = " + getCnpj() + " ]";
 	}
}
