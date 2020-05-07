package br.com.spring.code.ecommerce.menuInterface;

import java.util.Scanner;

import br.com.spring.code.ecommerce.gestaopessoas.RepositorioPessoas;
import br.com.spring.code.ecommerce.gestaoprodutos.Estado;
import br.com.spring.code.ecommerce.gestaoprodutos.FaixaEtaria;
import br.com.spring.code.ecommerce.gestaoprodutos.Produto;
import br.com.spring.code.ecommerce.gestaoprodutos.RepositorioCategorias;
import br.com.spring.code.ecommerce.gestaoprodutos.RepositorioProdutos;

public class InterfaceSubMenuProdutos {

	public static void mostrarSubMenuProdutos() {

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

	}

	/**
	 * 
	 * @param pessoas
	 * @param produtos
	 * @param categorias
	 * @param leia
	 * @throws InterruptedException
	 */
	public static void ingressaOpcoesGestaoProdutos(RepositorioPessoas pessoas, RepositorioProdutos produtos,
			RepositorioCategorias categorias, Scanner leia) throws InterruptedException {

		int op;
		do {
			InterfaceSubMenuProdutos.mostrarSubMenuProdutos();
			op = leia.nextInt();
			switch (op) {
			case 1:
				Produto produto = new Produto();
				System.out.println("\nDigite o Titulo do Produto: ");
				produto.setTitulo(leia.nextLine());
				System.out.println("\nDigite a Descricao do Produto: ");
				produto.setDescricao(leia.nextLine());
				System.out.println("\nDigite a Quantidade do Produto: ");
				produto.setQuantidade(leia.nextInt());
				int opc;
				do {
					System.out.println("\nSelecione o Estado do Produto: ");
					System.out.println("1 - Novo \n2 - Usado");
					opc = leia.nextInt();
					if (opc == 1) {
						produto.setEstado(Estado.NOVO);
					} else if (opc == 2) {
						produto.setEstado(Estado.USADO);
					} else {
						System.out.println("Opção Inválida!");
					}
				} while (opc != 1 && opc != 2);

				do {
					System.out.println("\nSelecione a faixa etaria do Produto: ");
					System.out.println(
							"1 - De 0 a 3 meses \n2 - De 3 a 6 meses\n3 - De 6 a 12 meses\n4 - De 1 a 2 anos\n5 - De 2 a 4 anos\n6 - De 4 a 6 anos\n7 - De 6 a 8 anos");
					opc = leia.nextInt();
					if (opc == 1) {
						produto.setFaixaEtaria(FaixaEtaria.ZERO_A_TRES_MESES);

					} else if (opc == 2) {
						produto.setFaixaEtaria(FaixaEtaria.TRES_A_SEIS_MESES);

					} else if (opc == 3) {
						produto.setFaixaEtaria(FaixaEtaria.SEIS_A_DOZE_MESES);

					} else if (opc == 4) {
						produto.setFaixaEtaria(FaixaEtaria.UM_A_DOIS);

					} else if (opc == 5) {
						produto.setFaixaEtaria(FaixaEtaria.DOIS_A_QUATRO);

					} else if (opc == 6) {
						produto.setFaixaEtaria(FaixaEtaria.QUATRO_A_SEIS);

					} else if (opc == 7) {
						produto.setFaixaEtaria(FaixaEtaria.SEIS_A_OITO);

					} else {
						System.out.println("Opção Inválida!");

					}
				} while (opc != 1 && opc != 2 && opc != 3 && opc != 4 && opc != 5 && opc != 6 && opc != 7);

//			Listar categorias
				do {
					System.out.println("\nDigite o id da Categoria do Produto:\n ");
					categorias.exibirTodoscategorias();
					opc = leia.nextInt();
					if (opc == 1) {
						produto.setCategoria(categorias.procurarCategoria(1));

					} else if (opc == 2) {
						produto.setCategoria(categorias.procurarCategoria(2));

					} else if (opc == 3) {
						produto.setCategoria(categorias.procurarCategoria(3));

					} else if (opc == 4) {
						produto.setCategoria(categorias.procurarCategoria(4));

					} else if (opc == 5) {
						produto.setCategoria(categorias.procurarCategoria(5));

					} else {
						System.out.println("Opção Inválida!");

					}
				} while (opc != 1 && opc != 2 && opc != 3 && opc != 4 && opc != 5);

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
				InterfaceDoApp.mostrarMenuOpcoes(pessoas, produtos, categorias, leia);
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

		} while (op != 6);
	}

}
