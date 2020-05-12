package br.com.spring.code.ecommerce.menuInterface;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import br.com.spring.code.ecommerce.anuncio.Anuncio;
import br.com.spring.code.ecommerce.anuncio.ListaRepositorioAnuncio;
import br.com.spring.code.ecommerce.anuncio.RepositorioAnuncio;
import br.com.spring.code.ecommerce.atendimento.Atendimento;

import br.com.spring.code.ecommerce.atendimento.RepositorioAtendimento;
import br.com.spring.code.ecommerce.atendimento.TipoAtendimento;
import br.com.spring.code.ecommerce.duvidas.Duvidas;
import br.com.spring.code.ecommerce.duvidas.RepositorioDuvidas;
import br.com.spring.code.ecommerce.geolocalizacao.GeoLocalizacao;
import br.com.spring.code.ecommerce.gestaopessoas.Pessoa;
import br.com.spring.code.ecommerce.gestaopessoas.RepositorioPessoas;
import br.com.spring.code.ecommerce.gestaoprodutos.Produto;
import br.com.spring.code.ecommerce.gestaoprodutos.RepositorioProdutos;

public class InterfaceSubMenuAnuncios {

	public static void mostrarMenuAnuncios(
			RepositorioPessoas pessoas, 
			RepositorioProdutos produtos,
			RepositorioAnuncio anuncios
			) {
		Scanner leia = new Scanner(System.in);
		int opcao = 0;

		System.out.println("##################################################");
		System.out.println("******** e-COMMERCE DE PRODUTOS PARA BEBÊ ********\n");
		System.out.println(" ===== MENU OPÇÕES DE ANÚNCIOS =====\n");
		System.out.println("1. CRIAR UM ANÚNCIO");
		System.out.println("2. EXCLUIR UM ANÚNCIO");
		System.out.println("3. ALTERAR UM ANÚNCIO");
		System.out.println("4. LISTAR SEUS ANUNCIOS");
		System.out.println("5. LISTAR TODOS OS ANÚNCIOS");
		System.out.println("6. VOLTAR AO MENU PRINCIPAL");
		System.out.println("0. ENCERRAR SISTEMA");

		System.out.println("\n Digite uma opção: ");
		opcao = leia.nextInt();

		ingressaOpcaoAtendimento(opcao, pessoas, produtos, anuncios);

	}

