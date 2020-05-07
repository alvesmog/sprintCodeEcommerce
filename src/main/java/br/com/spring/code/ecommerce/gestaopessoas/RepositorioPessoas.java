package br.com.spring.code.ecommerce.gestaopessoas;

import java.util.ArrayList;
import java.util.List;

/* [UPDATE] 20/04/2020
 * Autor: Henrique
 * 1. REMOVIDA FUNÇÃO PROCURARPESSOA. JÁ EXISTE A FUNÇÃO EXIBIR(ID)
 * 2. MODIFICAÇÃO DA FUNÇÃO ADICIONAR(PESSOA) PARA POPULAR AS ID'S (PESSOA/ENDEREÇO/USUARIO) AUTOMATICAMENTE
 * 3. ATUALIZADA A FUNÇÃO REMOVER(ID).
 * 4. CRIADA FUNÇÃO VALIDARCPFCNPJ(STRING) PARA VALIDAR E IDENTIFICAR ESSA ENTRADA
 */

public class RepositorioPessoas {

	private static List<Pessoa> listaDePessoas = new ArrayList<Pessoa>();
	private static int idReferencia;

	public RepositorioPessoas() {

	}

	public void exibirTodasPessoas() {
		for (int i = 0; i < listaDePessoas.size(); i++) {
			System.out.println(listaDePessoas.get(i));
		}
	}

	public void exibir(Integer id) {
		System.out.println(listaDePessoas.get(id - 1));
	}

	public void adicionar(Pessoa pessoa) {
		if (listaDePessoas.isEmpty()) {
			pessoa.setId(1);
			listaDePessoas.add(pessoa);
			idReferencia = 1;
		} else {
			idReferencia = idReferencia + 1;
			pessoa.setId(idReferencia);
			listaDePessoas.add(pessoa);
		}

	}

	public void remover(Integer idParaRemover) {

		for (int i = 0; i < listaDePessoas.size(); i++) {
			if (listaDePessoas.get(i).getId() == idParaRemover) {
				listaDePessoas.remove(i);
			}
		}
	}

	// VALIDAR

	public String validaCpfCnpj(String entrada) {
		int tamanho = entrada.length();
		if (tamanho == 11) {
			return "CPF";
		} else {
			if (tamanho == 14) {
				return "CNPJ";
			} else {
				return null;
			}
		}
	}

	/**
	 * Autentica se o usuario está no repositório.
	 * 
	 * @param login
	 * @param senha
	 * @return {@code true} se está autenticado, {@code false} caso contrário.
	 */
	public boolean estaAutenticado(String login, String senha) {

		for (Pessoa pessoa : listaDePessoas) {

			// Verica se existe o usuario com aquele `login`
			if (pessoa.getUsuario().getLogin().equals(login)) {

				// Caso exista, verifica se a `senha` procede:
				if (pessoa.getUsuario().getSenha().equals(senha))

					return true;
			}
		}
		return false;
	}

	/**
	 * Autentica o usuario e retorna o objeto {@code Pessoa} associado.
	 * 
	 * @param login
	 * @param senha
	 * @return {@code Pessoa} pessoaAutenticada OR {@code null}
	 */
	public Pessoa estaAutenticadoRetornaPessoa(String login, String senha) {

		for (Pessoa pessoa : listaDePessoas) {

			// Verica se existe o usuario com aquele `login`
			if (pessoa.getUsuario().getLogin().equals(login)) {

				// Caso exista, verifica se a `senha` procede:
				if (pessoa.getUsuario().getSenha().equals(senha))

					return pessoa;
			}
		}
		return null;
	}

	/**
	 * Verifica o tipo de usuario, com base no {@code login} e {@code senha}
	 * informados.
	 * 
	 * @return
	 *         <p>
	 *         -1 -> caso não haja permissão;
	 *         </p>
	 *         <p>
	 *         1 -> caso seja Pessoa Jurídica;
	 *         </p>
	 *         <p>
	 *         2 -> caso seja Pessoa Física;
	 *         </p>
	 * 
	 */
	public int verificarPermissao(String login, String senha) {

		Pessoa pessoaProcurada = this.estaAutenticadoRetornaPessoa(login, senha);

		if (pessoaProcurada instanceof PessoaJuridica) {
			return 1;
		} else if (pessoaProcurada instanceof PessoaFisica) {
			return 2;
		}

		return -1;
	}

}
