package br.com.spring.code.ecommerce.duvidas;

/**
 * TODO
 * Importar pacote do produto
 */

import java.util.List;

public class Duvidas {
	private Integer  id;
	private Integer idProduto;
	private List<Interacoes> interacoes;
	
	
	
	/**
	 * TODO
	 * Construtor necessita do produto para pegar o ID do produto
	 
	public Duvidas(Integer id, Produto produto) {
	//	this.idProduto= produto.getId();
		this.id = id;
		
	}
	*/
	

	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}
	public List<Interacoes> getInteracoes() {
		return interacoes;
	}
	public void setInteracoes(List<Interacoes> interacoes) {
		this.interacoes = interacoes;
	}
	
	public Interacoes buscarInteracaoPorTexto(String busca) {
		Interacoes interacaoMatch=null;
		for(Interacoes interacao: interacoes) {
			if(interacao.getPergunta().toLowerCase().contains(busca.toLowerCase()) ||interacao.getResposta().toLowerCase().contains(busca.toLowerCase())) {
				interacaoMatch= interacao;
			}
			
		}
		return interacaoMatch;
		
	}
	
	public Interacoes buscarInteracaoPorId(Integer IdInteracao) {
		Interacoes interacaoMatch=null;
		for(Interacoes interacao: interacoes) {
			if(interacao.getId().equals(IdInteracao)) {
				interacaoMatch= interacao;
			}
			
		}
		return interacaoMatch;
		
	}
	
		
	public void desativarTodasInteracoes() {
		for(Interacoes interacao: interacoes) {
			interacao.inativar();
			}
	}
	
	
	

}
