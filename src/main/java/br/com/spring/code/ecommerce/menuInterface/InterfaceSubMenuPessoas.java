package br.com.spring.code.ecommerce.menuInterface;
  
  // [novo] source: Aula 18/04,  9-12h: https://github.com/alvesmog/sprintCodeEcommerce/commit/b069ece92b571a188769eec075737660e8a44743

/* [UPDATE] 20/04/2020
 * Autor: Henrique
 * 1. AJUSTES NA ESTRUTURA 
 */
  
import java.util.Scanner;
import br.com.spring.code.ecommerce.gestaopessoas.Endereco;
import br.com.spring.code.ecommerce.gestaopessoas.Pessoa;
import br.com.spring.code.ecommerce.gestaopessoas.PessoaFisica;
import br.com.spring.code.ecommerce.gestaopessoas.PessoaJuridica;
import br.com.spring.code.ecommerce.gestaopessoas.RepositorioPessoas;
import br.com.spring.code.ecommerce.gestaopessoas.Usuario;

public class InterfaceSubMenuPessoas {

  	public int mostrarSubMenuPessoas() {
 		Scanner leia = new Scanner(System.in);
 		int opcao = 0;

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
 		opcao = leia.nextInt();

  		return opcao;
 	}
  	/* [UPDATE] 21/04/2020
  	 * Autor: Henrique
  	 * 1. ATUALIZADO O MENU PARA CADASTRO DE NOVO USUÁRIO
  	 */
  	public int ingressaOpcoesGestaoPessoa(int op, RepositorioPessoas pessoas) throws InterruptedException {
 		InterfaceDoApp princ = null;
 		Scanner leia = new Scanner(System.in);
  		switch (op) {
 			case 1 :
 			boolean cepValido;
 			Usuario usuario = new Usuario(); 			
 			System.out.println("Informe o CPF ou CNPJ: ");
 			String entrada = leia.next();
 			if (pessoas.validaCpfCnpj(entrada) == "CPF" || pessoas.validaCpfCnpj(entrada) == "CNPJ") {
 				if (pessoas.validaCpfCnpj(entrada) == "CPF") {
					PessoaFisica pessoa = new PessoaFisica("", "", "", null, null, entrada);
					System.out.println("Nome: ");
					pessoa.setNome(leia.next());
					System.out.println("Telefone: ");
					pessoa.setTelefone(leia.next());
					System.out.println("E-mail: ");
					pessoa.setEmail(leia.next());
					do {
						System.out.println("CEP: ");
						Endereco endereco = new Endereco(leia.next());						
						cepValido = endereco.isCepValido();
						if (endereco.isCepValido() == true) {
							System.out.println("CEP: " + endereco.getCep());
							System.out.println("Logradouro: " + endereco.getLogradouro());
							System.out.println("Bairro: " + endereco.getBairro());
							System.out.println("Cidade: " + endereco.getCidade());
							System.out.println("Uf: " + endereco.getUf());
							System.out.println("Numero: ");
							endereco.setNumero(leia.next());
							System.out.println("Pais: ");
							endereco.setPais(leia.next());
							System.out.println("Referência: ");
							endereco.setRef(leia.next());
							pessoa.setEndereco(endereco);
						} else {
							System.out.println("CEP inválido!");
						}
					} while (cepValido != true);
					System.out.println("Usuário: ");
					usuario.setLogin(leia.next());
					System.out.println("Senha: ");
					usuario.setSenha(leia.next());
					pessoa.setUsuario(usuario);
					pessoas.adicionar(pessoa);
				} else {				
					PessoaJuridica pessoa = new PessoaJuridica("", "", "", null, null, entrada, "");
					System.out.println("Nome: ");
					pessoa.setNome(leia.next());
					System.out.println("Telefone: ");
					pessoa.setTelefone(leia.next());
					System.out.println("E-mail: ");
					pessoa.setEmail(leia.next());
					do {
						System.out.println("CEP: ");
						Endereco endereco = new Endereco(leia.next());
						cepValido = endereco.isCepValido();
						if (endereco.isCepValido() == true) {
							System.out.println("CEP: " + endereco.getCep());
							System.out.println("Logradouro: " + endereco.getLogradouro());
							System.out.println("Bairro: " + endereco.getBairro());
							System.out.println("Cidade: " + endereco.getCidade());
							System.out.println("Uf: " + endereco.getUf());
							System.out.println("Numero: ");
							endereco.setNumero(leia.next());
							System.out.println("Pais: ");
							endereco.setPais(leia.next());
							System.out.println("Referência: ");
							endereco.setRef(leia.next());
							pessoa.setEndereco(endereco);
						} else {
							System.out.println("CEP inválido!");
						}
					} while (cepValido != true);
					System.out.println("Usuário: ");
					usuario.setLogin(leia.next());
					System.out.println("Senha: ");
					usuario.setSenha(leia.next());
					pessoa.setUsuario(usuario);
					System.out.println("Razão social: ");
					pessoa.setRazaoSocial(leia.next());
					pessoas.adicionar(pessoa);			
				}				
			} else {
				System.out.println("Entrada inválida!");
			} 					
 			break;
 			case 2 : pessoas.exibirTodasPessoas();
 			break;
 			case 3 : System.out.println("Digite o ID da Pessoa:");
 					int idBusca = leia.nextInt();
 					pessoas.exibir(idBusca);
 			break;
 			case 4: System.out.println("Digite o ID da Pessoa:");
 					int idRemove = leia.nextInt();
 					pessoas.remover(idRemove);
 			break;
 			case 5: System.out.println("Voltando ao Menu Principal");
 					Thread.sleep(1000);
 					return 0;
 					
 			case 0: System.out.println("Saindo do Sistema...");
 					Thread.sleep(2000);
 					System.exit(0);
 			break;
 			default: System.out.println("Opção Inválida!");;
 		}
  		return op;
  	}
}
