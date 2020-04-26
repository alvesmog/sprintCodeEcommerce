package br.com.spring.code.ecommerce.menuInterface;

import java.util.List;
import java.util.Scanner;

import br.com.spring.code.ecommerce.anuncio.Anuncio;
import br.com.spring.code.ecommerce.anuncio.ListaRepositorioAnuncio;
import br.com.spring.code.ecommerce.anuncio.RepositorioAnuncio;
import br.com.spring.code.ecommerce.financeiro.RepositorioFinanceiro;
import br.com.spring.code.ecommerce.gestaopessoas.RepositorioPessoas;
import br.com.spring.code.ecommerce.venda.RepositorioVendas;

public class InterfaceSubMenuVenda {

	public int mostrarSubMenuVendas() {
		Scanner leia = new Scanner(System.in);

		System.out.println("\n\n##################################################");
		System.out.println("******** e-COMMERCE DE PRODUTOS PARA BEBÊ ********\n");
		System.out.println(" ===== VENDAS:  \"VAMOS FECHAR UMA COMPRA?\" =====\n");	
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

		Integer opcao = leia.nextInt();
		return opcao;
	}

	public Integer ingressaOpcoesParaVenda(
			Integer opcaoEscolhida, 
			ListaRepositorioAnuncio repositorioAnuncio, 
			RepositorioPessoas repositorioPessoas,
			RepositorioVendas repositorioVendas, 
			RepositorioFinanceiro repositorioFinanceiro
			) throws InterruptedException {

		Scanner input = new Scanner(System.in);

		switch (opcaoEscolhida) {

		case 1 : // 1. OLHAR O CATÁLOGO
			System.out.println("\n===== Exibindo catálogo ... =====\n");
			repositorioAnuncio.exibirTodosAnunciosNoConsole();
			break;

		case 2 : // 2. PROCURAR ANÚNCIOS POR ID
			System.out.println("\n===== Procurar anúncio POR ID ... =====\n");
			System.out.println("Digite o ID do ANÚNCIO específico, caso você saiba: ");
			int idAnuncio = input.nextInt();

			Anuncio procurado = repositorioAnuncio.procurarAnuncioPorId(idAnuncio);
			if (procurado != null) {

				System.out.println(
						"\n > Com o ID `" + idAnuncio
						+ "` foi encontrado este resultado: \n\n"
						+ procurado.mostrarInfo()
						);

			} else {
				System.out.println(
						"\n > Com o ID `" + idAnuncio
						+ "` NÃO foi encontrado nenhum anúncio válido. "
						+ "Desculpe. :( \n"
						);

			}
			break;

		case 3 : // 3. PROCURAR ANÚNCIOS POR VENDEDOR
			
			System.out.println("\n===== Procurar anúncio POR ID do VENDEDOR ... =====\n");
			System.out.println("Digite o ID do VENDEDOR específico, caso você saiba: ");
			int idVendedor = input.nextInt();

			List<Anuncio> procuradoPorVendedor = repositorioAnuncio.procurarAnuncioPorVendedor(idVendedor);
			if (procuradoPorVendedor.size() > 0) {

				System.out.println(
						"\n > Com o ID `" + idVendedor
						+ "` foi encontrado este resultado: \n\n");
				for (Anuncio anuncio : procuradoPorVendedor) {
					System.out.println(anuncio.mostrarInfo());
				}

			} else {
				System.out.println(
						"\n > Com um ID de Vendedor `" + idVendedor
						+ "` NÃO foi encontrado nenhum anúncio válido. "
						+ "Desculpe. :( \n"
						);
			}
			break;

		case 4 : // 4. PROCURAR ANÚNCIOS POR PRODUTO
			System.out.println("\n===== Procurar anúncio POR ID do PRODUTO ... =====\n");
			System.out.println("Digite o ID do PRODUTO específico, caso você saiba: ");
			int idProduto = input.nextInt();

			List<Anuncio> produtosPorProduto = repositorioAnuncio.procurarAnuncioPorProduto(idProduto);
			if (produtosPorProduto.size() > 0) {

				System.out.println(
						"\n > Com o ID `" + idProduto
						+ "` foi encontrado este resultado: \n\n");
				for (Anuncio anuncio : produtosPorProduto) {
					System.out.println(anuncio.mostrarInfo());
				}

			} else {
				System.out.println(
						"\n > Com um ID de Produto `" + idProduto
						+ "` NÃO foi encontrado nenhum anúncio válido. "
						+ "Desculpe. :( \n"
						);
			}
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
		opcaoEscolhida = 0;
		Thread.sleep(2000);
		break;

		case 0: System.out.println("\\n===== Saindo do Sistema... =====\\n");
		Thread.sleep(2000);
		System.exit(0);
		break;

		default: System.out.println("Opção inválida! \nTente outra ...");;
		}

		return opcaoEscolhida;
	}
}

