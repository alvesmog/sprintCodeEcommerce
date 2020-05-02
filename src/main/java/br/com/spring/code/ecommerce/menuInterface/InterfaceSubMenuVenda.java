package br.com.spring.code.ecommerce.menuInterface;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.spring.code.ecommerce.anuncio.Anuncio;
import br.com.spring.code.ecommerce.anuncio.ListaRepositorioAnuncio;
import br.com.spring.code.ecommerce.anuncio.RepositorioAnuncio;
import br.com.spring.code.ecommerce.financeiro.Financeiro;
import br.com.spring.code.ecommerce.financeiro.Pagamento;
import br.com.spring.code.ecommerce.financeiro.RepositorioFinanceiro;
import br.com.spring.code.ecommerce.gestaopessoas.RepositorioPessoas;
import br.com.spring.code.ecommerce.venda.RepositorioVendas;
import br.com.spring.code.ecommerce.venda.TipoDeEnvio;
import br.com.spring.code.ecommerce.venda.Venda;

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
			RepositorioFinanceiro repositorioFinanceiro,
			List<Anuncio> carrinhoDeCompras
			) throws InterruptedException {

		Scanner input = new Scanner(System.in);
		Integer inputCarrinho = null;

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
			System.out.println("\n===== Seu carrinho de compras =====\n");
			inputCarrinho = null;
			do {
				
				System.out.println("\nJá sabe qual anúncio tem interesse?\n"
						+ " > Se SIM, digite o ID do Anúncio;\n\n"
						+ " > Se NÃO souber, digite '0' para voltar ao menu anterior e procure o ID do Anuncio "
						+ "\nPOR VENDEDOR (Opção 3) ou POR PRODUTO (Opção 4).\n\n"
						+ " > Digite 999 quando terminar de adicionar os produtos ao carrinho.");
				inputCarrinho = input.nextInt();
				if (inputCarrinho.equals(0) || inputCarrinho.equals(999)) break;
				
				Anuncio anuncioEscolhido = repositorioAnuncio.procurarAnuncioPorId(inputCarrinho);
				if (anuncioEscolhido == null) {
					System.out.println(String.format("\nNão foi possível encontrar nenhum Anuncio com ID: `%d`.\nTente novamente ...", inputCarrinho));
					break;
				}
				carrinhoDeCompras.add(anuncioEscolhido);
				
				this.mostrarCalculosPreliminares(carrinhoDeCompras);
			
			} while (!inputCarrinho.equals(999));
			
			break;
			
		case 6 : // 6. RETIRAR DO CARRINHO DE COMPRAS
			
			System.out.println("\n===== Seu carrinho de compras =====\n");
			inputCarrinho = null;
			do {
				if (carrinhoDeCompras.size() == 0) {
					System.out.println("Ops... seu carrinho está vazio.");
					break;
				}
				
				System.out.println("\n - - Conteúdo do Carrinho de Compras - - \n"); 
				
				this.mostrarCarrinho(carrinhoDeCompras);
				
				System.out.println("\n > Para remover algum item, digite o ID do Anúncio correspondente;\n\n"
						+ " > Para voltar ao menu anterior, digite: 0");
				inputCarrinho = input.nextInt();
				if (inputCarrinho.equals(0)) break;
				
				Anuncio procuradoParaRemover = this.procurarNoCarrinhoPorId(carrinhoDeCompras, inputCarrinho);
				if (procuradoParaRemover == null) {
					System.out.println(String.format("\nNão foi possível encontrar nenhum Anuncio com ID no carrinho: `%d`.\nTente novamente ...", inputCarrinho));
				};
				carrinhoDeCompras.remove(procuradoParaRemover);
				
			} while(!inputCarrinho.equals(0));
			
			break;

		case 7: // 7. REALIZAR CHECKOUT
			System.out.println("\n===== Checkout =====\n"
					+ "\n > Seu carrinho de compras atual: ");
			this.mostrarCarrinho(carrinhoDeCompras);
			
			System.out.println("\n Deseja proceder o checkout? "
					+ "\n > Digite qualquer número para continuar;"
					+ "\n > Ou, digite '0' para voltar ao menu. ");
			inputCarrinho = input.nextInt();
			if (inputCarrinho.equals(0)) break;
			
			Financeiro calculosCheckout = this.mostrarCalculosPreliminares(carrinhoDeCompras);
			
			
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
	
	private Anuncio procurarNoCarrinhoPorId(List<Anuncio> carrinho, Integer id) {
		if (id == null) return null;
		Anuncio procurado = null;
		
		for (Anuncio anuncio : carrinho) {
			if (id.equals(anuncio.getIdAnuncio())) {
				return anuncio;
			}
		}
		return procurado;
	}
	
	private void mostrarCarrinho(List<Anuncio> carrinho) {
		for (int i = 0; i < carrinho.size(); i++) {
			int index = i + 1; 
			System.out.println(index + ") " + carrinho.get(i).mostrarInfo());
		}
	}
	
	private Financeiro mostrarCalculosPreliminares(List<Anuncio> carrinho) {
		Financeiro calculosDoCarrinho = new Financeiro(1, null, new Date(new java.util.Date().getTime()));
		calculosDoCarrinho.calcularValor(carrinho);
		
		System.out.println("\n > Valor do(s) produto(s):	R$ " + calculosDoCarrinho.getValorTotal());
		calculosDoCarrinho.calcularValorDoFrete(carrinho, TipoDeEnvio.PAC);
		System.out.println("- - - - -\n > Frete (PAC):			R$ " + calculosDoCarrinho.getValorFrete());
		calculosDoCarrinho.calcularValorDoFrete(carrinho, TipoDeEnvio.SEDEX);
		System.out.println(" > Frete (SEDEX):		R$ " + calculosDoCarrinho.getValorFrete());
		calculosDoCarrinho.calcularValorDoFrete(carrinho, TipoDeEnvio.SEDEX_10);
		System.out.println(" > Frete (SEDEX10):		R$ " + calculosDoCarrinho.getValorFrete());
		
		return calculosDoCarrinho;
	}
}

