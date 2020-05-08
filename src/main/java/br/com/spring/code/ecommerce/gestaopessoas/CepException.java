package br.com.spring.code.ecommerce.gestaopessoas;

/**
 * A classe CepException é uma exceção personalizada que deve ser lançada
 * quando na validação ocorrer um CEP inválido.
 * 
 */
public class CepException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	/**
	 * Lança uma nova exceção de CEP inválido.
	 *
	 * @param msg the msg
	 */
	public CepException(String msg) {
		super(msg);
	}

}
