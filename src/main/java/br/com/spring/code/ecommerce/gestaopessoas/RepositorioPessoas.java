package br.com.spring.code.ecommerce.gestaopessoas;

import java.util.ArrayList;
import java.util.List;

public class RepositorioPessoas {
	
	// [fix] source: https://github.com/alvesmog/sprintCodeEcommerce/commit/4aa4cde652ed03a8c2f3b81b59eed7154715f05e
	List<Pessoa> listaDePessoas;

	public RepositorioPessoas() {
		this.listaDePessoas = new ArrayList<Pessoa>();
	}

	public void exibirTodasPessoas() {

		for (int i = 0; i < listaDePessoas.size(); i++) {

			System.out.println(listaDePessoas.get(i));

		}

	}

	public Pessoa procurarPessoa(Integer idProcurado) {

		if (idProcurado != null && !listaDePessoas.isEmpty()) {

			Pessoa pessoaProcurada = new Pessoa();

			for (int i = 0; i < listaDePessoas.size(); i++) {

				if (listaDePessoas.get(i).getId().equals(idProcurado)) {

					pessoaProcurada = listaDePessoas.get(i);

				}

			}

			return pessoaProcurada;

		}

		return null;

	}

	public void exibir(Integer id) {

		Pessoa pessoaProcurada = procurarPessoa(id);
		if (pessoaProcurada != null) {

			System.out.println(pessoaProcurada.toString());
			return;

		}

		System.out.println("Pessoa com esse ID não encontrada.");

	}

	public void adicionar(Pessoa pessoa) {

		listaDePessoas.add(pessoa);

	}

	public void remover(Integer idParaRemover) {

		Pessoa procurada = procurarPessoa(idParaRemover);
		if (procurada != null) {

			listaDePessoas.remove(procurada);
			System.out.println("Pessoa removida com sucesso.");
			return;

		}

		System.out.println("Pessoa com esse ID não encontrada.");

	}
	
	/**
	 * Autentica se o usuario está no repositório.
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
	 * Verifica o tipo de usuario, com base no 
	 * {@code login} e {@code senha} informados.
	 * @return 
	 * <p> -1 -> caso não haja permissão; </p>
	 * <p> 1 -> caso seja Pessoa Jurídica; </p>
	 * <p> 2 -> caso seja Pessoa Física; </p>
	 * 
	 */
	public int verificarPermissao(String login, String senha) {
		
		Pessoa pessoaProcurada = this.estaAutenticadoRetornaPessoa(login, senha);
		
		if (pessoaProcurada.getPessoa() instanceof PessoaJuridica) {
			return 1;
		} else if (pessoaProcurada.getPessoa() instanceof PessoaFisica) {
			return 2;
		}
		
		return -1;
	}

}
