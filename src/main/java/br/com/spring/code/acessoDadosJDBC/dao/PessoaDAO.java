package br.com.spring.code.acessoDadosJDBC.dao;

import java.util.List;

import br.com.spring.code.ecommerce.gestaopessoas.Pessoa;

public interface PessoaDAO {
	
	public void insert(Pessoa pes);
	public void update(Pessoa pes);
	public void deleteById(Integer id);
	public Pessoa findById(Integer id);
	public List<Pessoa> findAll();

}
