package br.com.spring.code.ecommerce.duvidas;

import java.util.List;

public class RepositorioDuvidas {
	private static List<Duvidas> duvidas;
	
	public static void salvarDuvida(Duvidas duvidaNova) {
	duvidas.add(duvidaNova);
		
	}
	
	public static void removerDuvida(Duvidas duvidaNova) {
	duvidas.remove(duvidaNova);
		
	}
	
	public Duvidas buscarDuvidaporId(Integer idDuvida) {
		Duvidas duvidaEncontrada=null;
		for(Duvidas duvida: duvidas) {
			if (duvida.getId().equals(idDuvida)) {
				duvidaEncontrada=duvida;
				
				}
			}
		return duvidaEncontrada;
				
		
	}
	
	
	public Duvidas buscarDuvidaporIddoProduto(Integer idProduto) {
		Duvidas duvidaEncontrada=null;
		for(Duvidas duvida: duvidas) {
			if (duvida.getIdProduto().equals(idProduto)) {
				duvidaEncontrada=duvida;
				
				}
			}
		return duvidaEncontrada;
				
		
	}
	
}
