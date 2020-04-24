package br.com.spring.code.ecommerce.menuInterface;

import java.util.Scanner;

import br.com.spring.code.ecommerce.anuncio.ListaRepositorioAnuncio;
import br.com.spring.code.ecommerce.anuncio.RepositorioAnuncio;
import br.com.spring.code.ecommerce.financeiro.RepositorioFinanceiro;
import br.com.spring.code.ecommerce.gestaopessoas.RepositorioPessoas;
import br.com.spring.code.ecommerce.venda.RepositorioVendas;

public class InterfaceSubMenuVenda {

	public int mostrarSubMenuVendas() {
		Scanner leia = new Scanner(System.in);
		int opcao = 0;

		System.out.println("##################################################");
		System.out.println("******** e-COMMERCE DE PRODUTOS PARA BEBÊ ********\n\n");
		System.out.println(" ===== VENDAS:  \"VAMOS FECHAR UMA COMPRA?\" =====\n\n");	
		System.out.println("1. OLHAR O CATÁLOGO ...");
		System.out.println("2. PROCURAR ANÚNCIOS POR ID");
		System.out.println("3. PROCURAR ANÚNCIOS POR VENDEDOR");
		System.out.println("4. PROCURAR ANÚNCIOS POR PRODUTO");
		System.out.println("5. COLOCAR NO CARRINHO DE COMPRAS");
		System.out.println("6. RETIRAR DO CARRINHO DE COMPRAS");
		System.out.println("7. REALIZAR CHECKOUT");
		System.out.println("8. VISUALIZAR PEDIDOS");
		System.out.println("9. VOLTAR AO MENU PRINCIPAL");
		System.out.println("0. ENCERRAR SISTEMA");

		System.out.println("\n Digita uma opção: ");
		opcao = leia.nextInt();

		return opcao;
	}

	public void ingressaOpcoesParaVenda(int op, 
			ListaRepositorioAnuncio repositorioAnuncio, 
			RepositorioPessoas repositorioPessoas,
			RepositorioVendas repositorioVendas, 
			RepositorioFinanceiro repositorioFinanceiro
			) throws InterruptedException {

		Scanner leia = new Scanner(System.in);

		switch (op) {
		case 1 : // 1. OLHAR O CATÁLOGO
			System.out.println("\n===== Exibindo catálogo ... =====\n");
			repositorioAnuncio.exibirTodosAnunciosNoConsole();

			break;

		case 2 : // 2. PROCURAR ANÚNCIOS POR ID
			System.out.println("\n===== Procurar anúncio POR ID ... =====\n");
			System.out.println("Digite o ID do ANÚNCIO específico, caso você saiba: ");
			int idAnuncio = leia.nextInt();
			repositorioAnuncio.procurarAnuncioPorId(idAnuncio);
			break;

		case 3 : // 3. PROCURAR ANÚNCIOS POR VENDEDOR

			break;

		case 4 : // 4. PROCURAR ANÚNCIOS POR PRODUTO

			break;
		case 5 : // 5. COLOCAR NO CARRINHO DE COMPRAS

			break;
		case 6 : // 6. RETIRAR DO CARRINHO DE COMPRAS

			break;

		case 7: // 7. REALIZAR CHECKOUT

			break;

		case 8: // 8. VISUALIZAR PEDIDOS

			break;

		case 9: System.out.println("\n===== Voltando ao Menu Principal ... =====\n");					
		Thread.sleep(2000);
		break;

		case 0: System.out.println("\\n===== Saindo do Sistema... =====\\n");
		Thread.sleep(2000);
		System.exit(0);
		break;
		
		default: System.out.println("Opção inválida! \nTente outra ...");;
		}
		
		leia.close();
	}
}

