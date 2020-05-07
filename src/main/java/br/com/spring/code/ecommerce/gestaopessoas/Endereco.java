package br.com.spring.code.ecommerce.gestaopessoas;

import javax.json.JsonObject;

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

	public Endereco(String cep) throws CepException {
		JsonObject enderecoJSON = WebServiceCep.buscarCep(cep);
		this.logradouro = enderecoJSON.get("logradouro").toString();
		this.bairro = enderecoJSON.get("bairro").toString();
		this.cidade = enderecoJSON.get("localidade").toString();
		this.uf = enderecoJSON.get("uf").toString();
	}

	public Endereco(String cep, String numero, String ref, String pais) throws CepException {
		JsonObject enderecoJSON = WebServiceCep.buscarCep(cep);
		this.logradouro = enderecoJSON.get("logradouro").toString();
		this.bairro = enderecoJSON.get("bairro").toString();
		this.cidade = enderecoJSON.get("localidade").toString();
		this.uf = enderecoJSON.get("uf").toString();
		this.numero = numero;
		this.ref = ref;
		this.cep = cep;
		this.pais = pais;
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