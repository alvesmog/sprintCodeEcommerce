package br.com.spring.code.ecommerce.gestaopessoas;

public abstract class Pessoa {

	private Integer id;
	private String nome;
	private String telefone;
	private String email;
	private double confiabilidade;
	private Usuario usuario;
	private Endereco endereco;
	private Integer pontos;

	public Pessoa() {
		this.confiabilidade = 0;
		this.pontos = 0;
	}

	public Pessoa(String nome, String telefone, String email, Endereco endereco, Usuario usuario) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.confiabilidade = 0;
		this.endereco = endereco;
		this.usuario = usuario;
		this.pontos = 0;
	}

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public double getConfiabilidade() {
		return confiabilidade;
	}

	public void setConfiabilidade(double confiabilidade) {
		this.confiabilidade = confiabilidade;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Integer getPontos() {
		return pontos;
	}

	public void setPontos(Integer pontos) {
		this.pontos = pontos;
	}

	@Override
	public String toString() {
		return "[Id:" + getId() + ", Nome:" + getNome() + ", Telefone:" + getTelefone()
				+ ", Email:" + getEmail() + ", Confiabilidade:" + getConfiabilidade() + ", Endereco:"
				+ getEndereco() + ", Usuario:" + getUsuario() + ", Pontos:" + getPontos() + "]";
	}

}
