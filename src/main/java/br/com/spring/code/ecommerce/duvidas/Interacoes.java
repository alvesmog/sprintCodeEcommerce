package br.com.spring.code.ecommerce.duvidas;

import br.com.spring.code.ecommerce.gestaopessoas.Pessoa;
import br.com.spring.code.ecommerce.gestaopessoas.RepositorioPessoas;
import br.com.spring.code.ecommerce.gestaopessoas.Usuario;

public class Interacoes {
	private Integer id;
	private String pergunta;
	private Integer idUsuarioPergunta;
	private StatusInteracoes status;
	private String resposta;
	
	
	public Interacoes(Integer id, String pergunta, Pessoa pessoa) {
		this.idUsuarioPergunta= pessoa.getId();
		this.id = id;
		this.pergunta = pergunta;
		this.status = StatusInteracoes.analise;
	}
	
	
	public void inativar() {
		this.status= StatusInteracoes.inativo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public Integer getIdUsuarioPergunta() {
		return idUsuarioPergunta;
	}

	public void setIdUsuarioPergunta(Integer idUsuarioPergunta) {
		this.idUsuarioPergunta = idUsuarioPergunta;
	}

	public StatusInteracoes getStatus() {
		return status;
	}

	public void setStatus(StatusInteracoes status) {
		this.status = status;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
		this.status= status.ativo;
	}
	
	@Override
	public String toString() {
		
		if(resposta!=null) {
			 return "Id: "+id+"\n"+"Usuário da pergunta: "+idUsuarioPergunta+"\n"+
						"Pergunta: "+pergunta+"\n"+"Resposta: "+resposta+"\n";
		}else {
			return "Id: "+id+"\n"+"Usuário da pergunta: "+idUsuarioPergunta+"\n"+
					"Pergunta: "+pergunta+"\n";
		}
	
	}
	
	
	
	
	

}
