package br.com.spring.code.ecommerce.gestaoprodutos;

import java.util.ArrayList;
import java.util.List;

public class RepositorioCategorias {
	// Atributos
	List<Categoria> listaDeCategorias;

	// Construtor
	public RepositorioCategorias() {

		listaDeCategorias = new ArrayList<Categoria>();
	}

	// Métodos

	// Percorre e imprime os elementos
	public void exibirTodoscategorias() {
		for (int i = 0; i < listaDeCategorias.size(); i++) {
			System.out.println(listaDeCategorias.get(i));
		}
	}

	public Categoria procurarCategoria(Integer idProcurado) {

		if (idProcurado != null && !listaDeCategorias.isEmpty()) {

			Categoria categoriaProcurada = new Categoria();

			for (int i = 0; i < listaDeCategorias.size(); i++) {
				// Se `idProcurado` = id de cada elemento da lista:
				if (listaDeCategorias.get(i).getId().equals(idProcurado)) {
					categoriaProcurada = listaDeCategorias.get(i);
				}
			}
			return categoriaProcurada;
			
		}
		// ou retorne NULL
		return null;
	}
	
	public void adicionarCategoria(Categoria categoria) {
		listaDeCategorias.add(categoria);
		for (int i = 0; i < listaDeCategorias.size(); i++) {
			if (listaDeCategorias.get(i) == categoria) {
				listaDeCategorias.get(i).setId(i + 1);
			}
		}
	}

// Remover elementos pelo ID:
	public void removerCategoria(Integer idParaRemover) {

		Categoria procurada = procurarCategoria(idParaRemover);

		if (procurada != null) {

			listaDeCategorias.remove(procurada);
			System.out.println("categoria removido com sucesso.");
			return;
		}

		System.out.println("categoria com esse ID não encontrado.");

	}
}
