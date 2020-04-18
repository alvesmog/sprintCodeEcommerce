package br.com.spring.code.ecommerce.menuInterface;
  
  // [novo] source: Aula 18/04,  9-12h: https://github.com/alvesmog/sprintCodeEcommerce/commit/b069ece92b571a188769eec075737660e8a44743
  
  import java.util.Scanner;

  import br.com.spring.code.ecommerce.gestaopessoas.Pessoa;
 import br.com.spring.code.ecommerce.gestaopessoas.RepositorioPessoas;

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

  	public void ingressaOpcoesGestaoPessoa(int op, RepositorioPessoas pessoas) throws InterruptedException {
 		InterfaceDoApp princ = null;
 		Scanner leia = new Scanner(System.in);

  		switch (op) {
 			case 1 : Pessoa p = new Pessoa("", "", "", 0.0, null, null, null, 3);
 					pessoas.adicionar(p);
 			break;
 			case 2 : pessoas.exibirTodasPessoas();
 			break;
 			case 3 : System.out.println("Digite o ID da Pessoa:");
 					int idBusca= leia.nextInt();
 					pessoas.exibir(idBusca);
 			break;
 			case 4: System.out.println("Digite o ID da Pessoa:");
 					int idRemove = leia.nextInt();
 					pessoas.remover(idRemove);
 			break;
 			case 5: System.out.println("Voltando ao Menu Principal");					      
 					Thread.sleep(2000);
 			break;
 			case 0: System.out.println("Saindo do Sistema...");
 					Thread.sleep(2000);
 					System.exit(0);
 			break;
 			default: System.out.println("Opção Inválida!");;
 		}

  	}
}
