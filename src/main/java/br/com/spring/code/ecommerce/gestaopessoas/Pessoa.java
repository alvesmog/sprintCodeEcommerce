package br.com.spring.code.ecommerce.gestaopessoas;

/* [UPDATE] 20/04/2020
 * Autor: Henrique
 * 1. POPULAÇÃO DO ATRIBUTO ID AO INSERIR O OBJETO NO REPOSITORIO
 * 2. POPULACÃO INICIAL DOS ATRIBUTOS CONFIABILIDADE E PONTOS COM 0 INICIALMENTE.
 * 3. VALIDAÇÃO DA FORMATAÇÃO DE ENDEREÇAMENTO DE E-MAIL (PODE SER CRIADA UMA FUNÇÃO NO REPOSITORIO ANTES DE SER INSERIDO OU NO MENU)
 * 4. CLASSE PESSOA DEFINIDA COMO ABSTRATA, FORÇANDO O INSTANCIAMENTO DE PESSOA COMO NOVA PESSOAFISICA OU PESSOAJURIDICA
 */

public abstract class Pessoa{
	
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

	public Pessoa(String nome, String telefone, String email,Endereco endereco, Usuario usuario) {
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
		return "TipoPessoa [getId()=" + getId() + ", getNome()=" + getNome() + ", getTelefone()=" + getTelefone()
				+ ", getEmail()=" + getEmail() + ", getConfiabilidade()=" + getConfiabilidade() + ", getEndereco()="
				+ getEndereco() + ", getUsuario()=" + getUsuario() + ", getPontos()=" + getPontos() + "]";
	}	

}
