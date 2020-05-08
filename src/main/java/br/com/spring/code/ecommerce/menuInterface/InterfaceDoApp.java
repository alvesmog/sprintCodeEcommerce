package br.com.spring.code.ecommerce.menuInterface;

import java.util.List;
import java.util.Scanner;

import br.com.spring.code.ecommerce.anuncio.Anuncio;
import br.com.spring.code.ecommerce.anuncio.RepositorioAnuncio;
import br.com.spring.code.ecommerce.financeiro.RepositorioFinanceiro;
import br.com.spring.code.ecommerce.gestaopessoas.RepositorioPessoas;
import br.com.spring.code.ecommerce.gestaoprodutos.RepositorioCategorias;
import br.com.spring.code.ecommerce.gestaoprodutos.RepositorioProdutos;
import br.com.spring.code.ecommerce.sessao.ControladorSessao;
import br.com.spring.code.ecommerce.venda.RepositorioVendas;

public class InterfaceDoApp {

	public static void mostrarMenuOpcoes(
			RepositorioPessoas pessoas, 
			RepositorioProdutos produtos,
			RepositorioCategorias categorias, 
			
			RepositorioAnuncio repositorioAnuncio,
			RepositorioFinanceiro repositorioFinanceiro,
			RepositorioVendas repositorioVendas,
			ControladorSessao controladorSessao,
			List<Anuncio> carrinhoDeCompras,
			
			Scanner leia) throws InterruptedException {

		/**
		 * =================================== 
		 * FAZ A CHAMADA DO MENU DE OPÇÕES
		 * ===================================
		 */
		int op;
		do {

			System.out.println("\n##################################################");
			System.out.println("******** e-COMMERCE DE PRODUTOS PARA BEBÊ ********\n");
			System.out.println(" ===== MENU DE OPÇÕES =====\n");
			System.out.println("1. GESTÃO DE PESSOAS");
			System.out.println("2. GESTÃO DE PRODUTOS");
			System.out.println("3. ANUNCIO");
			System.out.println("4. VENDAS");
			System.out.println("5. ATENDIMENTO");
			System.out.println("0. ENCERRAR SISTEMA");
			System.out.println("##################################################");

			System.out.println("\n");

			System.out.print("Acessar o Sistema. Digite a sua opção: ");

			op = leia.nextInt();
			switch (op) {
			case 1:

				InterfaceSubMenuPessoas.ingressaOpcoesGestaoPessoa(pessoas, produtos, categorias, leia);
				break;
				
			case 2: // chamar a classe/metodo do submenu de gestão de produtos

				InterfaceSubMenuProdutos.ingressaOpcoesGestaoProdutos(pessoas, produtos, categorias, leia);
				break;
				
			case 3: // chamar a classe/metodo do submenu de gestão de anuncio
				break;
			case 4: // chamar a classe/metodo do submenu de gestão de vendas
				InterfaceSubMenuVenda.ingressaOpcoesParaVenda(repositorioAnuncio, pessoas, repositorioVendas, repositorioFinanceiro, carrinhoDeCompras, controladorSessao, leia);
				break;
			case 5: // chamar a classe/metodo do submenu de gestão de atendimento
				break;

			case 0:
				System.out.println("Saindo do Sistema... ");
				Thread.sleep(3000);
				break;

			default:
				System.out.println("Opção Inválida");
			}

		} while (op != 0);

	}

}
