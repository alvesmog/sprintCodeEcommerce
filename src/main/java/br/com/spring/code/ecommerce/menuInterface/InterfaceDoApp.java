package br.com.spring.code.ecommerce.menuInterface;

import java.util.Scanner;

import br.com.spring.code.ecommerce.gestaopessoas.RepositorioPessoas;
import br.com.spring.code.ecommerce.gestaoprodutos.RepositorioCategorias;
import br.com.spring.code.ecommerce.gestaoprodutos.RepositorioProdutos;

public class InterfaceDoApp {

	public static void mostrarMenuOpcoes(RepositorioPessoas pessoas, RepositorioProdutos produtos,
			RepositorioCategorias categorias, Scanner leia) throws InterruptedException {

		

		/**
		 * =================================== 
		 * FAZ A CHAMADA DO MENU DE OPÇÕES
		 * ===================================
		 */

		InterfaceSubMenuProdutos menuProdutos = new InterfaceSubMenuProdutos();

		do {

			System.out.println("##################################################");
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
			
			int op = leia.nextInt();
			switch (op) {
			case 1:

//				InterfaceSubMenuPessoas.mostrarSubMenuPessoas();
				InterfaceSubMenuPessoas.ingressaOpcoesGestaoPessoa(pessoas, produtos, categorias, leia);

				break;
			case 2: // chamar a classe/metodo do submenu de gestão de produtos
				Integer opcao;
				do {
					opcao = menuProdutos.mostrarSubMenuProdutos();
					opcao = menuProdutos.ingressaOpcoesGestaoProdutos(opcao, produtos, categorias);
				} while (!opcao.equals(0));
			case 3: // chamar a classe/metodo do submenu de gestão de anuncio
				break;
			case 4: // chamar a classe/metodo do submenu de gestão de vendas
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

		} while (leia.nextInt() != 0);

	}


}
