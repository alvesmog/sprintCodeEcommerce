package br.com.spring.code.acessoDadosJDBC.dao.impl;

import java.sql.Connection;
import java.util.List;

import br.com.spring.code.acessoDadosJDBC.dao.PessoaDAO;
import br.com.spring.code.ecommerce.gestaopessoas.Pessoa;

public class PessoaDAOJDBC implements PessoaDAO {
	
	private Connection conn = null;
	
	public PessoaDAOJDBC(Connection conn) {
		this.conn = conn;
	}

	public void insert(Pessoa pes) {
		// TODO Auto-generated method stub
		
	}

	public void update(Pessoa pes) {
		// TODO Auto-generated method stub
		
	}

	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	public Pessoa findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Pessoa> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
