package br.com.spring.code.ecommerce.gestaopessoas;

public class PessoaFisica extends Pessoa {
	
	private String cpf;	
	
	// [fix] source: https://github.com/alvesmog/sprintCodeEcommerce/commit/4aa4cde652ed03a8c2f3b81b59eed7154715f05e
	public PessoaFisica() {
		super();
	}
	public PessoaFisica(String nome, String telefone, String email, Endereco endereco, Usuario usuario, String cpf) {
		super(nome, telefone, email, endereco, usuario);
 		this.cpf = cpf;
 	}	

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
