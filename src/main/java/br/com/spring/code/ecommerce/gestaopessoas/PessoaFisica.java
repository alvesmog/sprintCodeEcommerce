package br.com.spring.code.ecommerce.gestaopessoas;

public class PessoaFisica extends TipoPessoa {
	
	private String cpf;
	
	public PessoaFisica(String cpf) {
		this.cpf = cpf;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return "PessoaFisica [Cpf()=" + getCpf() + "]";
	}
	
	

}
