package br.com.spring.code.ecommerce.gestaopessoas;

public class Pessoa {
	
	private String nome;
	private String telefone;
	private String email;
	private float confiabilidade;
	private TipoPessoa pessoa;
	
	public Pessoa(String nome, String telefone, String email, float confiabilidade, TipoPessoa pessoa) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.confiabilidade = confiabilidade;
		this.pessoa = pessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public float getConfiabilidade() {
		return confiabilidade;
	}

	public void setConfiabilidade(float confiabilidade) {
		this.confiabilidade = confiabilidade;
	}

	public TipoPessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(TipoPessoa pessoa) {
		this.pessoa = pessoa;
	}	

}
