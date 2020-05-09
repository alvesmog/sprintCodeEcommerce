package br.com.spring.code.ecommerce.gestaopessoas;

/**
 * A classe CpfCnpjException é uma exceção personalizada que deve ser lançada
 * quando na validação ocorrer um CPF ou CNPJ inválido.
 * 
 */
public class CpfCnpjException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	/**
	 * Lança uma nova exceção de cpf ou cnpj inválido.
	 *
	 * @param msg the msg
	 */
	public CpfCnpjException(String msg) {
		super(msg);
	}

}
