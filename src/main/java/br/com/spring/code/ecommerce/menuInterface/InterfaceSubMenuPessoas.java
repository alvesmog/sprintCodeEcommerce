package br.com.spring.code.ecommerce.menuInterface;

import java.util.Scanner;

import br.com.spring.code.ecommerce.gestaopessoas.CepException;
import br.com.spring.code.ecommerce.gestaopessoas.CpfCnpjException;
import br.com.spring.code.ecommerce.gestaopessoas.Endereco;
import br.com.spring.code.ecommerce.gestaopessoas.Pessoa;
import br.com.spring.code.ecommerce.gestaopessoas.PessoaFisica;
import br.com.spring.code.ecommerce.gestaopessoas.PessoaJuridica;
import br.com.spring.code.ecommerce.gestaopessoas.RepositorioPessoas;
import br.com.spring.code.ecommerce.gestaopessoas.Usuario;
import br.com.spring.code.ecommerce.gestaoprodutos.RepositorioCategorias;
import br.com.spring.code.ecommerce.gestaoprodutos.RepositorioProdutos;

public class InterfaceSubMenuPessoas {

	public static void mostrarSubMenuPessoas() {

		System.out.println("##################################################");
		System.out.println("******** e-COMMERCE DE PRODUTOS PARA BEBÊ ********\n");
		System.out.println(" ===== MENU DE OPÇÕES GESTÃO PESSOAS =====\n");
		System.out.println("1. CADASTRAR USUARIO");
		System.out.println("2. LISTAR USUARIO");
		System.out.println("3. PROCURAR USUARIO");
		System.out.println("4. EXCLUIR USUARIO");
		System.out.println("5. VOLTAR AO MENU PRINCIPAL");
		System.out.println("0. ENCERRAR SISTEMA");

		System.out.println("\n Digita uma opção: ");

	}

	/**
	 * 
	 * @param pessoas
	 * @param leia
	 * @throws InterruptedException
	 */
	public static void ingressaOpcoesGestaoPessoa(RepositorioPessoas pessoas, RepositorioProdutos produtos,
			RepositorioCategorias categorias, Scanner leia) throws InterruptedException {

		int op;
		do {
			InterfaceSubMenuPessoas.mostrarSubMenuPessoas();
			op = leia.nextInt();
			switch (op) {
			case 1:
				try {

					System.out.println("Informe o CPF ou CNPJ: ");
					String cpfOuCnpj = leia.next();

					Pessoa pessoa = null;
					if (pessoas.validaCpfCnpj(cpfOuCnpj) == "CPF") {
						pessoa = new PessoaFisica(null, null, null, null, null, cpfOuCnpj);
					} else {
						pessoa = new PessoaJuridica(null, null, null, null, null, cpfOuCnpj, null);
					}

					System.out.println("Nome: ");
					pessoa.setNome(leia.next());

					System.out.println("Telefone: ");
					pessoa.setTelefone(leia.next());

					System.out.println("E-mail: ");
					pessoa.setEmail(leia.next());

					Endereco endereco = null;
					do {

						try {

							System.out.println("CEP: ");
							endereco = new Endereco(leia.next());

							System.out.println("Numero: ");
							endereco.setNumero(leia.next());

							System.out.println("Referência: ");
							endereco.setRef(leia.next());

							System.out.println("Pais: ");
							endereco.setPais(leia.next());

						} catch (CepException e) {
							System.out.println("CEP Inválido! Tente novamente.\n");
						}

					} while (endereco == null);

					System.out.println("Usuário: ");
					Usuario usuario = new Usuario();
					usuario.setLogin(leia.next());

					System.out.println("Senha: ");
					usuario.setSenha(leia.next());

					pessoa.setEndereco(endereco);
					pessoa.setUsuario(usuario);

					pessoas.adicionar(pessoa);

					break;
				} catch (CpfCnpjException e) {
					System.out.println("CPF ou CNPJ inválido! Tente novamente.\n");
					break;
				}
			case 2:
				pessoas.exibirTodasPessoas();
				break;
			case 3:
				System.out.println("Digite o ID da Pessoa:");
				int idBusca = leia.nextInt();
				pessoas.exibir(idBusca);
				break;
			case 4:
				System.out.println("Digite o ID da Pessoa:");
				int idRemove = leia.nextInt();
				pessoas.remover(idRemove);
				break;
			case 5:
				System.out.println("Voltando ao Menu Principal");
				Thread.sleep(2000);
//				InterfaceDoApp.mostrarMenuOpcoes(pessoas, produtos, categorias, leia);
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

		} while (op != 5);

	}
}
