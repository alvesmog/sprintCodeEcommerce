package br.com.spring.code.ecommerce.menuInterface;
// [novo] source: Aula 18/04,  9-12h: https://github.com/alvesmog/sprintCodeEcommerce/commit/b069ece92b571a188769eec075737660e8a44743
  import java.util.Scanner;

  public class InterfaceDoApp {

  	public static int mostrarMenuOpcoes() {
 		Scanner leia = new Scanner(System.in);
 		int opcao;

  		System.out.println("##################################################");
 		System.out.println("******** e-COMMERCE DE PRODUTOS PARA BEBÊ ********\n");
 		System.out.println(" ===== MENU DE OPÇÕES =====\n");		
 		System.out.println("1. GESTÃO DE PESSOAS");
 		System.out.println("2. GESTÃO DE PRODUTOS");
 		System.out.println("3. ANUNCIO");
 		System.out.println("4. VENDAS");
 		System.out.println("5. ATENDIMENTO");
 		System.out.println("6. DÚVIDAS SOBRE PRODUTOS");
 		System.out.println("0. ENCERRAR SISTEMA");
 		System.out.println("##################################################");

  		System.out.println("\n");

  		System.out.print("Acessar o Sistema. Digite a sua opção: ");

  		opcao = leia.nextInt();

  		return opcao;
 	}

  }
