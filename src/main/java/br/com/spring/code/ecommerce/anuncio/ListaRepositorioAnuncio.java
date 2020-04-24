package br.com.spring.code.ecommerce.anuncio;

import java.util.ArrayList;
import java.util.List;

import br.com.spring.code.ecommerce.gestaopessoas.Pessoa;
import br.com.spring.code.ecommerce.gestaoprodutos.Produto;

public class ListaRepositorioAnuncio implements RepositorioAnuncio{

	List<Anuncio> anuncios;
	
	public ListaRepositorioAnuncio() {
		anuncios = new ArrayList<Anuncio>();
	}
	
	public void criarAnuncio(Anuncio anuncio) {
		anuncios.add(anuncio);
	}
	
	public List<Anuncio> listarAnuncios() {	
		return this.anuncios;
	}
	
	public void exibirTodosAnunciosNoConsole() {
		for (Anuncio anuncio : anuncios) {
			System.out.println(anuncio.toString());
		}
	}
	
	public Anuncio procurarAnuncioPorId(Integer id) {
				
		for (Anuncio anuncio : anuncios) {
			if (anuncio.getIdAnuncio() == id) return anuncio;
		}
		
		return null;
	}
	
	public List<Anuncio> procurarAnuncioPorVendedor(Pessoa pessoa) {
		
		List<Anuncio> anunciosDesseVendedor = new ArrayList<Anuncio>();
		
		for (Anuncio anuncio : anuncios) {
			if (anuncio.getPessoa().equals(pessoa)) {
				anunciosDesseVendedor.add(anuncio);
			}
		}
		
		return anunciosDesseVendedor;
	}
	
public List<Anuncio> procurarAnuncioPorVendedor(Produto produtoProcurado) {
		
		List<Anuncio> anunciosDesseVendedor = new ArrayList<Anuncio>();
		
		for (Anuncio anuncio : anuncios) {
			if (anuncio.getProduto().equals(produtoProcurado)) {
				anunciosDesseVendedor.add(anuncio);
			}
		}
		
		return anunciosDesseVendedor;
	}
	
	/**
	 * Método para remover anúncio a partir do ID
	 * 
	 * @return boolean {@code true} se o anuncio for removido.
	 */
	public boolean removerAnuncio(Integer Id) {
		
		for (Anuncio anuncio : anuncios) {
			if (anuncio.getIdAnuncio() == Id) {
				return this.anuncios.remove(anuncio);
			}
		}
		
		return false;
	}

		
	 
	
}
