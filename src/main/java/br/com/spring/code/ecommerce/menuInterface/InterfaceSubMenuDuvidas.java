package br.com.spring.code.ecommerce.menuInterface;



import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import br.com.spring.code.ecommerce.anuncio.Anuncio;
import br.com.spring.code.ecommerce.anuncio.ListaRepositorioAnuncio;
import br.com.spring.code.ecommerce.anuncio.RepositorioAnuncio;
import br.com.spring.code.ecommerce.atendimento.Atendimento;

import br.com.spring.code.ecommerce.atendimento.RepositorioAtendimento;
import br.com.spring.code.ecommerce.atendimento.TipoAtendimento;
import br.com.spring.code.ecommerce.duvidas.Duvidas;
import br.com.spring.code.ecommerce.duvidas.Interacoes;
import br.com.spring.code.ecommerce.duvidas.RepositorioDuvidas;
import br.com.spring.code.ecommerce.geolocalizacao.GeoLocalizacao;
import br.com.spring.code.ecommerce.gestaopessoas.Pessoa;
import br.com.spring.code.ecommerce.gestaopessoas.RepositorioPessoas;
import br.com.spring.code.ecommerce.gestaoprodutos.Produto;
import br.com.spring.code.ecommerce.gestaoprodutos.RepositorioProdutos;



public class InterfaceSubMenuDuvidas {

	public static void mostrarMenuDuvidas(RepositorioPessoas pessoas, RepositorioProdutos produtos) {
		Scanner leia = new Scanner(System.in);
		int opcao = 0;

		System.out.println("##################################################");
		System.out.println("******** e-COMMERCE DE PRODUTOS PARA BEBÊ ********\n");
		System.out.println(" ===== MENU OPÇÕES DE DÚVIDAS SOBRE ANÚNCIOS =====\n");
		System.out.println("1. PERGUNTAR SOBRE UM PRODUTO");
		System.out.println("2. RESPONDER PERGUNTA DO SEU PRODUTO");
		System.out.println("3. LISTAR DÚVIDAS DE DETERMINADO PRODUTO");
		System.out.println("4. VOLTAR AO MENU PRINCIPAL");
		System.out.println("0. ENCERRAR SISTEMA");


		System.out.println("\n Digite uma opção: ");
		opcao = leia.nextInt();

		ingressaOpcaoAtendimento(opcao, pessoas, produtos);

	}

	public static void ingressaOpcaoAtendimento(int op, RepositorioPessoas pessoas, RepositorioProdutos produtos) {
	
	
		Scanner leia = new Scanner(System.in);

		Pessoa pessoaAutenticada = null;


	
		switch (op) {

		case 1: // Perguntar sobre um produto
			
			if(pessoaAutenticada==null) {

			System.out.println("Login: ");

			String login = leia.next();

			System.out.println("Senha: ");

			String senha = leia.next();

			pessoaAutenticada = pessoas.estaAutenticadoRetornaPessoa(login, senha);
			}
			if (pessoaAutenticada != null) {
				System.out.println("Digite o id do produto : ");
				int id = leia.nextInt();

				Produto produto = produtos.procurarProduto(id);

				if (produto != null) {
					Duvidas duvidas = RepositorioDuvidas.buscarDuvidaporId(produto.getId());
					System.out.println("Digite a sua pergunta: ");
					String pergunta = leia.nextLine();
					Random gerador = new Random();
					Integer aleatorio = gerador.nextInt(100000);
					Interacoes interacao = new Interacoes(aleatorio, pergunta, pessoaAutenticada);
					duvidas.inserirInteracao(interacao);
					System.out.println("Pergunta realizada: ");
					System.out.println(interacao);
					
				} else {
					System.out.println("Anúncio não encontrado");
					mostrarMenuDuvidas(pessoas, produtos);
				}

			} else {
				System.out.println("Usuário ou senha incorretos");
				mostrarMenuDuvidas(pessoas, produtos);
			}
			break;

		case 2: // Responder pergunta do seu produto
			
			while(pessoaAutenticada==null) {
				System.out.println("Login: ");

				String login = leia.next();

				System.out.println("Senha: ");

				String senha = leia.next();

				pessoaAutenticada = pessoas.estaAutenticadoRetornaPessoa(login, senha);
				
			}

			System.out.println("Digite o id do anúncio:");
			int idProcurado= leia.nextInt();
			
			Produto produto = produtos.procurarProduto(idProcurado);
			
			
			if (produto != null && produto.getIdPessoa().equals(pessoaAutenticada.getId())) {
				Duvidas duvidas = RepositorioDuvidas.buscarDuvidaporId(produto.getId());
				System.out.println("Digite o id da pergunta: ");
				int idPergunta= leia.nextInt();
				Interacoes interacao = duvidas.buscarInteracaoPorId(idPergunta);
				
				if(interacao!=null) {
					System.out.println("Digite a sua resposta: ");
					String resposta = leia.nextLine();
					interacao.setResposta(resposta);
				}else {
					System.out.println("Não há perguntas com este ID");
				}
				
				
				
			}else {
				
				System.out.println("Você não possui este produto para responder perguntas");
				mostrarMenuDuvidas(pessoas, produtos);
				
			}

		

			break;

		case 3: // Mostrar todas as dúvidas
			while(pessoaAutenticada==null) {

				System.out.println("Login: ");

				String login = leia.next();

				System.out.println("Senha: ");

				String senha = leia.next();

				pessoaAutenticada = pessoas.estaAutenticadoRetornaPessoa(login, senha);
				}
				if (pessoaAutenticada != null) {
					System.out.println("Digite o id do produto cujas dúvidas serão listadas: ");
					int id = leia.nextInt();

					Produto produto1 = produtos.procurarProduto(id);

					if (produto1 != null ) {
						Duvidas duvidas = RepositorioDuvidas.buscarDuvidaporId(produto1.getId());
						duvidas.mostrarTodasInterações();
						
					} else {
						System.out.println("Produto não encontrado");
						mostrarMenuDuvidas(pessoas, produtos);
					}

				} else {
					System.out.println("Usuário ou senha incorretos");
					mostrarMenuDuvidas(pessoas, produtos);
				}
			break;

	

		case 4:
			System.out.println("Voltando ao Menu Principal");
			InterfaceDoApp.mostrarMenuOpcoes();

			break;

		case 5:
			System.out.println("Saindo do Sistema...");

			System.exit(0);
			break;

		default:
			System.out.println("Opção Inválida!");
		}
	}

}