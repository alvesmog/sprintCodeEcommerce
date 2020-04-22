package br.com.spring.code.ecommerce.gestaopessoas;

public class PessoaJuridica extends Pessoa {
	
	private String cnpj;
	private String razaoSocial;	
	
	// [fix] Atualizados os contrutores
	
	public PessoaJuridica() {
		super();		
	}
	public PessoaJuridica(String nome, String telefone, String email,Endereco endereco, Usuario usuario, String cnpj,String razaoSocial) {
		super(nome, telefone, email, endereco, usuario);
 		this.cnpj = cnpj;
 		this.razaoSocial = razaoSocial;
 	}

	public String getCnpj() {
		return cnpj;
	}
	
	// [fix] nome do metodo estava "setCpf()"
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}	
	
	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	@Override
	public String toString() {
		return "PessoaJuridica [getCnpj()=" + getCnpj() + ", getRazaoSocial()=" + getRazaoSocial() + "]";
	}

}