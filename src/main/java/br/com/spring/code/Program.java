package br.com.spring.code;

import br.com.spring.code.acessoDadosJDBC.dao.EnderecoDAO;
import br.com.spring.code.acessoDadosJDBC.dao.FabricaDao;
import br.com.spring.code.ecommerce.gestaopessoas.Endereco;

public class Program {

	public static void main(String[] args) {

		Endereco end1 = new Endereco(null, "logradouro 01", "numero 01", "bairro 01", "municipio 01", "estado 01",
				"ref 01", "cep 01", "pais 01", "caixaPostal 01");
		
		Endereco end2 = new Endereco(null, "logradouro 02", "numero 02", "bairro 02", "municipio 02", "estado 02",
				"ref 02", "cep 02", "pais 02", "caixaPostal 02");
		
		EnderecoDAO enderecoDAO = FabricaDao.criarEnderecoDAO();
		
		enderecoDAO.insert(end1);
		
		
	}
}
