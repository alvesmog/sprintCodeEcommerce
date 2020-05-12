package br.com.spring.code.ecommerce;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.spring.code.ecommerce.anuncio.Anuncio;
import br.com.spring.code.ecommerce.anuncio.ListaRepositorioAnuncio;
import br.com.spring.code.ecommerce.anuncio.RepositorioAnuncio;
import br.com.spring.code.ecommerce.duvidas.Duvidas;
import br.com.spring.code.ecommerce.financeiro.ListaRepositorioFinanceiro;
import br.com.spring.code.ecommerce.financeiro.RepositorioFinanceiro;
import br.com.spring.code.ecommerce.geolocalizacao.GeoLocalizacao;
import br.com.spring.code.ecommerce.gestaopessoas.Endereco;
import br.com.spring.code.ecommerce.gestaopessoas.Pessoa;
import br.com.spring.code.ecommerce.gestaopessoas.PessoaFisica;
import br.com.spring.code.ecommerce.gestaopessoas.PessoaJuridica;
import br.com.spring.code.ecommerce.gestaopessoas.RepositorioPessoas;
import br.com.spring.code.ecommerce.gestaopessoas.Usuario;
import br.com.spring.code.ecommerce.gestaoprodutos.Categoria;
import br.com.spring.code.ecommerce.gestaoprodutos.Produto;
import br.com.spring.code.ecommerce.gestaoprodutos.RepositorioCategorias;
import br.com.spring.code.ecommerce.gestaoprodutos.RepositorioProdutos;
import br.com.spring.code.ecommerce.menuInterface.InterfaceDoApp;
import br.com.spring.code.ecommerce.menuInterface.InterfaceSubMenuAnuncios;
import br.com.spring.code.ecommerce.menuInterface.InterfaceSubMenuAtendimento;
import br.com.spring.code.ecommerce.menuInterface.InterfaceSubMenuDuvidas;
import br.com.spring.code.ecommerce.menuInterface.InterfaceSubMenuPessoas;
import br.com.spring.code.ecommerce.menuInterface.InterfaceSubMenuProdutos;
import br.com.spring.code.ecommerce.menuInterface.InterfaceSubMenuVenda;
import br.com.spring.code.ecommerce.sessao.ControladorSessao;
import br.com.spring.code.ecommerce.venda.ListaRepositorioVendas;
import br.com.spring.code.ecommerce.venda.RepositorioVendas;

/**
 * Juntando as peças: Prof. Lenin
 */

