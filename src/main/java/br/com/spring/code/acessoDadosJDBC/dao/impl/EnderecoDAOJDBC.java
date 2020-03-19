package br.com.spring.code.acessoDadosJDBC.dao.impl;

import java.sql.Connection;
import java.util.List;

import br.com.spring.code.acessoDadosJDBC.dao.EnderecoDAO;
import br.com.spring.code.ecommerce.gestaopessoas.Endereco;

public class EnderecoDAOJDBC implements EnderecoDAO {
	
	private Connection conn = null;
	
	public EnderecoDAOJDBC(Connection conn) {
		this.conn = conn;
	}

	public void insert(Endereco end) {
		// TODO Auto-generated method stub
		
	}

	public void update(Endereco end) {
		// TODO Auto-generated method stub
		
	}

	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	public Endereco findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Endereco> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
