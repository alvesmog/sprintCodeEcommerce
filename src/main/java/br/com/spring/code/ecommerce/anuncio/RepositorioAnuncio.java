package br.com.spring.code.ecommerce.anuncio;

import java.util.List;

public interface RepositorioAnuncio {

	void criarAnuncio(Anuncio anuncio);
	List<Anuncio> listarAnuncios();
	void exibirTodosAnunciosNoConsole();
	Anuncio procurarAnuncioPorId(Integer id);
	List<Anuncio> procurarAnuncioPorVendedor(Integer pessoaId);
	List<Anuncio> procurarAnuncioPorProduto(Integer produtoId);
	boolean removerAnuncio(Integer Id);	
}
