package br.com.spring.code.ecommerce.anuncio;

import java.util.ArrayList;
import java.util.List;

import br.com.spring.code.ecommerce.gestaopessoas.Pessoa;

public class ListaRepositorioAnuncio implements RepositorioAnuncio {

	static List<Anuncio> anuncios = new ArrayList<Anuncio>();

	public void CriarAnuncio(Anuncio anuncio) {

	}

	public List<Anuncio> listarAnuncios() {

		return this.anuncios;
	}

	public static void mostrarTodosAnuncios() {
		for (Anuncio anuncio : anuncios) {

			System.out.println(anuncio);

		}
	}

	public static void mostrarAnuncioPorUsuario(int idUsuario) {
		for (Anuncio anuncio : anuncios) {
			if (anuncio.getPessoa().getId() == idUsuario) {
				System.out.println(anuncio);

			}

		}
	}

	public Anuncio procurarAnuncioPorId(Integer id) {

		return null;
	}

	public Anuncio procurarAnuncioPorVendedor(Pessoa pessoa) {

		return null;
	}

	public static void adicionar(Anuncio anuncio) {
		anuncios.add(anuncio);
		System.out.println("Anúncio adicionado com sucesso!");
		System.out.println("Detalhes: ");
		System.out.println(anuncio);
	}

	public static void remover(Integer Id) {
Anuncio excluir = null;
		for (Anuncio anuncio : anuncios) {
			if (anuncio.getIdAnuncio() == Id) {
				excluir=anuncio;

			}

		}
		if(excluir!=null) {
			anuncios.remove(excluir);
		}else {
			System.out.println("Anúncio não encontrado para exclusão");
		}
	}
	
	public static Anuncio getById(Integer id) {
		Anuncio procurado = null;
				for (Anuncio anuncio : anuncios) {
					if (anuncio.getIdAnuncio() == id) {
						procurado=anuncio;

					}

				}
				if(procurado!=null) {
					return procurado;
				}else {
					System.out.println("Anúncio não encontrado");
					return null;
				}
			}

	public void removerAnuncio(Integer Id) {

		for (Anuncio anuncio : anuncios) {
			if (anuncio.getIdAnuncio() == Id) {
				anuncios.remove(anuncio);

			}

		}
	}

}
