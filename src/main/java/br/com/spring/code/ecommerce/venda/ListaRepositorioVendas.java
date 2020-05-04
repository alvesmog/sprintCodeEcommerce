package br.com.spring.code.ecommerce.venda;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author thiagojacinto, carloshenrique e wilson;
 * 
 * @Definição classe que implementa `RepositorioVendas` 
 * e representa uma forma de salvar os registros de venda realizadas.
 *
 */
public class ListaRepositorioVendas implements RepositorioVendas {
	
	// Atributos
	
	/**
	 * 	O repositório em lista simula o banco de dados onde serão 
	 * 	guardadas as informações de cada objeto Venda.
	 */
	List<Venda> repositorioDeVendas;
	
	
	// Construtor
	
	/**
	 * Construtor de um repositório de objetos `Venda` implementado em {@code ArrayList()};
	 */
	public ListaRepositorioVendas() {
		this.repositorioDeVendas = new ArrayList<Venda>();
	}
	
	// Métodos
	
	/**
	 * 	Salva a nova venda no repositório.
	 * <p>
	 * Usa o `.add()` da classe List
	 */
	public void registrarVenda(Venda venda) {
		
		repositorioDeVendas.add(venda);
	}
	
	/**
	 * 	Lista as vendas registradas no repositório.
	 */
	public List<Venda> listarVendas() {
		
		return this.repositorioDeVendas;
		
	}
	
	/**
	 * @descrição Percorre a lista e imprime os itens nela contidos.
	 * <p>
	 * Usa o `System.out.println()` para cada impressão.
	 */
	public void exibirTodasVendas() {
		
		for (Venda venda : repositorioDeVendas) {
			System.out.println(venda.toString());
		}
	}
	
	/**
	 * @descrição Percorre a lista em busca de vendas cuja data 
	 * seja IGUAL ao valor da data de entrada.
	 * 
	 */
	public Venda procurarVenda(Date dataProcurada) {
		
		for (Venda venda : repositorioDeVendas) {
			if (venda.getFinanceiro().getDataDoPagamento().equals(dataProcurada)) {
				return venda;
			}
		}
		
		return null;
	}

	/**
	 * @descrição Percorre a lista em busca de vendas cujo o id seja correspondente
	 * 
	 */
	
public Venda procurarVendaPorId(Integer id) {
		
		for (Venda venda : repositorioDeVendas) {
			if (venda.getFinanceiro().getId().equals(id)) {
				return venda;
			}
		}
		
		return null;
	}
}
