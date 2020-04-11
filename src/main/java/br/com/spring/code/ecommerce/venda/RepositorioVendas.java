package br.com.spring.code.ecommerce.venda;

import java.util.*;

public interface RepositorioVendas {

	void registrarVenda(Venda venda);
	List<Venda> listarvendas();
	Venda procurarVenda(Date data);
	
}
