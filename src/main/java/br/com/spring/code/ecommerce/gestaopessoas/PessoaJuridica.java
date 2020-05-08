package br.com.spring.code.ecommerce.gestaopessoas;

public class PessoaJuridica extends Pessoa {

	private String cnpj;
	private String razaoSocial;

	public PessoaJuridica() {
		super();
	}

	/**
	 * Instancia uma nova pessoa juridica.
	 *
	 * @param nome        the nome
	 * @param telefone    the telefone
	 * @param email       the email
	 * @param endereco    the endereco
	 * @param usuario     the usuario
	 * @param cnpj        the cnpj
	 * @param razaoSocial the razao social
	 */
	public PessoaJuridica(String nome, String telefone, String email, Endereco endereco, Usuario usuario, String cnpj,
			String razaoSocial) {
		super(nome, telefone, email, endereco, usuario);
		this.cnpj = ValidadorCpfCnpj.isValidCnpj(cnpj);
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return ValidadorCpfCnpj.isValidCnpj(cnpj);
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	@Override
	public String toString() {
		return "[Id: " + getId() + ", Nome: " + getNome() + ", Telefone: " + getTelefone() + ", Email: " + getEmail()
				+ ", Confiabilidade: " + getConfiabilidade() + ", Endereco: " + getEndereco() + ", Usuario: "
				+ getUsuario() + ", Pontos: " + getPontos() + ", Cnpj: " + getCnpj() + ", RazaoSocial: " + getRazaoSocial()
				+ "]";
	}

}