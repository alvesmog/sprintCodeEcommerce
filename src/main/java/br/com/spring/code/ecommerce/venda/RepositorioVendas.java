package br.com.spring.code.ecommerce.venda;

import java.util.*;

import br.com.spring.code.ecommerce.gestaopessoas.Pessoa;

public interface RepositorioVendas {

	void registrarVenda(Venda venda);
	List<Venda> listarVendas();
	Venda procurarVendaPorData(Date data);
	
	public List<Venda> procurarVendasPorComprador(Pessoa Comprador);
	public List<Venda> procurarVendasPorVendedor(Pessoa Vendedor);
	public Venda procurarVendaPorId(Integer id);
}
