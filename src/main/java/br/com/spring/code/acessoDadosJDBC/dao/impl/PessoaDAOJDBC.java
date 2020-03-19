package br.com.spring.code.acessoDadosJDBC.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import br.com.spring.code.acessoDadosJDBC.dao.PessoaDAO;
import br.com.spring.code.acessoDadosJDBC.db.DB;
import br.com.spring.code.acessoDadosJDBC.db.DBException;
import br.com.spring.code.ecommerce.gestaopessoas.Pessoa;

public class PessoaDAOJDBC implements PessoaDAO {

	private Connection conn = null;

	public PessoaDAOJDBC(Connection conn) {
		this.conn = conn;
	}

	public void insert(Pessoa pes) {
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("INSERT INTO pessoa "
					+ "(Nome, Telefone, Email, Confiabilidade, CpfOUCnpj, Pontos, Endereco, Usuario) " + "VALUES "
					+ "(?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, pes.getNome());
			ps.setString(2, pes.getTelefone());
			ps.setString(3, pes.getEmail());
			ps.setFloat(4, pes.getConfiabilidade());
			ps.setString(5, pes.getCpfOUCnpj());
			ps.setInt(6, pes.getPontos());
			ps.setInt(7, pes.getEndereco().getId());
			ps.setInt(8, pes.getUsuario().getId());

			int nLinhasAlteradas = ps.executeUpdate();

			// Atribui ao objeto Pessoa inserido o id gerado automaticamente na inserção de
			// dados.
			if (nLinhasAlteradas > 0) {
				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					pes.setId(id);
				}
				DB.closeResultSet(rs);
			} else {
				throw new DBException("Erro inesperado. Nenhuma alteração realizada!");
			}

		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		} finally {
			DB.closeStatment(ps);
		}

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
