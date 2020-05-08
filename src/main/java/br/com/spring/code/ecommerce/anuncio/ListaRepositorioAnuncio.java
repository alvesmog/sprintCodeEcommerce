package br.com.spring.code.ecommerce.anuncio;

import java.util.ArrayList;
import java.util.List;

public class ListaRepositorioAnuncio implements RepositorioAnuncio{

	List<Anuncio> anuncios;
	Integer indiceUnico = 0;

	public ListaRepositorioAnuncio() {
		anuncios = new ArrayList<Anuncio>();
	}

	private Integer incrementaIndiceUnico(Integer indice) {
		this.indiceUnico++;
		return this.indiceUnico;
	}

	/**
	 * Adiciona um novo 'Anuncio' e gera um novo ID, auto incrementando
	 */
	public void criarAnuncio(Anuncio anuncio) {
		anuncio.setIdAnuncio(
				this.incrementaIndiceUnico(this.indiceUnico)
				);
		anuncios.add(anuncio);
	}

	public List<Anuncio> listarAnuncios() {	
		return this.anuncios;
	}

	/**
	 * Varre o repositório, e aplica o {@code System.out.println()}
	 * em cada elemento exibindo suas informações no console.
	 * 
	 * @return {@code System.out.println()}
	 */
	public void exibirTodosAnunciosNoConsole() {
		for (Anuncio anuncio : anuncios) {
			System.out.println(anuncio.mostrarInfo());
		}
	}

	public Anuncio procurarAnuncioPorId(Integer id) {

		for (Anuncio anuncio : anuncios) {
			if (id.equals(anuncio.getIdAnuncio())) return anuncio;
		}

		return null;
	}

	public List<Anuncio> procurarAnuncioPorVendedor(Integer vendedorId) {

		List<Anuncio> anunciosDesseVendedor = new ArrayList<Anuncio>();

		for (Anuncio anuncio : anuncios) {
			if (anuncio.getPessoa().getId().equals(vendedorId)) {
				anunciosDesseVendedor.add(anuncio);
			}
		}

		return anunciosDesseVendedor;
	}

	public List<Anuncio> procurarAnuncioPorProduto(Integer produtoId) {

		List<Anuncio> anunciosDesseVendedor = new ArrayList<Anuncio>();

		for (Anuncio anuncio : anuncios) {
			if (anuncio.getProduto().getId().equals(produtoId)) {
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
