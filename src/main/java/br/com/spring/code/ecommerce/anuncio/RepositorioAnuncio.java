package br.com.spring.code.ecommerce.anuncio;

import java.util.List;

import br.com.spring.code.ecommerce.gestaopessoas.Pessoa;

public interface RepositorioAnuncio {

	void criarAnuncio(Anuncio anuncio);
	List<Anuncio> listarAnuncios();
	Anuncio procurarAnuncioPorId(Integer id);
	List<Anuncio> procurarAnuncioPorVendedor(Pessoa pessoa);
	boolean removerAnuncio(Integer Id);	
}
