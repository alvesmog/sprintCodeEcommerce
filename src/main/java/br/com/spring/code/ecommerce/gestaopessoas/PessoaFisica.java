package br.com.spring.code.ecommerce.gestaopessoas;

public class PessoaFisica extends Pessoa {

	private String cpf;

	public PessoaFisica() {
		super();
	}

	/**
	 * Instantiates a new pessoa fisica.
	 *
	 * @param nome     the nome
	 * @param telefone the telefone
	 * @param email    the email
	 * @param endereco the endereco
	 * @param usuario  the usuario
	 * @param cpf      the cpf
	 */
	public PessoaFisica(String nome, String telefone, String email, Endereco endereco, Usuario usuario, String cpf) {
		super(nome, telefone, email, endereco, usuario);
		this.cpf = ValidadorCpfCnpj.isValidCpf(cpf);
	}

	public String getCpf() {
		return ValidadorCpfCnpj.isValidCpf(cpf);
	}

	public void setCpf(String cpf) {
		this.cpf = ValidadorCpfCnpj.isValidCpf(cpf);
	}

	@Override
	public String toString() {
		return "[Id: " + getId() + ", Nome: " + getNome() + ", Telefone: " + getTelefone() + ", Email: " + getEmail()
				+ ", Confiabilidade: " + getConfiabilidade() + ", Endereco: " + getEndereco() + ", Usuario: "
				+ getUsuario() + ", Pontos: " + getPontos() + ", Cpf: " + getCpf() + "]";
	}

}
