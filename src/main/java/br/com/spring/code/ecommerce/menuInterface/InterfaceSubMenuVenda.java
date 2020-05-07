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
import br.com.spring.code.ecommerce.gestaopessoas.Pessoa;
import br.com.spring.code.ecommerce.gestaopessoas.RepositorioPessoas;
import br.com.spring.code.ecommerce.sessao.ControladorSessao;
import br.com.spring.code.ecommerce.venda.BarraDeProgresso;
import br.com.spring.code.ecommerce.venda.ListaRepositorioVendas;
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
			RepositorioAnuncio repositorioAnuncio, 
			RepositorioPessoas repositorioPessoas,
			RepositorioVendas repositorioVendas, 
			RepositorioFinanceiro repositorioFinanceiro,
			List<Anuncio> carrinhoDeCompras,
			ControladorSessao controladorSessao
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
					+ "\n Seu carrinho de compras atual: ");
			if (carrinhoDeCompras == null | carrinhoDeCompras.size() == 0) {
				System.out.println(" - - VAZIO - - ");
				break;
			} 

			this.mostrarCarrinho(carrinhoDeCompras);

			System.out.println("\n Deseja proceder o checkout? "
					+ "\n > Digite qualquer número para continuar;"
					+ "\n > Ou, digite '0' para voltar ao menu. ");
			inputCarrinho = input.nextInt();
			if (inputCarrinho.equals(0)) break;

			Financeiro calculosCheckout = this.mostrarCalculosPreliminares(carrinhoDeCompras);
			boolean repeat = true;
			TipoDeEnvio tipoDeEnvio = null;
			do {
				System.out.println("\n ... Escolha o tipo de frete, digitando:"
						+ "\n > '1' e escolher PAC;"
						+ "\n > '2' e escolher SEDEX;"
						+ "\n > '3' e escolher SEDEX 10."
						);
				inputCarrinho = input.nextInt();
				if (inputCarrinho.equals(1) || inputCarrinho.equals(2) || inputCarrinho.equals(3)) {
					repeat = false;
					switch (inputCarrinho) {
					case 1:
						tipoDeEnvio = TipoDeEnvio.PAC;
						break;
					case 2:
						tipoDeEnvio = TipoDeEnvio.SEDEX;
						break;
					case 3:
						tipoDeEnvio = TipoDeEnvio.SEDEX_10;
						break;
					}
					System.out.println(" Você escolheu: " + tipoDeEnvio);
					calculosCheckout.calcularValorDoFrete(carrinhoDeCompras, tipoDeEnvio);
					break;
				}
				System.out.println(String.format(" ... `%d` não é opção válida. Tente novamente.", inputCarrinho));
			} while (repeat);

			do {
				System.out.println("\n ... Escolha o tipo de PAGAMENTO, digitando:");
				StringBuilder opcoesDePagamento = new StringBuilder();
				int index = 0;
				for (int i = 0; i < Pagamento.values().length; i++) {
					index = i + 1;
					opcoesDePagamento.append(String.format("\n > '%d' e escolher %s", index, Pagamento.values()[i]));
				}
				System.out.println(opcoesDePagamento);
				inputCarrinho = input.nextInt();
				if (inputCarrinho < 1 || inputCarrinho > index) break;

				for (Pagamento pag : Pagamento.values()) {
					if (inputCarrinho.equals(pag.ordinal() + 1)) {
						repeat = false;
						System.out.println(" Você escolheu: " + pag);
						calculosCheckout.setFormaPagamento(pag);
						break;
					}
				}
				if (repeat) System.out.println(String.format(" ... `%d` não é opção válida. Tente novamente.", inputCarrinho));
			} while (repeat);
			repeat = true;
			Pessoa comprador = null;
			do {
				System.out.println("Ok, agora é hora de realizar o LOGIN em sua conta."
						+ "\nPara tal, digite seu login/username OU digite '0' para voltar ao menu: ");
				String username = input.next();
				if (username.equals("0")) break;
				System.out.println(" ... e em seguida sua senha de acessso correspondente: ");
				String senha = input.next();

				if (controladorSessao.login(username, senha, repositorioPessoas) 
						|| controladorSessao.isAutenticado(username)) {
					System.out.println("Login realizado com sucesso.\n");
					comprador = repositorioPessoas.estaAutenticadoRetornaPessoa(username, senha);
					repeat = false;
				} else {
					System.out.println("Ocorreu um erro, tente novamente.\n");
					repeat = true;
				}
			} while (repeat);

			if (comprador == null) break;

			try {
				Integer idAleatorio = (int) Math.floor(Math.random()*10000);

				calculosCheckout.setId(idAleatorio);
				repositorioFinanceiro.registrarMovimentacao(calculosCheckout);

				Venda vendaProcessada = new Venda(
						idAleatorio, 
						comprador, 
						carrinhoDeCompras, 
						tipoDeEnvio, 
						calculosCheckout
						);
				BarraDeProgresso.play();
				vendaProcessada.confirmarVenda(true);
				repositorioVendas.registrarVenda(vendaProcessada);
				System.out.println("\n	> VENDA REALIZADA: \n" 
						+ vendaProcessada.toString()
						);
				carrinhoDeCompras.clear();
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;

		case 8: // 8. VISUALIZAR PEDIDOS
			String username, senha = "";
			System.out.println("\n===== Histórico de Pedidos =====\n"
					+ "Digite o login/username desejado:");
			username = input.next();
			System.out.println("... e em seguida a senha correspondente: ");
			senha = input.next();

			if (!controladorSessao.login(username, senha, repositorioPessoas)) {
				if (!controladorSessao.isAutenticado(username)) {
					System.out.println("Houve problemas na autenticação deste usuário. Tente novamente...");
					break;
				}
			} 

			int permissao = repositorioPessoas.verificarPermissao(username, senha);
			if (permissao == -1) {
				System.out.println("Houve problema no registro do usuário. Procurar suporte técnico.");
				break;
			}
			Pessoa pessoaProcurada = repositorioPessoas.estaAutenticadoRetornaPessoa(username, senha);
			List<Venda> listaDeVendas = null; 
			switch (permissao) {
			case 1:
				System.out.println("\n > Produtos vendidos:");
				listaDeVendas = repositorioVendas.procurarVendasPorVendedor(pessoaProcurada);
				this.mostrarHistoricoPedidos(listaDeVendas);
				System.out.println("\n > Produtos comprados:");
				listaDeVendas = repositorioVendas.procurarVendasPorComprador(pessoaProcurada);
				break;

			case 2:
				System.out.println("\n > Produtos comprados:");
				listaDeVendas = repositorioVendas.procurarVendasPorComprador(pessoaProcurada);
				break;
			}
			this.mostrarHistoricoPedidos(listaDeVendas);

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

	private void mostrarHistoricoPedidos(List<Venda> vendas) {
		if (vendas == null) {
			System.out.println("Não existem pedidos para serem mostrados.");
			return;
		}
		if (vendas.size() == 0) {
			System.out.println("Não existem pedidos para serem mostrados.");
			return;
		}
		StringBuffer str = new StringBuffer();
		for (int i = 0; i < vendas.size(); i++) {
			int index = i + 1;
			str.append(index + ") ID = ");
			str.append(vendas.get(i).getId());
			str.append(", Tipo de Pgto = ");
			str.append(vendas.get(i).getTipoDePagamento());
			str.append(", ID_Financeiro = ");
			str.append(vendas.get(i).getFinanceiroID());
			str.append(", Beneficio Gerado = ");
			str.append(vendas.get(i).getFinanceiro().getBeneficio());
			str.append(", ID_Comprador = ");
			str.append(vendas.get(i).getPessoa().getId());
			str.append(" e ID_Anuncios = { ");
			for (Anuncio anuncio : vendas.get(i).getAnuncio()) {
				str.append(anuncio.getIdAnuncio() + ", ");
			}
			str.append("};");
		}

		System.out.println("\n" + str.toString());
	}
}

