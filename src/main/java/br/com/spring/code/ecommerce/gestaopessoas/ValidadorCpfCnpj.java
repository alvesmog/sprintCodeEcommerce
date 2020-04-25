package br.com.spring.code.ecommerce.gestaopessoas;
//	https://gist.github.com/adrianoluis/5043397d378ae506d87366abb0ab4e30

/**
 * A Class ValidadorCpfCnpj verifica a o CPF ou CNPJ e lança um erro
 * personalizado CpfCnpjException no caso de ser inválido o CPF ou CNPJ
 * informado.
 * 
 */
public class ValidadorCpfCnpj {

	// CPF
	private static final int[] WEIGHT_SSN = { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2 };

	// CNPJ
	private static final int[] WEIGHT_TFN = { 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };

	/**
	 * Recursive sum.
	 *
	 * @param weight the weight
	 * @param chr    the chr
	 * @param number the number
	 * @return the int
	 */
	private static int recursiveSum(int[] weight, char[] chr, int number) {
		if (number <= 0)
			return 0;
		final int chrIndex = number - 1;
		final int weightIndex = weight.length > chr.length ? number : chrIndex;
		return (recursiveSum(weight, chr, chrIndex) + Character.getNumericValue(chr[chrIndex]) * weight[weightIndex]);
	}

	/**
	 * Calculate.
	 *
	 * @param str    the str
	 * @param weight the weight
	 * @return the int
	 */
	private static int calculate(final String str, final int[] weight) {
		final char[] chr = str.toCharArray();
		int sum = recursiveSum(weight, chr, chr.length);
		sum = 11 - (sum % 11);
		return sum > 9 ? 0 : sum;
	}

	/**
	 * Check equals.
	 *
	 * @param tfn    the tfn
	 * @param length the length
	 * @param weight the weight
	 * @return the string
	 */
	private static String checkEquals(String tfn, int length, int[] weight) {
		final String number = tfn.substring(0, length);
		final int digit1 = calculate(number, weight);
		final int digit2 = calculate(number + digit1, weight);

		if (tfn.equals(number + digit1 + digit2)) {
			return tfn;
		} else {
			throw new CpfCnpjException("Cpf ou Cnpj Inválido! " + tfn);
		}

	}

	/**
	 * Valida CPF.
	 *
	 * @param cpf the cpf
	 * @return true/false
	 */
	public static String isValidCpf(String cpf) {
		if (cpf == null || !cpf.matches("\\d{11}") || cpf.matches(cpf.charAt(0) + "{11}")) {
			throw new CpfCnpjException("CPF inválido " + cpf);
		} else {
			return checkEquals(cpf, 9, WEIGHT_SSN);
		}
	}

	/**
	 * Valida CNPJ.
	 *
	 * @param cnpj the cnpj
	 * @return true/false
	 */
	public static String isValidCnpj(String cnpj) {
		if (cnpj == null || !cnpj.matches("\\d{14}") || cnpj.matches(cnpj.charAt(0) + "{14}")) {
			throw new CpfCnpjException("CNPJ inválido! " + cnpj);
		} else {
			return checkEquals(cnpj, 12, WEIGHT_TFN);
		}
	}

}
