package br.com.spring.code.ecommerce.venda;

import java.util.*;

public interface RepositorioVendas {

	void registrarVenda(Vendas vendas);
	List<Vendas> listarvendas();
	Vendas procurarVenda(Date data);
	
}
