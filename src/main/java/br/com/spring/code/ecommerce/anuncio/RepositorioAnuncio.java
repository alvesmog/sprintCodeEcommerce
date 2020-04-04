package br.com.spring.code.ecommerce.anuncio;

import java.util.List;

import br.com.spring.code.ecommerce.gestaopessoas.Pessoa;

public interface RepositorioAnuncio {

	void CriarAnuncio(Anuncio anuncio);
	List<Anuncio> listarAnuncios();
	Anuncio procurarAnuncioPorId(Integer id);
	Anuncio procurarAnuncioPorVendedor(Pessoa pessoa);
	void removerAnuncio(Integer Id);	
}
