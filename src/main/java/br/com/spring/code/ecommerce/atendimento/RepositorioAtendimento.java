package br.com.spring.code.ecommerce.atendimento;

import java.util.ArrayList;
import java.util.List;

public class RepositorioAtendimento {
	 //Atributos
	public static List<Atendimento> listaAtendimentos=new ArrayList<Atendimento>();
	
	
	
	

	
	
	public static void mostrarAtendimento() {
	
		for(Atendimento atendimento: listaAtendimentos) {
	
			System.out.println(atendimento.getId());
		}
	}
	
	public static Atendimento buscarPorId(Integer idProcurado) {
		if (idProcurado != 0 && !listaAtendimentos.isEmpty()) {
			//Cria um objeto vazio
			Atendimento procurado = null;
			// Percorre a lista
			for (int i = 0; i < listaAtendimentos.size(); i++) {
				
				//Se o id procurado for igual ao da lista				
				if (listaAtendimentos.get(i).getId().equals(idProcurado)) {
					//O objeto criado passa a receber o id encontrado
					procurado = listaAtendimentos.get(i);			
				}
									
			}
			return procurado;
		}
		System.out.println("Atendimento não encontrado");
		return null;	
	}
	
	public Atendimento buscarPorIdUsuario(Integer idProcurado) {
		if (idProcurado != 0 && !listaAtendimentos.isEmpty()) {
			
			Atendimento procurado = null;
			
			for (int i = 0; i <= listaAtendimentos.size(); i++) {
							
				if (listaAtendimentos.get(i).getIdUsuario().equals(idProcurado)) {
					procurado = listaAtendimentos.get(i);		
				}
									
			}
			return procurado;
		}
		return null;	
	}
	
	public Atendimento buscarPorIdVenda(Integer idProcurado) {
		if (idProcurado != 0 && !listaAtendimentos.isEmpty()) {
			
			Atendimento procurado = null;
			
			for (int i = 0; i <= listaAtendimentos.size(); i++) {
												
				if (listaAtendimentos.get(i).getIdVenda().equals(idProcurado)) {
					procurado = listaAtendimentos.get(i);
				}					
			}
			return procurado;
		}
		return null;	
	}
	
	public List<Atendimento> buscarPorTipoAtendimento(TipoAtendimento tipo) {
		if (!listaAtendimentos.isEmpty()) {
			List<Atendimento> listaProcurada = new ArrayList<Atendimento>();
			for (Atendimento a: listaAtendimentos) {
				if (a.getTipoAtendimento().equals(tipo)) {
					listaProcurada.add(a);
					
				}
				
			}
			return listaProcurada;
		}
		return null;	
	}
	
	
	public static void adicionar(Atendimento atendimento) {
		
			listaAtendimentos.add(atendimento);
			System.out.println("Atendimento salvo com sucesso!");
			System.out.println("Detalhes: ");
			System.out.println(atendimento);
	}
	

	

}