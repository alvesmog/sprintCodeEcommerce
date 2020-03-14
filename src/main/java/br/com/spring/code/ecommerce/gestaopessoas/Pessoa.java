package br.com.spring.code.ecommerce.gestaopessoas;

public class Pessoa {

	private Integer id;
	private String nome;
	private String telefone;
	private String email;
	private float confiabilidade;
	private TipoPessoa pessoa;
	private Usuario usuario;
	private Endereco endereco;
	private Integer pontos;

	public Pessoa() {

	}

	public Pessoa(Integer id, String nome, String telefone, String email, float confiabilidade, TipoPessoa pessoa, Endereco endereco, Usuario usuario, Integer pontos) {
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.confiabilidade = confiabilidade;
		this.pessoa = pessoa;
		this.endereco = endereco;
		this.usuario = usuario;
		this.pontos = pontos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

}
