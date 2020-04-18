package br.com.spring.code.ecommerce.gestaopessoas;

public class PessoaFisica extends TipoPessoa {
	
	// [fix] source: https://github.com/alvesmog/sprintCodeEcommerce/commit/4aa4cde652ed03a8c2f3b81b59eed7154715f05e
	public PessoaFisica(String cpf) {
 		this.cpf = cpf;
 	}
	
	private String cpf;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}	
	
	// [fix] source: https://github.com/alvesmog/sprintCodeEcommerce/commit/4aa4cde652ed03a8c2f3b81b59eed7154715f05e
	@Override
 	public String toString() {
 		return "PessoaFisica [Cpf()=" + getCpf() + "]";
 	}
}
