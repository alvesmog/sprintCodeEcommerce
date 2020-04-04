package br.com.spring.code.ecommerce.anuncio;

import java.util.ArrayList;
import java.util.List;

import br.com.spring.code.ecommerce.gestaopessoas.Pessoa;

public class ListaRepositorioAnuncio implements RepositorioAnuncio{

	List<Anuncio> anuncios;
	
	public ListaRepositorioAnuncio() {
		anuncios = new ArrayList<Anuncio>();
	}
	
	public void CriarAnuncio(Anuncio anuncio) {
		
	}
	
	public List<Anuncio> listarAnuncios() {	
		
		return this.anuncios;
	}
	
	public Anuncio procurarAnuncioPorId(Integer id) {
		
		return null;
	}
	
	public Anuncio procurarAnuncioPorVendedor(Pessoa pessoa) {
		
		
		return null;
	}
	
	public void removerAnuncio(Integer Id) {
		
	}

		
	 
	
}
