package br.com.spring.code.acessoDadosJDBC.dao;

import java.util.List;

import br.com.spring.code.ecommerce.gestaopessoas.Endereco;

public interface EnderecoDAO {

	public void insert(Endereco end);
	public void update(Endereco end);
	public void deleteById(Integer id);
	public Endereco findById(Integer id);
	public List<Endereco> findAll();

}
