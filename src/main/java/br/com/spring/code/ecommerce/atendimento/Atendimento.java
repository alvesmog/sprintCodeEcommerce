package br.com.spring.code.ecommerce.atendimento;

import br.com.spring.code.ecommerce.gestaopessoas.Pessoa;

import br.com.spring.code.ecommerce.venda.Venda;

public class Atendimento {
	private Integer id;
	private Integer idUsuario;
	private String assunto;
	private Integer idVenda;
	private String email;
	private TipoAtendimento tipoAtendimento;
	private StatusAtendimento status;	

	public Atendimento(Integer id, Pessoa pessoa, String assunto, Venda venda, 
			TipoAtendimento tipoAtendimento) {	
		this.id = id;
		this.idUsuario = pessoa.getId();;
		this.assunto = assunto;
		this.idVenda = venda.getId();
		this.email = pessoa.getEmail();
		this.tipoAtendimento = tipoAtendimento;
		this.status = StatusAtendimento.novo;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	public Integer getIdVenda() {
		return idVenda;
	}
	public void setIdVenda(Integer idVenda) {
		this.idVenda = idVenda;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public TipoAtendimento getTipoAtendimento() {
		return tipoAtendimento;
	}
	public void setTipoAtendimento(TipoAtendimento tipoAtendimento) {
		this.tipoAtendimento = tipoAtendimento;
	}
	public StatusAtendimento getStatus() {
		return status;
	}
	public void setStatus(StatusAtendimento status) {
		this.status = status;
	}
}
