package br.com.spring.code.ecommerce.venda;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.spring.code.ecommerce.gestaopessoas.Pessoa;

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
	 * @descrição Percorre a lista em busca da composição de uma lista de vendas (histórico de vendas) de um mesmo usuário (comprador)
	 * @param comprador
	 * @return {@code List<Venda>}, como um histórico de vendas de um comprador.
	 */
	public List<Venda> procurarVendasPorComprador(Pessoa comprador) {//, RepositorioPessoas repositorioPessoas) {
		
		if (comprador == null) return null;
//		if (repositorioPessoas.verificarPermissao(
//				comprador.getUsuario().getLogin(), 
//				comprador.getUsuario().getSenha()
//			) != 2) return null;
		
		List<Venda> listaDeVendas = new ArrayList<Venda>();
		
		for (Venda venda : listaDeVendas) {
			if (venda.getPessoa().equals(comprador)) {
				listaDeVendas.add(venda);
			}
		}
		
		return listaDeVendas.size() > 0 ? listaDeVendas : null;
	}

}
