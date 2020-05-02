package br.com.spring.code.ecommerce.menuInterface;

import java.util.Scanner;

import br.com.spring.code.ecommerce.gestaoprodutos.Estado;
import br.com.spring.code.ecommerce.gestaoprodutos.FaixaEtaria;
import br.com.spring.code.ecommerce.gestaoprodutos.Produto;
import br.com.spring.code.ecommerce.gestaoprodutos.RepositorioCategorias;
import br.com.spring.code.ecommerce.gestaoprodutos.RepositorioProdutos;

public class InterfaceSubMenuProdutos {
	public int mostrarSubMenuProdutos() {
		Scanner leia = new Scanner(System.in);
		int opcao = 0;

		System.out.println("##################################################");
		System.out.println("******** e-COMMERCE DE PRODUTOS PARA BEBÊ ********\n");
		System.out.println(" ===== MENU DE OPÇÕES GESTÃO PRODUTOS =====\n");
		System.out.println("1. CADASTRAR PRODUTO");
		System.out.println("2. LISTAR PRODUTO");
		System.out.println("3. PROCURAR PRODUTO");
		System.out.println("4. EDITAR QUANTIDADE PRODUTO");
		System.out.println("5. EXCLUIR PRODUTO");
		System.out.println("6. VOLTAR AO MENU PRINCIPAL");
		System.out.println("0. ENCERRAR SISTEMA");

		System.out.println("\n Digita uma opção: ");
		opcao = leia.nextInt();

		return opcao;
	}
	/*
	 * [UPDATE] 01/05/2020 Autor: Carlos e Wilson 1. CRIANDO O MENU PARA CADASTRO DE
	 * NOVO PRODUTO
	 */

	public Integer ingressaOpcoesGestaoProdutos(Integer op, RepositorioProdutos produtos, RepositorioCategorias categorias)
			throws InterruptedException {
		int cond = 0;
		Scanner leia = new Scanner(System.in);
		switch (op) {
		case 1:
			Produto produto = new Produto();
			System.out.println("\nDigite o Titulo do Produto: ");
			produto.setTitulo(leia.nextLine());
			System.out.println("\nDigite a Descricao do Produto: ");
			produto.setDescricao(leia.nextLine());
			System.out.println("\nDigite a Quantidade do Produto: ");
			produto.setQuantidade(leia.nextInt());
			do {
				System.out.println("\nSelecione o Estado do Produto: ");
				System.out.println("1 - Novo \n2 - Usado");
				int opc = leia.nextInt();
				if (opc == 1) {
					produto.setEstado(Estado.NOVO);
					cond = 0;
				} else if (opc == 2) {
					produto.setEstado(Estado.USADO);
					cond = 0;
				} else {
					System.out.println("Opção Inválida!");
					cond = 1;
				}
			} while (cond != 0);

			do {
				System.out.println("\nSelecione a faixa etaria do Produto: ");
				System.out.println(
						"1 - De 0 a 3 meses \n2 - De 3 a 6 meses\n3 - De 6 a 12 meses\n4 - De 1 a 2 anos\n5 - De 2 a 4 anos\n6 - De 4 a 6 anos\n7 - De 6 a 8 anos");
				int opc = leia.nextInt();
				if (opc == 1) {
					produto.setFaixaEtaria(FaixaEtaria.ZERO_A_TRES_MESES);
					cond = 0;
				} else if (opc == 2) {
					produto.setFaixaEtaria(FaixaEtaria.TRES_A_SEIS_MESES);
					cond = 0;
				} else if (opc == 3) {
					produto.setFaixaEtaria(FaixaEtaria.SEIS_A_DOZE_MESES);
					cond = 0;
				} else if (opc == 4) {
					produto.setFaixaEtaria(FaixaEtaria.UM_A_DOIS);
					cond = 0;
				} else if (opc == 5) {
					produto.setFaixaEtaria(FaixaEtaria.DOIS_A_QUATRO);
					cond = 0;
				} else if (opc == 6) {
					produto.setFaixaEtaria(FaixaEtaria.QUATRO_A_SEIS);
					cond = 0;
				} else if (opc == 7) {
					produto.setFaixaEtaria(FaixaEtaria.SEIS_A_OITO);
					cond = 0;
				} else {
					System.out.println("Opção Inválida!");
					cond = 1;
				}
			} while (cond != 0);

//			Listar categorias
			do {
				System.out.println("\nDigite o id da Categoria do Produto:\n ");
				categorias.exibirTodoscategorias();
				int opc = leia.nextInt();
				if (opc == 1) {
					produto.setCategoria(categorias.procurarCategoria(1));
					cond = 0;
				} else if (opc == 2) {
					produto.setCategoria(categorias.procurarCategoria(2));
					cond = 0;
				} else if (opc == 3) {
					produto.setCategoria(categorias.procurarCategoria(3));
					cond = 0;
				} else if (opc == 4) {
					produto.setCategoria(categorias.procurarCategoria(4));
					cond = 0;
				} else if (opc == 5) {
					produto.setCategoria(categorias.procurarCategoria(5));
					cond = 0;
				} else {
					System.out.println("Opção Inválida!");
					cond = 1;
				}
			} while (cond != 0);

//			Adcionar Foto
			produtos.adicionar(produto);
			System.out.println("Produto cadastrado com sucesso!");
			break;
		case 2:
			produtos.exibirTodosProdutos();
			break;
		case 3:
			System.out.println("Digite o ID do Produto para Buscar: ");
			int idBusca = leia.nextInt();
			produtos.exibir(idBusca);
			break;
		case 4:
			System.out.println("Digite o ID do Produto para Atualizacao: ");
			int idAtualizar = leia.nextInt();
			produto = produtos.procurarProduto(idAtualizar);
			System.out.println("Digite a quantidade do produto: ");
			int idQnt = leia.nextInt();
			produtos.atualizarQuantidade(produto, idQnt);
			System.out.println("Quantidade atualizada!");
			break;
		case 5:
			System.out.println("Digite o ID do Produto para Exclui-lo: ");
			int idRemove = leia.nextInt();
			produtos.remover(idRemove);
			break;
		case 6:
			System.out.println("Voltando ao Menu Principal");
			Thread.sleep(2000);
			op = 0;
			break;
		case 0:
			System.out.println("Saindo do Sistema...");
			Thread.sleep(2000);
			System.exit(0);
			break;
		default:
			System.out.println("Opção Inválida!");
			;
		}
		return op;
	}

}
