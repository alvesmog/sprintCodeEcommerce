package br.com.spring.code.ecommerce.atendimento;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

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
	private ArrayList<MensagensAtendimento> mensagensAtendimento= new ArrayList();
	
	

	public Atendimento(Integer id, Pessoa pessoa, String assunto, int idVenda, 
			TipoAtendimento tipoAtendimento, String mensagem) {	
		this.id = id;
		this.idUsuario = pessoa.getId();;
		this.assunto = assunto;
		this.idVenda = idVenda;
		this.email = pessoa.getEmail();
		this.tipoAtendimento = tipoAtendimento;
		this.status = StatusAtendimento.novo;
		Random random = new Random();
		Integer idMensagem = random.nextInt(1000);
		MensagensAtendimento mensagemObjeto = new MensagensAtendimento(id, idMensagem, EmissorMensagem.cliente, mensagem);
		this.mensagensAtendimento.add(mensagemObjeto);
		
	
		
		
	}
	
public void adicionaMensagem(MensagensAtendimento mensagem) {
	System.out.println(mensagem);
	mensagensAtendimento.add(mensagem);
	
}
	
		
	public Atendimento(Integer id, Pessoa pessoa, String assunto, 
			TipoAtendimento tipoAtendimento,  String mensagem) {	
		this.id = id;
		this.idUsuario = pessoa.getId();;
		this.assunto = assunto;
		this.email = pessoa.getEmail();
		this.tipoAtendimento = tipoAtendimento;
		this.status = StatusAtendimento.novo;
		Random random = new Random();
		Integer idMensagem = random.nextInt(1000);
		MensagensAtendimento mensagemObjeto = new MensagensAtendimento(id, idMensagem, EmissorMensagem.cliente, mensagem);
		this.mensagensAtendimento.add(mensagemObjeto);
	}
	
	
	public void atendenteResponde(Integer idAtendimento,String mensagem) {
		Random random = new Random();
		int idMensagem = random.nextInt(1000);
		MensagensAtendimento mensagemAtendimento= new MensagensAtendimento(idAtendimento, idMensagem, EmissorMensagem.atendente, mensagem);
		mensagensAtendimento.add(mensagemAtendimento);
		
		if(RepositorioAtendimento.buscarPorId(idAtendimento)!=null) {
			Atendimento atendimento = RepositorioAtendimento.buscarPorId(idAtendimento);
			if (atendimento.status==StatusAtendimento.novo) {
				atendimento.setStatus(StatusAtendimento.atendimento);
			}
		}else {
			System.out.println("Atendimento não encontrado");
		}
	
	}
	
	public void clienteResponde(Integer idAtendimento,String mensagem) {
		Random random = new Random();
		int idMensagem = random.nextInt(1000);
		MensagensAtendimento mensagemAtendimento= new MensagensAtendimento(idAtendimento, idMensagem, EmissorMensagem.cliente, mensagem);
		mensagensAtendimento.add(mensagemAtendimento);
	
	}
	
	public void fecharAtendimento(Integer idAtendimento) {
		if(RepositorioAtendimento.buscarPorId(idAtendimento)!=null) {
			Atendimento atendimento = RepositorioAtendimento.buscarPorId(idAtendimento);
			atendimento.setStatus(StatusAtendimento.fechado);
			System.out.println("O atendimento foi fechado. Esperamos ter solucionado sua questão.");
		}else {
			System.out.println("Atendimento não encontrado");
		}
		
	}
	
	public void mostrarMensagens(Integer idAtendimento) {
		Atendimento atendimento= RepositorioAtendimento.buscarPorId(idAtendimento);
		List<MensagensAtendimento> mensagem = atendimento.getMensagensAtendimento();
		for (MensagensAtendimento  mensagens: mensagem) {
			System.out.println(mensagens);
		}
	}
	
	public List<MensagensAtendimento> getMensagensAtendimento() {
		return mensagensAtendimento;
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

	@Override
	public String toString() {
		return "\n [Id=" + id + ", \nAssunto=" + assunto + ", \nid Venda=" + idVenda + ", \nEmail=" + email
				+ ", \nTipo de atendimento=" + tipoAtendimento + ", \nStatus=" + status + ", \nMensagens="
				+ mensagensAtendimento + "]";
	}
	
	
}
