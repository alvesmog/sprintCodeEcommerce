package br.com.spring.code.acessoDadosJDBC.dao;

import br.com.spring.code.acessoDadosJDBC.dao.impl.EnderecoDAOJDBC;
import br.com.spring.code.acessoDadosJDBC.dao.impl.PessoaDAOJDBC;
import br.com.spring.code.acessoDadosJDBC.db.DB;

public class FabricaDao {

	public static PessoaDAO criarPessoaDAO() {
		return new PessoaDAOJDBC(DB.getConnection());
	}
	
	public static EnderecoDAO criarDepartamentoDao() {
		return new EnderecoDAOJDBC(DB.getConnection());
	}

}
