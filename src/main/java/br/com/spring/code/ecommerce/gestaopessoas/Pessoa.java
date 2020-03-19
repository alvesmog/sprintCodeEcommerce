package br.com.spring.code.ecommerce.gestaopessoas;

import java.io.Serializable;

public class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private String telefone;
	private String email;
	private float confiabilidade;
	private String cpfOUCnpj;
	private Usuario usuario;
	private Endereco endereco;
	private Integer pontos;

	public Pessoa() {

	}

	public Pessoa(String nome, String telefone, String email, float confiabilidade, String cpfOUCnpj, Endereco endereco,
			Usuario usuario, Integer pontos) {
		this.id = usuario.getId();
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.confiabilidade = confiabilidade;
		this.cpfOUCnpj = cpfOUCnpj;
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

	public String getCpfOUCnpj() {
		return cpfOUCnpj;
	}

	public void setCpfOUCnpj(String cpfOUCnpj) {
		this.cpfOUCnpj = cpfOUCnpj;
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
