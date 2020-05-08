package br.com.spring.code.ecommerce.menuInterface;

import java.util.Random;
import java.util.Scanner;

import br.com.spring.code.ecommerce.atendimento.Atendimento;
import br.com.spring.code.ecommerce.atendimento.EmissorMensagem;
import br.com.spring.code.ecommerce.atendimento.MensagensAtendimento;
import br.com.spring.code.ecommerce.atendimento.RepositorioAtendimento;
import br.com.spring.code.ecommerce.atendimento.TipoAtendimento;
import br.com.spring.code.ecommerce.gestaopessoas.Pessoa;
import br.com.spring.code.ecommerce.gestaopessoas.RepositorioPessoas;
import br.com.spring.code.ecommerce.venda.ListaRepositorioVendas;
import br.com.spring.code.ecommerce.venda.RepositorioVendas;
import br.com.spring.code.ecommerce.venda.Venda;

/** @author Stella Nazário **/

public class InterfaceSubMenuAtendimento {

	public static void mostrarMenuAtendimento(RepositorioPessoas pessoas) {
		Scanner leia = new Scanner(System.in);
		int opcao = 0;

		System.out.println("##################################################");
		System.out.println("******** e-COMMERCE DE PRODUTOS PARA BEBÊ ********\n");
		System.out.println(" ===== MENU OPÇÕES DE ATENDIMENTO =====\n");
		System.out.println("1. CRIAR ATENDIMENTO");
		System.out.println("2. ATENDENTE RESPONDE");
		System.out.println("3. CLIENTE RESPONDE");
		System.out.println("4. FECHAR ATENDIMENTO");
		System.out.println("5. LISTAR MENSAGENS");
		System.out.println("6. VOLTAR AO MENU PRINCIPAL");
		System.out.println("0. ENCERRAR SISTEMA");

		System.out.println("\n Digite uma opção: ");
		opcao = leia.nextInt();

		ingressaOpcaoAtendimento(opcao, pessoas);

	}

	public static void ingressaOpcaoAtendimento(int op, RepositorioPessoas pessoas) {

	
		
		Random gerador = new Random();
		Integer aleatorio = gerador.nextInt(1000000);
		Scanner leia = new Scanner(System.in);
		switch (op) {

		case 1: // Criar atendimento

			System.out.println("Login: ");
			
			String login = leia.next();

			System.out.println("Senha: ");
		
			String senha = leia.next();

			Pessoa pessoaAutenticada = pessoas.estaAutenticadoRetornaPessoa(login, senha);

			if (pessoaAutenticada != null) {

				System.out.println("Digite o assunto: ");
				leia.nextLine();
				String assunto = leia.next();

				System.out.println("Selecione o tipo de atendimento: ");
				System.out.println("\n 1-Dúvidas \n 2-Problemas \n 3-Sugestões");
				TipoAtendimento tipoAtendimento = null;

				leia.nextLine();
				int opAtendimento = leia.nextInt();
				switch (opAtendimento) {
				case 1:
					tipoAtendimento = TipoAtendimento.duvidas;
					break;
				case 2:
					tipoAtendimento = TipoAtendimento.problemas;
					break;
				case 3:
					tipoAtendimento = TipoAtendimento.sugestoes;
				}

				System.out.println("Digite a sua mensagem: ");
				leia.nextLine();
				String msg = leia.nextLine();

				System.out.println("Há venda relacionada?\n1-Sim\n2-Não");
				leia.nextLine();
				int temVenda = leia.nextInt();

				if (temVenda == 1) {
					System.out.println("Id da Venda: ");
				
					int idVenda = leia.nextInt();

					Atendimento a = new Atendimento(aleatorio, pessoaAutenticada, assunto, idVenda, tipoAtendimento,
							msg);
				
				
					RepositorioAtendimento.adicionar(a);
					mostrarMenuAtendimento(pessoas);

				} else if (temVenda == 2) {
					Atendimento a = new Atendimento(aleatorio, pessoaAutenticada, assunto, tipoAtendimento, msg);
			
					RepositorioAtendimento.adicionar(a);
					mostrarMenuAtendimento(pessoas);
					

				} else {
					System.out.println("Opção não válida");
					mostrarMenuAtendimento(pessoas);
				}

			} else {
				System.out.println("Login e/ou Senha incorretos");
				mostrarMenuAtendimento(pessoas);
			}
			break;

		case 2: // Atendente responder atendimento
			
		
			System.out.println("Id do Atendimento:");
			int idAtendimento = leia.nextInt();

			Atendimento atendimento = RepositorioAtendimento.buscarPorId(idAtendimento);
			if (atendimento != null) {
				System.out.println("Mensagem: ");
				leia.nextLine();
				String mensagem = leia.nextLine();
				atendimento.atendenteResponde(idAtendimento, mensagem);
				mostrarMenuAtendimento(pessoas);

			} else {
				System.out.println("Atendimento não encontrado");
				mostrarMenuAtendimento(pessoas);
			}
			
			break;

		case 3: // Cliente responder atendimento
			System.out.println("Id do Atendimento:");
	
			int idAtendimento1 = leia.nextInt();

			Atendimento atendimento1 = RepositorioAtendimento.buscarPorId(idAtendimento1);
			if (atendimento1 != null) {
				System.out.println("Mensagem: ");
				leia.nextLine();
				String mensagem = leia.nextLine();
				atendimento1.clienteResponde(idAtendimento1, mensagem);
				mostrarMenuAtendimento(pessoas);

			} else {
				System.out.println("Atendimento não encontrado");
				mostrarMenuAtendimento(pessoas);
			}
			
			break;

		case 4: // Fechar atendimento
			System.out.println("Id do Atendimento:");
		
			int idAtendimento2 = leia.nextInt();

			Atendimento atendimento2 = RepositorioAtendimento.buscarPorId(idAtendimento2);
			if (atendimento2 != null) {
				atendimento2.fecharAtendimento(idAtendimento2);
				mostrarMenuAtendimento(pessoas);

			} else {
				System.out.println("Atendimento não encontrado");
				mostrarMenuAtendimento(pessoas);
			}
			
			break;

		case 5: // Listar mensagens de um atendimento
			System.out.println("Id do Atendimento:");
			int idAtendimento3 = leia.nextInt();

			Atendimento atendimento3 = RepositorioAtendimento.buscarPorId(idAtendimento3);
			if (atendimento3 != null) {
				atendimento3.mostrarMensagens(idAtendimento3);
				mostrarMenuAtendimento(pessoas);

			} else {
				System.out.println("Atendimento não encontrado");
				mostrarMenuAtendimento(pessoas);
			}
		
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