public class App 
{
	// [fix] source: Aula 18/04,  9-12h: https://github.com/alvesmog/sprintCodeEcommerce/commit/b069ece92b571a188769eec075737660e8a44743
	public static void main( String[] args ) throws InterruptedException
	{
		//Populando dados no sistema
		RepositorioPessoas pessoas = new RepositorioPessoas();
		RepositorioProdutos produtos = new RepositorioProdutos();	
		RepositorioCategorias categorias = new RepositorioCategorias();
		RepositorioAnuncio anuncios = new ListaRepositorioAnuncio();
		RepositorioFinanceiro financas = new ListaRepositorioFinanceiro();
		RepositorioVendas vendas = new ListaRepositorioVendas();
		ControladorSessao controladorSessao = new ControladorSessao();

		//[UPDATE] Redefinidos os instanciamentos seguindo as mudanças na estrutura do pacote "gestaopessoas" | INICIO

		Endereco end1 = new Endereco("50010-060", "105", "Banco Itaú", "Brasil");
		Endereco end2 = new Endereco("50010-230", "1212", "", "Brasil");
		Endereco end3 = new Endereco("50020-040", "06", "Nenhum", "Brasil");
		Endereco end4 = new Endereco("50010-080", "591", "", "Brasil");
		Endereco end5 = new Endereco("50050-130", "13", "Casa de festas", "Brasil");
		Endereco end6 = new Endereco("50050-070", "198", "", "Brasil");    			
		Endereco end7 = new Endereco("50040-220", "01", "Proximo ao colégio e curso XYZ", "Brasil");

		Usuario user1 = new Usuario("user1", "1234");
		Usuario user2 = new Usuario("user2", "2020");
		Usuario user3 = new Usuario("user3", "1111");
		Usuario user4 = new Usuario("user4", "0250");
		Usuario user5 = new Usuario("user5", "8569");
		Usuario user6 = new Usuario("user6", "4575");
		Usuario user7 = new Usuario("user7", "7586");

		Pessoa pessoa1 = new PessoaFisica("Joao Augusto", "986413568", "joao@teste.com", end1, user1, "18874319002");
		Pessoa pessoa2 = new PessoaFisica("Arthur Leandro", "96853214", "arthur@teste.com", end2, user2, "69257102084");
		Pessoa pessoa3 = new PessoaFisica("Carlina Perez", "5842027547", "candryushchenko0@a8.net", end3, user3,
				"69476312033");
		Pessoa pessoa4 = new PessoaFisica("Nichole Lima", "8232611354", "nbrigdale1@vkontakte.ru", end4, user4,
				"08407446092");
		Pessoa pessoa5 = new PessoaFisica("Matthew Souza", "2555717124", "mtitmuss2@multiply.com", end5, user5,
				"27535452000");
		Pessoa pessoa6 = new PessoaJuridica("Corrinne Silva", "7047897644", "cchallens3@1688.com", end6, user6,
				"60054463000168", "Informatica SA");
		Pessoa pessoa7 = new PessoaJuridica("Sherilyn Perez", "9461924214", "sivanyutin4@sakura.ne.jp", end7, user7,
				"37500473000168", "Cosmeticos Ltda");

		pessoas.adicionar(pessoa1);
		pessoas.adicionar(pessoa2);
		pessoas.adicionar(pessoa3);
		pessoas.adicionar(pessoa4);
		pessoas.adicionar(pessoa5);
		pessoas.adicionar(pessoa6);
		pessoas.adicionar(pessoa7);
		// [UPDATE] Redefinidos os instanciamentos seguindo as mudanças na estrutura do
		// pacote "gestaopessoas" | FINAL

		Categoria cat1 = new Categoria(1, "Roupa");
		Categoria cat2 = new Categoria(2, "Móveis");
		Categoria cat3 = new Categoria(3, "Decoração");
		Categoria cat4 = new Categoria(4, "Peças de Cama");
		Categoria cat5 = new Categoria(5, "Brinquedo");

		categorias.adicionarCategoria(cat1);
		categorias.adicionarCategoria(cat2);
		categorias.adicionarCategoria(cat3);
		categorias.adicionarCategoria(cat4);
		categorias.adicionarCategoria(cat5);

		Produto produto1 = new Produto(1, "Ninho para Bebê Redutor", "Com a suavidade do tecido 100% algodão e enchimento fofinho", "./images/ninho.png", pessoa1,cat1);    	
		Produto produto2 = new Produto(2, "Berço Minicama 3 em 1 Dom", "Com design moderno, a cabeceira e a peseira se destacam com originais linhas curvilíneas", "./images/berço.png", pessoa2,cat2);
		Produto produto3 = new Produto(3, "Andador Goal Walker 4 em 1 Cosco", "Com a suavidade do tecido 100% algodão e enchimento fofinho", "./images/andardor.png", pessoa3, cat2);
		Produto produto4 = new Produto(4, "Prateleira com Varão Branca", "madeira MDF com varão é a escolha ideal para acomodar caixas e enfeites", "./images/prateleira.png", pessoa4, cat3);
		Produto produto5 = new Produto(5, "Kit Mijões Bebê 3 Peças Vaquinha", "Confeccionadas em 85% algodão e 15% pode variar entre outras fibras", "./images/kitmijoes.png", pessoa5,cat4);
		Produto produto6 = new Produto(6, "Kit Berço Trança Poá Azul Bebê", "com peças confeccionadas em tecidos 100% algodão e essenciais para o enxoval do bebê", "./images/kitberco.png", pessoa6,cat5);
		Produto produto7 = new Produto(7,"Camisa","Camisa Azul","Foto",pessoa7,cat5);

		produtos.adicionar(produto1);
		produtos.adicionar(produto2);
		produtos.adicionar(produto3);
		produtos.adicionar(produto4);
		produtos.adicionar(produto5);
		produtos.adicionar(produto6);
		produtos.adicionar(produto7);

		/**
		 * 	ANÚNCIO:
		 * 
		 *  - [] Criar anúncios: é preciso criar Datas, Geolocalização, Dúvidas
		 *  
		 */

		GeoLocalizacao geo1 = new GeoLocalizacao(1, produto1, -8.92, -33.89);
		GeoLocalizacao geo2 = new GeoLocalizacao(2, produto2, -8.92, -34.89);
		GeoLocalizacao geo3 = new GeoLocalizacao(3, produto3, -8.12, -34.95);

		Duvidas duvida1 = new Duvidas(1, produto1);
		Duvidas duvida2 = new Duvidas(2, produto2);
		Duvidas duvida3 = new Duvidas(3, produto3);

		Anuncio anuncio1 = new Anuncio(pessoa1, produto1, new Date(), duvida1, 95.99, geo1);
		Anuncio anuncio2 = new Anuncio(pessoa3, produto2, new Date(), duvida2, 54.75, geo2);
		Anuncio anuncio3 = new Anuncio(pessoa6, produto3, new Date(), duvida3, 39.90, geo3);

		anuncios.criarAnuncio(anuncio1);
		anuncios.criarAnuncio(anuncio2);
		anuncios.criarAnuncio(anuncio3);

		List<Anuncio> carrinhoDeCompras = new ArrayList<>();

		// [fix] source: Aula 18/04, 9-12h:
		// https://github.com/alvesmog/sprintCodeEcommerce/commit/b069ece92b571a188769eec075737660e8a44743
		InterfaceDoApp menuGeral = new InterfaceDoApp();

		// Faz a chamada do menu de opções

		InterfaceSubMenuPessoas menuPessoas = new InterfaceSubMenuPessoas();
		InterfaceSubMenuProdutos menuProdutos = new InterfaceSubMenuProdutos();
		InterfaceSubMenuVenda menuVendas = new InterfaceSubMenuVenda();

		int rep;
		do {
			rep = menuGeral.mostrarMenuOpcoes();
			Integer opcao;
			switch (rep) {
			case 1:
				do {
					opcao = menuPessoas.mostrarSubMenuPessoas();
					opcao = menuPessoas.ingressaOpcoesGestaoPessoa(opcao, pessoas);
				} while (!opcao.equals(0));
				break;
			case 2 : //chamar a classe/metodo do submenu de gestão de produtos 		
				
				do {
					opcao = menuProdutos.mostrarSubMenuProdutos();
					opcao = menuProdutos.ingressaOpcoesGestaoProdutos(opcao, produtos, categorias);
				} while (!opcao.equals(0));
				break;
			case 3: // chamar a classe/metodo do submenu de gestão de anuncio
				InterfaceSubMenuAnuncios.mostrarMenuAnuncios(pessoas,produtos,anuncios);
				break;
			case 4: // chamar a classe/metodo do submenu de gestão de vendas
				
				do {
					opcao = menuVendas.mostrarSubMenuVendas();
					opcao = menuVendas.ingressaOpcoesParaVenda(
							opcao, 
							anuncios,
							pessoas, 
							vendas, 
							financas, 
							carrinhoDeCompras, 
							controladorSessao);

				} while (!opcao.equals(0));
				break;
				
			case 5: // chamar a classe/metodo do submenu de gestão de atendimento
				InterfaceSubMenuAtendimento.mostrarMenuAtendimento(pessoas);
				break;
				
			case 6: // PR #33 => chamar a classe/metodo do submenu de duvidas sobre um produto
				InterfaceSubMenuDuvidas.mostrarMenuDuvidas(pessoas, produtos);
				break;

			case 0:
				System.out.println("Saindo do Sistema... ");
				Thread.sleep(3000);
				break;

			default:
				System.out.println("Opção Inválida");
			}

		} while (rep != 0);
	}
}