package br.com.spring.code.ecommerce.gestaopessoas;

public class Endereco {

	private Integer id;
	private String logradouro;
	private String numero;
	private String bairro;
	private String municipio;
	private String estado;
	private String ref;
	private String cep;
	private String pais;
	private String caixaPostal;

	public Endereco() {
		
	}

	public Endereco(Integer id, String logradouro, String numero, String bairro, String municipio, String estado, String ref,
			String cep, String pais, String caixaPostal) {
		this.id = id;
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.municipio = municipio;
		this.estado = estado;
		this.ref = ref;
		this.cep = cep;
		this.pais = pais;
		this.caixaPostal = caixaPostal;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCaixaPostal() {
		return caixaPostal;
	}

	public void setCaixaPostal(String caixaPostal) {
		this.caixaPostal = caixaPostal;
	}

}