	public static void ingressaOpcaoAtendimento(
			int op, 
			RepositorioPessoas pessoas, 
			RepositorioProdutos produtos,
			RepositorioAnuncio anuncios
			) {

		Scanner leia = new Scanner(System.in);

		Pessoa pessoaAutenticada = null;

		switch (op) {

		case 1: // Criar Anúncio

			if (pessoaAutenticada == null) {

				System.out.println("Login: ");

				String login = leia.next();

				System.out.println("Senha: ");

				String senha = leia.next();

				pessoaAutenticada = pessoas.estaAutenticadoRetornaPessoa(login, senha);
			}
			if (pessoaAutenticada != null) {
				System.out.println("Digite o id do produto a ser anunciado: ");
				int id = leia.nextInt();

				Produto produto = produtos.procurarProduto(id);

				if (produto != null && produto.getIdPessoa().equals(pessoaAutenticada.getId())) {
					Date dataAnuncio = new Date();
				
					Duvidas duvidas = new Duvidas(produto.getId(), produto);
					RepositorioDuvidas.salvarDuvida(duvidas);
					
					System.out.println("Digite o valor do produto a ser anunciado: ");
					Double valor = leia.nextDouble();
					GeoLocalizacao localizacao = new GeoLocalizacao(produto.getId(), produto, -8.060628, -34.891295);
					Anuncio anuncio = new Anuncio(pessoaAutenticada, produto, dataAnuncio, duvidas, valor, localizacao);
					
					anuncio.setIdAnuncio(produto.getId());

					anuncios.criarAnuncio(anuncio);
					System.out.println("\n> Anuncio criado:\n" + anuncio.mostrarInfo());
					
					mostrarMenuAnuncios(pessoas, produtos, anuncios);

				} else {
					System.out.println("Você não possui este produto para anunciar");
					mostrarMenuAnuncios(pessoas, produtos, anuncios);
				}

			} else {
				System.out.println("Usuário ou senha incorretos");
				mostrarMenuAnuncios(pessoas, produtos, anuncios);
			}
			break;

		case 2: // Excluir anúncio

			while (pessoaAutenticada == null) {
				System.out.println("Login: ");

				String login = leia.next();

				System.out.println("Senha: ");

				String senha = leia.next();

				pessoaAutenticada = pessoas.estaAutenticadoRetornaPessoa(login, senha);

			}

			System.out.println("Digite o id do produto:");
			int idProcurado = leia.nextInt();

			Produto produto = produtos.procurarProduto(idProcurado);

			if (produto != null && produto.getIdPessoa().equals(pessoaAutenticada.getId())) {
				anuncios.removerAnuncio(idProcurado);
				mostrarMenuAnuncios(pessoas, produtos, anuncios);

			} else {

				System.out.println("Você não possui este produto para excluir dos anúncios");
				mostrarMenuAnuncios(pessoas, produtos, anuncios);

			}

			break;

		case 3: // Alterar anúncio
			while (pessoaAutenticada == null) {

				System.out.println("Login: ");

				String login = leia.next();

				System.out.println("Senha: ");

				String senha = leia.next();

				pessoaAutenticada = pessoas.estaAutenticadoRetornaPessoa(login, senha);
			}
			if (pessoaAutenticada != null) {
				System.out.println("Digite o id do produto a ser alterado: ");
				int id = leia.nextInt();

				Produto produto1 = produtos.procurarProduto(id);

				if (produto1 != null && produto1.getIdPessoa().equals(pessoaAutenticada.getId())) {
					Anuncio anuncio = anuncios.procurarAnuncioPorId(id);
			
					System.out.println("Digite o valor do produto a ser anunciado: ");
					Double valor = leia.nextDouble();
					anuncio.setValor(valor);

				
					mostrarMenuAnuncios(pessoas, produtos, anuncios);

				} else {
					System.out.println("Você não possui este produto para alterar");
					mostrarMenuAnuncios(pessoas, produtos, anuncios);
				}

			} else {
				
				System.out.println("Usuário ou senha incorretos");
				InterfaceSubMenuAnuncios.mostrarMenuAnuncios(pessoas, produtos,anuncios);
			}
			break;

		case 4: // Mostrar anúncio por usuário
			while (pessoaAutenticada == null) {
				System.out.println("Login: ");

				String login = leia.next();

				System.out.println("Senha: ");

				String senha = leia.next();

				pessoaAutenticada = pessoas.estaAutenticadoRetornaPessoa(login, senha);

			}

			List<Anuncio> listaDeAnunciosPorUsuario =  anuncios.procurarAnuncioPorVendedor(pessoaAutenticada.getId());
			
			if (listaDeAnunciosPorUsuario == null) {
				System.out.println("> Não existem anuncios criados por este usuário.");
				break;
			} else if (listaDeAnunciosPorUsuario.size() == 0) {
				System.out.println("> Não existem anuncios criados por este usuário.");
				break;
			}
			System.out.println(" > Os anuncios ligados a este usuario são: \n");
			for (Anuncio anuncio : listaDeAnunciosPorUsuario) {
				System.out.println(anuncio.mostrarInfo());
			}
			InterfaceSubMenuAnuncios.mostrarMenuAnuncios(pessoas, produtos, anuncios);
			break;

		case 5: // Mostrar todos os anúncios
			
			anuncios.exibirTodosAnunciosNoConsole();
			InterfaceSubMenuAnuncios.mostrarMenuAnuncios(pessoas, produtos, anuncios);
			
			break;

		case 6:
			System.out.println("Voltando ao Menu Principal");
			InterfaceDoApp.mostrarMenuOpcoes();

			break;

		case 0:
			System.out.println("Saindo do Sistema...");

			System.exit(0);
			break;

		default:
			System.out.println("Opção Inválida!");
		}
	}

}