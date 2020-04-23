package br.com.spring.code.ecommerce.gestaopessoas;

import br.com.spring.code.ecommerce.gestaopessoas.WebServiceCep;

/* [UPDATE] 20/04/2020
 * Autor: Henrique
 * 1. REMOÇÃO DO ATRIBUTO "caixaPostal";
 * 2. INCLUSÃO DE NOVOS CONTRUTORES COM BUSCA AUTOMATICA DO CEP VIA WEBSERVICE DOS CORREIOS;
 * 3. INCLUSÃO DA FUNÇÃO TOSTRING();
 * 
 * [PENDENCIAS]
 * 1. VALIDAÇÃO DO TAMANHO E FORMATO DO CEP
 * 2. VALIDAÇÃO DA INEXISTÊNCIA DO CEP (OS CAMPOS RECEBEM VALOR VAZIO PARA SEREM TRATADOS)  
 */

public class Endereco {
	
	// [fix] Realizada remoção do atributo "caixaPostal" 
	private Integer id;
	private String logradouro;
	private String numero;
	private String bairro;
	private String cidade;
	private String uf;
	private String ref;
	private String cep;
	private String pais;
	private boolean cepValido;

	public Endereco(String cep) {
		this.cep = cep;
		WebServiceCep webServiceCep = WebServiceCep.searchCep(cep);
		if (webServiceCep.wasSuccessful()) {
			this.logradouro = webServiceCep.getLogradouro();
			this.bairro = webServiceCep.getBairro();
			this.cidade = webServiceCep.getCidade();
			this.uf = webServiceCep.getUf();
			this.cepValido = webServiceCep.wasSuccessful();
		}else {
			this.logradouro = ""; 
			this.bairro = "";
			this.cidade = "";
			this.uf = "";
			this.cepValido = webServiceCep.wasSuccessful();
		}
	}
	
	public Endereco(String cep, String numero, String ref, String pais) {		
		this.cep = cep;
		WebServiceCep webServiceCep = WebServiceCep.searchCep(cep);
		if (webServiceCep.wasSuccessful()) {
			this.logradouro = webServiceCep.getLogradouro();
			this.bairro = webServiceCep.getBairro();
			this.cidade = webServiceCep.getCidade();
			this.uf = webServiceCep.getUf();
			this.cepValido = webServiceCep.wasSuccessful();
		}else {
			this.logradouro = ""; 
			this.bairro = "";
			this.cidade = "";
			this.uf = "";
			this.cepValido = webServiceCep.wasSuccessful();
		}
		this.numero = numero;
		this.pais = pais;
		this.ref = ref;
	}
	
	public Endereco(String logradouro, String numero, String bairro, String cidade, String uf, String ref, String cep, String pais) {
		WebServiceCep webServiceCep = WebServiceCep.searchCep(cep);
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.ref = ref;
		this.cep = cep;
		this.pais = pais;
		this.cepValido = webServiceCep.wasSuccessful();
	}
	
	//FUNÇÃO DE BUSCA POR CEP RETORNANDO OBJETO ENDERECO
	
	public Endereco BuscaCep(String cep) {
		Endereco endereco = new Endereco(cep);
		WebServiceCep webServiceCep = WebServiceCep.searchCep(cep);
		if (webServiceCep.wasSuccessful()) {
			endereco.logradouro = webServiceCep.getLogradouro();
			endereco.bairro = webServiceCep.getBairro();
			endereco.cidade = webServiceCep.getCidade();
			endereco.uf = webServiceCep.getUf();	
			endereco.cep = cep;
			endereco.numero = "";
			endereco.ref = "";
			endereco.pais = "";
		}else {
			return null;
		}
		return endereco;
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

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
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

	public boolean isCepValido() {
		return cepValido;
	}

	public void setCepValido(boolean cepValido) {
		this.cepValido = cepValido;
	}

	@Override
	public String toString() {
		return "Endereco [getId()=" + getId() + ", getLogradouro()=" + getLogradouro() + ", getNumero()=" + getNumero()
				+ ", getBairro()=" + getBairro() + ", getCidade()=" + getCidade() + ", getUf()=" + getUf()
				+ ", getRef()=" + getRef() + ", getCep()=" + getCep() + ", getPais()=" + getPais() + ", isCepValido()="
				+ isCepValido() + "]";
	}
	
}