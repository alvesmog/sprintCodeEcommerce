package br.com.spring.code.ecommerce.vendas;

import java.util.*;

public interface RepositorioVendas {

	void registrarVenda(Vendas vendas);
	List<Vendas> listarvendas();
	Vendas procurarVenda(Date data);
	
}
