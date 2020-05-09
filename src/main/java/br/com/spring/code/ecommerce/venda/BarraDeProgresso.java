package br.com.spring.code.ecommerce.venda;

public class BarraDeProgresso {
	
	// referencia: https://kodejava.org/how-do-i-create-a-console-progress-bar/
	
	private static char[] animacao = {'|', '/', '-', '\\'};

	public static void play() {
		for (int i = 0; i <= 100; i++) {
			System.out.print("Processando ... " + i + "% " + animacao[i % 4] + "\r");

			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("Processando: Pronto!          ");
	}
}

